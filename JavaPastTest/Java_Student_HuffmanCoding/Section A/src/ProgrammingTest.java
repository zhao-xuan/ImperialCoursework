import java.util.HashSet;
import java.util.Set;

public class ProgrammingTest {

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        Academic tutor1 = new Academic("Ricardo Rodriguez");
        Academic tutor2 = new Academic("Ismael Bento");
        students.add(new Undergraduate("gg4",
                "Gareth Gail", "gg4@ic.ac.uk", tutor1));
        students.add(new Undergraduate("pr3",
                "Peter Rainhurt", "pr3@ic.ac.uk", tutor2));
        students.add(new Postgraduate("te2",
                "Terry Emanuel", "te2@ic.ac.uk", tutor1));
        students.add(new Postgraduate("yj34",
                "Young Jia", "yj34@ic.ac.uk", tutor2));
        students.add(new Postgraduate("jj8",
                "Jack Jin", "jj8@ic.ac.uk", tutor2));
        Course course = new Course("example", students);
        course.getPostgraduates("Ismael Bento")
                .stream().forEach(i -> i.notify("You have been notified!"));
    }

}
