/**
 * Created by Alien on 04.11.2014.
 */
public class Person {
    private final String firstName;
    private final String secondName;
    private final int age;
    private final String email;
    private final Position position;

    public String getEmail (){
        return this.email;
    }
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (age != person.age) return false;
        if (!email.equals(person.email)) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (!secondName.equals(person.secondName)) return false;
        if (position != person.position) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + age;
        result = 31 * result + position.hashCode();
        return result;
    }
    public Person(PersonBuilder builder) {
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.age = builder.age;
        this.email = builder.email;
        this.position = builder.position;
    }

    public static class PersonBuilder {
        private final String firstName;
        private final String secondName;
        private int age;
        private String email;
        private Position position;

        public PersonBuilder(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PersonBuilder position(Position position) {
            this.position = position;
            return this;
        }


        public Person build() {
            return new Person (this);
        }

    }


}
