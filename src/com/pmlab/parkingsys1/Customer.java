package com.pmlab.parkingsys1;

import java.util.Scanner;

public class Customer {
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
        System.out.println("Enter Account Balance for Payment: ");
        accountBalance = scanner.nextFloat();
        System.out.println("Choose Your Vehicle Type: ");
        for (int i = 0; i < vehicleTypes.length; i++) {
            System.out.println(i + 1 + ": " + vehicleTypes[i]);
        }
        vehicleType = vehicleTypes[scanner.nextInt() - 1];
        System.out.println("Enter Your Parking Time: ");
        stayTime= scanner.nextInt();
    }

    //IMPLEMENT OTHER FUNCTIONS
}
