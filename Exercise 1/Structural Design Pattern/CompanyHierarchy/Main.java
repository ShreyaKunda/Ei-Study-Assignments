// Main.java

public class Main {
    public static void main(String[] args) {
        // CEO
        Employee CEO = new Employee("John", "CEO", 30000);

        // Head of Departments
        Employee headSales = new Employee("Robert", "Head Sales", 20000);
        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

        // Employees under Sales
        Employee salesExecutive1 = new Employee("Laura", "Sales", 10000);
        Employee salesExecutive2 = new Employee("Bob", "Sales", 10000);

        // Employees under Marketing
        Employee clerk1 = new Employee("Richard", "Marketing", 10000);
        Employee clerk2 = new Employee("Rob", "Marketing", 10000);

        // Build the hierarchy
        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        // Print the hierarchy starting from the CEO
        System.out.println(CEO);

        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);

            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
