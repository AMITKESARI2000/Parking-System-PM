package com.pmlab.parkingsys1;

import java.util.ArrayList;
import java.util.Scanner;

public class Floors implements CallMenu{
    Scanner scanner = new Scanner(System.in);
    private int smallSlotCount = 0;
    private int largeSlotCount = 0;
    private int handicappedSlotCount = 0;
    private int motorCycleSlotCount = 0;
    
    ArrayList<VehicleSlot> small = new ArrayList<>(0);
    ArrayList<VehicleSlot> large = new ArrayList<>(0);
    ArrayList<VehicleSlot> handicapped = new ArrayList<>(0);
    ArrayList<VehicleSlot> motorCycle = new ArrayList<>(0);
    Floors() {
        System.out.println("Configure your floor space");
        
        System.out.println("Enter number of slots of type 'small' you want: ");
        smallSlotCount = scanner.nextInt();
        if( smallSlotCount >= 0 )
        	for (int i = 0; i < smallSlotCount; i++)
        		small.add(new VehicleSlot("small"));
        else
        	System.out.println("Enter valid Number");
        
        System.out.println("Enter number of slots of type 'large' you want: ");
        largeSlotCount = scanner.nextInt();
        if( largeSlotCount >= 0 )
        	for (int i = 0; i < largeSlotCount; i++) 
        		large.add(new VehicleSlot("large"));
        else
        	System.out.println("Enter valid Number");
        
        System.out.println("Enter number of slots of type 'handicapped' you want: ");
        handicappedSlotCount = scanner.nextInt();
        if( handicappedSlotCount >= 0 )
        	for (int i = 0; i < handicappedSlotCount; i++) 
        		handicapped.add(new VehicleSlot("handicaped"));
        else
        	System.out.println("Enter valid Number");
 
        System.out.println("Enter number of slots of type 'motorcycle' you want: ");
        motorCycleSlotCount = scanner.nextInt();
        if( motorCycleSlotCount >= 0 )
        	for (int i = 0; i < motorCycleSlotCount; i++)
        		motorCycle.add(new VehicleSlot("motorcycle"));
        else
        	System.out.println("Enter valid Number");
        
    }
    //================IMPLEMENT OTHER FUNCTIONS======================
    
    public int availableSmallSlots()                  //returns no of available slots of type small
    {
    	int i = 0 ;
    	for( VehicleSlot v: small )
    		if( v.getStatus() == false )
    			i++;
    	return i;
    }
    
    public int availableLargeSlots()                 //returns no of available slots of type large
    {
    	int i = 0 ;
    	for( VehicleSlot v: large )
    		if( v.getStatus() == false )
    			i++;
    	return i;
    }
    
    public int availableHandicappedSlots()           //returns no of available slots of type handicapped
    {
    	int i = 0 ;
    	for( VehicleSlot v: handicapped )
    		if( v.getStatus() == false )
    			i++;
    	return i;
    }
    public int availableMotorCycleSlots()            //returns no of available slots of type motorcycle
    {
    	int i = 0 ;
    	for( VehicleSlot v: motorCycle )
    		if( v.getStatus() == false )
    			i++;
    	return i;
    }
    
    public boolean bookSlot( String type )            //takes vehicleType as input and return true if 
    {                                                 //a VehicleSlot of that type is booked
    	if( type.equals("small"))                     //returns false if no VehicleSlot is free for the given vehicleType
    		if( availableSmallSlots() > 0 )
    			for( VehicleSlot v: small )
    				if( v.getStatus() == false)
    				{
    					v.setStatus(true);
    					return true;
    				}
    	if( type.equals("large"))                     
    		if( availableLargeSlots() > 0 )
    			for( VehicleSlot v: large )
    				if( v.getStatus() == false)
    				{
    					v.setStatus(true);
    					return true;
    				}
    	if( type.equals("handicapped"))                     
    		if( availableHandicappedSlots() > 0 )
    			for( VehicleSlot v: handicapped )
    				if( v.getStatus() == false)
    				{
    					v.setStatus(true);
    					return true;
    				}
    	if( type.equals("motorcycle"))                    
    		if( availableSmallSlots() > 0 )
    			for( VehicleSlot v: motorCycle )
    				if( v.getStatus() == false)
    				{
    					v.setStatus(true);
    					return true;
    				}
    	return false;
    }
    
    public void displayTotalSlots()                        //displays availability information
    {
    	System.out.printf("Type            Total Slots    Available Slots%n");
		System.out.printf("%-12s%10d%17d","small",smallSlotCount,availableSmallSlots());
		System.out.printf("%-12s%10d%17d","small",largeSlotCount,availableLargeSlots());
		System.out.printf("%-12s%10d%17d","small",handicappedSlotCount,availableHandicappedSlots());
		System.out.printf("%-12s%10d%17d","small",motorCycleSlotCount,availableMotorCycleSlots());
		
    }
    private int option = 0;
    @Override
    public int showMenu() {

        System.out.println("Choose your option:");
        String[] functions = new String[]{"Display Total No of Available slots", "Subtraction", "Multiplication", "Division"};
        for (int i = 0; i < functions.length; i++) {
            System.out.println(i + 1 + ": " + functions[i]);
        }
        option = scanner.nextInt();
        return option;
    }
    @Override
    public void functionInvoker(int opt) 
    {
    	if( opt == 1 )
    		displayTotalSlots();
    }
    
}
