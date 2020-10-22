package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

import static com.pmlab.parkingsys1.Solution.*;

public class ParkingLot implements CallMenu {
    Scanner scanner = new Scanner(System.in);
    static private int floorCount;
    static ArrayList<Floors> floors = new ArrayList<>(0);
    long totalEarning = 0;

    ParkingLot() {


    }
//================IMPLEMENT OTHER FUNCTIONS======================

    //Adds floors to Parking System
    public void setFloorCount() {
        System.out.println("Enter the number of floors you want to add: ");
        floorCount = scanner.nextInt();
        for (int i = 0; i < floorCount; i++) {
            Floors floor = new Floors();
            floors.add(floor);
        }
    }

    public int getFloorCount() {
        return floorCount;
    }


    //Configure Specific Floor
    public static int floorChoice = 0;

    public void floorsConfig() {
        displayFloorDetails();
        System.out.println("Enter the Floor Number You want to Configure: ");
        floorChoice = scanner.nextInt();
        floors.get(floorChoice).showMenu();
    }

    //Display the details of Each Floor
    public void displayFloorDetails() {
        if (floorCount <= 0) {
            System.out.println("Please Add Floors First!");
            return;
        }
        for (int i = 0; i < floorCount; i++) {
            System.out.print("Floor " + (i) + ": ");
            if (i == 0)
                System.out.print(" (Ground Floor)");
            System.out.println();
            floors.get(i).displayTotalSlots();
            System.out.println();
        }
    }

    public void displayCustomerDetails() {
        if (customerArrayList.size() <= 0) {
            System.out.println("No Customer in DataBase!");
            return;
        } else {
            System.out.println("Details: ");
            for (int i = 0; i < customerArrayList.size(); i++) {
                if (customerArrayList.get(i).getCustomerId().equals("")) continue;
                System.out.printf("%d. \n", i + 1);
                System.out.printf("%-15s%15s\n", "Customer ID: ", customerArrayList.get(i).getCustomerId());
                System.out.printf("%-15s%15s\n", "UserName: ", customerArrayList.get(i).getUsername());
                System.out.printf("%-15s%15f\n", "Account Balance: ", customerArrayList.get(i).getAccountBalance());
                System.out.printf("%-15s%15s\n", "Vehicle Type: ", customerArrayList.get(i).getvehicleType());
                System.out.println();
            }
        }
    }

    private int option = 0;

    @Override
    public void showMenu() {

        System.out.println("Choose your option:");
        String[] functions = new String[]{"Add Floors", "Floor Details", "Configure Specific Floor",
                "Show Customer Details", "Back", "Exit"};
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
                setFloorCount();
                System.out.println("Floors are empty by default. Want to add vehicle slots of each type?(y/n)");
                if (scanner.next().equals("y"))
                    floorsConfig();
                break;
            }
            case 2: {
                displayFloorDetails();
                parkingLot.showMenu();
                break;
            }
            case 3: {
                floorsConfig();
                break;
            }
            case 4: {
                displayCustomerDetails();
                parkingLot.showMenu();
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
                parkingLot.showMenu();
        }
    }
}
