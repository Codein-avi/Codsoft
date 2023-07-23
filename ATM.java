import java.util.Scanner;

public class ATM {                   // ATM class that contains all the required methods
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {  // Parameterized constructor that initializes the account
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void run() {             // Function to initiate the program
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();  // User Entry for choice of which operation needs to be performed
            switch (choice) {       // Switch statement to execute the required function based on user's choice
                case 1 : checkBalance();
                         break;
                case 2 : deposit();
                         break;
                case 3 : withdraw();
                         break;
                case 4 : System.out.println("Thank you for using the ATM. Goodbye!");
                         break;
                default : System.out.println("Invalid option. Please try again.");


            }
        } while (choice != 4);
    }

    private void displayMenu() {
        System.out.println("\nATM MENU");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void checkBalance() {      // Checks current balance in account
        double balance = account.getBalance();
        System.out.println("Your account balance: Rs" + balance);
    }

    private void deposit() {          // Deposit the amount to the account
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit amount must be positive.");
        } else {
            account.deposit(amount);
            System.out.println("Rs" + amount + " deposited successfully.");
        }
    }

    private void withdraw() {       // Withdraws amount from the account
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal amount must be positive.");
        } else {
            boolean success = account.withdraw(amount);
            if (success) {
                System.out.println("Rs" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance. Withdrawal failed.");
            }
        }
    }

    public static void main(String[] args) {         // Main function from where the program starts
        BankAccount account = new BankAccount(1000); // Initialize account with $1000 balance
        ATM atm = new ATM(account);                  // Object "atm" is created
        atm.run();
    }
}



