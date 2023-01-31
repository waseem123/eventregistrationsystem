import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AttendeeOperations {
    EventOperations eventOperations = new EventOperations();
    private String file_attendees = "src/attendees.txt";

    public void registerAttendee() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE DATE OF EVENT IN DD-MM-YYYY FORMAT - ");
        String eventDate = sc.next();
        Events bookedEvent = eventOperations.getBookedEvent(eventDate);
        if (bookedEvent == null) {
            System.out.println("ERROR : NO EVENTS BOOKED FOR THE GIVEN DATE.");
        } else if (bookedEvent.getEventStatus().equals("CANCELLED")) {
            System.out.println("ERROR : THE EVENT HAS BEEN CANCELLED.");
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("ENTER THE NAME OF ATTENDEE - ");
            String attendeeName = br.readLine();
            System.out.println("ENTER THE EMAIL OF ATTENDEE - ");
            String attendeeEmail = br.readLine();
            System.out.println("ENTER THE MOBILE NUMBER OF ATTENDEE - ");
            String attendeeMobileNo = br.readLine();
            List<Attendee> attendees = getAttendees(file_attendees);
            Attendee attendee;
            int id = 0;
            if (attendees.size() > 0)
                id = attendees.get(attendees.size() - 1).getAttendeeId();
            attendee = new Attendee(id + 1, attendeeName, attendeeEmail, attendeeMobileNo, bookedEvent.getEventId());
            attendees.add(attendee);
            File file = new File(file_attendees);
            FileWriter fw;
            try {
                fw = new FileWriter(file, true);
                fw.write(attendee.toString());
                fw.close();
                System.out.println("ATTENDEE HAS BEEN REGISTERED FOR " + bookedEvent.getEventName() + " SUCCESSFULLY.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void editAttendee() {
    }

    public void searchAttendee() {
    }

    public void deleteAttendee() {
    }

    private List<Attendee> getAttendees(String file_attendees) {
        List<Attendee> attendees = new ArrayList<>();
        File file = new File(file_attendees);
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String[] lines = sc.nextLine().split(",");
            for (String line : lines) {
                String[] content = line.split(":");
                attendees.add(new Attendee(
                                Integer.parseInt(content[0]),
                                content[1],
                                content[2],
                                content[3],
                                Integer.parseInt(content[4])
                        )
                );
            }
        }
        return attendees;
    }
}
