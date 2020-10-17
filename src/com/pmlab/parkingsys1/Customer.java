package com.pmlab.parkingsys1;

import java.util.Scanner;

public class Customer extends ParkingLot {
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
    private String CustomerId;

    Customer() {
    }
    //================IMPLEMENT OTHER FUNCTIONS======================

    public void setCustomerId(){
        int n=10;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

            for (int i = 0; i < n; i++) {
                int index = (int)(AlphaNumericString.length() * Math.random());
                sb.append(AlphaNumericString.charAt(index));
            }
            CustomerId=sb.toString();

        System.out.println("Customer Id:"+CustomerId);
    }

    public String getCustomerId()
    {
        return CustomerId;
    }

    public void setAccountBalance() {
        System.out.println("Enter Account Balance for Validation of Payment: ");
        this.accountBalance = scanner.nextFloat();
        System.out.println("Added : " + accountBalance);
    }
    public float getAccountBalance()
    {
        return accountBalance;
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
    public String getvehicleType()
    {
        return vehicleType;
    }


   public boolean setParkingLotCustomer()
    {
        System.out.println("Enter preferred floor: ");
         floor_no=scanner.nextInt();

         if(getFloorCount()<floor_no | floor_no<0) {
             System.out.println("Enter valid number:");
             return false;
         }
         else{
             boolean check_status = floors.get(floor_no).bookSlot(vehicleType);

             if(check_status) {
                 System.out.println("Parking has been allotted");
                 System.out.println("Floor:"+ floor_no);
                 System.out.println("Slot:"+ vehicleType);
             }

             return check_status;
         }
    }

    public boolean exitParkingLotCustomer()
    {

        boolean check_status=floors.get(floor_no).exitSlot(vehicleType);

        if(check_status){
            System.out.println("Exited from Parking Lot");
        }

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
        String[] functions = new String[]{"Enter User Data", "Set Parking Slot","Exit Parking Slot", "Exit"};
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
                setCustomerId();
                setAccountBalance();
                setVehicleType();
                setStayTime();
                break;
            }
            case 2: {
                setParkingLotCustomer();
                break;
            }
            case 3: {
                exitParkingLotCustomer();
                break;
            }
            case 4: {
                System.exit(0);
                break;
            }

            default:
                System.out.println("Choose correctly");
        }
    }

}


 
