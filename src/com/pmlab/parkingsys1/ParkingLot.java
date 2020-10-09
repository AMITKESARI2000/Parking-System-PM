package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

public class ParkingLot implements CallMenu {
    Scanner scanner = new Scanner(System.in);
    static private int floorCount;
    ArrayList<Floors> floors = new ArrayList<>(0);

    ParkingLot() {

    }
//================IMPLEMENT OTHER FUNCTIONS======================


    public void setFloorCount() {
        System.out.println("Enter the number of floors you want: ");
        floorCount = scanner.nextInt();
        for (int i = 0; i < floorCount; i++) {
            floors.add(new Floors());
        }
    }

    private int option = 0;

    @Override
    public int showMenu() {

        System.out.println("Choose your option:");
        String[] functions = new String[]{"Admin Dash", "Customer Dash"};
        for (int i = 0; i < functions.length; i++) {
            System.out.println(i + 1 + ": " + functions[i]);
        }
        option = scanner.nextInt();
        return option;
    }

    @Override
    public void functionInvoker(int option) {
        switch (option) {
            //Add different functions below
            case 1: {

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
