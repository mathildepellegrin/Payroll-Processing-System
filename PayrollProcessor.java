//
// Assignment 2
// Written by: Mathilde Pellegrin, 40267333
//
import java.io.*;
import java.util.Scanner;

// This class handles file I/O, payroll processing, and report generation

public class PayrollProcessor {
    public static void main(String[] args) {

        /* ***Debug***
        // Print current working directory
        System.out.println("Current working directory: " + new File(".").getAbsolutePath());

        // Check if payroll.txt exists
        File payrollFile = new File("payroll.txt");
        System.out.println("Checking for payroll.txt at: " + payrollFile.getAbsolutePath());

        if (!payrollFile.exists()) {
            System.out.println("Error: payroll.txt not found!");
            System.exit(0);
        }
        */

        Employee[] employees = new Employee[100]; //fixed sized array of employees
        int employeeCount = 0;
        int errorCount = 0;

        try (
                //try creating output files
                PrintWriter errorWriter = new PrintWriter(new FileOutputStream("payrollError.txt"));
                PrintWriter reportWriter = new PrintWriter(new FileOutputStream("payrollReport.txt"));
                Scanner keyboard = new Scanner(new FileInputStream("payroll.txt"));
        ) {
            // Read payroll file
            while (keyboard.hasNextLine() && employeeCount < employees.length) {
                String line = keyboard.nextLine();
                Scanner lineScanner = new Scanner(line);
                try {
                    long empNumber = lineScanner.nextLong();
                    String firstName = lineScanner.next();
                    String lastName = lineScanner.next();
                    double hoursWorked = lineScanner.nextDouble();
                    double hourlyWage = lineScanner.nextDouble();

                    if (hourlyWage < 15.75) {
                        throw new MinimumWageException("Hourly wage below legal limit: " + hourlyWage);
                    }

                    //store valid employees
                    employees[employeeCount++] = new Employee(empNumber, firstName, lastName, hoursWorked, hourlyWage);

                } catch (Exception e) {
                    errorWriter.println(line); // Write error line directly to error file
                    errorCount++;
                } finally {
                    lineScanner.close();
                }
            }

            errorWriter.close();

            // Writing report file
            reportWriter.println("""
                    > Opening file payroll...
                    > Reading file payroll...
                    > Error lines found in file payroll...
                    """ + "\n");

            // Reopen payrollError.txt to read and include in payrollReport.txt
            try (Scanner errorReader = new Scanner(new FileInputStream("payrollError.txt"))) {
                while (errorReader.hasNextLine()) {
                    reportWriter.println(errorReader.nextLine());
                }
            }

            reportWriter.printf("\n> %d lines read from file payroll\n", employeeCount + errorCount);
            reportWriter.printf("> %d lines written to error file\n", errorCount);
            reportWriter.println("> Calculating deductions...");
            reportWriter.println("> Writing report file...\n");
            reportWriter.println("                           iDroid Solutions");
            reportWriter.println("                          -------------------\n");

            reportWriter.printf("%-10s %-10s %-10s %-15s %-15s %-15s\n", "Employee#", "First Name", "Last Name", "Gross Salary", "Deductions", "Net Salary");
            reportWriter.println("------------------------------------------------------------------------------");

            for (int i = 0; i < employeeCount; i++) {
                Employee emp = employees[i];
                double totalDeductions = new ProvincialIncomeTax().calculateTax(emp.getGrossSalary()) +
                        new FederalTax().calculateTax(emp.getGrossSalary()) +
                        new QPP().calculateTax(emp.getGrossSalary()) +
                        new EI().calculateTax(emp.getGrossSalary()) +
                        new QPIP().calculateTax(emp.getGrossSalary());
                double netSalary = emp.getGrossSalary() - totalDeductions;

                reportWriter.printf("%-10d %-10s %-10s $%-14.2f $%-14.2f $%-14.2f\n",
                        emp.getEmployeeNumber(), emp.getEmployeeFirstName(), emp.getEmployeeLastName(),
                        emp.getGrossSalary(), totalDeductions, netSalary);
            }


        } catch (FileNotFoundException fnfex) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error processing payroll files: " + e.getMessage());
        }
    }
}


