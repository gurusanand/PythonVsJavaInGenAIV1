"""
RAG Query Implementation using LangChain
Author: Optimum AI Lab
Description: This example demonstrates how to implement a basic RAG pipeline
that loads a document, creates a vector store, and answers questions based on it.
"""

from langchain_community.vectorstores import FAISS
from langchain_core.output_parsers import StrOutputParser
from langchain_core.prompts import ChatPromptTemplate
from langchain_core.runnables import RunnablePassthrough
from langchain_openai import ChatOpenAI, OpenAIEmbeddings

# 1. Create a vector store with sample documents
print("Creating vector store...")
vectorstore = FAISS.from_texts(
    [
        "Optimum AI Lab builds autonomous AI agents for enterprise applications.",
        "We specialize in LLM frameworks comparison and optimization.",
        "Our dashboard provides comprehensive analysis of Python and Java frameworks."
    ],
    embedding=OpenAIEmbeddings()
)
retriever = vectorstore.as_retriever()

# 2. Define the prompt template
template = """Answer the question based only on the following context:
{context}

Question: {question}

Answer:"""
prompt = ChatPromptTemplate.from_template(template)

# 3. Initialize the LLM model
model = ChatOpenAI(model="gpt-4-turbo-preview")

# 4. Create the RAG chain
chain = (
    {"context": retriever, "question": RunnablePassthrough()}
    | prompt
    | model
    | StrOutputParser()
)

# 5. Test the RAG pipeline
if __name__ == "__main__":
    question = "What does Optimum AI Lab do?"
    print(f"\nQuestion: {question}")
    print("-" * 50)
    
    result = chain.invoke(question)
    print(f"Answer: {result}")
