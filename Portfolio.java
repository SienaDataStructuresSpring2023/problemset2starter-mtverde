import java.util.ArrayList;
/**
 * Write a description of class Portfolio here.
 *
 * @author (Michael Verde)
 * @version (2/23/23)
 */
public class Portfolio
{
    public ArrayList<StockHolding> stocks;
    public double invest;
    public double payout;
    /**
     * Constructs an empty portfolio
     * 
     */
    public Portfolio(){
        stocks = new ArrayList<StockHolding>();
        invest = 0.0;
        payout = 0.0;
    }
    /**
     * Returns the invest.
     * 
     * @return The invest.
     */
    public double getInvest(){
        return invest;
    }
    /**
     * Returns the payout
     * 
     * @return The payout.
     */
    public double getPayout(){
        return payout;
    }
    /**
     * Returns the value of the portfolio.
     * 
     * @return The table value of the portfolio.
     */
    public double getValue(){
        double val = 0;
        for(StockHolding s : stocks){
            val += s.getNumShares() * s.getPrice();
        }
        return val;
    }
    /**
     * Returns the index of a StockHolding with a sybol that equals the 
     * paramater
     * 
     * @param sym The symbol that the program is serching for
     * 
     * @return The index of a StockHolding with a sybol that equals the 
     * paramater
     */
    public int getIndex(String sym){
        int count = 0;
        for(StockHolding s : stocks){
            if(s.getSymbol().equals(sym)){
                return count;
            }
            count++;
        }
        return -1;
    }
    /**
     * Buys a certin type of stock. If the desired stock is not in the 
     * portfolio creates a new StockHolding object and adds it to the 
     * portfolio. Returns the newly bought stock * it's price
     * 
     * @param s The symbol of the stock
     * @param n The name of the stock
     * @param sn The number of shares of the stock
     * @param p The price of the stock
     * 
     * @return The newly bought stock * it's price
     */
    public double buyStock(String s, String n, int ns, double p){
        if(getIndex(s) == -1){
            StockHolding a = new StockHolding(s, n, ns, p);
            stocks.add(a);
        }else{
            stocks.get(getIndex(s)).buyShares(ns, p);
        }
        invest += ns * p;
        return ns * p;
    }
    /**
     * Sells a certin type of stock. If the stock has it's shares reduced to 
     * 0, removes that StockHolding item from stocks. Returns the sold 
     * stock * it's price
     * 
     * @param s The symbol of the stock
     * @param sn The number of shares of the stock
     * 
     * @return The sold stock * it's price
     */
    public double sellStock(String s, int ns){
        int i = getIndex(s);
        payout += ns * stocks.get(i).getPrice();
        double re = stocks.get(i).sellShares(ns);
        if(stocks.get(i).getNumShares() == 0){
         stocks.remove(i);
        }
        return re;
    }
    /**
     * Returns a string representation of this portfolio which would
     * print in the format shown in the example below.
     * 
     * Symbol                     Name    Shares         @Price          Total
     * -----------------------------------------------------------------------
     * stocks.get(0).toString()
     * stocks.get(1).toString()
     * ...
     * stocks.get(size(0-1).toString()
     * 
     * @return A string representation of this portfolio as described.
     */
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%6s%25s%10s%15s%15s%n", 
                "Symbol", "Name", "Shares", "@Price", "Total"));
        sb.append("-----------------------------------------------------------------------\n");

        for(StockHolding s : stocks){
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
