package snackVendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnackVendingMachine implements VendingMachine {

    private Map<String, Double> snacks;
    private double selectedSnackPrice;
    private double acceptedMoney;
    private boolean isTransactionInProgress;
    //private List<Snack> snacks = new ArrayList<>();

    public SnackVendingMachine() {
    
    	snacks=SnacksData.set(); 
        
        selectedSnackPrice = 0;
        acceptedMoney = 0;
        isTransactionInProgress = false;
    }
    
    

    @Override
    public void displaySnacks() {
        System.out.println("Snack Vending Machine");
        System.out.println("_____________________");
        System.out.println("Row 1: A1 A2 A3 A4 A5");
        System.out.println("Row 2: B1 B2 B3 B4 B5");
        System.out.println("Row 3: C1 C2 C3 C4 C5");
        System.out.println("Row 4: D1 D2 D3 D4 D5");
        System.out.println("Row 5: E1 E2 E3 E4 E5");
    }

    @Override
    public void selectSnack(int row, int column) {
        String selectedSnackName = String.format("%c%d", (char) ('A' + row - 1), column);
        if (snacks.containsKey(selectedSnackName)) {
        	selectedSnackPrice = snacks.get(selectedSnackName);
            System.out.printf("Selected snack: %s, price: %.2f\n", selectedSnackName, selectedSnackPrice);
            isTransactionInProgress = true;
        } else {
            System.out.println("Invalid selection");
        }
    }

    @Override
    public boolean insertCoin(Coin coin) {
        if (!isTransactionInProgress) {
            System.out.println("No transaction in progress");
            return false;
        }
        switch ((int) (coin.getValue() * 100)) {
            case 10:
            case 20:
            case 50:
            case 100:
                acceptedMoney += coin.getValue();
                System.out.printf("Accepted money: %.2f\n", acceptedMoney);
                return true;
            default:
                System.out.println("Invalid coin");
                return false;
        }
    }

    @Override
    public boolean insertCard(double amount) {
        if (!isTransactionInProgress) {
            System.out.println("No transaction in progress");
            return false;
        }
        acceptedMoney += amount;
        System.out.printf("Accepted money: %.2f\n", acceptedMoney);
        return true;
    }

    @Override
    public boolean insertNote(Note note) {
        if (!isTransactionInProgress) {
            System.out.println("No transaction in progress");
            return false;
        }
        switch ((int) note.getValue()) {
            case 20:
            case 50:
                acceptedMoney += note.getValue();
                System.out.printf("Accepted money: %.2f\n", acceptedMoney);
                return true;
            default:
                System.out.println("Invalid note");
                return false;
        }
    }

    @Override
    public void cancelTransaction() {
        if (!isTransactionInProgress) {
            System.out.println("No transaction in progress");
            return;
        }
        System.out.printf("Transaction cancelled, refunded: %.2f\n", acceptedMoney);
        resetTransaction();
    }
    
    private void resetTransaction() {
        selectedSnackPrice = 0;
        acceptedMoney = 0;
        isTransactionInProgress = false;
    }

	@Override
	public Snack getItem(int row, int column) {
		String key = String.format("%c%d", (char) ('A' + row - 1), column);
	    if (snacks.containsKey(key)) {
	        return new Snack(key, snacks.get(key));
	    } else {
	        return null;
	    }
	}

	@Override
	public void dispenseItem(int row, int column) {
	    if (!isTransactionInProgress) {
	        System.out.println("No transaction in progress");
	        return;
	    }
	    
	    Snack snackItem = getItem(row, column);
	    if (snackItem == null) {
	        System.out.println("Invalid selection");
	        return;
	    }
	    
	    if (acceptedMoney < selectedSnackPrice) {
	        System.out.println("Insufficient funds");
	        return;
	    }
	    
	    System.out.printf("Dispensing snack: %s\n", snackItem.getName());
	    
	    double change = acceptedMoney - selectedSnackPrice;
	    if (change > 0) {
	        System.out.printf("Change: %.2f\n", change);
	    }
	    
	    resetTransaction();
	}

	@Override
	public void loadSnackPricesFromFile(String filePath) {
		
		
	}
	
	
	
	
	
}
