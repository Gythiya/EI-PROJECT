package exercise1.creational.prototype;
import java.util.Scanner;

public class Editor {
    private ResumeDocument resumeTemplate;
    private ReportDocument reportTemplate;
    private DocumentPrototype currentDocument;
    private Scanner scanner;

    public Editor(ResumeDocument resumeTemplate, ReportDocument reportTemplate) {
        this.resumeTemplate = resumeTemplate;
        this.reportTemplate = reportTemplate;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\nWelcome to Document Editor.");
        System.out.println("1. Create New Document");
        System.out.println("2. Display Current Document");
        System.out.println("3. Exit");

        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                createNewDocument();
                start();
                break;

            case "2":
                displayDocument();
                start(); 
                break;

            case "3":
                System.out.println("Exiting program.");
                scanner.close();
                break;

            default:
                System.out.println("Invalid choice. Try again.");
                start();
                break;
        }
    }

    private void createNewDocument() {
        System.out.println("What type of document do you want to create? (resume/report)");
        String docType = scanner.nextLine().trim().toLowerCase();

        switch (docType) {
            case "resume":
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Skills: ");
                String skills = scanner.nextLine();
                currentDocument = resumeTemplate.cloneWith(name, skills);
                System.out.println("\nResume document created.");
                break;

            case "report":
                System.out.print("Enter Report Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Author Name: ");
                String author = scanner.nextLine();
                currentDocument = reportTemplate.cloneWith(title, author);
                System.out.println("\nReport document created.");
                break;

            default:
                System.out.println("\nInvalid document type! Please enter 'resume' or 'report'.\n");
                break; 
        }
    }

    private void displayDocument() {
        if (currentDocument == null) {
            System.out.println("No document created yet.");
        } else {
            currentDocument.showDetails();
        }
    }
}
