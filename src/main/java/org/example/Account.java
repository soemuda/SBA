package org.example;
import java.util.Scanner;

public class Account {
    //class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    Account (String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    //function for depositing money
    void deposit(int amount) {
        if (amount != 0 ) {
            balance = balance + amount;
            previousTransaction = amount;
        }

    }

    //funtion for Withdrawing money
    void withdraw(int amount) {
        if (amount !=0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    //function showing the previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited; " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred.");
        }

    }

    //funtion for calculating intrest of current funs after a number of years

    void calculateInterest(int years) {
        double interestRate = 0.185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate " + (100 * interestRate) + "%");
        System.out.println("After" + years + " years, your balance will be: " + newBalance);
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("===============================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("===============================");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("Enter an amount to deposit : ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;


                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("===============================");
                    getPreviousTransaction();
                    System.out.println("===============================");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;

                case 'F':
                    System.out.println("====================================");
                    break;

                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, or F.");
                    break;

                //case A allows the user to check their current balance

            }

        } while (option != 'F');
        System.out.println("Thank you for banking with us!");

    }



}
