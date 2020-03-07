import java.util.Set;
import java.util.stream.Collectors;

public class Course {
    private String name;
    private Set<Student> students;

    public Course(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    public Set<Student> getPostgraduates(String staffName) {
        return students.stream()
                .filter(i ->
                        i.getClass().getName() == "Postgraduate"
                        && ((Postgraduate) i).getSupervisor().getName() == staffName)
                .collect(Collectors.toSet());
    }


}
