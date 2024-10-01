import java.util.Random;

public class Rocket {
    private String name;
    private String stage;
    private double fuel;       // Fuel percentage
    private int altitude;      // Altitude in km
    private int speed;         // Speed in km/h
    private int secondsPassed;
    private boolean inOrbit;
    private int stageNumber;
    private int targetOrbitAltitude; // Target altitude for orbit
    private String weather;           // Current weather conditions
    private double mass;              // Mass of the rocket in kg
    private double g;                 // Gravitational constant (9.8 m/s^2)
    private boolean checksDone;       // Check if pre-launch checks are done
    private static final Random random = new Random();

    // Constructor to initialize the rocket's attributes
    public Rocket(String name) {
        this.name = name;
        this.stage = "Pre-Launch";
        this.fuel = 80.0 + random.nextDouble() * 20; // Random fuel between 80% and 100%
        this.altitude = 0;
        this.speed = 0;
        this.secondsPassed = 0;
        this.inOrbit = false;
        this.stageNumber = 1;
        this.targetOrbitAltitude = 150 + random.nextInt(101); // Random target orbit between 150 and 250 km
        this.weather = generateWeather(); // Random weather conditions
        this.mass = 500_000 + random.nextDouble() * 100_000; // Random mass between 500,000 and 600,000 kg
        this.g = 9.8;  // Standard gravity on Earth
        this.checksDone = false;  // Initially, pre-launch checks are not done
    }

    public String getName() {
        return name;
    }

    public double getFuel() {
        return fuel; // Getter method for fuel
    }

    public int getTargetOrbitAltitude() {
        return targetOrbitAltitude;
    }

    public String getWeather() {
        return weather;
    }

    public double getMass() {
        return mass;  // Getter for rocket mass
    }

    public double getG() {
        return g;  // Getter for gravitational constant
    }
    
    public double getCurrentSpeed() {
        return speed;
    }

    // Method to generate random weather conditions
    private String generateWeather() {
        String[] conditions = {"Sunny", "Cloudy", "Rainy", "Stormy", "Clear"};
        return conditions[random.nextInt(conditions.length)];
    }

    // Method to simulate pre-launch checks
    public void startChecks() {
        this.checksDone = true;  // Pre-launch checks completed
        System.out.println("All systems are 'Go' for launch on " + name + ".");
    }

    // Method to begin the launch
    public void launch() {
        if (!checksDone) {
            System.out.println("Oops! Pre-launch Checks are not completed! We cannot launch the rocket!");
            return; // Abort the launch if checks aren't done
        }

        if (this.stage.equals("Pre-Launch")) {
            this.stage = "Stage 1";
            this.secondsPassed = 0;
            System.out.println("Launching has started");
            displayLaunchDetails(); // Display details at launch
        } else {
            System.out.println(name + " launch has already started.");
        }
    }

    // Method to display rocket's launch details
    public void displayLaunchDetails() {
        System.out.println("\n================ Rocket Launch Details ================\n");
        System.out.println("Rocket Name: " + name);
        System.out.println("Rocket Mass: " + mass + " kg");
        System.out.println("Gravitational Constant (g): " + g + " m/s^2");
        System.out.println("Target Orbit Altitude: " + targetOrbitAltitude + " km");
        System.out.println("Current Weather: " + weather);
        System.out.println("Fuel Level: " + fuel + "%");
        System.out.println("\n========================================================\n");
    }

    // Method to update the rocket's status every second
    public void update() {
        if (this.stage.equals("Stage 1")) {
            this.fuel -= random.nextDouble() * 1.5;  // Random fuel consumption in Stage 1
            int altitudeIncrease = 8 + random.nextInt(5); // Random altitude increase per second (km)
            if (this.altitude + altitudeIncrease > targetOrbitAltitude) {
                this.altitude = targetOrbitAltitude;  // Set altitude to target if exceeded
            } else {
                this.altitude += altitudeIncrease; // Only increase altitude if within bounds
            }
            this.speed += 900 + random.nextInt(200);  // Random speed increase per second (km/h)

            logStatus();

            if (this.fuel <= 50.0) {  // Stage separation at 50% fuel
                System.out.println("Stage 1 complete for " + name + ". Separating stage. Entering Stage 2.");
                this.stage = "Stage 2";
                this.stageNumber = 2;
            }
        } else if (this.stage.equals("Stage 2")) {
            this.fuel -= random.nextDouble();  // Random fuel consumption in Stage 2
            int altitudeIncrease = 4 + random.nextInt(3); // Random altitude increase per second (km)
            if (this.altitude + altitudeIncrease > targetOrbitAltitude) {
                this.altitude = targetOrbitAltitude;  // Set altitude to target if exceeded
            } else {
                this.altitude += altitudeIncrease; // Only increase altitude if within bounds
            }
            this.speed += 300 + random.nextInt(100);  // Random speed increase per second (km/h)

            logStatus();

            // Check if orbit has been achieved
            if (this.altitude >= targetOrbitAltitude) {  // Orbit achieved at the target altitude
                this.stage = "Orbit";
                this.inOrbit = true;
                System.out.println(name + " achieved orbit! Mission Successful.");
            }
        }

        // Check if fuel is depleted
        if (this.fuel <= 0) {
            this.stage = "Failed";
            System.out.println(name + " Mission Failed due to insufficient fuel.");
        }

        // Prevent further fuel consumption after achieving orbit
        if (this.inOrbit) {
            this.fuel = Math.max(this.fuel, 0); // Ensure fuel doesn't go below zero
        }
    }

    // Method to log the rocket's status
    private void logStatus() {
        System.out.printf("%s | Altitude: %d km | Speed: %d km/h | Fuel: %.2f%%%n",
                name, altitude, speed, fuel);
    }

    // Method to fast forward time
    public void fastForward(int seconds) {
        for (int i = 0; i < seconds; i++) {
            if (!isInOrbit() && !isFailed()) {
                update();  // Update the rocket's state every second during fast forward
            }
        }
    }

    public boolean isInOrbit() {
        return inOrbit;
    }

    public boolean isFailed() {
        return stage.equals("Failed");
    }
}
