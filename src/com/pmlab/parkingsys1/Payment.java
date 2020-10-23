package com.pmlab.parkingsys1;

import java.util.Scanner;

public class Payment implements CallMenu {
    //to know the method of payment
    Scanner scan = new Scanner(System.in);
    private float bill;
    private float balance;
    private boolean premiumSubscription = false;
    private float amount;

    Payment(float bill, float balance, boolean premiumSubscription) {
        this.bill = bill;
        this.balance = balance;
        this.premiumSubscription = premiumSubscription;
        amount=balance;
    }

    public void paymentMethod() {
        System.out.println("you can pay in 3 ways");
        String[] functions = new String[]{"cash", "debit / credit card", "pay to attender", "Use Premimum account","exit"};
        for (int i = 0; i < functions.length; i++) {
            System.out.println(i + 1 + ": " + functions[i]);
        }
        int option1 = scan.nextInt();
        functionInvoker(option1);

    }

    public float getAmount() {
        System.out.println("Account Balance:"+ amount);
        return amount;
    }

    @Override
    public void showMenu() {
        System.out.println("welcome to the payment counter");
        System.out.println("your bill" + bill);
        String[] where = new String[]{"pay at floor customer info", "pay at exit gate", "exit"};
        for (int i = 0; i < where.length; i++) {
            System.out.println(i + 1 + ": " + where[i]);
        }
        int option = scan.nextInt();
        if (option == 1 || option == 2) {
            paymentMethod();
        }
        if (option == 3) {
            return;
        }

    }

    @Override
    public void functionInvoker(int option1) {
        switch (option1) {
            //Add different functions below
            case 1: {
                System.out.println("you paid " + bill);

                break;
            }
            case 2: {

                if (balance >= bill) {
<<<<<<< HEAD
                    System.out.println(bill);
                    System.out.println("rupees has been deducted from your credit card");
=======
                    System.out.println(bill +"rupees has been deducted from your credit card");
>>>>>>> 5a2ff05b829ca7b0277d616a3da277520b563957

                    amount = balance - bill;


                } else {

                    System.out.println("your account balance is not sufficient");
                    System.out.println("Select Another method of payment");
                    paymentMethod();

                }
                break;
            }
            case 3: {
                System.out.println(bill + "rupees should be paid to our attender");

                break;
            }
            case 4: {
                if (premiumSubscription) {
                    if (balance >= bill) {
                        System.out.println(bill + "rupees has been deducted from your premium account");
                        amount = balance - bill;
                    }

                } else {

                    System.out.println("your account balance is not sufficient");
                    System.out.println("Select Another method of payment");
                    paymentMethod();

                }
                break;
            }

<<<<<<< HEAD
=======



            case 5: {
                System.exit(0);
                break;
            }
>>>>>>> 5a2ff05b829ca7b0277d616a3da277520b563957



        case 5: {
            System.exit(0);
            break;
        }

        default:
        System.out.println("Choose correctly");
    }
<<<<<<< HEAD


}
}
=======
}
>>>>>>> 5a2ff05b829ca7b0277d616a3da277520b563957
