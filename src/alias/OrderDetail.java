
package alias;

public class OrderDetail {
    private int id;
    private int orderid;
    private int productid;
    private int category;
    private int quantity;
    private double weight;

    public OrderDetail(int id, int orderid, int productid, int category, int quantity, double weight) {
        this.id = id;
        this.orderid = orderid;
        this.productid = productid;
        this.category = category;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int getOrderid() {
        return orderid;
    }

    public int getProductid() {
        return productid;
    }

    public int getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
}
