
# 🎓 Virtual Classroom Management Application

Welcome to the **Virtual Classroom Management Application**, a comprehensive **Java-based solution** for managing virtual classrooms efficiently. This application provides easy-to-use tools for **classroom management, student enrollment, assignment handling, and logging**, all designed to improve the user experience for educators and administrators.

---

## 🚀 Key Features

### 📌 **Classroom Management**

* Easily add or remove classrooms of types such as **Core, Interdepartment, and Practical**.
* View all classrooms in a **numbered list** for easy selection.
* Prevents duplicate classroom names.
* Can list all available classrooms.

### 👩‍🎓 **Student Management**

* Enroll students into classrooms.
* Prevents duplicate student enrollment.
* List all students present in a classroom.

### 📝 **Assignment Management**

* Schedule new assignments for classrooms.
* Remove assignments when no longer needed.
* Submit assignments through a **number-based system** (avoids spelling/typing errors).
* Prevents duplicate assignment scheduling and ensures only valid submissions.

### 🎛️ **User Experience Enhancements**

* User-friendly **numbered selection system** prevents errors and avoids typing mismatches.
* Validation checks for invalid or empty inputs for smoother operation.
* Clear console messages for better interaction.
* **Action logging** for transparency.

---

## 🛠️ Technologies & Design

* **Programming Language**: Java

### **Design Patterns Used**

* **Singleton** – Ensures a single instance of `VirtualClassroomManager` handles all classrooms and students.
* **Factory** – Simplifies creation of different classroom types (**Core, Interdepartment, Practical**).
* **Observer** – Monitors assignment submissions and updates logs accordingly.

### **Utilities**

* **Custom Logger** – Tracks actions like classroom creation, student enrollment, and assignment submissions.

### **Version Control**

* **Git**

---

## 📋 Prerequisites

Make sure you have the following installed:

* **Java Development Kit (JDK)**
* **Git**

---

## 🚀 Installation

### **Clone the Repository**

```bash
git clone https://github.com/Gythiya/EI-PROJECT.git
cd EI-PROJECT
```

### **Compile the Java Files**

```bash
javac -d bin src/exercise2/*.java
```

### **Run the Application**

```bash
java -cp bin exercise2.Main
```

---

## 📚 Usage Instructions

Once the application is running, follow the console prompts:

* **Add Classroom** → Choose type and input name.
* **Remove Classroom** → Select type and choose classroom by number.
* **Add Student** → Input student ID and select classroom by number.
* **Schedule Assignment** → Input title and assign to classroom.
* **Remove Assignment** → Select classroom and assignment by number.
* **Submit Assignment** → Select student, classroom, and assignment by number.
* **List Students in Classroom** → Displays all students numerically.
* **List Classrooms by Type** → Displays classrooms with numbers.
* **Exit Application** → Terminates the program.

---

## 📜 Code Structure

* **Main.java** – Handles user input, menu, and workflows.
* **VirtualClassroomManager.java** – Central management of classrooms and students.
* **Classroom.java** – Represents classroom entities and assignment management.
* **Student.java** – Represents student information and assignment submissions.
* **Assignment.java** – Represents individual assignments.
* **LoggerManager.java** – Handles custom logging.
* **ClassroomFactory.java** – Creates classroom instances (**Core, Interdepartment, Practical**).

---

## 🤝 Contributing

Contributions are welcome! 🎉
Please **fork the repository** and submit a **pull request** with details of your changes.

---



# 🖥️ Design Patterns Implementation in Java

This project demonstrates the implementation of **design patterns** in Java, covering **Creational, Structural, and Behavioral** categories. Each pattern includes a real-world use case to show how it improves code flexibility, maintainability, and scalability.

---

## 🏭 1. Creational Patterns

### 1️⃣ Factory Method Pattern

**Package:** `exercise1.creational.factory`

**Purpose:**
The Factory Method pattern provides a way to **create objects without specifying the exact class**. It promotes flexibility and scalability by encapsulating object creation logic.

**Use Case in This Project:**
Used to **dynamically create different types of alerts** (Critical, Warning, Info) based on user input. New alert types can be added easily without modifying client code.

#### 🔹 Classes and Functionality

* `Alert` – Interface defining alert behavior.
* `CriticalAlert`, `WarningAlert`, `InfoAlert` – Concrete alert implementations.
* `AlertFactory` – Factory class responsible for creating alerts.
* `AlertManager` – Menu-driven manager for creating and triggering alerts.
* `Main` – Entry point to start the alert system.

#### 🔹 How it works

1. User selects the alert type.
2. `AlertFactory` creates the corresponding alert object.
3. Alert is triggered, displaying messages and executing actions.

---

### 2️⃣ Prototype Pattern

**Package:** `exercise1.creational.prototype`

**Purpose:**
The Prototype pattern **creates new objects by cloning existing ones**, avoiding costly setup or repeated configuration.

**Use Case in This Project:**
Used to **clone documents** (resumes or reports) from templates. Users can modify only specific fields while retaining formatting and default settings.

