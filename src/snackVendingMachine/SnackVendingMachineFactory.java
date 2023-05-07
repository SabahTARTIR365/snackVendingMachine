package snackVendingMachine;


public class SnackVendingMachineFactory extends VendingMachineFactory {
    @Override
    public VendingMachine createVendingMachine() {
        VendingMachine vendingMachine = new SnackVendingMachine();
        return vendingMachine;
    }
}


