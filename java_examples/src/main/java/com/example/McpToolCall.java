package com.example;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

/**
 * Tool Calling with MCP Server using LangChain4j
 * Author: Optimum AI Lab
 * Description: This example demonstrates how to define tools that an LLM can call
 * to perform specific operations (like calculations).
 */
public class McpToolCall {

    // 1. Define a class with tools that the LLM can call
    static class Calculator {
        @Tool("Multiplies two numbers together")
        public int multiply(int a, int b) {
            return a * b;
        }

        @Tool("Adds two numbers together")
        public int add(int a, int b) {
            return a + b;
        }

        @Tool("Divides the first number by the second number")
        public double divide(double a, double b) {
            if (b == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return a / b;
        }
    }

    // 2. Define an interface for the AI service
    interface Assistant {
        String chat(String userMessage);
    }

    public static void main(String[] args) {
        System.out.println("Creating AI Assistant with tools...");

        // 3. Create the AI Service with the tools
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(OpenAiChatModel.builder()
                        .apiKey(System.getenv("OPENAI_API_KEY"))
                        .modelName("gpt-4-turbo-preview")
                        .build())
                .tools(new Calculator())
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();

        // 4. Ask questions that trigger tool calls
        String[] questions = {
            "What is 15 * 8?",
            "Calculate 100 + 50",
            "What is 144 divided by 12?"
        };

        for (String question : questions) {
            System.out.println("\nQuestion: " + question);
            System.out.println("-".repeat(50));

            String answer = assistant.chat(question);
            System.out.println("Answer: " + answer);
        }
    }
}
