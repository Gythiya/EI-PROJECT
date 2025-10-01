package exercise2;

import java.util.*;

public class VirtualClassroomManager {

    private static VirtualClassroomManager instance;
    private final Map<String, List<Classroom>> classroomsByType = new HashMap<>();
    private final Map<String, Student> students = new HashMap<>();

    private VirtualClassroomManager() {
        classroomsByType.put("Core", new ArrayList<>());
        classroomsByType.put("Interdepartment", new ArrayList<>());
        classroomsByType.put("Practical", new ArrayList<>());
    }

    public static VirtualClassroomManager getInstance() {
        if(instance == null) instance = new VirtualClassroomManager();
        return instance;
    }

    public void addClassroom(String type, String name) {
        Classroom c = ClassroomFactory.createClassroom(type, name);
        classroomsByType.get(type).add(c);
        LoggerManager.getInstance().log(type + " classroom added: " + name);
    }

    public Classroom getClassroom(String type, String name) {
        return classroomsByType.get(type).stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Classroom> getClassroomsByType(String type) {
        return classroomsByType.get(type);
    }

    public void addStudent(String id, String type, String classroomName) {
        Student s = students.computeIfAbsent(id, Student::new);
        Classroom c = getClassroom(type, classroomName);
        if(c != null) { c.addStudent(s); LoggerManager.getInstance().log("Student " + id + " added to " + classroomName); }
    }

    public Student getStudent(String id) { 
        return students.get(id); 
    }
    
    // Remove a classroom by type and name
   public void removeClassroom(String type, String name) {
    List<Classroom> cls = classroomsByType.get(type);
    if(cls == null || cls.isEmpty()) {
        System.out.println("No classrooms of type " + type);
        return;
    }
    boolean removed = cls.removeIf(c -> c.getName().equals(name));
    if(removed) {
        LoggerManager.getInstance().log(type + " classroom removed: " + name);
    } else {
        System.out.println("Classroom not found: " + name);
    }
}

// Remove an assignment from a classroom
public void removeAssignment(String type, String classroomName, String assignmentTitle) {
    Classroom c = getClassroom(type, classroomName);
    if(c == null) {
        System.out.println("Classroom not found: " + classroomName);
        return;
    }
    boolean removed = c.getAssignments().removeIf(a -> a.getTitle().equals(assignmentTitle));
    if(removed) {
        LoggerManager.getInstance().log("Assignment '" + assignmentTitle + "' removed from " + classroomName);
    } else {
        System.out.println("Assignment not found: " + assignmentTitle);
    }
}

}
