package exercise2;

import java.util.ArrayList;
import java.util.List;

public class Classroom implements ClassroomOperations {

    private final String name;
    private final List<Student> students = new ArrayList<>();
    private final List<Assignment> assignments = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    public Classroom(String name) { this.name = name; }

    public String getName() { return name; }
    public List<Student> getStudents() { return students; }
    public List<Assignment> getAssignments() { return assignments; }

    public void addStudent(Student s) {
        students.add(s);
        attach(s);
    }

    public void scheduleAssignment(Assignment a) {
        assignments.add(a);
        notifyAllObservers(a);
    }

    private void attach(Observer o) { observers.add(o); }
    private void notifyAllObservers(Assignment a) { observers.forEach(o -> o.update(a)); }
}
