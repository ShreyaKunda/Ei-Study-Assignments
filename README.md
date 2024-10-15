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

The below use cases depict the usage of various software design patterns through six use cases.

### Behavioral Design Patterns
1. **Use Case 1: Smart Home Command**

**Pattern**: Command Pattern
**Description**: This pattern turns requests into objects, making it possible to queue, log, and undo them.
**Example**: Controlling smart home devices where commands (like turning lights on/off) can be queued or undone.

![WhatsApp Image 2024-10-01 at 15 34 13_cdd0bae5](https://github.com/user-attachments/assets/1e28c00d-985e-4f53-ac09-dab1f8bf2ea8)




2. **Use Case 2: Stock Market**

**Pattern**: Observer Pattern
**Description**: This pattern lets one object notify others about changes in its state.
**Example**: Tracking stock prices and alerting traders when prices change.

![WhatsApp Image 2024-10-01 at 15 32 01_6d63801f](https://github.com/user-attachments/assets/6b9c6c35-c766-48b2-9f23-c84cfa9d475e)



### Creational Design Patterns
1. **Use Case 1: Database Connection**

**Pattern**: Singleton Pattern
**Description**: This pattern ensures that only one instance of a class exists and provides a global access point to it.
**Example**: Managing a single database connection in an application

![WhatsApp Image 2024-10-01 at 15 34 41_f86b9c91](https://github.com/user-attachments/assets/7b61951f-8e42-477f-b4d9-25c037610251)



2. **Use Case 2: Vehicle Factory**
   
**Pattern**: Factory Pattern
**Description:** The factory pattern provides an interface for creating objects, allowing the instantiation of different types of vehicles (e.g., Car, Bike).
**Use Case:** A vehicle dealership system that creates different types of vehicles based on user input.

![WhatsApp Image 2024-10-01 at 15 35 43_d978d7aa](https://github.com/user-attachments/assets/3825bc27-6644-44f1-aeca-622c32cb7e06)



### Structural Design Patterns


1. **Use Case: Employee Management System**


**Pattern**: Composite Pattern
**Description**: This pattern allows for the creation of a tree structure where individual objects (employees) and compositions of objects (departments) can be treated uniformly. It facilitates the management of hierarchical relationships, enabling operations on both single objects and groups of objects.
**Example:** An organizational chart where a CEO manages department heads, who in turn manage their respective employees. This setup allows for easy addition, removal, and retrieval of employees in a corporate structure.

![WhatsApp Image 2024-10-01 at 15 36 47_e3dbaae3](https://github.com/user-attachments/assets/df3cb38a-8530-48e7-90f5-0734e327678b)



2. **Use Case 2: Media Player**

**Pattern**: Adapter Pattern
**Description**: This pattern allows different interfaces to work together.
**Example**: A media player that can play multiple formats (e.g., MP3, MP4) using a common interface.

![WhatsApp Image 2024-10-01 at 15 37 45_92f28b7a](https://github.com/user-attachments/assets/06b74ed2-b40c-4827-ac0e-39e282760348)


---

## Assignment 2: Rocket Launch Simulator

### Overview
This terminal-based simulator mimics a rocket launch and the deployment of a satellite into orbit. The program provides real-time updates on the rocket's status during the mission.

### Functional Requirements
1. **Pre-Launch Checks:** 
   - User can begin the pre-launch checks by typing `start_checks`. Without the pre-launch checks, the rocket will not launch. Before start_checks, user can choose between 3 rockets as shown in the below images.
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
To run the rocket launch, follow these steps:
1. Clone the repository:
   ```bash
   git clone [repository-url]
   cd [repository-directory]
