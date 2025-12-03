"""
Simple API Call using LangChain
Author: Optimum AI Lab
Description: This example demonstrates the simplest way to call an LLM
using LangChain to generate a response to a prompt.
"""

from langchain_openai import ChatOpenAI

# 1. Initialize the LLM model
llm = ChatOpenAI(model="gpt-4-turbo-preview")

# 2. Invoke the model with a prompt
if __name__ == "__main__":
    prompt = "Explain why the sky is blue in one sentence."
    print(f"Prompt: {prompt}")
    print("-" * 50)
    
    result = llm.invoke(prompt)
    print(f"Response: {result.content}")
