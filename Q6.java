import java.util.Scanner;

// User-defined exception
class MinimumAmountException extends Exception {

    public MinimumAmountException(String message) {
        super(message);
    }
}

class OnlineShopping {

    public void placeOrder(int amount)
            throws MinimumAmountException {

        if (amount < 500) {
            throw new MinimumAmountException(
                "Minimum cart value must be ₹500"
            );
        }

        System.out.println("Order placed successfully");
    }
}

public class Q6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cart amount: ");
        int amount = sc.nextInt();

        OnlineShopping shopping =
                new OnlineShopping();

        try {
            shopping.placeOrder(amount);
        }
        catch (MinimumAmountException e) {
            System.out.println(
                "Exception: " + e.getMessage()
            );
        }

        sc.close();
    }
}