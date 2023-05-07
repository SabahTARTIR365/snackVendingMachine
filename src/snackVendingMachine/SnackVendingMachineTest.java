package snackVendingMachine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.Before;
import org.junit.Test;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SnackVendingMachineTest {
    private SnackVendingMachine vendingMachine;
    private VendingMachineController controller = new VendingMachineController(vendingMachine);
    @Before
    public void setUp() {
   	 VendingMachineFactory factory = new SnackVendingMachineFactory();
     VendingMachine vendingMachine = factory.createVendingMachine();
     VendingMachineController controller = new VendingMachineController(vendingMachine);
    }

    @Test
    public void testDisplaySnacks() {
        VendingMachineFactory factory = new SnackVendingMachineFactory();
        VendingMachine vendingMachine = factory.createVendingMachine();
        VendingMachineController controller = new VendingMachineController(vendingMachine);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        controller.displaySnacks();
        String expectedOutput = "Snack Vending Machine\r\n"
                +"_____________________\r\n"
        		+ "Row 1: A1 A2 A3 A4 A5\r\n"
        		+ "Row 2: B1 B2 B3 B4 B5\r\n"
        		+ "Row 3: C1 C2 C3 C4 C5\r\n"
        		+ "Row 4: D1 D2 D3 D4 D5\r\n"
        		+ "Row 5: E1 E2 E3 E4 E5\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }

   
    //Invalid selection
    @Test
    public void testSelectSnack() {
    	VendingMachineFactory factory = new SnackVendingMachineFactory();
        VendingMachine vendingMachine = factory.createVendingMachine();
        VendingMachineController controller = new VendingMachineController(vendingMachine);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        controller.selectSnack(3,3);
        String expectedOutput ="Selected snack: C3, price: 1.75\n";

        assertEquals(expectedOutput, outContent.toString());}
    
    @Test
    public void testSelectInvalidSelection() {
    	VendingMachineFactory factory = new SnackVendingMachineFactory();
        VendingMachine vendingMachine = factory.createVendingMachine();
        VendingMachineController controller = new VendingMachineController(vendingMachine);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        controller.selectSnack(-3,3);
        String expectedOutput ="Invalid selection\r\n";

        assertEquals(expectedOutput, outContent.toString());}
    
}

