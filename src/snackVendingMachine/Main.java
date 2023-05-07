package snackVendingMachine;

public class Main {
 // uml 
	// money polym
	
	
	public static void main(String[] args) {

		System.out.print("hi");
		 VendingMachineFactory factory = new SnackVendingMachineFactory();
	     VendingMachine vendingMachine = factory.createVendingMachine();
	     VendingMachineController controller = new VendingMachineController(vendingMachine);
	     
	  // Display available snacks
	     controller.displaySnacks();
	     // Select a snack
	     controller.selectSnack(3, 3);
	     // Insert coins or notes
	     controller.insertCoin(Coin.DOLLAR);//1
	     controller.insertCoin(Coin.FIFTYCent);//0.5
	    
	     // Dispense the snack
	     controller.dispenseItem(3, 3);
	    System.out.println("_______________________________________________________");
	     
	     // Display available snacks
	     controller.displaySnacks();

	     // Select a snack
	     controller.selectSnack(3, 2);
	     // Insert coins or notes
	     controller.insertCoin(Coin.DOLLAR);//1
	     controller.insertCoin(Coin.FIFTYCent);//0.5
	    
	     // Dispense the snack
	     controller.dispenseItem(3, 2);
	     System.out.println("_______________________________________________________");
	     // Display available snacks
	     controller.displaySnacks();

	     // Select a snack
	     controller.selectSnack(3, 1);
	     // Insert coins or notes
	     controller.insertCoin(Coin.DOLLAR);//1
	     controller.insertCoin(Coin.FIFTYCent);//0.5
	    
	     // Dispense the snack
	     controller.dispenseItem(3, 1);
	     System.out.println("_______________________________________________________");
	   

	}

}
