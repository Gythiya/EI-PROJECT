package exercise2;

import java.util.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final VirtualClassroomManager manager = VirtualClassroomManager.getInstance();

    public static void main(String[] args) {
        System.out.println("Welcome to Virtual Classroom Manager!");
        start();
        sc.close();
        System.out.println("Exiting the application.");
    }

    private static void start() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add Classroom");
        System.out.println("2. Remove Classroom");
        System.out.println("3. Add Student");
        System.out.println("4. Schedule Assignment");
        System.out.println("5. Remove Assignment");
        System.out.println("6. Submit Assignment");
        System.out.println("7. List Students in a Classroom");
        System.out.println("8. List Classrooms by Type");
        System.out.println("9. Exit");
        System.out.print("Enter choice (1-9): ");

        String input = sc.nextLine().trim();
        switch (input) {
            case "1" -> addClassroomFlow();
            case "2" -> removeClassroomFlow();
            case "3" -> addStudentFlow();
            case "4" -> scheduleAssignmentFlow();
            case "5" -> removeAssignmentFlow();
            case "6" -> submitAssignmentFlow();
            case "7" -> listStudentsFlow();
            case "8" -> listClassroomsFlow();
            case "9" -> { return; }
            default -> System.out.println("Invalid choice. Enter 1-9.");
        }
        start(); 
    }

    private static String chooseCourseType() {
        System.out.println("Choose course type: 1.Core 2.Interdepartment 3.Practical");
        return switch (sc.nextLine().trim()) {
            case "1" -> "Core";
            case "2" -> "Interdepartment";
            case "3" -> "Practical";
            default -> {
                System.out.println("Invalid type, defaulting to Core.");
                yield "Core";
            }
        };
    }

    private static Classroom selectClassroom(String type) {
        List<Classroom> cls = manager.getClassroomsByType(type);
        if(cls.isEmpty()) { System.out.println("No classrooms available!"); return null; }

        System.out.println("Available Classrooms:");
        cls.forEach(c -> System.out.println("- " + c.getName()));

        System.out.print("Enter Classroom Name: ");
        String name = sc.nextLine().trim();
        if(name.isEmpty()) { System.out.println("Classroom name cannot be empty!"); return null; }

        Classroom c = manager.getClassroom(type, name);
        if(c == null) { System.out.println("Classroom not found!"); }
        return c;
    }

    // --- Classroom  Features---

    private static void addClassroomFlow() {
        String type = chooseCourseType();
        System.out.print("Enter Classroom Name: ");
        String name = sc.nextLine().trim();
        if(name.isEmpty()) { System.out.println("Classroom name cannot be empty!"); return; }
        manager.addClassroom(type, name);
        System.out.println("Classroom '" + name + "' added in " + type);
    }

    private static void removeClassroomFlow() {
        String type = chooseCourseType();
        Classroom c = selectClassroom(type);
        if(c == null) return;
        manager.removeClassroom(type, c.getName());
        System.out.println("Classroom '" + c.getName() + "' removed from " + type);
    }

   // --- Student & Assignment Features ---  

    private static void addStudentFlow() {
        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine().trim();
        if(studentId.isEmpty()) { System.out.println("Student ID cannot be empty!"); return; }

        String type = chooseCourseType();
        Classroom c = selectClassroom(type);
        if(c == null) return;

        manager.addStudent(studentId, type, c.getName());
        System.out.println("Student '" + studentId + "' enrolled in " + c.getName());
    }

    

    private static void scheduleAssignmentFlow() {
        String type = chooseCourseType();
        Classroom c = selectClassroom(type);
        if(c == null) return;

        System.out.print("Enter Assignment Title: ");
        String title = sc.nextLine().trim();
        if(title.isEmpty()) { System.out.println("Title cannot be empty!"); return; }

        boolean exists = c.getAssignments().stream()
                          .anyMatch(a -> a.getTitle().equalsIgnoreCase(title));
        if(exists) {
            System.out.println("Assignment already exists! Cannot schedule duplicate.");
            return;
        }

        c.scheduleAssignment(new Assignment(title));
        System.out.println("Assignment '" + title + "' scheduled in " + c.getName());
    }

    private static void removeAssignmentFlow() {
        String type = chooseCourseType();
        Classroom c = selectClassroom(type);
        if(c == null) return;

        if(c.getAssignments().isEmpty()) {
            System.out.println("No assignments to remove in " + c.getName());
            return;
        }

        System.out.println("Available Assignments:");
        c.getAssignments().forEach(a -> System.out.println("- " + a.getTitle()));

        System.out.print("Enter Assignment Title to remove: ");
        String title = sc.nextLine().trim();
        if(title.isEmpty()) { System.out.println("Title cannot be empty!"); return; }

        boolean removed = c.getAssignments().removeIf(a -> a.getTitle().equalsIgnoreCase(title));
        if(removed) {
            System.out.println("Assignment '" + title + "' removed from " + c.getName());
        } else {
            System.out.println("Assignment not found!");
        }
    }

    private static void submitAssignmentFlow() {
        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine().trim();
        Student s = manager.getStudent(studentId);
        if(s == null) { System.out.println("Student not found!"); return; }

        String type = chooseCourseType();
        Classroom c = selectClassroom(type);
        if(c == null) return;

        if(c.getAssignments().isEmpty()) {
            System.out.println("No assignments scheduled in " + c.getName());
            return;
        }

        System.out.println("Available Assignments:");
        c.getAssignments().forEach(a -> System.out.println("- " + a.getTitle()));

        System.out.print("Enter Assignment Title: ");
        String title = sc.nextLine().trim();
        if(title.isEmpty()) { System.out.println("Title cannot be empty!"); return; }

        boolean exists = c.getAssignments().stream()
                          .anyMatch(a -> a.getTitle().equalsIgnoreCase(title));
        if(!exists) {
            System.out.println("Assignment does not exist! Submission canceled.");
            return;
        }

        s.submitAssignment(c.getName(), title);
        System.out.println("Assignment '" + title + "' submitted by " + studentId);
    }



    private static void listStudentsFlow() {
        String type = chooseCourseType();
        Classroom c = selectClassroom(type);
        if(c == null) return;

        if(c.getStudents().isEmpty()) {
            System.out.println("No students in " + c.getName());
        } else {
            System.out.println("Students in " + c.getName() + ":");
            c.getStudents().forEach(s -> System.out.println("- " + s.getId()));
        }
    }

    private static void listClassroomsFlow() {
        String type = chooseCourseType();
        List<Classroom> cls = manager.getClassroomsByType(type);
        if(cls.isEmpty()) {
            System.out.println("No classrooms of type " + type);
            return;
        }
        System.out.println("Classrooms of type " + type + ":");
        cls.forEach(c -> System.out.println("- " + c.getName()));
    }
}
