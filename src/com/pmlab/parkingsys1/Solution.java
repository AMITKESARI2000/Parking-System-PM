package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static public ParkingLot parkingLot = new ParkingLot();
    static ArrayList<Customer> customerArrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Fantasy Parking Lot!!!");
        String yn = "y";

        //Menu For Displaying Options
        do {
            int option = 0;
            System.out.println("Choose your option:");
            String[] functions = new String[]{"Admin Dash", "Customer Dash", "Exit"};
            for (int i = 0; i < functions.length; i++) {
                System.out.println(i + 1 + ": " + functions[i]);
            }
            option = scanner.nextInt();
            switch (option) {
                //Add different functions below
                case 1: {
                    //For Admin
                    parkingLot.showMenu();

                    break;
                }
                case 2: {
                    //For Customer
                    Customer customer = new Customer();
                    customer.showMenu();
                    customerArrayList.add(customer);

                    break;
                }
                case 3: {
                    //For Exit from Program
                    System.out.println("Tata Bye!!! Have a Great Day ;)");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Choose correctly");
            }


        } while (yn.equals("y"));

    }
}
