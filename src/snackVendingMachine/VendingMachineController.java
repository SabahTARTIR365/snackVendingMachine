package snackVendingMachine;

public class VendingMachineController {
    private final VendingMachine vendingMachine;

    public VendingMachineController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
       }
   

    public void displaySnacks() {
        vendingMachine.displaySnacks();
    }

    public void selectSnack(int row, int column) {
        vendingMachine.selectSnack(row, column);
    }

    public void insertCoin(Coin coin) {
        vendingMachine.insertCoin(coin);
    }

    public void insertCard(double amount) {
        vendingMachine.insertCard(amount);
    }

    public void insertNote(Note note) {
        vendingMachine.insertNote(note);
    }

    public void cancelTransaction() {
        vendingMachine.cancelTransaction();
    }

    public void dispenseItem(int row, int column) {
        Snack snackItem = vendingMachine.getItem(row, column);
        if (snackItem == null) {
            System.out.println("Invalid selection");
        } else {
            vendingMachine.dispenseItem(row, column);
        }
    }

}

