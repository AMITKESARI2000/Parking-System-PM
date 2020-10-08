package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

public class Floors {
    Scanner scanner = new Scanner(System.in);
    private int freeSlotCount = 0;
    private int paidSlotCount = 0;
    ArrayList<VehicleSlot> free = new ArrayList<>(0);
    ArrayList<VehicleSlot> paid = new ArrayList<>(0);

    Floors() {
        System.out.println("Configure your floor space");
        System.out.println("Enter number of free slots you want: ");
        freeSlotCount = scanner.nextInt();
        for (int i = 0; i < freeSlotCount; i++) {
            free.add(new VehicleSlot());
        }
        System.out.println("Enter number of free slots you want: ");
        freeSlotCount = scanner.nextInt();
        for (int i = 0; i < freeSlotCount; i++) {
            paid.add(new VehicleSlot());
        }
    }
    //IMPLEMENT OTHER FUNCTIONS
}
