package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

import static com.pmlab.parkingsys1.ParkingLot.floorChoice;
import static com.pmlab.parkingsys1.Solution.parkingLot;

public class Floors implements CallMenu {
    Scanner scanner = new Scanner(System.in);
    private int smallSlotCount = 4;
    private int largeSlotCount = 4;
    private int handicappedSlotCount = 4;
    private int motorCycleSlotCount = 4;
    private int electricSlotCount = 4;

    ArrayList<VehicleSlot> small = new ArrayList<>(0);
    ArrayList<VehicleSlot> large = new ArrayList<>(0);
    ArrayList<VehicleSlot> motorCycle = new ArrayList<>(0);
    ArrayList<VehicleSlot> handicapped = new ArrayList<>(0);
    ArrayList<VehicleSlot> electric = new ArrayList<>(0);

    Floors() {
        //Add 4 vehicle slots of each type by default
        for (int i = 0; i < smallSlotCount; i++)
            small.add(new VehicleSlot("small"));

        for (int i = 0; i < largeSlotCount; i++)
            large.add(new VehicleSlot("large"));

        for (int i = 0; i < handicappedSlotCount; i++)
            handicapped.add(new VehicleSlot("handicapped"));

        for (int i = 0; i < motorCycleSlotCount; i++)
            motorCycle.add(new VehicleSlot("motorcycle"));

        for (int i = 0; i < electricSlotCount; i++)
            electric.add(new VehicleSlot("electric"));

    }
    //================IMPLEMENT OTHER FUNCTIONS======================

    //Configure Specific Floor
    public void floorConfig() {
        System.out.println("Configure your floor space");
        setSmallSlotCount();
        setLargeSlotCount();
        setMotorCycleSlotCount();
        setHandicappedSlotCount();
        setElectricSlotCount();
    }

    //Sets Number Of Slots of all 5 types
    public void setSmallSlotCount() {
        try {
            small.clear();
            System.out.println("Enter number of slots of type 'small' you want: ");
            smallSlotCount = scanner.nextInt();

            if (smallSlotCount >= 0)
                for (int i = 0; i < smallSlotCount; i++)
                    small.add(new VehicleSlot("small"));
            else
                System.out.println("Enter valid Number");
        } catch (Exception e) {
            System.out.println("Enter valid input.");
            e.printStackTrace();
        }
    }

    public void setLargeSlotCount() {
        try {
            large.clear();
            System.out.println("Enter number of slots of type 'large' you want: ");
            largeSlotCount = scanner.nextInt();
            if (largeSlotCount >= 0)
                for (int i = 0; i < largeSlotCount; i++)
                    large.add(new VehicleSlot("large"));
            else
                System.out.println("Enter valid Number");
        } catch (Exception e) {
            System.out.println("Enter valid input.");
            e.printStackTrace();
        }

    }

    public void setHandicappedSlotCount() {
        try {
            handicapped.clear();
            System.out.println("Enter number of slots of type 'handicapped' you want: ");
            handicappedSlotCount = scanner.nextInt();
            if (handicappedSlotCount >= 0)
                for (int i = 0; i < handicappedSlotCount; i++)
                    handicapped.add(new VehicleSlot("handicapped"));
            else
                System.out.println("Enter valid Number");
        } catch (Exception e) {
            System.out.println("Enter valid input.");
            e.printStackTrace();
        }
    }

    public void setMotorCycleSlotCount() {
        try {
            motorCycle.clear();
            System.out.println("Enter number of slots of type 'motorcycle' you want: ");
            motorCycleSlotCount = scanner.nextInt();
            if (motorCycleSlotCount >= 0)
                for (int i = 0; i < motorCycleSlotCount; i++)
                    motorCycle.add(new VehicleSlot("motorcycle"));
            else
                System.out.println("Enter valid Number");
        } catch (Exception e) {
            System.out.println("Enter valid input.");
            e.printStackTrace();
        }
    }

    public void setElectricSlotCount() {
        try {
            electric.clear();
            System.out.println("Enter number of slots of type 'electric' you want: ");
            electricSlotCount = scanner.nextInt();
            if (electricSlotCount >= 0)
                for (int i = 0; i < electricSlotCount; i++)
                    electric.add(new VehicleSlot("electric"));
            else
                System.out.println("Enter valid Number");
        } catch (Exception e) {
            System.out.println("Enter valid input.");
            e.printStackTrace();
        }
    }

    //Returns no of available slots of type "small"
    public int availableSmallSlots() {
        int i = 0;
        for (VehicleSlot v : small)
            if (v.getStatus() == false)
                i++;
        return i;
    }

    //Returns no of available slots of type "large"
    public int availableLargeSlots() {
        int i = 0;
        for (VehicleSlot v : large)
            if (v.getStatus() == false)
                i++;
        return i;
    }

    //Returns no of available slots of type "handicapped"
    public int availableHandicappedSlots() {
        int i = 0;
        for (VehicleSlot v : handicapped)
            if (v.getStatus() == false)
                i++;
        return i;
    }

