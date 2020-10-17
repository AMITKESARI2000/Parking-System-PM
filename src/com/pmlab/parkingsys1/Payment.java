import java.util.Scanner;

public class payment {

	public class payment implements CallMenu {
	    //to know the method of payment
	    Scanner scan = new Scanner(System.in);
	    System.out.println("welcome to the payment counter");
	    System.out.println("you should collect your ticket here");
	    String[] where = new String[]{"pay at floor customerinfo", "pay at exitgate","exit"};
	    for (int i = 0; i < where.length; i++) 
        {
            System.out.println(i + 1 + ": " + where[i]);
        }
        private int option=scan.nextInt();
        whereinvoker(option);
	    System.out.println("you can pay in 3 ways");
	    String[] functions = new String[]{"cash", "debit / creditcard", "pay to attender","exit"};
        for (int i = 0; i < functions.length; i++) 
        {
            System.out.println(i + 1 + ": " + functions[i]);
        }
        private int option1 = scan.nextInt();
        functionInvoker(option1);
	}
	
	
        public void whereinvoker(int option){
            switch (option1) {
            case 1: {
                rate 
                System.out.println("");
                
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
        
        
        
         public void functionInvoker(int option1) {
        switch (option1) {r
            //Add different functions below
            case 1: {
                System.out.println("");
                
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                
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
}
