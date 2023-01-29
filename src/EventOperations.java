import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EventOperations {
    public void registerEvent() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE DATE OF EVENT IN DD-MM-YYYY FORMAT - ");
        String eventDate = sc.next();

        if(isVenueBooked(eventDate)){
            System.out.println("ERROR : ANOTHER EVENT IS ALREADY BOOKED FOR THE SAME DATE.");
        }else{
            /*BOOKING LOGIC*/
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
