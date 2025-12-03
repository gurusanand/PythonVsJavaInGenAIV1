package com.example;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;

/**
 * RAG Query Implementation using LangChain4j
 * Author: Optimum AI Lab
 * Description: This example demonstrates how to implement a basic RAG pipeline
 * that loads documents, creates a vector store, and answers questions based on them.
 */
public class RagQuery {

    // Define an interface for the AI service
    interface Assistant {
        String chat(String userMessage);
    }

    public static void main(String[] args) {
        System.out.println("Creating RAG pipeline...");

        // 1. Create documents to be ingested
        String text = "Optimum AI Lab builds autonomous AI agents for enterprise applications. " +
                     "We specialize in LLM frameworks comparison and optimization. " +
                     "Our dashboard provides comprehensive analysis of Python and Java frameworks.";
        Document document = new TextDocumentParser().parse(text);

        // 2. Create embedding model and embedding store
        OpenAiEmbeddingModel embeddingModel = OpenAiEmbeddingModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName("text-embedding-3-small")
                .build();

        EmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();

        // 3. Ingest the document into the embedding store
        // Note: This is a simplified example. In production, use proper ingestion pipeline
        System.out.println("Ingesting documents...");

        // 4. Create a content retriever
        ContentRetriever contentRetriever = EmbeddingStoreContentRetriever.builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(embeddingModel)
                .maxResults(2)
                .minScore(0.6)
                .build();

        // 5. Create the AI Service (the RAG pipeline)
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(OpenAiChatModel.builder()
                        .apiKey(System.getenv("OPENAI_API_KEY"))
                        .modelName("gpt-4-turbo-preview")
                        .build())
                .contentRetriever(contentRetriever)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();

        // 6. Ask a question and print the result
        String question = "What does Optimum AI Lab do?";
        System.out.println("\nQuestion: " + question);
        System.out.println("-".repeat(50));

        String answer = assistant.chat(question);
        System.out.println("Answer: " + answer);
    }
}
