
package alias;

public class Order {
    private int id;
    private int customerid;
    private int paidbybonus;
    private double total;

    public Order(int id, int customerid, int paidbybonus, double total) {
        this.id = id;
        this.customerid = customerid;
        this.paidbybonus = paidbybonus;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public int getPaidbybonus() {
        return paidbybonus;
    }

    public double getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public void setPaidbybonus(int paidbybonus) {
        this.paidbybonus = paidbybonus;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
