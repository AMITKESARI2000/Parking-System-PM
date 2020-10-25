package com.pmlab.parkingsys1;

import java.util.Scanner;

//To know the method of payment
public class Payment implements CallMenu {
    Scanner scanner = new Scanner(System.in);
    private float bill;
    private float balance;
    private boolean premiumSubscription = false;
    private float amount;

    //Constructor for setting up initial values
    Payment(float bill, float balance, boolean premiumSubscription) {
        this.bill = bill;
        this.balance = balance;
        this.premiumSubscription = premiumSubscription;
        amount = balance;
    }

    //Gets the account balance
    public float getAmount() {
        System.out.println("Account Balance:" + amount);
        return amount;
    }

    @Override
    public void showMenu() {
        System.out.println("Welcome to the payment counter");
        System.out.println("Your bill: Rs" + bill);
        String[] where = new String[]{"Pay at floor customer info", "Pay at exit gate", "Exit"};
        for (int i = 0; i < where.length; i++) {
            System.out.println(i + 1 + ": " + where[i]);
        }
        int option = scanner.nextInt();
        if (option == 1 || option == 2) {
            paymentMethod();
        }
        if (option == 3) {
            return;
        }
    }

    //Menu selection for payment method
    public void paymentMethod() {
        try {
            System.out.println("You can pay in 4 ways");
            String[] functions = new String[]{"Cash", "Debit / Credit card", "Pay to Attender", "Use Premium account", "Exit"};
            for (int i = 0; i < functions.length; i++) {
                System.out.println(i + 1 + ": " + functions[i]);
            }
            int option1 = scanner.nextInt();
            functionInvoker(option1);
        } catch (Exception e) {
            System.out.println("Enter Valid input.");
            e.printStackTrace();
        }
    }

    //Function invoker for payment method
    @Override
    public void functionInvoker(int option1) {
        switch (option1) {
            //Add different functions below
            case 1: {
                System.out.println("You paid: Rs " + bill);
                break;
            }
            case 2: {
                if (balance >= bill) {
                    System.out.println("Rs" + bill + " has been deducted from your credit card");
                    amount = balance - bill;
                } else {
                    System.out.println("Your account balance is not sufficient");
                    System.out.println("Select Another method of payment");
                    paymentMethod();
                }
                break;
            }
            case 3: {
                System.out.println("Rs" + bill + " should be paid to our attender");
                break;
            }
            case 4: {
                if (premiumSubscription) {
                    if (balance >= bill) {
                        System.out.println("Rs" + bill + " has been deducted from your premium account");
                        amount = balance - bill;
                    }
                } else {
                    System.out.println("Your account balance is not sufficient");
                    System.out.println("Select Another method of payment");
                    paymentMethod();
                }
                break;
            }
            case 5: {
                System.exit(0);
                break;
            }
            default:
                System.out.println("Choose correctly");
                paymentMethod();
        }
    }
}



