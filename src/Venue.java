public class Venue {
    private int venueId;
    private String venueName;
    private int venueRent;
    private boolean venueStatus;

    public Venue() {
    }

    public Venue(String venueName, int venueRent, boolean venueStatus) {
        this.venueName = venueName;
        this.venueRent = venueRent;
        this.venueStatus = venueStatus;
    }

    public Venue(int venueId, String venueName, int venueRent, boolean venueStatus) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.venueRent = venueRent;
        this.venueStatus = venueStatus;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public int getVenueRent() {
        return venueRent;
    }

    public void setVenueRent(int venueRent) {
        this.venueRent = venueRent;
    }

    public boolean isVenueStatus() {
        return venueStatus;
    }

    public void setVenueStatus(boolean venueStatus) {
        this.venueStatus = venueStatus;
    }

    @Override
    public String toString() {
        return venueId + ":" + venueName + ":" + venueRent + ":" + venueStatus + ',';
    }
}
