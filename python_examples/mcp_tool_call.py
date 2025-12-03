"""
Tool Calling with MCP Server using LangChain
Author: Optimum AI Lab
Description: This example demonstrates how to define tools that an LLM can call
to perform specific operations (like calculations).
"""

from langchain_core.tools import tool
from langchain_openai import ChatOpenAI

# 1. Define a tool that the LLM can call
@tool
def multiply(a: int, b: int) -> int:
    """Multiplies two integers together."""
    return a * b

@tool
def add(a: int, b: int) -> int:
    """Adds two integers together."""
    return a + b

@tool
def divide(a: float, b: float) -> float:
    """Divides the first number by the second number."""
    if b == 0:
        return "Cannot divide by zero"
    return a / b

# 2. Initialize the LLM and bind tools to it
llm = ChatOpenAI(model="gpt-4-turbo-preview")
tools = [multiply, add, divide]
llm_with_tools = llm.bind_tools(tools)

# 3. Create the tool-calling chain
if __name__ == "__main__":
    # Test queries that should trigger tool calls
    queries = [
        "What is 15 * 8?",
        "Calculate 100 + 50",
        "What is 144 divided by 12?"
    ]
    
    for query in queries:
        print(f"\nQuery: {query}")
        print("-" * 50)
        
        result = llm_with_tools.invoke(query)
        
        # Check if tool calls were made
        if hasattr(result, 'tool_calls') and result.tool_calls:
            print(f"Tool calls: {result.tool_calls}")
        else:
            print(f"Response: {result.content}")