#### 🔹 Classes and Functionality

* `DocumentPrototype` – Interface defining cloning behavior.
* `ResumeDocument` – Concrete prototype for resumes.
* `ReportDocument` – Concrete prototype for reports.
* `Editor` – Menu-driven editor for creating and cloning documents.
* `Main` – Entry point to start the editor.

#### 🔹 How it works

1. Base templates are created for resumes and reports.
2. User selects a document type and provides details.
3. A new document is **cloned** from the template with updated information.
4. User can display document details.


---

## 🧩 2. Structural Patterns

### 1️⃣ Adapter Pattern

**Package:** `exercise1.structural.adapter`

**Purpose:**
The Adapter pattern **converts the interface of a class into another expected by the client**, enabling incompatible interfaces to work together.

**Use Case in This Project:**
Used to read **JSON and CSV sensor data** through a common interface (`SensorData`). Users interact with a single interface without worrying about the sensor’s format.

#### 🔹 Classes and Functionality

* `SensorData` – Interface defining `readData()` for all sensors.
* `JsonSensor` – Provides sensor data in JSON format.
* `CsvSensor` – Provides sensor data in CSV format.
* `SensorAdapter` – Adapts JSON or CSV sensor data to `SensorData` interface.
* `SensorManager` – Menu-driven manager for reading sensor data.
* `Main` – Entry point to start the sensor manager.

#### 🔹 How it works

1. User selects a sensor type (JSON or CSV).
2. `SensorAdapter` converts the sensor’s data to a common format.
3. `SensorManager` reads and displays data uniformly.

---

### 2️⃣ Facade Pattern

**Package:** `exercise1.structural.facade`

**Purpose:**
The Facade pattern **provides a simplified interface to a complex subsystem**, hiding internal complexities.

**Use Case in This Project:**
Used for **payment processing**, which involves multiple services: fraud check, payment gateway, invoice generation, and customer notifications.

#### 🔹 Classes and Functionality

* `PaymentFacade` – Simplified interface to handle the complete payment process.
* `FraudCheckService` – Performs fraud detection on orders.
* `PaymentGateway` – Handles the actual payment transaction.
* `InvoiceService` – Generates invoices.
* `NotificationService` – Sends notifications to customers.
* `Order` – Represents an order (ID, amount, customer).
* `PaymentEditor` – Menu-driven interface for creating orders and processing payments.
* `Main` – Entry point to start the payment system.

#### 🔹 How it works

1. User enters order details.
2. `PaymentFacade` orchestrates all services:

   * Performs fraud check.
   * Processes payment.
   * Generates invoice.
   * Notifies the customer.
3. Users interact with a **single, simplified interface**.


---

## 💬 3. Behavioral Patterns

### 1️⃣ Chain of Responsibility Pattern

**Package:** `exercise1.behavioral.chain`

**Purpose:**
The Chain of Responsibility pattern **passes a request along a chain of handlers**, allowing multiple objects a chance to handle it.

**Use Case in This Project:**
Used for **ATM cash dispensing**, where different denominations handle the requested amount sequentially.

#### 🔹 Classes and Functionality

* `DispenseChain` – Interface defining `setNextChain()` and `dispense()`.
* `Rupee2000Dispenser`, `Rupee500Dispenser`, `Rupee100Dispenser`, `Rupee50Dispenser` – Concrete handlers.
* `ATMDispenserClient` – Initializes chain and handles user input.

#### 🔹 How it works

1. ATM initializes a chain of dispensers from largest to smallest denomination.
2. User enters withdrawal amount.
3. Each handler dispenses its notes and passes remainder to the next handler.

---

### 2️⃣ Strategy Pattern 

**Package:** `exercise1.behavioral.strategy`

**Purpose:**
The Strategy pattern allows **choosing algorithms or behaviors at runtime**, promoting flexibility and maintainability.

**Use Case in This Project:**
Used to select **different payment methods** (Credit Card or UPI) for a shopping cart dynamically.

#### 🔹 Classes and Functionality

* `PaymentStrategy` – Interface defining `pay()` method.
* `CreditCardPayment`, `UPIPayment` – Concrete strategies for payments.
* `ShoppingCart` – Context class that uses the selected payment strategy.
* `Main` – Demonstrates runtime selection of payment strategy.

#### 🔹 How it works

1. User enters the **amount to pay**.
2. User selects a **payment method**.
3. `ShoppingCart` sets the chosen strategy and calls `checkout()`.
4. Payment is processed according to the selected strategy.


## 🛠️ Technologies Used

* **Language:** Java
* **Version Control:** Git

## 📜 License

This project is licensed under the MIT License. For more details, see the LICENSE file. 

## 📧 Contact

**👩‍💻 Author**: Gythiya Sree V S V

* **Email**: [gythiya24@gmail.com](mailto:gythiya24@gmail.com)
* **GitHub**: [Gythiya](https://github.com/Gythiya)

