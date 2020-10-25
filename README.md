# Parking-System-PM
##Case Study-1
####Team 6: Team Members

* CS19B003 - AMIT KESARI : Worked on Solution.Java, ParkingLot.Java, CallMenu (Interface)
* CS19B006 - BAINDLA GOUTHAM : Worked on Bill/Rate Calculation and reset function.
* CS19B017 - PAVAN SAHITH : Worked on Payment.Java
* CS19B039 - SUMAN P : Worked on Customer.Java
* CS19B049 - POORNA SYAMA SUNDAR : Worked on Floor.java , VehicleSlot.java


#####Solution.java
* We have made Solution.java in which there is Admin Dash and Customer Dash.
* Admin Dash is for configuring the parking lot and setting up the floors (Admin Password:1234).
* Customer Dash is for getting information from the customer. The duplicity of the user is checked first.

#####ParkingLot.java
* In this class we are setting up number of floors using ArrayList.
* Specific floors can be viewed and configured.
* We are also displaying customer details, total earnings and individual floor details.
* Reset function given to erase everything.


#####Floors.java
* Each individual floor is configured through here.
* We are setting up VehicleSlot of various types (5) of vehicles using ArrayList.
* Each vehicle slot availability is checked from here.
* We have also included functions for booking slots and exiting the slot.
* All slots can also be viewed.


#####Payment.java
* It displays the bill and asks the customer to pay through various methods of payment.
* Customer has flexible payment options and can pay through different method if any method is having any problem.

#####Customer.java
* Customer is checked in the database and system generates a customer ID .
* We get all the details from the customer such as username, vehicle type,account balance, stayTime.
* Customer can book the slot on the floor he prefers while viewing the available empty floors on each block.
* Sets the customer bill according to different rates , types, subscription etc
* He/She can also exit the parking lot after payment of bill.

#####VehicleSlot.java
* Setting Slots of different vehicle types on specific floors.

#####CallMenu.java (Interface)
* An interface used for displaying the Menu driving for the program and invoking functions according to the input given by user.

####Running the program
* Open project in Text Editor.
* No dependency required.
* Open Solution.java and run the main() method.
* Navigate through different options in the menu.
* Exit using the option given.


