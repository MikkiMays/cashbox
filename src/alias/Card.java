
package alias;

public class Card {
    private int id;
    private String num;
    private double balance;

    public Card(int id, String num, double balance) {
        this.id = id;
        this.num = num;
        this.balance = balance;
    }

    public Card(){
        
    }
    public int getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
