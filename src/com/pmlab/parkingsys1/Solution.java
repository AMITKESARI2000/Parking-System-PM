package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        String yn = "y";

        //Menu For Displaying Options
        do {
            int option = 0;
            System.out.println("Choose your option:");
            String[] functions = new String[]{"Admin Dash", "Customer Dash", "Exit Program"};
            for (int i = 0; i < functions.length; i++) {
                System.out.println(i + 1 + ": " + functions[i]);
            }
            option = scanner.nextInt();
            switch (option) {
                //Add different functions below
                case 1: {
                    //For Admin
                    System.out.println("ENTER ADMIN PASSWORD");
                    if (scanner.next().equals("1234")) {
                        parkingLot.showMenu();
                    } else {
                        System.out.println("Not Authorized!!!");
                    }
                    break;
                }
                case 2: {
                    //For Customer
                    System.out.println("Hello Friendly User. Hope we make your stay pleasant ;)");
                    System.out.println("Are you an existing Customer (y/n)?");
                    String y = scanner.next();
                    int i;
                    if (y.charAt(0) == 'y') {
                        System.out.println("Enter Username");
                        String userName = scanner.next();
                        for (i = 0; i < customerArrayList.size(); i++) {
                            if (userName.equals(customerArrayList.get(i).getUsername())) {
                                System.out.println("Username:" + userName);
                                customerArrayList.get(i).showMenu();
                                break;
                            }
                        }
                        if (i == customerArrayList.size()) {
                            System.out.println("User does not exist. Add a new one:");
                            Customer customer = new Customer();
                            customerArrayList.add(customer);
                            customer.showMenu();
                        }
                    } else {
                        Customer customer = new Customer();
                        customerArrayList.add(customer);
                        customer.showMenu();
                    }
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
                    showMainMenu();
            }


        } while (yn.equals("y"));

    }

    static public ParkingLot parkingLot = new ParkingLot();
    static ArrayList<Customer> customerArrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Fantasy Parking Lot!!!");
        showMainMenu();
    }
}
