package snackVendingMachine;

interface VendingMachine {
    void displaySnacks();
    void selectSnack(int row, int column);
    public void dispenseItem(int row, int column);
    public Snack getItem(int row, int column);
    boolean insertCoin(Coin coin);
    boolean insertCard(double amount);
    boolean insertNote(Note note);
    void cancelTransaction();
    void loadSnackPricesFromFile(String filePath);
}