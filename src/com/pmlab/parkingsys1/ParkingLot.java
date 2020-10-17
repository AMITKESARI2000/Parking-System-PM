package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

import static com.pmlab.parkingsys1.Solution.parkingLot;

public class ParkingLot implements CallMenu {
    Scanner scanner = new Scanner(System.in);
    static private int floorCount;
    static ArrayList<Floors> floors = new ArrayList<>(0);

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

    public int getFloorCount(){
        return floorCount;
    }


    //Configure Specific Floor
    public void floorsConfig() {
        displayFloorDetails();
        System.out.println("Enter the Floor Number You want to Configure: ");
        int choice = 0;
        choice = scanner.nextInt();
        floors.get(choice).showMenu();

    }

    //Display the details of Each Floor
    public void displayFloorDetails() {
        if (floorCount <= 0) {
            System.out.println("Please Add Floors First!");
            return;
        }
        for (int i = 0; i < floorCount; i++) {
            System.out.println((i + 1) + ": ");
            floors.get(i).displayTotalSlots();
            System.out.println();
        }

    }

    private int option = 0;

    @Override
    public void showMenu() {

        System.out.println("Choose your option:");
        String[] functions = new String[]{"Add Floors", "Floor Details", "Configure Specific Floor", "Back", "Exit"};
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

                break;
            }
            case 2: {
                displayFloorDetails();
                break;
            }
            case 3: {
                floorsConfig();
                break;
            }
            case 4: {
              //  System.out.println();
                parkingLot.showMenu();
                break;
            }
            case 5: {
                System.exit(0);
                break;
            }
            default:
                System.out.println("Choose correctly");
        }
    }
}
