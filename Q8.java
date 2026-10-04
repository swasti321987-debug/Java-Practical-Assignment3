import java.util.Scanner;

class PrinterJob implements Runnable {

    private int jobNumber;
    private String studentName;

    public PrinterJob(int jobNumber, String studentName) {
        this.jobNumber = jobNumber;
        this.studentName = studentName;
    }

    @Override
    public void run() {

        System.out.println(
            "Printing job " +
            jobNumber +
            " by " +
            studentName
        );

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println("Printing interrupted");
        }
    }
}

public class Q8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of print jobs: ");
        int numberOfJobs = sc.nextInt();

        Thread[] threads =
                new Thread[numberOfJobs];

        for (int i = 0; i < numberOfJobs; i++) {

            String studentName =
                    "Student " + (char)('A' + i);

            PrinterJob job =
                    new PrinterJob(i + 1, studentName);

            threads[i] = new Thread(job);

            threads[i].start();
        }

        // Wait for all printing threads
        for (int i = 0; i < numberOfJobs; i++) {

            try {
                threads[i].join();
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        sc.close();
    }
}
