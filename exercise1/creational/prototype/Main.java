package exercise1.creational.prototype;

public class Main {
    public static void main(String[] args) {
        // Base templates
        ResumeDocument resumeTemplate = new ResumeDocument("Default Name", "Default Skills", "Arial", "Left");
        ReportDocument reportTemplate = new ReportDocument("Default Report", "Admin", "Times New Roman", "Justify");

        // Start editor
        Editor editor = new Editor(resumeTemplate, reportTemplate);
        editor.start();
    }
}
