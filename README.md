# Airport Runway Simulation 

This is a Java-based simulation of a small airport with a single runway, built as a Data Structures lab project. It implements a custom Queue Abstract Data Type (ADT) to manage air traffic based on strict priority rules

## Objective
To simulate a single-runway airport by applying a custom Queue data structure. The simulation manages two different priority levels of traffic: planes waiting in the air (Landing Queue) and planes waiting on the ground (Takeoff Queue).

## Rules & Logic
The system strictly enforces the following rule:
* **The Priority Rule (Landings First):** All planes in the air must land before any plane can take off. Even if a plane has been waiting on the ground for a long time, it must wait if there is a plane in the air.
* Only one plane can use the runway at any given time.

## Tech Stack & Data Structures
* **Language:** Java
* **Data Structure:** Custom Generics-based Queue implementation using a Linked List (`AirportImplementation<T>`).
* **Core Concepts:** Queues (FIFO), Linked Nodes, Object-Oriented Programming (OOP).

## How to Run
1. Clone the repository.
2. Compile and run the `AirportDemo.java` file.
3. The console will output the simulation time steps, showing planes landing and taking off, along with their respective wait times and final statistics.
