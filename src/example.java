
//public void restaurant(String rest1Name, String pass1) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("\n******LOGIN SUCCESSFUL*****\n");
//        System.out.println("WELCOME TO DAVE'S BURGER");
//        System.out.println("Enter Username: ");
//        String user = scanner.nextLine();
//        System.out.println("Enter Password: ");
//        String pass = scanner.nextLine();
//
//        if (user.equals("admin") && pass.equals("admin123")) {
//        System.out.println("1. View Sale Report");
//        System.out.println("2. Take Order");
//        System.out.println("3. View Timecards");
//        System.out.println("4. Inventory");
//        System.out.println("Please enter your choice");
//        int choice = scanner.nextInt();
//        switch (choice) {
//        case 1:
//        break;
//        case 2:
//        System.out.println("***********CREATE ORDER***********");
//        System.out.println("Enter customer name: ");
//        String customerName = scanner.nextLine();
//        System.out.println("Enter order details: ");
//        String items = scanner.nextLine();
//        System.out.println("Enter total price: ");
//        double totalPrice = scanner.nextDouble();
//        scanner.nextLine();
//        System.out.println("Enter payment method: ");
//        String paymentMethod = scanner.nextLine();
//        Order order = new Order(customerName, Collections.singletonList(items), totalPrice, paymentMethod);
//        System.out.println("Order created successfully!");
//        System.out.println("***********CREATE ORDER***********");
//        break;
//        case 3:
//        System.out.println("***********TIMECARDS***********");
//        for (String empId : empClockIns.keySet()) {
//        System.out.print("Employee " + empId + ":\nClock in time: " + empClockIns.get(empId));
//        if (empClockOuts.containsKey(empId)) {
//        System.out.print("\nClock out time: " + empClockOuts.get(empId));
//        Duration totalHours = Duration.between(empClockIns.get(empId), empClockOuts.get(empId));
//        long hours = totalHours.toHours();
//        long minutes = totalHours.toMinutes() % 60;
//        System.out.println("\nTotal work hours: " + hours + " hours and " + minutes + " minutes.");
//        } else {
//        System.out.println("\nStatus: On shift.");
//        }
//        }
//        break;
//        case 4:
//        HashMap<String, Integer> inventory = new HashMap<>();
//        inventory.put("Beef Burger", 50);
//        inventory.put("Cheeseburger", 75);
//        inventory.put("Hamburger", 100);
//        inventory.put("French Fries", 200);
//        inventory.put("Soft Drink", 300);
//        inventory.put("Milkshake", 100);
//        System.out.println("Current Inventory:");
//        for (String item : inventory.keySet()) {
//        System.out.println(item + ": " + inventory.get(item));
//        }
//        break;
//        case 0:
//        break;
//default:
//        System.out.println("Invalid choice!");
//        break;
//        }
//        } else {
//        boolean continueWorking = true;
//        while (continueWorking) {
//        System.out.println("1. Clock-in to start working");
//        System.out.println("2. Create Order");
//        System.out.println("3. View Menu");
//        System.out.println("4. Log Out");
//        System.out.println("Enter your selection: ");
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//
//        switch (choice) {
//        case 1:
//        System.out.println("***********CLOCK-IN***********");
//        System.out.println("Please enter your 4 digits employee number: ");
//        String empInfo = scanner.nextLine();
//        System.out.println("1. Clock-in to start working");
//        System.out.println("2. Clock-out to finish working");
//        System.out.println("Enter your selection: ");
//        int choice2 = scanner.nextInt();
//        if (choice2 == 1) {
//        empClockIns.put(empInfo, LocalTime.now());
//        System.out.println("You have successfully clocked-in.");
//        } else if (choice2 == 2) {
//        empClockOuts.put(empInfo, LocalTime.now());
//        System.out.println("You have successfully clocked-out.");
//        }
//        if (empClockIns.containsKey(empInfo)) {
//        LocalTime clockInTime = empClockIns.get(empInfo);
//        LocalTime clockOutTime = empClockOuts.get(empInfo);
//        if (clockOutTime == null) {
//        Duration totalHours = Duration.between(clockInTime, LocalTime.now());
//        long hours = totalHours.toHours();
//        long minutes = totalHours.toMinutes() % 60;
//        System.out.println("You have worked " + hours + " hours and " + minutes + " minutes today.");
//        System.out.println("You clocked in at " + clockInTime + ".");
//        } else {
//        Duration totalHours = Duration.between(clockInTime, clockOutTime);
//        long hours = totalHours.toHours();
//        long minutes = totalHours.toMinutes() % 60;
//        System.out.println("You worked " + hours + " hours and " + minutes + " minutes on your last shift.");
//        System.out.println("You clocked in at " + clockInTime + " and clocked out at " + clockOutTime + ".");
//        }
//        } else {
//        System.out.println("You have not clocked in today.");
//        }
//        break;
//        case 2:
//        System.out.println("***********CREATE ORDER***********");
//        System.out.println("Enter customer name: ");
//        String customerName = scanner.nextLine();
//        System.out.println("Enter order details: ");
//        String items = scanner.nextLine();
//        System.out.println("Enter total price: ");
//        double totalPrice = scanner.nextDouble();
//        scanner.nextLine();
//        System.out.println("Enter payment method: ");
//        String paymentMethod = scanner.nextLine();
//        Order order = new Order(customerName, Collections.singletonList(items), totalPrice, paymentMethod);
//        System.out.println("Order created successfully!");
//        System.out.println("***********CREATE ORDER***********");
//        break;
//        case 3:
//        System.out.println("***********MENU***********");
//        System.out.println("1. Beef Burger - $11.99");
//        System.out.println("2. Cheeseburger - $9.99");
//        System.out.println("3. Hamburger - $8.99");
//        System.out.println("4. French Fries - $4.99");
//        System.out.println("5. Soft Drink - $1.99");
//        System.out.println("6. Milkshake - $5.99");
//        System.out.println("***********MENU***********");
//        break;
//        case 4:
//        continueWorking = false;
//        break;
//        case 0:
//        break;
//default:
//        System.out.println("Invalid choice!");
//        break;
//        }
//        }
//        }
//        }