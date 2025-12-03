@echo off
REM ============================================================================
REM Optimum AI Lab - Python vs Java LLM Frameworks Comparison Dashboard
REM Windows Startup Script
REM ============================================================================

echo.
echo ============================================================================
echo Optimum AI Lab - LLM Frameworks Comparison Dashboard
echo ============================================================================
echo.

REM Check if Python is installed
python --version >nul 2>&1
if errorlevel 1 (
    echo ERROR: Python is not installed or not in PATH
    echo Please install Python 3.8+ from https://www.python.org/
    echo Make sure to check "Add Python to PATH" during installation
    pause
    exit /b 1
)

echo ✓ Python found
echo.

REM Check if pip is available
pip --version >nul 2>&1
if errorlevel 1 (
    echo ERROR: pip is not available
    echo Please reinstall Python and ensure pip is included
    pause
    exit /b 1
)

echo ✓ pip found
echo.

REM Create virtual environment if it doesn't exist
if not exist "venv" (
    echo Creating virtual environment...
    python -m venv venv
    if errorlevel 1 (
        echo ERROR: Failed to create virtual environment
        pause
        exit /b 1
    )
    echo ✓ Virtual environment created
    echo.
)

REM Activate virtual environment
echo Activating virtual environment...
call venv\Scripts\activate.bat
if errorlevel 1 (
    echo ERROR: Failed to activate virtual environment
    pause
    exit /b 1
)
echo ✓ Virtual environment activated
echo.

REM Install/upgrade requirements
echo Installing dependencies...
pip install -q --upgrade pip
pip install -q -r requirements.txt
if errorlevel 1 (
    echo ERROR: Failed to install dependencies
    pause
    exit /b 1
)
echo ✓ Dependencies installed
echo.

REM Start Streamlit
echo ============================================================================
echo Starting Streamlit Dashboard...
echo ============================================================================
echo.
echo The dashboard will open in your default browser at: http://localhost:8501
echo.
echo Press Ctrl+C to stop the server
echo.

streamlit run dashboard.py

pause
