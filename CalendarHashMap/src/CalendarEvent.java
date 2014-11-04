/**
 * Created by Alien on 04.11.2014.
 */
import java.sql.Date;
import java.util.*;


public class CalendarEvent {


    public static void main(String[] args) {
        Person p1 = new Person.PersonBuilder("Jhon", "Doe")
                .age(30)
                .email("f@g")
                .position(Position.Director)
                .build();
        Person p2 = new Person.PersonBuilder("Jhon", "Doe")
                .age(30)
                .email("f@g")
                .position(Position.Secretary)
                .build();

        Map<UUID, Event> Evthashmap = new HashMap<UUID, Event>();


        Event e1 = new Event.EventBuilder("Task1", "meeting2")
                .email("f@g")
                .startDate(Date.valueOf("2014-10-10"))
                .endDate(Date.valueOf("2014-10-11"))
                .build();
        e1.addAttender(p1.getEmail());

        Evthashmap.put(e1.getID(), e1);

        Event e2 = new Event.EventBuilder("Task2", "Meeting1")
                .email("f@g")
                .startDate(Date.valueOf("2014-10-10"))
                .endDate(Date.valueOf("2014-10-11"))
                .build();
        e2.addAttender(p2.getEmail());

        Evthashmap.put(e2.getID(), e2);

        for (UUID key : Evthashmap.keySet()) {
            System.out.println(Evthashmap.get(key));
        }

//
//              System.out.println(e1);
//              System.out.println(e2);
        System.out.println("Comparison by equals()- " + e1.equals(e2));
        System.out.println("Comparsion by HashCode " + (e1.hashCode() == e2.hashCode()));
        System.out.println("Event1" + (e1) + " Cравниваетса с Event 2" + (e2));



    }
}