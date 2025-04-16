import java.util.Scanner;

public class ATM {

    private static String accountNumber = "123456"; // Sample account number
    private static String pin = "1234";         // Sample PIN
    private static double balance = 1000.0;    // Sample initial balance
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM!");

        if (authenticateUser()) {
            displayMainMenu();
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private static boolean authenticateUser() {
        System.out.print("Enter your account number: ");
        String enteredAccountNumber = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (enteredAccountNumber.equals(accountNumber) && enteredPin.equals(pin)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Invalid account number or PIN.");
            return false;
        }
    }

    private static void displayMainMenu() {
        int choice;
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: ₹" + String.format("%.2f", balance));
    }

    private static void deposit() {
        System.out.print("Enter the amount to deposit: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + String.format("%.2f", amount) + " deposited successfully.");
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("₹" + String.format("%.2f", amount) + " withdrawn successfully.");
                checkBalance();
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
}