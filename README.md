📚 Virtual Classroom Management Application

Welcome to the Virtual Classroom Management Application, a comprehensive Java-based solution for managing virtual classrooms efficiently. This application provides easy-to-use tools for classroom management, student enrollment, assignment handling, and logging, all designed to improve the user experience for educators and administrators.

🚀 Key Features
📌 Classroom Management

Easily add or remove classrooms of types such as Core, Interdepartment, and Practical.

View all classrooms in a numbered list for easy selection.

Prevents duplicate classroom names.

Can list all available classrooms.

👩‍🎓 Student Management

Enroll students into classrooms.

Prevents duplicate student enrollment.

List all students present in a classroom.

📝 Assignment Management

Schedule new assignments for classrooms.

Remove assignments when no longer needed.

Submit assignments through a number-based system (avoids spelling/typing errors).

Prevents duplicate assignment scheduling and ensures only valid submissions.

🎛️ User Experience Enhancements

User-friendly numbered selection system prevents errors and avoids typing mismatches.

Validation checks for invalid or empty inputs for smoother operation.

Clear console messages for better interaction.

Action logging for transparency.

🛠️ Technologies & Design

Programming Language: Java

Design Patterns Used

Singleton – Ensures a single instance of VirtualClassroomManager handles all classrooms and students.

Factory – Simplifies creation of different classroom types (Core, Interdepartment, Practical).

Observer – Monitors assignment submissions and updates logs accordingly.

Utilities

Custom Logger – Tracks actions like classroom creation, student enrollment, and assignment submissions.

Version Control

Git

📋 Prerequisites

Ensure you have the following installed:

Java Development Kit (JDK)

Git

🚀 Installation
Clone the Repository
git clone https://github.com/Gythiya/EI-PROJECT.git
cd EI-PROJECT

Compile the Java Files
javac -d bin src/exercise2/*.java

Run the Application
java -cp bin exercise2.Main

📚 Usage Instructions

Once the application is running, follow the console prompts:

Add Classroom: Choose type and input name.

Remove Classroom: Select type and choose classroom by number.

Add Student: Input student ID and select classroom by number.

Schedule Assignment: Input title and assign to classroom.

Remove Assignment: Select classroom and assignment by number.

Submit Assignment: Select student, classroom, and assignment by number.

List Students in Classroom: Displays all students numerically.

List Classrooms by Type: Displays classrooms with numbers.

Exit Application: Terminates the program.

📜 Code Structure

Main.java – Handles user input, menu, and all workflows.

VirtualClassroomManager.java – Central management of classrooms and students.

Classroom.java – Represents classroom entities and assignment management.

Student.java – Represents student information and assignment submissions.

Assignment.java – Represents individual assignments.

LoggerManager.java – Handles custom logging.

ClassroomFactory.java – Creates classroom instances (Core, Interdepartment, Practical).

🤝 Contributing

Contributions are welcome! Please fork the repository and submit a pull request with details of your changes.



📧 Contact

Gythiya Sree V S V

Email: gythiya24@gmail.com

GitHub: Gythiya