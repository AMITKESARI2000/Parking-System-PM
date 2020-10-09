package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Fantasy Parking Lot!!!");
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        String yn;

        do {
            int option = 0;
            System.out.println("Choose your option:");
            String[] functions = new String[]{"Admin Dash", "Customer Dash"};
            for (int i = 0; i < functions.length; i++) {
                System.out.println(i + 1 + ": " + functions[i]);
            }
            option = scanner.nextInt();
            switch (option) {
                //Add different functions below
                case 1: {
                    parkingLot.showMenu();

                    break;
                }
                case 2: {
                    Customer customer = new Customer();
                    customer.showMenu();
                    customerArrayList.add(customer);

                    break;
                }
                default:
                    System.out.println("Choose correctly");
            }

            System.out.println("Choose again?(y/n)");
            yn = scanner.next();
        } while (yn.equals("y"));
// parking lot

    }
}
