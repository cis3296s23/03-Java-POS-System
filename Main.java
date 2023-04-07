import java.time.LocalTime;
import java.time.Duration;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rest1Name = "daveburger";
        String pass1 = "dave123";

        System.out.println("Please enter your username: ");
        String restUserName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String restPassWord = scanner.nextLine();

        if (restUserName.equals(rest1Name) && restPassWord.equals(pass1)) {
            System.out.println("\n******LOGIN SUCCESSFUL*****\n");
            System.out.println("WELCOME TO DAVE'S BURGER");
            System.out.println("Enter Username: ");
            String user = scanner.nextLine();
            System.out.println("Enter Password: ");
            String pass = scanner.nextLine();

            if (user.equals("admin") && pass.equals("admin123")) {
                System.out.println("1. View Sale Report");
                System.out.println("2. Take Order");
                System.out.println("3. View Timecards");
                System.out.println("4. Inventory");
                System.out.println("Please enter your choice");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        System.out.println("Enter customer name: ");
                        String customerName = scanner.nextLine();
                        System.out.println("Enter order details: ");
                        String orderDetails = scanner.nextLine();
                        System.out.println("Enter total price: ");
                        double totalPrice = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Enter payment method: ");
                        String paymentMethod = scanner.nextLine();
                        System.out.println("Order created successfully!");
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } else {
                System.out.println("1. Clock-in to start working");
                System.out.println("2. Create Order");
                System.out.println("3. View Menu");
                System.out.println("Enter your selection: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        HashMap<String, LocalTime> empClockIns = new HashMap<>();
                        HashMap<String, LocalTime> employeeClockOuts = new HashMap<>();
                        System.out.println("Please enter your 4 digits employee number: ");
                        String empInfo = scanner.nextLine();

                        if (empClockIns.containsKey(empInfo)) {
                            System.out.println("You've already clocked in today at " + empClockIns.get(empInfo) + ".");
                            System.out.println("Enter 'out' to clock out: ");
                            String cOut = scanner.nextLine();
                            if (cOut.equalsIgnoreCase("out")) {
                                LocalTime currentTime = LocalTime.now();
                                employeeClockOuts.put(empInfo, currentTime);
                                Duration totalHours = Duration.between(empClockIns.get(empInfo), employeeClockOuts.get(empInfo));
                                long hours = totalHours.toHours();
                                long minutes = totalHours.toMinutes() % 60;
                                System.out.println("You have worked " + hours + " hours and " + minutes + " minutes today.");
                            }
                        } else {
                            // Record employee clock-in time
                            LocalTime currentTime = LocalTime.now();
                            empClockIns.put(empInfo, currentTime);
                            System.out.println("You have clocked in at " + currentTime + ".");
                        }
                        break;
                    case 2:
                        System.out.println("Enter customer name: ");
                        String customerName = scanner.nextLine();
                        System.out.println("Enter order details: ");
                        String orderDetails = scanner.nextLine();
                        System.out.println("Enter total price: ");
                        double totalPrice = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Enter payment method: ");
                        String paymentMethod = scanner.nextLine();
                        System.out.println("Order created successfully!");
                        break;
                    case 3:
                        System.out.println("***********MENU***********");
                        System.out.println("1. Beef Burger - $11.99");
                        System.out.println("2. Cheeseburger - $9.99");
                        System.out.println("3. Hamburger - $8.99");
                        System.out.println("4. French Fries - $4.99");
                        System.out.println("5. Soft Drink - $1.99");
                        System.out.println("6. Milkshake - $5.99");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        } else {
            System.out.println("\n******LOGIN FAILED******\n");
        }
    }
}

