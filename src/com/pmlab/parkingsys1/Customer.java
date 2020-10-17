package com.pmlab.parkingsys1;

import java.util.Scanner;

public class Customer implements CallMenu  {
    Scanner scanner = new Scanner(System.in);
    private float accountBalance = 0;
    private boolean premiumSubscription = false;
    private String[] vehicleTypes = new String[]{
            "Small ( Sedans, Compact etc ) ",
            "Large ( Truck, SUV etc )",
            "Motor Bike",
            "Other ( Cycles, Handicapped etc )"
    };


    private String vehicleType;
    private int stayTime = 0;
    private int floor_no=0;

    Customer() {
    }
    //================IMPLEMENT OTHER FUNCTIONS======================

    public void setAccountBalance() {
        System.out.println("Enter Account Balance for Validation of Payment: ");
        this.accountBalance = scanner.nextFloat();
        System.out.println("Added : " + accountBalance);
    }

    public void setVehicleType() {
        System.out.println("Choose Your Vehicle Type: ");
        for (int i = 0; i < vehicleTypes.length; i++) {
            System.out.println(i + 1 + ": " + vehicleTypes[i]);
        }
        switch (scanner.nextInt()) {
            case 1:
                vehicleType = "small";
                break;
            case 2:
                vehicleType = "large";
                break;
            case 3:
                vehicleType = "motorcycle";
                break;
            case 4:
                vehicleType = "handicapped";
                break;
            default:
                System.out.println("Enter valid number");
                setVehicleType();
                break;
        }
    }

   public void set_parkingslot_customer()
    {
        System.out.println("Enter preferred floor: ");
         floor_no=scanner.nextInt();
         boolean check_status=Floors[floor_no].bookslot(vehicleType);

         return check_status;
    }





    public void setStayTime() {
        System.out.println("Enter Your Parking Time: ");
        stayTime = scanner.nextInt();
        System.out.println("Added : " + stayTime);
        int rate=0;
        if(stayTime>0 && stayTime<=60) {
			rate=20;
		}
		if(stayTime>60 && stayTime<=180 ) {
			if(stayTime<=120)
				rate=30;
			else 
				rate=40;
		}
		if(stayTime>180) {
			stayTime=stayTime-180;
			if(stayTime%60==0) {
				stayTime=stayTime/60;
				rate=40+(stayTime*5);
			}
			else {
				stayTime=stayTime/60;
				rate=40+(stayTime+1)*5;
			}
		}
        System.out.println("You have to pay "+rate);
    }

    private int option;

    @Override
    public void showMenu() {

        System.out.println("Choose your option:");
        String[] functions = new String[]{"Enter User Data", "", "Exit"};
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
                setAccountBalance();
                setVehicleType();
                setStayTime();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }

            default:
                System.out.println("Choose correctly");
        }
    }

}


 
