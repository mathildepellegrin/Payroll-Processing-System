# Payroll-Processing-System
Project Overview

This project processes payroll data for iDroid Solutions, calculating employee salaries, deductions, and generating payroll reports. It demonstrates the use of:

- File I/O for reading/writing payroll data
- Exception Handling for input validation
- Abstract Classes & Inheritance for tax calculations
- Arrays for storing employee data

⚙️ Features

 ✔ Reads payroll data from payroll.txt

 ✔ Stores employee data in an array

 ✔ Handles invalid data using exceptions and logs errors in payrollError.txt

 ✔ Calculates salary deductions (Provincial Tax, Federal Tax, QPP, EI, QPIP)

 ✔ Generates a formatted payroll report (payrollReport.txt)


📁 Project Structure

  ├ 📄 Employee.java       # Employee class with attributes and methods
 
  ├ 📄 Deductions.java     # Abstract class for tax deductions
 
  ├ 📄 ProvincialTax.java  # Provincial tax calculation (inherits Deductions)
 
  ├ 📄 FederalTax.java     # Federal tax calculation (inherits Deductions)
 
  ├ 📄 PayrollProcessor.java  # Main program: Reads file, processes data, outputs reports
 
  ├ 📄 MinimumWageException.java  # Custom exception for wage validation
 
  ├ 📄 payroll.txt         # Input file with employee payroll data
 
  ├ 📄 payrollError.txt    # Log file for invalid data entries
 
  ├ 📄 payrollReport.txt   # Output file with final payroll report
 
  ├ 📄 README.md           # Documentation (this file)

 How to Run
 1. Compile java files and input payroll information to payroll.txt
 2. Run main program (PayrollProcessor)
 3. Check output files
    
    -> payrollError.txt for invalid records
    
    -> payrollReport.txt for payroll summary
