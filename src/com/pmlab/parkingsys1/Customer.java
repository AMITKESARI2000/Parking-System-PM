package com.pmlab.parkingsys1;

import java.util.Scanner;

public class Customer implements CallMenu {
    Scanner scanner = new Scanner(System.in);
    private float accountBalance = 0;
    private boolean premiumSubscription = false;
    private String[] vehicleTypes = new String[]{
            "Small ( Sedans, Compact etc ) ",
            "Large ( Truck, SUV etc )",
            "Motor Bike",
            "Other ( Cycles, Handicapped etc )"
    };
    private String vehicleType;
    private int stayTime = 0;

    Customer() {
    }
    //================IMPLEMENT OTHER FUNCTIONS======================

    public void setAccountBalance() {
        System.out.println("Enter Account Balance for Validation of Payment: ");
        this.accountBalance = scanner.nextFloat();
        System.out.println("Added : " + accountBalance);
    }

    public void setVehicleType() {
        System.out.println("Choose Your Vehicle Type: ");
        for (int i = 0; i < vehicleTypes.length; i++) {
            System.out.println(i + 1 + ": " + vehicleTypes[i]);
        }
        switch( scanner.nextInt() )
        {
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

    public void setStayTime() {
        System.out.println("Enter Your Parking Time: ");
        stayTime = scanner.nextInt();
        System.out.println("Added : " + stayTime);
    }

    private int option;

    @Override
    public int showMenu() {

        System.out.println("Choose your option:");
        String[] functions = new String[]{"Enter User Data"};
        for (int i = 0; i < functions.length; i++) {
            System.out.println(i + 1 + ": " + functions[i]);
        }
        option = scanner.nextInt();
        functionInvoker(option);
        return option;
    }

    @Override
    public void functionInvoker(int option) {
        switch (option) {
            //Add different functions below
            case 1: {
                setAccountBalance();
                setVehicleType();
                setStayTime();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }

            default:
                System.out.println("Choose correctly");
        }
    }

}


 