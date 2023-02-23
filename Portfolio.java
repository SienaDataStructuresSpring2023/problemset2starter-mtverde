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
    public Portfolio(){
        stocks = new ArrayList<StockHolding>();
        invest = 0.0;
        payout = 0.0;
    }
    public double getInvest(){
        return invest;
    }
    public double getPayout(){
        return payout;
    }
    public double getValue(){
        double val = 0;
        for(StockHolding s : stocks){
            val += s.getNumShares() * s.getPrice();
        }
        return val;
    }
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
    public double sellStock(String s, int ns){
        int i = getIndex(s);
        payout += ns * stocks.get(i).getPrice();
        double re = stocks.get(i).sellShares(ns);
        if(stocks.get(i).getNumShares() == 0){
         stocks.remove(i);
        }
        return re;
    }
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
