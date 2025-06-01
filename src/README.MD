# 🚕 RideBuddy – Ride-Sharing Backend (Java)

RideBuddy is a fully in-memory, object-oriented backend simulation of a ride-sharing service like Uber or Ola. This project was built using core Java, applying SOLID principles and multiple design patterns as part of the CoderArmy LLD Hackathon challenge.

---

## 📦 Project Structure


---

## 🎯 Objective

The goal of this project is to design and implement a ride-sharing backend with clean low-level design using object-oriented principles. The system is built to support extensibility, clarity, and clean abstractions using SOLID principles and design patterns. Everything is managed in-memory with no use of external databases or frameworks.

---

## 📐 Architecture & UML Diagrams

Class and Sequence diagrams are provided under the `UML/` folder:

- `class_diagram.png`: Shows all entities, services, and relationships
- `sequence_diagram.png`: Demonstrates flow from ride request to completion

---

## 🧠 SOLID Principles Applied

- ✅ **Single Responsibility Principle**: Each class handles only one responsibility. For instance, `DriverService` manages only driver-related logic.
- ✅ **Open/Closed Principle**: The system is open for extension (e.g., adding new ride types or matching strategies) but closed for modification of existing logic.
- ✅ **Liskov Substitution Principle**: Interfaces like `MatchingStrategy` and `FareCalculator` allow new strategies without breaking current logic.
- ✅ **Interface Segregation Principle**: Interfaces are small and specific. Fare calculation, ride updates, and notifications are separated.
- ✅ **Dependency Inversion Principle**: High-level modules depend on abstractions (e.g., `NotificationService`, `MatchingStrategy`) rather than concrete classes.

---

## 🎨 Design Patterns Used

- 🧠 **Strategy Pattern**: Used for driver matching algorithms (`NearestMatchStrategy`, `HighestRatedStrategy`) to keep the logic pluggable.
- 🏭 **Factory Pattern**: Used to create different ride/vehicle types dynamically based on user input.
- 🧍‍♂️ **Singleton Pattern**: Used for manager classes like `RideService`, `DriverService`, and `NotificationService` to maintain single instances.
- 👀 **Observer Pattern**: Used to send notifications to riders and drivers when ride status changes or payments are completed.
- 🎁 **Decorator Pattern**: Used to dynamically add pricing rules such as surge pricing or discounts on top of base fare calculation.

---

## 🧪 How to Run

### Requirements
- Java 11+ installed
- Any IDE like IntelliJ or Eclipse, or CLI setup

### Run Instructions
1. Open the project in your preferred Java IDE.
2. Navigate to `src/Main.java`.
3. Run `Main.java` as a Java Application.

The console output will simulate:
- Rider and driver registration
- Ride request and driver assignment based on matching strategy
- Ride status transitions: en route → in progress → completed
- Fare calculation with optional pricing rules
- Notifications sent to users via print statements

---

## 📝 Assumptions & Trade-offs

- All rides occur in a single city with simplified distance simulation
- Matching is based on hardcoded location and rating values
- Drivers always accept rides for this prototype (though the system can simulate rejections)
- Fare is calculated as base fare + per km rate, with decorators for surge or discounts
- Notifications and payments are simulated using print statements
- No threading or concurrent operations; single-threaded environment only
- No persistence layer; all data is in-memory using Java collections

---

## ✔️ Features Implemented

- [x] Rider and Driver Registration
- [x] Ride Booking with Matching Strategy
- [x] Two Driver Matching Strategies (Nearest & Highest Rated)
- [x] Ride Types (Bike, Sedan, SUV, Auto-Rickshaw)
- [x] Carpool and Normal Ride Support
- [x] Dynamic Fare Calculation with Decorators
- [x] Notification System using Observer Pattern
- [x] In-Memory Data Storage and Ride Lifecycle Tracking

---

## 🙌 Final Notes

This project was built with a strong focus on maintainability, modularity, and extensibility. The design choices made prioritize clean code architecture and prepare the system for future features like scheduled rides, dynamic driver ratings, and more.

Feel free to explore the code and diagrams to understand the application of design patterns and SOLID principles in a real-world inspired system!

