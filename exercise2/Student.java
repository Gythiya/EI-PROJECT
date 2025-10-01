package exercise2;

public class Student implements Observer {

    private final String id;

    public Student(String id) { this.id = id; }

    public String getId() { return id; }

    public void submitAssignment(String classroomName, String assignmentTitle) {
        LoggerManager.getInstance().log("Student " + id + " submitted '" + assignmentTitle + "' in " + classroomName);
    }

    @Override
    public void update(Assignment assignment) {
        System.out.println("[Notification → " + id + "] New assignment: " + assignment.getTitle());
    }
}
