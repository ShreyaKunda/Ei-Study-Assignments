# Shreya's Coding Assignments

Welcome to the assignment repository with two coding assignments focused on software design patterns and a Rocket Launch Simulator.

## Table of Contents
1. [Assignment 1: Design Patterns](#assignment-1-design-patterns)
    - [Behavioral Design Patterns](#behavioral-design-patterns)
    - [Creational Design Patterns](#creational-design-patterns)
    - [Structural Design Patterns](#structural-design-patterns)
2. [Assignment 2: Rocket Launch Simulator](#assignment-2-rocket-launch-simulator)
    - [Overview](#overview)
    - [Functional Requirements](#functional-requirements)
    - [Usage](#usage)


---

## Assignment 1: Design Patterns

This below use cases depict the usage of various software design patterns through six use cases.

### Behavioral Design Patterns
1. **Use Case 1:** Smart Home Command - Pattern: Command Pattern
Description: This pattern encapsulates requests as objects, allowing for parameterizing clients with different requests, queueing requests, and logging them.
Use Case: Automating smart home devices where commands can be queued or undone.


2. **Use Case 2:** Stock Market - Pattern: Observer Pattern
Description: The observer pattern allows an object to notify other objects when there is a state change.
Use Case: Monitoring stock price changes and notifying subscribed traders.

### Creational Design Patterns
1. **Use Case 1:** Database Connection - Pattern: Singleton Pattern
Description: Ensures only one instance of a DatabaseConnection exists and provides a global point of access to it.
Use Case: Managing a database connection pool efficiently in an application.


2. **Use Case 2:** Vehicle Factory - Pattern: Factory Pattern
Description: The factory pattern provides an interface for creating objects, allowing the instantiation of different types of vehicles (e.g., Car, Bike).
Use Case: A vehicle dealership system that creates different types of vehicles based on user input.

### Structural Design Patterns
1. **Use Case 1:** Company Hierarchy- Pattern: Composite Pattern
Description: The composite pattern allows a hierarchy of objects where individual objects and compositions of objects are treated uniformly.
Use Case: Managing a company's employee structure where managers can manage other employees.


2. **Use Case 2:** Media Player - Pattern: Adapter Pattern
Description: The adapter pattern allows a media player to support multiple formats by adapting one interface to another.
Use Case: Playing various media formats (e.g., MP4, MP3) using a single media player interface.

---

## Assignment 2: Rocket Launch Simulator

### Overview
The Rocket Launch Simulator is a terminal-based application that simulates the launch of a rocket and the subsequent placement of a satellite into orbit. The program provides real-time updates on the rocket's status throughout the mission.

### Functional Requirements
1. **Pre-Launch Checks:** 
   - Users initiate the pre-launch checks by typing `start_checks`.
   - The system confirms: "All systems are 'Go' for launch."
     ![image](https://github.com/user-attachments/assets/b84fa91e-3ab1-4609-921f-9876d0d3f7d0)

  
2. **Launch and Stage Updates:** 
   - Users start the launch sequence by typing `launch`.
   - The program updates the rocket's stage, fuel level, altitude, and speed every second.
     ![image](https://github.com/user-attachments/assets/24884a24-7618-46ff-8196-5d9d67f35ffe)
     ![image](https://github.com/user-attachments/assets/e9cc1564-381f-419c-83fa-6326c971b2e0)



3. **Fast Forward:** 
   - Users can advance the simulation by typing `fast_forward X`, where X is the number of seconds to skip.
   - The simulator calculates and displays updated parameters after X seconds.

### Usage
To run the simulator, follow these steps:
1. Clone the repository:
   ```bash
   git clone [repository-url]
   cd [repository-directory]
