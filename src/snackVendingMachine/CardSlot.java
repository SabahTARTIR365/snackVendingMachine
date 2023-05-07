package snackVendingMachine;

class CardSlot implements Money{
    private double amount;

    public void insertCard(double amount) {
        this.amount += amount;
    }

    public double getAmount() {
        return amount;
    }

	@Override
	public String getCurrency() {
		return "USA";
	}
}