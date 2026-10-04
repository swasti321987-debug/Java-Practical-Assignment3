import java.util.Scanner;

class BankTransaction extends Thread {

    private int amount;
    private boolean highValue;

    public BankTransaction(int amount, boolean highValue) {
        this.amount = amount;
        this.highValue = highValue;
    }

    @Override
    public void run() {

        if (highValue) {
            System.out.println("High-value transaction processed first");
        } else {
            System.out.println("Low-value transaction processed later");
        }
    }
}

public class Q10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Transaction1 amount: ");
        int amount1 = sc.nextInt();

        System.out.print("Enter Transaction2 amount: ");
        int amount2 = sc.nextInt();

        BankTransaction transaction1 =
                new BankTransaction(amount1, false);

        BankTransaction transaction2 =
                new BankTransaction(amount2, true);

        // Set thread priorities
        transaction1.setPriority(Thread.MIN_PRIORITY);
        transaction2.setPriority(Thread.MAX_PRIORITY);

        // Start high-value transaction first
        transaction2.start();

        try {
            transaction2.join();
        } catch (InterruptedException e) {
            System.out.println("Transaction interrupted");
        }

        // Start low-value transaction after high-value transaction
        transaction1.start();

        sc.close();
    }
}