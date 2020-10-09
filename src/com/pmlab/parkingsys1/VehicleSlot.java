package com.pmlab.parkingsys1;

import java.util.Scanner;

public class VehicleSlot{
    Scanner scanner = new Scanner(System.in);
    private String type ;
    private Boolean occupied = false;

    VehicleSlot( String type) {
    	this.type = type;
    }

    //================IMPLEMENT OTHER FUNCTIONS======================

    public String getType( )
    {
    	return type;
    }
    
    public void setStatus( boolean occupied )
    {
    	this.occupied = occupied;
    }
    
    public boolean getStatus()
    {
    	return occupied;
    }
}