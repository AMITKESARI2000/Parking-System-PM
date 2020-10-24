package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

import static com.pmlab.parkingsys1.Solution.*;

public class ParkingLot implements CallMenu {
    Scanner scanner = new Scanner(System.in);
    static private int floorCount = 3;
    static private int maxFloorCount = 15;
    static ArrayList<Floors> floors = new ArrayList<>(0);

    long totalEarning = 0;

    ParkingLot() {
        //Add 3 floors by default
        for (int i = 0; i < floorCount; i++) {
            Floors floor = new Floors();
            floors.add(floor);
        }
    }

    //================IMPLEMENT OTHER FUNCTIONS======================
    //Gets floor count
    public int getFloorCount() {
        return floorCount;
    }

    //Adds floors to Parking System
    public void setFloorCount() {
        try {
            floors.clear();
            System.out.println("Enter the number of floors you want to set: ");
            floorCount = scanner.nextInt();
            if (floorCount >= 0) {
                if (floorCount > maxFloorCount) {
                    System.out.println("This is a commercial building. Max floors possible is:" + maxFloorCount);
                    System.out.println("Setting Floor Count to max possible only");
                    floorCount = maxFloorCount;
                }
                for (int i = 0; i < floorCount; i++) {
                    Floors floor = new Floors();
                    floors.add(floor);
                }

            } else {
                System.out.println("Enter valid number of floors.");
            }
        } catch (Exception e) {
            System.out.println("Enter valid input.");
            e.printStackTrace();
        }
    }


    //Configure Specific Floor
    public static int floorChoice = 0;

    public void floorsConfig() {
        displayFloorDetails();
        System.out.println("Enter the Floor Number You want to Configure ( 0 - " + (floorCount - 1) + " ): ");
        floorChoice = scanner.nextInt();
        if (floorChoice >= 0 && floorChoice < floorCount)
            floors.get(floorChoice).showMenu();
        else {
            System.out.println("Please enter valid floor number. Discarding...");
        }
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
                System.out.printf("%-15s%15s\n", "Premium Subscription: ", customerArrayList.get(i).getIsPremiumSubscription());
                System.out.printf("%-15s%15s\n", "Bill Paid: ", customerArrayList.get(i).getBill());

                System.out.println();
            }
        }
    }

    private int option = 0;

    public boolean getParking()
    {
        for(int i=0;i<customerArrayList.size();i++) {
            if(customerArrayList.get(i).getParkingStatus())
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public void showMenu() {
        try {
            System.out.println("Choose your option:");
            String[] functions = new String[]{"Set Floors", "Show Floor Details", "Configure Specific Floor",
                    "Show Customer Details", "Back", "Exit Program"};
            for (int i = 0; i < functions.length; i++) {
                System.out.println(i + 1 + ": " + functions[i]);
            }
            option = scanner.nextInt();
            functionInvoker(option);
        } catch (Exception e) {
            System.out.println("Enter valid Input.");
            e.printStackTrace();
        }
    }

    //Different functions are invoked according to choice
    @Override
    public void functionInvoker(int option) {
        switch (option) {
            case 1: {

                if(getParking()) {
                    setFloorCount();
                    System.out.println("Parking Lot has " + floorCount + " floors by default having " + 4 + " slots of each type." +
                            " Want to change vehicle slots of each type?(y/n)");
                    if (scanner.next().equals("y"))
                        floorsConfig();
                }
                else
                    System.out.println("Can't reconfigure Parking Lot now" );
                break;
            }
            case 2: {
                displayFloorDetails();
                parkingLot.showMenu();
                break;
            }
            case 3: {
                if(getParking()) {
                    floorsConfig();
                }
                else
                    System.out.println("Can't reconfigure Parking Slot now" );
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
                System.out.println("Tata Bye!!! Have a Great Day ;)");
                System.exit(0);
                break;
            }
            default:
                System.out.println("Please Choose correctly. ");
                parkingLot.showMenu();
        }
    }
}
