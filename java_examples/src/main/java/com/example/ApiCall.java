package com.example;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

/**
 * Simple API Call using LangChain4j
 * Author: Optimum AI Lab
 * Description: This example demonstrates the simplest way to call an LLM
 * using LangChain4j to generate a response to a prompt.
 */
public class ApiCall {

    public static void main(String[] args) {
        System.out.println("Initializing LLM...");

        // 1. Build the chat model with your API key
        ChatLanguageModel model = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName("gpt-4-turbo-preview")
                .build();

        // 2. Generate a response to a prompt
        String prompt = "Explain why the sky is blue in one sentence.";
        System.out.println("Prompt: " + prompt);
        System.out.println("-".repeat(50));

        String response = model.generate(prompt);
        System.out.println("Response: " + response);
    }
}
