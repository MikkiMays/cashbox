
package alias;

public class BonusCard {
    private int id;
    private String num;
    private int balance;

    public BonusCard(int id, String num, int balance) {
        this.id = id;
        this.num = num;
        this.balance = balance;
    }
    
    public BonusCard(){
        
    }
    public int getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    
}
