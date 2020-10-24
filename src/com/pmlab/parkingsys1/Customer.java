package com.pmlab.parkingsys1;

import java.util.Scanner;

import static com.pmlab.parkingsys1.Solution.showMainMenu;

public class Customer extends ParkingLot {
    Scanner scanner = new Scanner(System.in);
    private String[] vehicleTypes = new String[]{
            "Small ( Sedans, Compact etc ) ",
            "Large ( Truck, SUV etc )",
            "Motor Bike",
            "Handicapped",
            "Electric"
    };

    private String username = "";
    private String CustomerId = "";
    private String vehicleType;
    private float accountBalance = 0;
    private boolean premiumSubscription = false;
    private int stayTime = 0;
    private int floor_no = 0;
    private float bill = 0;

    Customer() {
        setUsername();
        setCustomerId();
        setAccountBalance();
        setVehicleType();
        setPremiumSubscription();
    }

    //================IMPLEMENT OTHER FUNCTIONS======================
    public String getCustomerId() {
        return CustomerId;
    }

    public String getUsername() {
        return username;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public String getvehicleType() {
        return vehicleType;
    }

    public boolean getIsPremiumSubscription() {
        return premiumSubscription;
    }

    public void setCustomerId() {
        int n = 10;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        CustomerId = sb.toString();

        System.out.println("Customer ID:" + CustomerId);
    }

    public void setUsername() {
        try {
            System.out.println("Please Enter User Name: ");
            username = scanner.next();
        } catch (Exception e) {
            System.out.println("Please enter valid username");
            setUsername();
        }
    }

    public void setAccountBalance() {
        try {
            System.out.println("Enter Account Balance for Validation of Payment: ");
            accountBalance = Float.parseFloat(scanner.next());
            if (accountBalance <= 0) {
                System.out.println("Please enter valid balance amount");
                setAccountBalance();
            } else {
                System.out.println("Added : " + accountBalance);
            }
        } catch (Exception e) {
            System.out.println("Please enter valid input");
            System.out.println("Balance set to 0 OR");
            accountBalance=0;
            setAccountBalance();
        }

    }

    public void setVehicleType() {
        System.out.println("Choose Your Vehicle Type: ");
        for (int i = 0; i < vehicleTypes.length; i++) {
            System.out.println(i + 1 + ": " + vehicleTypes[i]);
        }
        switch (scanner.nextInt()) {
            case 1:
                vehicleType = "small";
                break;
            case 2:
                vehicleType = "large";
                break;
            case 3:
                vehicleType = "motorcycle";
                break;
            case 4:
                vehicleType = "handicapped";
                break;
            case 5:
                vehicleType = "electric";
                break;
            default:
                System.out.println("Enter valid number");
                setVehicleType();
                break;
        }
    }

    public void setPremiumSubscription() {
        System.out.println("Are you our premium customer? (y/n)");
        if (scanner.next().equals("y") && accountBalance > 1000) {
            premiumSubscription = true;
            System.out.println("Verified!");
        } else {
            System.out.println("You are not a premium customer. Please don't fake it and buy a Subscription");
        }
    }

    public boolean setParkingLotCustomer() {
        System.out.println("Current User: " + username);
        System.out.println("Enter preferred floor ( 0 - " + (getFloorCount() - 1) + " )");
        floor_no = scanner.nextInt();

        if (getFloorCount() < floor_no || floor_no < 0) {
            System.out.println("Enter valid number :(");
            return false;
        } else {
            String check_status = floors.get(floor_no).bookSlot(vehicleType, floor_no);

            if (!check_status.equals("")) {
                System.out.println("Parking Slot has been allotted");
                System.out.println("Floor: " + floor_no);
                System.out.println("Slot: " + vehicleType);
                System.out.println("Parking Slot ID: " + check_status);
                if (premiumSubscription)
                    System.out.println("Enjoy your premium stay!");
                setBill();
                return true;
            } else {
                System.out.println("Error in slot allotment. No slot of type " + vehicleType + " on this floor is free now.");
            }
            return false;
        }
    }

    public boolean exitParkingLotCustomer() {
        boolean check_status = false;
        if (username.equals("")) {
            System.out.println("Check in first!");
        } else {
            System.out.println("Current User: " + username);
            check_status = floors.get(floor_no).exitSlot(vehicleType);
            if (check_status) {
                System.out.println("Exited from Parking Lot");
            } else {
                System.out.println("Exit restricted");
            }
        }
        return check_status;
    }

    public void setBill() {
        float baseRate = 20, interest = 10;
        if (vehicleType == "small") {
            baseRate = 50;
        } else if (vehicleType == "large") {
            baseRate = 80;
        } else if (vehicleType == "motorcycle") {
            baseRate = 40;
        } else if (vehicleType == "handicapped") {
            baseRate = 20;
        } else if (vehicleType == "Electric") {
            baseRate = 30;
        }
        System.out.println("Enter Your Parking Stay Time (in hrs): ");
        stayTime = scanner.nextInt();
        System.out.println("Added " + stayTime + " hr parking time");
        if (stayTime > 0) {
            System.out.printf("Please note: \n Base rate: Rs%.2f    Increment per hour: Rs%.2f", baseRate, interest);
            bill = baseRate + (stayTime - 1) * interest;

            if (premiumSubscription) {
                System.out.println("\nThank you for being our premium member! 10% bill amount reduced.");
                bill = (float) Math.max(0.9 * bill, 0);
            }

            System.out.println("You have to pay Rs" + bill);
        } else {
            System.out.println("Please enter valid time");
        }
    }

    public float getBill() {
        return bill;
    }


    private int option;

    @Override
    public void showMenu() {

        System.out.println("Choose your option:");
        String[] functions = new String[]{"Edit User Data", "Book Parking Slot", "Show Bill", "Pay and Exit Parking Slot", "Back", "Exit"};
        for (int i = 0; i < functions.length; i++) {
            System.out.println(i + 1 + ": " + functions[i]);
        }
        option = scanner.nextInt();
        functionInvoker(option);

    }

    @Override
    public void functionInvoker(int option) {
        switch (option) {
            //Add different functions below
            case 1: {
                setUsername();
                setCustomerId();
                setAccountBalance();
                setVehicleType();
                setPremiumSubscription();
                showMenu();
                break;
            }
            case 2: {
                setParkingLotCustomer();
                showMenu();
                break;
            }
            case 3: {
                System.out.println("Your bill is " + getBill());
                showMenu();
                break;
            }
            case 4: {
                Payment pay = new Payment(bill, accountBalance, premiumSubscription);
                pay.showMenu();
                accountBalance = pay.getAmount();
                exitParkingLotCustomer();
                break;
            }
            case 5: {
                showMainMenu();
                break;
            }
            case 6: {
                System.exit(0);
                break;
            }

            default:
                System.out.println("Choose correctly");
                showMenu();
        }
    }

}


 
