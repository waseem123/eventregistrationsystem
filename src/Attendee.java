public class Attendee {
    private int attendeeId;
    private String attendeeName;
    private String attendeeEmail;
    private String attendeeMobileNo;
    private int attendeeEventId;

    public Attendee(int attendeeId, String attendeeName, String attendeeEmail, String attendeeMobileNo, int attendeeEventId) {
        this.attendeeId = attendeeId;
        this.attendeeName = attendeeName;
        this.attendeeEmail = attendeeEmail;
        this.attendeeMobileNo = attendeeMobileNo;
        this.attendeeEventId = attendeeEventId;
    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public String getAttendeeEmail() {
        return attendeeEmail;
    }

    public void setAttendeeEmail(String attendeeEmail) {
        this.attendeeEmail = attendeeEmail;
    }

    public String getAttendeeMobileNo() {
        return attendeeMobileNo;
    }

    public void setAttendeeMobileNo(String attendeeMobileNo) {
        this.attendeeMobileNo = attendeeMobileNo;
    }

    public int getAttendeeEventId() {
        return attendeeEventId;
    }

    public void setAttendeeEventId(int attendeeEventId) {
        this.attendeeEventId = attendeeEventId;
    }

    @Override
    public String toString() {
        return attendeeId +":" + attendeeName +":" + attendeeEmail +":" + attendeeMobileNo + ":" + attendeeEventId +',';
    }
}
