package com.pmlab.parkingsys1;

public interface CallMenu {
    //Return the option (integer chosen)
    public void showMenu();

    //Takes in the option for switching
    public void functionInvoker(int option);
}
