package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

public class Floors {
    Scanner scanner=new Scanner(System.in);
    private int freeSlotCount=0;
    ArrayList<VehicleSlot> free=new ArrayList<>(5);
    ArrayList<VehicleSlot> paid=new ArrayList<>(5);
    Floors(){
        System.out.println("Configure your floor space");
        System.out.println("Enter number of free slots you want: ");
        freeSlotCount=scanner.nextInt();

    }
}
