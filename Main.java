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

        if (restUserName.equals(rest1Name) && restPassWord.equals(pass1)){
            System.out.println("\n******LOGIN SUCCESSFUL*****\n");
            System.out.println("WELCOME TO DAVE'S BURGER");
            System.out.println("Enter Username: ");
            String user = scanner.nextLine();
            System.out.println("Enter Password: ");
            String pass = scanner.nextLine();

            if(user.equals("admin")&& pass.equals("admin123")){
                System.out.println("1. View Sale Report");
                System.out.println("2. Take Order");
                System.out.println("3. View Timecards");
                System.out.println("4. Inventory");
                System.out.println("Please enter your choice");
                int choice = scanner.nextInt();
                switch(choice){
                    case 1:break;//do sth;
                    case 2:break;
                    case 3:break;
                    case 4:break;
                    case 0:break;
                }
            }
            else {
                    System.out.println("1. Clock-in to start working");
                    System.out.println("2. Create Order");
                    System.out.println("3. View Menu");
                    System.out.println("Enter your selection: ");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            HashMap<String, LocalTime> empClockIns = new HashMap<>();
                            HashMap<String, LocalTime> employeeClockOuts = new HashMap<>();
                            System.out.println("Please enter your 4 digits employee number: ");
                            String empInfo = scanner.nextLine();

                            if (empClockIns.containsKey(empInfo)) {
                                System.out.println("You've already clock in today at " + empClockIns.get(empInfo) + ".");
                                System.out.println("Enter 'out' to clock out: ");
                                String cOut = scanner.nextLine();
                                if (cOut.equalsIgnoreCase("out")) {
                                    LocalTime currentTime = LocalTime.now();
                                    employeeClockOuts.put(empInfo, currentTime);
                                    Duration totalHours = Duration.between(empClockIns.get(empInfo)
                                            , employeeClockOuts.get(empInfo));
                                    long hours = totalHours.toHours();
                                    long minutes = totalHours.toMinutes();
                                    System.out.println("You have worked " + hours + " hours and " + minutes + " minutes today.");
                                }
                            } else {
                                // Record employee clock-in time
                                LocalTime currentTime = LocalTime.now();
                                empClockIns.put(empInfo, currentTime);
                                System.out.println("You have clocked in at " + currentTime + ".");
                            }
                            break;//employee can clock-in
                        case 2:
                            break;
                        case 3:
                            break;
                        case 0:
                            break;
                    }
            }

        }
        else{
            System.out.println("\n******LOGIN FAILED******\n");
        }





    }
}