import java.util.Scanner;

public class MissionControl {
    private Rocket rocket;
    private final Logger logger;
    private boolean flightInProgress; // Flag to indicate if the flight is in progress
    private Thread flightThread; // Thread for the flight simulation
    private final Scanner scanner;

    // Constructor initializes a new Logger
    public MissionControl(String logFilePath) {
        this.logger = new Logger(logFilePath);
        this.scanner = new Scanner(System.in);
    }

    // Main method to start the mission control
    public void run() {
        System.out.println("Available Rockets are 1. Voyager, 2. Explorer, 3. Dreamer");
        System.out.println("To choose a rocket, enter 1, 2, or 3");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> rocket = new Rocket("Voyager");
            case "2" -> rocket = new Rocket("Explorer");
            case "3" -> rocket = new Rocket("Dreamer");
            default -> {
                System.out.println("Invalid input. Defaulting to Rocket Voyager.");
                rocket = new Rocket("Voyager");
            }
        }

        // Start flight simulation in a separate thread
        flightThread = new Thread(this::startFlightSimulation);
        flightThread.start();

        // Start command processing
        processCommands();
        
        // Wait for flight simulation to complete
        try {
            flightThread.join(); // Wait for the flight thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Mission control session ended.");
        scanner.close();
        logger.close();
    }

    // Method to handle user commands
    private void processCommands() {
        String command;
        do {
            System.out.print("Enter command (start_checks, launch, fast_forward X, exit): ");
            command = scanner.nextLine().trim();
            handleCommand(command);
        } while (!command.equals("exit"));
    }

    // Method to handle user commands
    private void handleCommand(String command) {
        if (command.equals("start_checks")) {
            rocket.startChecks();
        } else if (command.equals("launch")) {
            displayLaunchDetails(); // Display launch details before launching
            if (!rocket.isFailed()) {
                countdown(); // Add the countdown before launch
                rocket.launch();
                flightInProgress = true; // Set the flag indicating flight is in progress
            }
        } else if (command.startsWith("fast_forward")) {
            handleFastForwardCommand(command);
        } else if (!command.equals("exit")) {
            System.out.println("Unknown command. Please try again.");
        }
    }

    // Method to display launch details in a formatted way
    private void displayLaunchDetails() {
        System.out.println("\n================ Launch Details ================\n");
        System.out.println("Rocket Name: " + rocket.getName());
        System.out.println("Target Orbit Altitude: " + rocket.getTargetOrbitAltitude() + " km");
        System.out.println("Current Weather: " + rocket.getWeather());
        System.out.println("Fuel Level: " + rocket.getFuel() + "%");
        System.out.println("\n===============================================\n");
    }

    // Method to perform a countdown before launch
    private void countdown() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Countdown: " + i);
            try {
                Thread.sleep(1000);  // Wait for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Liftoff!");
    }

    // Method to handle fast forward command
    private void handleFastForwardCommand(String command) {
        String[] parts = command.split(" ");
        if (parts.length == 2) {
            try {
                int seconds = Integer.parseInt(parts[1]);
                if (!flightInProgress) { // Fast forward only after the flight is done
                    System.out.println("Fast forwarding " + seconds + " seconds...");

                    // Simulate what happened during the launch
                    for (int i = 0; i < seconds; i++) {
                        rocket.update(); // Update the rocket's state
                        displaySimulationState(); // Display the rocket's state
                        try {
                            Thread.sleep(1000); // Simulate the passage of time
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Fast forward complete.");
                } else {
                    System.out.println("Fast forward can only be initiated after launch is completed.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number for fast forward.");
            }
        } else {
            System.out.println("Usage: fast_forward <seconds>");
        }
    }

    // Method to display the rocket's state
    private void displaySimulationState() {
        System.out.println("\n================ Simulation State ================\n");
        System.out.println("Rocket Name: " + rocket.getName());
        System.out.println("Current Altitude: " + rocket.getTargetOrbitAltitude() + " km");
        System.out.println("Current Speed: " + rocket.getCurrentSpeed() + " km/h");
        System.out.println("Fuel Level: " + rocket.getFuel() + "%");
        System.out.println("Orbit Status: " + (rocket.isInOrbit() ? "In Orbit" : "Not in Orbit"));
        System.out.println("\n==================================================\n");
    }

    // Method to start the flight simulation
    private void startFlightSimulation() {
        while (!rocket.isInOrbit() && !rocket.isFailed()) {
            if (flightInProgress) {
                rocket.update(); // Update the rocket's state
            }
            try {
                Thread.sleep(1000);  // Simulate waiting for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        flightInProgress = false; // Reset the flag when the flight ends
        System.out.println("\nFlight has ended.");
    }
}
