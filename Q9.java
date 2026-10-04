import java.util.Random;
import java.util.Scanner;

class SquareCalculator extends Thread {

    private int number;

    public SquareCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        int square = number * number;

        System.out.println("Square: " + square);
    }
}

class CubeCalculator extends Thread {

    private int number;

    public CubeCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        int cube = number * number * number;

        System.out.println("Cube: " + cube);
    }
}

class RandomNumberGenerator extends Thread {

    private boolean running;

    public RandomNumberGenerator(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {

        Random random = new Random();

        for (int i = 0; i < 3 && running; i++) {

            int number = random.nextInt(10) + 1;

            System.out.println("Generated: " + number);

            if (number % 2 == 0) {

                SquareCalculator square =
                        new SquareCalculator(number);

                square.start();

                try {
                    square.join();
                }
                catch (InterruptedException e) {
                    System.out.println(
                        "Square thread interrupted"
                    );
                }

            } else {

                CubeCalculator cube =
                        new CubeCalculator(number);

                cube.start();

                try {
                    cube.join();
                }
                catch (InterruptedException e) {
                    System.out.println(
                        "Cube thread interrupted"
                    );
                }
            }

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println(
                    "Generator interrupted"
                );
            }
        }
    }
}

public class Q9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Start Simulation");
        System.out.println("2. Exit");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            RandomNumberGenerator generator =
                    new RandomNumberGenerator(true);

            generator.start();

            try {
                generator.join();
            }
            catch (InterruptedException e) {
                System.out.println(
                    "Simulation interrupted"
                );
            }

        } else if (choice == 2) {

            System.out.println("Exiting...");

        } else {

            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
