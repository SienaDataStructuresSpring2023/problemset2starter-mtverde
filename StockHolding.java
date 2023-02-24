/**
 * Write a description of class Asset here.
 *
 * @author (Michael Verde)
 * @version (2/22/23)
 */
public class StockHolding
{
    public String symbol;
    public String name;
    public int numShares;
    public double price;
    /**
     * Constructs a StockHolding object with the given parameters
     * 
     * @param s The symbol of the stock
     * @param n The name of the stock
     * @param sn The number of shares of the stock
     * @param p The price of the stock
     * 
     * @return The table number.
     */
    public StockHolding(String s, String n, int ns, double p){
        symbol = s;
        name = n;
        numShares = ns;
        price = p;
    }
    /**
     * Returns the symbol.
     * 
     * @return The symbol.
     */
    public String getSymbol(){
        return symbol;
    }
    /**
     * Returns the name.
     * 
     * @return The name.
     */
    public String getName(){
        return name;
    }
    /**
     * Returns the number of shares.
     * 
     * @return The number of shares.
     */
    public int getNumShares(){
        return numShares;
    }
    /**
     * Returns the price.
     * 
     * @return The price.
     */
    public double getPrice(){
        return price;
    }
    /**
     * Adds s shares and sets the price to p
     * 
     * @param s The number of shares to be bought
     * @param p The new price of the shares
     */
    public void buyShares(int s, double p){
        numShares += s;
        price = p;
    }
    /**
     * Removes s shares and returns s * price.
     * 
     * @param s The number of shares to be sold
     * 
     * @return s * price.
     */
    public double sellShares(int s){
        numShares -= s;
        return s * price;
    }
    /**
     * Returns a string representation of this StockHolding which would
     * print in the format shown in the example below.
     * 
     * symbol                    name        numShares  $       price  $    numShares * price
     * 
     * @return A string representation of this StockHolding as described.
     */
     @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
        symbol, name, numShares, price, numShares * price); 
    }
}
