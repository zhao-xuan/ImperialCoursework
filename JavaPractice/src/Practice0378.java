import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Person {
    String surname;
    String forename;
    String phoneNum;

    public Person(String forename, String surname, String phoneNum) {
        this.surname = surname;
        this.forename = forename;
        this.phoneNum = phoneNum;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String toString() {
        return "Name: " + forename + " " + surname + ", Tel: " + phoneNum;
    }
}

interface PersonComparator {
    public int compareTo(Person p1, Person p2);
}

class SurnameComparator implements PersonComparator {

    @Override
    public int compareTo(Person p1, Person p2) {
        return p1.getSurname().compareTo(p2.getSurname());
    }

}

class ForenameComparator implements PersonComparator {

    @Override
    public int compareTo(Person p1, Person p2) {
        return p1.getForename().compareTo(p2.getForename());
    }

}

class TelephoneNumberComparator implements PersonComparator {

    @Override
    public int compareTo(Person p1, Person p2) {
        return p1.getPhoneNum().compareTo(p2.getPhoneNum());
    }

}

public class Practice0378 {
    public static void main(String[] args) {
        Person p1 = new Person("Peter", "Zhang", "07421474987");
        Person p2 = new Person("Tom", "Zhao", "07421471909");
        Person p3 = new Person("Frank", "Dong", "07421471909");
        Person p4 = new Person("Cecilia", "Wang", "07421471909");
        Person p5 = new Person("Mark", "Yang", "07421471909");
        Person p6 = new Person("David", "Wan", "07421471909");
        Set<Person> persons = new HashSet<>(Arrays.asList(p1, p2, p3, p4, p5, p6));
        SurnameComparator sc = new SurnameComparator();
        ForenameComparator fc = new ForenameComparator();
        TelephoneNumberComparator tc = new TelephoneNumberComparator();

        System.out.println(sc.compareTo(p1, p2));
        System.out.println(fc.compareTo(p1, p2));
        System.out.println(tc.compareTo(p1, p2));
        System.out.println(findMin(persons, fc));
    }

    public static Person findMin(Set<Person> people, PersonComparator comparator) {
        //Person result = people.stream().reduce((x, y) -> comparator.compareTo(x, y) < 0 ? x : y).get();
        Person result = (Person) people.toArray()[0];
        for (Person person : people) {
            if (comparator.compareTo(result, person) > 0) {
                result = person;
            }
        }
        return result;
        //Impementation of the TwoTieredComparator is ignored
    }
}