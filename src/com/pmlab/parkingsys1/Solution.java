package com.pmlab.parkingsys1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome To Fantasy Parking Lot!!!");
        ParkingLot parkingLot=new ParkingLot();
        String yn;

        do {
            parkingLot.showMenu();
            System.out.println("Choose again?(y/n)");
            yn = scanner.next();
        } while (yn.equals("y"));
// parking lot

    }
}
