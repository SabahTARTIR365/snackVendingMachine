package snackVendingMachine;


enum Note {
    Twinty_DOLLAR(20),

    FIFTY_DOLLAR(50);
    private final double value;

    Note(double d) {
        this.value = d;
    }
    public double getValue() {
        return value;
    }
}
class NoteSlot implements Money {
    private double amount;

    public void insertCoin(Note note) {
     
            amount+= note.getValue();
           
      
    }

    public double getAmount() {
        return amount;
    }

	@Override
	public String getCurrency() {
		
		return  "USA";
	}
}