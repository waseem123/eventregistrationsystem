import java.util.Date;

public class Events {
    private int eventId;
    private String eventName;
    private Date eventDate;
    private boolean booked;

    public Events(int eventId, String eventName, Date eventDate, boolean booked) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.booked = booked;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return eventId +":" + eventName + ":" + eventDate +":" + booked+";";
    }
}
