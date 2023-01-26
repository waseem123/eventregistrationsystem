import java.io.File;
import java.util.Scanner;

public class Operations {
    private final String file_credentials = "src/credentials.txt";

    public boolean login() {
        boolean status = false;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("USERNAME - ");
            String username = sc.next();
            System.out.print("PASSWORD - ");
            String password = sc.next();
            File file = new File(file_credentials);
            Scanner reader = new Scanner(file);
            if (reader.hasNext()) {
                String[] credentials = reader.nextLine().split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    status = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public void getAttendeeMenu() {
        Scanner sc = new Scanner(System.in);
        AttendeeOperations attendeeOperations = new AttendeeOperations();
        while (true) {
            System.out.println("1. REGISTER AN ATTENDEE");
            System.out.println("2. EDIT AN ATTENDEE");
            System.out.println("3. SEARCH AN ATTENDEE");
            System.out.println("4. DELETE AN ATTENDEE");

            switch (sc.nextInt()) {
                case 1:
                    attendeeOperations.registerAttendee();
                    break;

                case 2:
                    attendeeOperations.editAttendee();
                    break;

                case 3:
                    attendeeOperations.searchAttendee();
                    break;
                case 4:
                    attendeeOperations.deleteAttendee();
                    break;
            }
        }
    }

    public void getEventMenu() {
        Scanner sc = new Scanner(System.in);
        EventOperations eventOperations = new EventOperations();
        while (true) {
            System.out.println("1. REGISTER AN EVENT");
            System.out.println("2. EDIT AN EVENT");
            System.out.println("3. DELETE AN EVENT");

            switch (sc.nextInt()) {
                case 1:
                    eventOperations.registerEvent();
                    break;

                case 2:
                    eventOperations.editEvent();
                    break;

                case 3:
                    eventOperations.deleteEvent();
                    break;
            }
        }
    }
}
