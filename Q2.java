import java.util.Scanner;

// User-defined exception
class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}

class Student {

    public void registerStudent(int age) throws InvalidAgeException {

        if (age < 17) {
            throw new InvalidAgeException(
                "Age must be above 17 for registration"
            );
        }

        System.out.println("Student registered successfully");
    }
}

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Student student = new Student();

        try {
            student.registerStudent(age);
        }
        catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}