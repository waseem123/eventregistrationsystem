import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class EventOperations {
    private String file_booking = "src/booking.txt";

    public void registerEvent() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE DATE OF EVENT IN DD-MM-YYYY FORMAT - ");
        String eventDate = sc.next();

        if(!isVenueBooked(eventDate)){
            /*BOOKING LOGIC*/
            System.out.println("ENTER EVENT NAME - ");
            String eventName = sc.nextLine();
            sc.nextLine();
            System.out.println("ENTER EVENT ORGANIZER'S NAME - ");
            String eventOrganizer = sc.nextLine();
            Events event = new Events();
            event.setEventName(eventName);
            event.setEventOrganizer(eventOrganizer);
            event.setEventDate(new SimpleDateFormat("dd-MM-yyyy").parse(eventDate));
            Booking booking = new Booking();
            booking.setEvent(event);
            booking.setBookingDate(Date.from(Instant.now()));

            File file = new File(file_booking);
            FileWriter fw;
            try {
                fw = new FileWriter(file, true);
                fw.write(booking.toString());
                fw.close();
                System.out.println("VENUE HAS BEEN BOOKED SUCCESSFULLY.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("ERROR : ANOTHER EVENT IS ALREADY BOOKED FOR THE SAME DATE.");
        }
    }

    private boolean isVenueBooked(String eventDate) throws ParseException {

        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(eventDate);
//        Booking b = getAllEvents();
        return false;
    }

    public void deleteEvent() {
    }

    public void getAllEvents() {
    }
}
