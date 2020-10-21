package com.pmlab.parkingsys1;

import java.util.Scanner;

import static com.pmlab.parkingsys1.Solution.showMainMenu;

public class Customer extends ParkingLot {
    Scanner scanner = new Scanner(System.in);
    private String[] vehicleTypes = new String[]{
            "Small ( Sedans, Compact etc ) ",
            "Large ( Truck, SUV etc )",
            "Motor Bike",
            "Other ( Cycles, Handicapped etc )"
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

        System.out.println("Customer Id:" + CustomerId);
    }

    public void setUsername() {
        System.out.println("Please Enter User Name: ");
        this.username = scanner.next();
    }

    public void setAccountBalance() {
        System.out.println("Enter Account Balance for Validation of Payment: ");
        this.accountBalance = scanner.nextFloat();
        System.out.println("Added : " + accountBalance);
    }
    
     public void setAccountBalance(float amount){
         accountBalance=amount;

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
            System.out.println("Please buy a Subscription");
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
            boolean check_status = floors.get(floor_no).bookSlot(vehicleType);

            if (check_status) {
                System.out.println("Parking Slot has been allotted");
                System.out.println("Floor: " + floor_no);
                System.out.println("Slot: " + vehicleType);
                if (premiumSubscription)
                    System.out.println("Enjoy your premium stay!");
                setBill();
            } else {
                System.out.println("Error in slot allotment");
            }
            return check_status;
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
        float baseRate;interest=10;
        if(vehicleType=="small") {
        	baseRate=30;
        }
        else if(vehicleType=="large") {
        	baseRate=50;
        }
        else if(vehicleType=="motorcycle") {
        	baseRate=25;
        }
        else if(vehicleType=="handicapped") {
        	baseRate=15;
        }
        System.out.println("Enter Your Parking Stay Time (in hrs): ");
        stayTime = scanner.nextInt();
        System.out.println("Added " + stayTime + " hr parking time");
        if (stayTime > 0) {
            System.out.printf("Please note: \n Base rate: Rs%f    Increment per hour: Rs%f", baseRate, interest);
            bill = baseRate + (stayTime - 1) * interest;

            //Goutam add different base rate for different vehicle types


            if (premiumSubscription) {
                System.out.println("\nThank you for being our premium member! 10% bill amount reduced.");
                bill = (float) Math.max(0.9 * bill, 0);
            }

            System.out.println("You have to pay Rs" + bill);
        } else {
            System.out.println("Please enter valid time");
        }
    }
    public int getBill(){
        return bill;
    }


    private int option;

    @Override
    public void showMenu() {

        System.out.println("Choose your option:");
        String[] functions = new String[]{"Enter User Data", "Set Parking Slot","bill", "Exit Parking Slot", "Back", "Exit"};
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
                break;
            }
            case 3: {
                exitParkingLotCustomer();
                break;
            }
            case 4:{
                System.out.println("your bill is "+getBill());
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


 
