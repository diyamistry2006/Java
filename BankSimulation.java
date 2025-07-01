import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        transactionHistory = new ArrayList<>();
        transactionHistory.add("Account opened with ₹" + initialDeposit);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println(" Deposit successful!");
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    public void withdraw(double amount)
    {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdraw: ₹" + amount);
            System.out.println(" Withdrawal successful!");
        } else {
            System.out.println(" Insufficient balance or invalid amount.");
        }
    }

    public void printBalance() {
        System.out.println(" Current balance: ₹" + balance);
    }

    public void printTransactionHistory() {
        System.out.println("\n Transaction History for " + accountHolder + ":");
        for (String transaction : transactionHistory) {
            System.out.println(" - " + transaction);
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print(" Enter initial deposit: ₹");
        double initial = scanner.nextDouble();

        Account account = new Account(name, initial);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n==== BANK MENU ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    account.deposit(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    account.withdraw(scanner.nextDouble());
                    break;
                case 3:
                    account.printBalance();
                    break;
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the banking system!");
                    exit = true;
                    break;
                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}