    //Returns no of available slots of type "motorcycle"
    public int availableMotorCycleSlots() {
        int i = 0;
        for (VehicleSlot v : motorCycle)
            if (v.getStatus() == false)
                i++;
        return i;
    }

    //Returns no of available slots of type "electric"
    public int availableElectricSlots() {
        int i = 0;
        for (VehicleSlot v : electric)
            if (v.getStatus() == false)
                i++;
        return i;
    }

    public String bookSlot(String type, int floor)     //takes vehicleType and floor_no as input and returns id of
    {                                                    //that vehicleSlot if a VehicleSlot of that type is booked
        String id = "F" + String.valueOf(floor);          //returns empty string if no VehicleSlot is free for the given vehicleType

        if (type.equals("small"))
            for (int i = 0; i < small.size(); i++)
                if (small.get(i).getStatus() == false) {
                    small.get(i).setStatus(true);
                    id = "s" + floor + i;
                    return id;
                }

        if (type.equals("large"))
            if (availableLargeSlots() > 0)
                for (int i = 0; i < large.size(); i++)
                    if (large.get(i).getStatus() == false) {
                        large.get(i).setStatus(true);
                        id = "l" + floor + i;
                        return id;
                    }

        if (type.equals("handicapped"))
            if (availableHandicappedSlots() > 0)
                for (int i = 0; i < handicapped.size(); i++)
                    if (handicapped.get(i).getStatus() == false) {
                        handicapped.get(i).setStatus(true);
                        id = "h" + floor + i;
                        return id;
                    }

        if (type.equals("motorcycle"))
            if (availableMotorCycleSlots() > 0)
                for (int i = 0; i < motorCycle.size(); i++)
                    if (motorCycle.get(i).getStatus() == false) {
                        motorCycle.get(i).setStatus(true);
                        id = "m" + floor + i;
                        return id;
                    }

        if (type.equals("electric"))
            if (availableElectricSlots() > 0)
                for (int i = 0; i < electric.size(); i++)
                    if (electric.get(i).getStatus() == false) {
                        electric.get(i).setStatus(true);
                        id = "e" + floor + i;
                        return id;
                    }
        return "";
    }

    //Exits customer from parking slot by freeing up the occupied slot
    public boolean exitSlot(String type) {
        if (type.equals("small"))
            if (availableSmallSlots() != smallSlotCount)
                for (VehicleSlot v : small)
                    if (v.getStatus() == true) {
                        v.setStatus(false);
                        return true;
                    }
        if (type.equals("large"))
            if (availableLargeSlots() != largeSlotCount)
                for (VehicleSlot v : large)
                    if (v.getStatus() == true) {
                        v.setStatus(false);
                        return true;
                    }
        if (type.equals("handicapped"))
            if (availableHandicappedSlots() != handicappedSlotCount)
                for (VehicleSlot v : handicapped)
                    if (v.getStatus() == true) {
                        v.setStatus(false);
                        return true;
                    }
        if (type.equals("motorcycle"))
            if (availableSmallSlots() != motorCycleSlotCount)
                for (VehicleSlot v : motorCycle)
                    if (v.getStatus() == true) {
                        v.setStatus(false);
                        return true;
                    }

        if (type.equals("electric"))
            if (availableElectricSlots() != electricSlotCount)
                for (VehicleSlot v : electric)
                    if (v.getStatus() == true) {
                        v.setStatus(false);
                        return true;
                    }
        return false;
    }

    //Displays availability information of slots
    public void displayTotalSlots() {
        System.out.printf("Type            Total Slots    Available Slots%n");
        System.out.printf("%-12s%10d%17d\n", "small", smallSlotCount, availableSmallSlots());
        System.out.printf("%-12s%10d%17d\n", "large", largeSlotCount, availableLargeSlots());
        System.out.printf("%-12s%10d%17d\n", "handicapped", handicappedSlotCount, availableHandicappedSlots());
        System.out.printf("%-12s%10d%17d\n", "motorcycle", motorCycleSlotCount, availableMotorCycleSlots());
        System.out.printf("%-12s%10d%17d\n", "electric", electricSlotCount, availableElectricSlots());

    }

    private int option = 0;

    @Override
    public void showMenu() {
        try {
            do {
                System.out.println("Currently on Floor: " + floorChoice);
                System.out.println("Choose your option:");
                String[] functions = new String[]{"Floor Configuration", "Display Available slots", "Back", "Exit Program"};
                for (int i = 0; i < functions.length; i++) {
                    System.out.println(i + 1 + ": " + functions[i]);
                }
                option = scanner.nextInt();
                functionInvoker(option);
            } while (true);
        } catch (Exception e) {
            System.out.println("Enter valid input");
            e.printStackTrace();
        }
    }

    @Override
    public void functionInvoker(int option) {
        switch (option) {
            case 1: {
                floorConfig();
                break;
            }
            case 2: {
                displayTotalSlots();
                break;
            }
            case 3: {
                parkingLot.showMenu();
                break;
            }
            case 4: {
                System.out.println("Tata Bye!!! Have a Great Day ;)");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Choose correctly");
            }
        }
    }

}

