package exercise2;

public class ClassroomFactory {

    public static Classroom createClassroom(String type, String name) {
        return new Classroom(name);
    }
}
