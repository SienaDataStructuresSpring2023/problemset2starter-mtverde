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
    public StockHolding(String s, String n, int ns, double p){
        symbol = s;
        name = n;
        numShares = ns;
        price = p;
    }
    public String getSymbol(){
        return symbol;
    }
    public String getName(){
        return name;
    }
    public int getNumShares(){
        return numShares;
    }
    public double getPrice(){
        return price;
    }
    public void buyShares(int s, double p){
        numShares += s;
        price = p;
    }
    public double sellShares(int s){
        numShares -= s;
        return s * price;
    }
     @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
        symbol, name, numShares, price, numShares * price); 
    }
}
