// Main.java

public class Main {
    public static void main(String[] args) {
        // Get the single instance of the database connection
        DatabaseConnection dbConnection1 = DatabaseConnection.getInstance();
        dbConnection1.executeQuery("SELECT * FROM users");

        // Try to get another instance
        DatabaseConnection dbConnection2 = DatabaseConnection.getInstance();
        dbConnection2.executeQuery("INSERT INTO users VALUES (1, 'John Doe')");

        // Verify that both variables point to the same instance
        if (dbConnection1 == dbConnection2) {
            System.out.println("Both are the same instance.");
        }
    }
}
