/**
 * Created by Alien on 04.11.2014.
 */
import java.util.*;

public class Event {
    private final String title;
    private final String description;
    private final String email;
    private final UUID id;
    private   List<String> attenders;
    private final Date startDate;
    private final Date endDate;

    public Event(EventBuilder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.email = builder.email;
        this.id = builder.id;
        this.attenders = builder.attenders;
        this.startDate=builder.startDate;
        this.endDate=builder.endDate;

    }
    public UUID getID () {
        return this.id;
    }



    public void addAttender(String attender){
        if (this.attenders == null)
            this.attenders = new ArrayList<String>();

        this.attenders.add(attender);
    }

    @Override
    public String toString() {
        return "Event{" + "title=" + title + ", description=" + description + ", email=" + email + ", id=" + id + ", attenders=" + attenders + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.title);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.attenders);
        hash = 83 * hash + Objects.hashCode(this.startDate);
        hash = 83 * hash + Objects.hashCode(this.endDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.attenders, other.attenders)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        return true;
    }

    public static class EventBuilder {
        private final String title;
        private final String description;
        private String email;
        private UUID id;
        private  List<String> attenders;
        private  Date startDate;
        private  Date endDate;

        public EventBuilder (String title,String description) {
            this.title = title;
            this.description = description;
        }

        public EventBuilder email(String email) {
            this.email = email;
            return this;
        }

        public EventBuilder attenders(List<String> attenders) {
            this.attenders = attenders;
            return this;
        }


        public EventBuilder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }


        public EventBuilder endDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }


        public Event build() {
            this.id = UUID.randomUUID();
            return new Event(this);
        }
    }
}
