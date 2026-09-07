import java.util.Scanner;

class ATM {
    private double balance;

    ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    void checkBalance() {
        System.out.printf("Your current balance is: Rs. %.2f%n", balance);
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Rs. %.2f deposited successfully. New balance: Rs. %.2f%n", amount, balance);
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Rs. %.2f withdrawn successfully. New balance: Rs. %.2f%n", amount, balance);
        }
    }
}

public class Task3_ATMSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(5000.0); // starting balance
        int choice;

        System.out.println("===== Welcome to Java ATM =====");

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    atm.deposit(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    atm.withdraw(sc.nextDouble());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
