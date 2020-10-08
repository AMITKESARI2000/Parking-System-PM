package com.pmlab.parkingsys1;

import java.util.Scanner;

public class VehicleSlot implements CallMenu {
    Scanner scanner = new Scanner(System.in);
    private String type = "Normal";
    private Boolean occupied = false;

    VehicleSlot() {

    }

    //IMPLEMENT OTHER FUNCTIONS

    private int option = 0;

    @Override
    public int showMenu() {

        System.out.println("Choose your option:");
        String[] functions = new String[]{"Addition", "Subtraction", "Multiplication", "Division"};
        for (int i = 0; i < functions.length; i++) {
            System.out.println(i + 1 + ": " + functions[i]);
        }
        option = scanner.nextInt();
        return option;
    }
    @Override
    public void functionInvoker(int opt) {

    }
}
