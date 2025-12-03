# Windows Setup Guide: Optimum AI Lab LLM Frameworks Comparison Dashboard

**Version:** 4.0
**Created by:** Optimum AI Lab
**Date:** December 2024

---

## 📋 Table of Contents

1. [System Requirements](#system-requirements)
2. [Installation Steps](#installation-steps)
3. [Running the Dashboard](#running-the-dashboard)
4. [Troubleshooting](#troubleshooting)
5. [Project Structure](#project-structure)

---

## System Requirements

Before you begin, ensure your Windows PC meets the following requirements:

- **Operating System:** Windows 7, 8, 10, or 11 (64-bit recommended)
- **Python:** Version 3.8 or higher (3.10+ recommended)
- **RAM:** Minimum 4GB (8GB recommended)
- **Disk Space:** At least 500MB free space
- **Internet Connection:** Required for downloading dependencies

---

## Installation Steps

### Step 1: Install Python

1. **Download Python:**
   - Visit [https://www.python.org/downloads/](https://www.python.org/downloads/)
   - Click on "Download Python 3.11" (or the latest version)

2. **Run the Installer:**
   - Double-click the downloaded `.exe` file
   - **IMPORTANT:** Check the box that says **"Add Python to PATH"** at the bottom of the installer
   - Click "Install Now"

3. **Verify Installation:**
   - Open Command Prompt (press `Win + R`, type `cmd`, press Enter)
   - Type: `python --version`
   - You should see: `Python 3.x.x`

### Step 2: Extract the Dashboard Files

1. **Extract the ZIP file:**
   - Right-click on the downloaded ZIP file
   - Select "Extract All..."
   - Choose a location (e.g., `C:\Users\YourUsername\Documents\Optimum-AI-Lab`)
   - Click "Extract"

2. **Navigate to the folder:**
   - Open File Explorer
   - Go to the extracted folder

### Step 3: Run the Dashboard

**Option A: Easy Method (Recommended)**

1. **Double-click `run_dashboard.bat`**
   - The script will automatically:
     - Create a Python virtual environment
     - Install all required dependencies
     - Start the Streamlit dashboard
   - Your browser should open automatically at `http://localhost:8501`

**Option B: Manual Method**

1. **Open Command Prompt:**
   - Press `Win + R`
   - Type: `cmd`
   - Press Enter

2. **Navigate to the dashboard folder:**
   ```
   cd C:\Users\YourUsername\Documents\Optimum-AI-Lab
   ```

3. **Create a virtual environment:**
   ```
   python -m venv venv
   ```

4. **Activate the virtual environment:**
   ```
   venv\Scripts\activate
   ```
   - You should see `(venv)` at the beginning of the command prompt

5. **Install dependencies:**
   ```
   pip install -r requirements.txt
   ```

6. **Run the dashboard:**
   ```
   streamlit run dashboard.py
   ```

7. **Access the dashboard:**
   - Open your browser
   - Go to: `http://localhost:8501`

---

## Running the Dashboard

### Starting the Dashboard

**Using the batch file (easiest):**
- Simply double-click `run_dashboard.bat` in the folder

**Using Command Prompt:**
- Open Command Prompt in the dashboard folder
- Type: `streamlit run dashboard.py`
- Press Enter

### Accessing the Dashboard

- **Local Access:** http://localhost:8501
- The dashboard will automatically open in your default browser
- If not, manually open the URL above in your browser

### Stopping the Dashboard

- Press `Ctrl + C` in the Command Prompt window
- Or close the Command Prompt window

---

## Troubleshooting

### Issue: "Python is not recognized as an internal or external command"

**Solution:**
1. Python is not installed or not in PATH
2. Reinstall Python and make sure to check "Add Python to PATH"
3. Restart your computer after installation
4. Open a new Command Prompt and try again

### Issue: "No module named 'streamlit'"

**Solution:**
1. Make sure the virtual environment is activated (you should see `(venv)` in the prompt)
2. Run: `pip install -r requirements.txt`
3. Wait for installation to complete

### Issue: "Port 8501 is already in use"

**Solution:**
1. Close any other Streamlit instances
2. Or use a different port:
   ```
   streamlit run dashboard.py --server.port 8502
   ```

### Issue: "The dashboard is slow or not loading"

**Solution:**
1. Ensure you have a stable internet connection
2. Try refreshing the page (F5)
3. Clear your browser cache
4. Try a different browser (Chrome, Firefox, Edge)

### Issue: "ModuleNotFoundError" for pandas, plotly, or numpy

**Solution:**
1. Activate the virtual environment
2. Run: `pip install --upgrade -r requirements.txt`
3. Restart Streamlit

---

## Project Structure

```
Optimum-AI-Lab-Dashboard/
├── dashboard.py                    # Main Streamlit application
├── requirements.txt                # Python dependencies
├── run_dashboard.bat              # Windows startup script
├── WINDOWS_SETUP_GUIDE.md         # This file
├── README.md                       # Project overview
├── python_examples/               # Python code examples
│   ├── rag_query.py
│   ├── api_call.py
│   └── mcp_tool_call.py
└── java_examples/                 # Java code examples
    ├── pom.xml
    └── src/main/java/com/example/
        ├── RagQuery.java
        ├── ApiCall.java
        └── McpToolCall.java
```

---

## Dashboard Sections

The dashboard includes the following sections:

1. **Overview** - Executive summary and key findings
2. **Lines of Code** - Comparison of code complexity
3. **LOC Analysis with Code Examples** - Detailed code examples with line counts
4. **Performance Metrics** - QPS and throughput comparison
5. **Token Costs** - LLM pricing analysis
6. **Implementation Complexity** - Complexity scoring
7. **Python in Enterprise** - Enterprise adoption statistics
8. **Financial Institutions Success** - Real-world success stories
9. **LangChain4j Drawbacks for Chatbots** - Limitations analysis
10. **Detailed Comparison** - Feature matrix and selection guide

---

## Features

✅ **Interactive Visualizations** - Plotly charts and graphs
✅ **Comprehensive Data** - 50+ metrics across 8+ dimensions
✅ **Real Code Examples** - Working Python and Java implementations
✅ **Enterprise Focus** - Fortune 500 company case studies
✅ **Production Ready** - Fully tested and optimized
✅ **Easy to Deploy** - One-click startup on Windows

---

## System Information

- **Dashboard Version:** 4.0
- **Created by:** Optimum AI Lab
- **Last Updated:** December 2024
- **Status:** Production Ready

---

## Support and Documentation

- **LangChain Documentation:** https://docs.langchain.com/
- **LangGraph Documentation:** https://docs.langchain.com/oss/python/langgraph
- **LangChain4j GitHub:** https://github.com/langchain4j/langchain4j
- **Spring AI Documentation:** https://docs.spring.io/spring-ai/reference/
- **Streamlit Documentation:** https://docs.streamlit.io/

---

## Notes

- The dashboard requires an internet connection for initial setup
- All dependencies are installed in an isolated virtual environment
- No system-wide Python packages are modified
- The virtual environment can be safely deleted if you want to uninstall

---

## Quick Start Checklist

- [ ] Python 3.8+ installed
- [ ] Files extracted to a folder
- [ ] `run_dashboard.bat` executed
- [ ] Browser opened at http://localhost:8501
- [ ] Dashboard loaded successfully

---

**Enjoy exploring the Optimum AI Lab LLM Frameworks Comparison Dashboard!**

For any issues or questions, refer to the troubleshooting section above.
