import java.util.Scanner;

class TicketBooking {

    private int availableSeats;

    public TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Synchronized method
    public synchronized void bookSeat(
            String userName, int seats) {

        if (seats <= availableSeats) {

            availableSeats = availableSeats - seats;

            System.out.println(
                userName +
                " booked " +
                seats +
                " seat(s) successfully"
            );

        } else {

            System.out.println(
                userName +
                " booking failed. Not enough seats"
            );
        }
    }
}

class User1 extends Thread {

    private TicketBooking booking;
    private int seats;

    public User1(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    @Override
    public void run() {
        booking.bookSeat("User1", seats);
    }
}

class User2 extends Thread {

    private TicketBooking booking;
    private int seats;

    public User2(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    @Override
    public void run() {
        booking.bookSeat("User2", seats);
    }
}

public class Q7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Available Seats: ");
        int availableSeats = sc.nextInt();

        System.out.print("User1 wants to book: ");
        int seats1 = sc.nextInt();

        System.out.print("User2 wants to book: ");
        int seats2 = sc.nextInt();

        TicketBooking booking =
                new TicketBooking(availableSeats);

        User1 user1 =
                new User1(booking, seats1);

        User2 user2 =
                new User2(booking, seats2);

        user1.start();

        try {
            user1.join();
        }
        catch (InterruptedException e) {
            System.out.println("User1 interrupted");
        }

        user2.start();

        try {
            user2.join();
        }
        catch (InterruptedException e) {
            System.out.println("User2 interrupted");
        }

        sc.close();
    }
}