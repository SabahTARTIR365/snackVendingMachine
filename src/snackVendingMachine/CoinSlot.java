package snackVendingMachine;
enum Coin {
    DOLLAR(1),
   TEN_CENT(0.1),
    TWINTY_CENT(0.2),
    FIFTYCent(0.5);
    private final double value;

    Coin(double d) {
        this.value = d;
    }
    public double getValue() {
        return value;
    }
}
class CoinSlot implements Money {
    private double amount;

    public void insertCoin(Coin coin) {
     
            amount+= coin.getValue();
           
      
    }

    public double getAmount() {
        return amount;
    }

	@Override
	public String getCurrency() {
		
		return  "USA";
	}
}