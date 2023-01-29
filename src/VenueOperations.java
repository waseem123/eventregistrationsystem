import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VenueOperations {
    String file_venues = "src/venues.txt";
    private String file_booked_Venues="src/booked_venues.txt";

    public void addVenue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER VENUE DETAILS - ");

        System.out.print("ENTER VENUE NAME - ");
        String venueName = sc.nextLine();

        System.out.print("ENTER VENUE RENT - ");
        int venueRent = sc.nextInt();

        List<Venue> venues = getVenues(file_venues);
        Venue v;
        int id = 0;
        if (venues.size() > 0)
            id = venues.get(venues.size() - 1).getVenueId();
        v = new Venue(id + 1, venueName, venueRent, true);
        venues.add(v);

        File file = new File(file_venues);
        FileWriter fw;
        try {
            fw = new FileWriter(file, true);
            fw.write(v.toString());
            fw.close();
            System.out.println("VENUE HAS SUCCESSFULLY ADDED.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Venue> getVenues(String file_venues) {
        List<Venue> venues = new ArrayList<>();
        File file = new File(file_venues);
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
                venues.add(new Venue(
                        Integer.parseInt(content[0]),
                        content[1],
                        Integer.parseInt(content[2]),
                        Boolean.parseBoolean(content[3]))
                );
            }
        }
        return venues;
    }

    public void getAllVenues() {
        displayVenues(getVenues(file_venues));
    }

    private void displayVenues(List<Venue> venues) {
        if (venues.size() > 0) {
            System.out.println("============================================================");
            System.out.printf("%5s %17s %17s %17s", "ID", "VENUE NAME", "RENT", "STATUS");
            System.out.println();
            System.out.println("============================================================");
            for (Venue v : venues) {
                System.out.format("%5s %17s %17s %17s", v.getVenueId(), v.getVenueName(), v.getVenueRent(), v.isVenueStatus() ? "AVAILABLE" : "BOOKED");
                System.out.println();
            }
            System.out.println("============================================================");
        } else {
            System.out.println("ERROR : NO DATA PRESENT AT THIS MOMENT.");
        }
    }

    public void editVenue() {
        getAllVenues();
        System.out.println("ENTER THE ");
    }

    public void deleteVenue() {
        try {
            Scanner sc = new Scanner(System.in);
            List<Venue> allVenues = getVenues(file_venues);
            List<Venue> bookedVenues = getVenues(file_booked_Venues);
            if (bookedVenues.size() > 0) {
                displayVenues(bookedVenues);
                System.out.print("ENTER THE VENUE ID TO REMOVE - ");
                int venue_id = sc.nextInt();
                if (isBooked(bookedVenues, venue_id)) {
                    System.out.println("ERROR : THIS VENUE CANNOT BE REMOVED AS IT IS BOOKED FOR AN EVENT.");
                } else {
                    if (bookedVenues.removeIf(n -> (n.getVenueId() == venue_id))) {
                        allVenues.removeIf(n -> (n.getVenueId() == venue_id));

                        File allvenues = new File(file_venues);
                        File myvenues = new File(file_booked_Venues);
                        FileWriter fw1 = new FileWriter(allvenues);
                        FileWriter fw2 = new FileWriter(myvenues);

                        for (Venue c : bookedVenues) {
                            fw2.write(c.toString());
                        }
                        for (Venue c : allVenues) {
                            fw1.write(c.toString());
                        }

                        fw1.close();
                        fw2.close();
                        System.out.println("VENUE SUCCESSFULLY REMOVED FROM THE LIST.");
                    } else {
                        System.out.println("ERROR : INCORRECT VENUE ID.");
                    }
                }
            } else {
                System.out.println("ERROR : NO VENUE FOUND IN YOUR LIST.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isBooked(List<Venue> bookedVenues, int venue_id) {
        boolean booked_status = false;
        for (Venue v : bookedVenues) {
            if (v.getVenueId() == venue_id && v.isVenueStatus() == false) {
                booked_status = true;
                break;
            }
        }
        return booked_status;
    }
}
