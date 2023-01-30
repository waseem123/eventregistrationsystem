import java.text.SimpleDateFormat;
import java.util.Date;

public class Events {
    private int eventId;
    private String eventName;
    private Date eventDate;
    private String eventOrganizer;

    public Events() {
    }

    public Events(int eventId, String eventName, Date eventDate, String eventOrganizer) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventOrganizer = eventOrganizer;
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

    public String getEventOrganizer() {
        return eventOrganizer;
    }

    public void setEventOrganizer(String eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    @Override
    public String toString() {
        return "{" + eventId + ":" + eventName + ":" + eventOrganizer + ":" + new SimpleDateFormat("dd-MM-yyyy").format(eventDate) + "}";
    }
}
