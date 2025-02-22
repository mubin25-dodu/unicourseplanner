
#   [AIUB Course Planner](https://github.com/mubin25-dodu/unicourseplanner)


## Introduction
**AIUB Course Planner** is a Java-based application designed to help students and administrators manage university courses efficiently. The system provides features such as user authentication, course management, and a user-friendly interface. It is aimed at streamlining the course selection process while ensuring ease of access to course-related data.

## What Did We Implement?
We implemented a **Java-based course planning system** with the following features:
- **User Authentication**: Secure login and signup for students and administrators.
- **Admin Panel**: Allows administrators to manage courses, users, and department data.
- **Course Management**: Enables students to view and select courses.
- **Data Handling**: Stores and retrieves course, user, and department information.
- **Graphical User Interface (GUI)**: Built using Java Swing for an interactive experience.
- **File Handling**: Reads and writes data to files for persistent storage.

## Why Did We Implement This?
The main motivation behind this project was:
- **Practical application of Object-Oriented Programming (OOP) principles** in a real-world scenario.
- **Developing a functional system** to assist students and administrators in course selection.
- **Enhancing Java programming skills**, particularly in GUI development, file handling, and data structures.
- **Understanding software development lifecycle** from planning to implementation.

## Significance of the Project
This project is significant because:
- It demonstrates the use of **Java for real-world applications**.
- It showcases how **OOP principles** can be used to build modular and scalable applications.
- It provides a **learning resource for students** interested in Java and GUI development.
- It serves as a **foundation for further improvements**, such as database integration and AI-based course recommendations.

## Target Population
This project is useful for:
- **University students** looking for a structured way to plan courses.
- **Educators and administrators** managing course data.
- **Java developers** interested in GUI-based applications.
- **OOP learners** wanting hands-on experience in Java programming.

## Tools Used in the Project
- **Java**: Primary programming language for the system.
- **Swing**: Used for GUI development.
- **File Handling**: Used for storing and retrieving course and user data.
- **Eclipse/IntelliJ IDEA**: IDEs used for development and debugging.

## Example Functions
### 1. User Authentication (Login System)
```java
public boolean authenticate(String username, String password) {
    if (storedUsers.containsKey(username) && storedUsers.get(username).equals(password)) {
        return true;
    }
    return false;
}
```
This function verifies if a username and password match the stored data.

### 2. Course Selection
```java
public void addCourse(String courseCode) {
    if (!selectedCourses.contains(courseCode)) {
        selectedCourses.add(courseCode);
    }
}
```
This function allows students to add a course to their selection list.

### 3. File Handling for Data Storage
```java
public void saveDataToFile(String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        for (String data : courseList) {
            writer.write(data + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```
This function saves course data to a file for persistent storage.

## Knowledge Applied
- **Object-Oriented Programming (OOP)**: Implementing classes, inheritance, and encapsulation.
- **GUI Development**: Using Swing for building an interactive user interface.
- **File Handling**: Reading and writing data to files for persistent storage.
- **Event-Driven Programming**: Handling user interactions in the application.
- **Data Structures**: Managing course lists and user information efficiently.

## Field for Higher Study Purpose
This project can serve as a starting point for exploring:
- **Advanced Java Programming**: Learning about JavaFX, multithreading, and networking.
- **Database Management**: Replacing file handling with SQL databases for efficient data storage.
- **Machine Learning for Course Recommendation**: Implementing AI-based suggestions for students.
- **Cloud-Based Course Management**: Hosting the system online for wider accessibility.
![Login](https://github.com/mubin25-dodu/unicourseplanner/blob/main/oop%20project%201/Images/Screenshot%202025-02-01%20061353.png)
![Signup](https://github.com/mubin25-dodu/unicourseplanner/blob/main/oop%20project%201/Images/Screenshot%202025-02-01%20061420.png)
![Home page](https://github.com/mubin25-dodu/unicourseplanner/blob/main/oop%20project%201/Images/Screenshot%202025-02-01%20061513.png)
By working on this project, students and developers gain hands-on experience in Java development, preparing them for more advanced studies in **software engineering, data management, and artificial intelligence**.

---

## How to Run the Project
1. Clone the repository:
   ```bash
   git clone (https://github.com/mubin25-dodu/unicourseplanner.git)
   ```
2. Open the project in an IDE (Eclipse or IntelliJ IDEA).
3. Compile and run the `AIUBCoursePlanner.java` file.

## Future Improvements
- Implementing **database storage** instead of file handling.
- Adding **real-time course recommendations** based on AI.
- Enhancing **user experience with better UI design**.


