/**
 * Created by Alien on 04.11.2014.
 */
import java.util.*;


/**
 *
 * @author Alien
 */
public class CalendarService {
    Map<UUID, Event> DataStorehashmap = new HashMap<UUID, Event>();

    public void addEvent(Event event) {
        DataStorehashmap.put(event.getID(), event);
    }

    public UUID createEvent(String description, List<String> emails) {
        Event e1 = new Event.EventBuilder(" ", description).build();
        for (String i : emails) {
            e1.addAttender(i);
        }
        DataStorehashmap.put(e1.getID(), e1);
        return e1.getID();
    }
}
