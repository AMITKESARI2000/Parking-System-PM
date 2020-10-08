package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

public class ParkingLot {
    Scanner scanner=new Scanner(System.in);
    private int floorCount;
    ArrayList<Floors> floors=new ArrayList<>(5);
    ParkingLot(){
        System.out.println("Enter the number of floors you want: ");
        floorCount=scanner.nextInt();
        for (int i = 0; i < floorCount; i++) {
            floors
        }
    }
}
