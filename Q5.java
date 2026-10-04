import java.util.Scanner;

class UniversityLogin {

    public void login(String username) {

        if (username == null) {
            throw new NullPointerException(
                "Username cannot be null"
            );
        }

        System.out.println("Login successful");
        System.out.println("Welcome " + username);
    }
}

public class Q5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String input = sc.nextLine();

        String username;

        if (input.equalsIgnoreCase("null")) {
            username = null;
        } else {
            username = input;
        }

        UniversityLogin loginSystem =
                new UniversityLogin();

        try {
            loginSystem.login(username);
        }
        catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
