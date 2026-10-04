import java.util.Scanner;

class ATM {

    private double balance;

    // Constructor
    public ATM(double balance) {
        this.balance = balance;
    }

    // Withdraw method
    public void withdraw(double amount) throws Exception {

        if (amount > balance) {
            throw new Exception("Insufficient Balance");
        }

        balance = balance - amount;

        System.out.println("Withdrawal Successful");
        System.out.println("Remaining Balance: " + balance);
    }
}

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        ATM atm = new ATM(balance);

        try {
            atm.withdraw(amount);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        finally {
            System.out.println("Transaction Completed");
        }

        sc.close();
    }
}