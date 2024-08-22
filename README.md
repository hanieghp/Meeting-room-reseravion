# Room Reservation System
## Project Overview
The Room Reservation System is a Java-based application that allows users to manage room reservations efficiently. The system supports different roles, including User, Manager, and Admin. Each role has specific functionalities, ensuring a smooth and organized room management process.

## Key Features:
- User: View available rooms, send reservation requests, check reservation status.
* Manager: View all rooms, add a room, delete a room.
+ Admin: View the list of reservation requests, confirm or reject current requests.

## File and Folder Structure
```
RoomReservationSystem/
│
├── src/
│   ├── org/example/
│   │   ├── Auth.java               // Handles authentication (signup and login)
│   │   ├── Main.java               // Main entry point for the application
│   │   ├── SqlConnection.java      // Handles database connections and queries
│   │   ├── Impl/                   // Implementation of interfaces
│   │   │   ├── ManagerImpl.java    
│   │   │   ├── UserImpl.java       
│   │   │   ├── AdminImpl.java      
│   │   ├── entity/                 // Entities for database representation
│   │   │   ├── Room.java
│   │   │   ├── User.java
│   │   │   ├── Reservation.java    
│   │   ├── interfaces/             // Interfaces for different roles
│   │       ├── ManagerInterface.java
│   │       ├── UserInterface.java
│   │       ├── AdminInterface.java 
│   └── README.md                   // Project documentation
│
├── resources/                      // Resources for project execution
│
└── build/                          // Build outputs


```
## How to Run and Use
### Prerequisites:
- Java Development Kit (JDK) installed.
* MySQL database server running and accessible.
+ Ensure the MySQL database connection details (URL, USER, PASSWORD) in SqlConnection.java are correctly configured.
### Steps to Run:
1. Compile the project:  
Open the terminal/command prompt and navigate to the project directory. Run:  
`javac -d build src/org/example/*.java src/org/example/Impl/*.java src/org/example/entity/*.java src/org/example/interfaces/*.java`
3. Run the project:  
After successful compilation, run the application using:  
`java -cp build org.example.Main`
4. Using the application:  
   - Signup: Enter signup when prompted, and follow the steps to create a new user with a specific role.
   * Login: Enter login to access the system with your credentials. The system will direct you based on your role.

## Resources and References
All related study materials, documentation, and resources are available in the [shared folder](https://podspace.ir/public/folders/QX5JZ5UDDK636KM1) on the public space (Padaspace).
