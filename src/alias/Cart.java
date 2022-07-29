
package alias;

public class Cart {
    private int productid;
    private String picture;
    private int category;
    private String productname;
    private int count;
    private double weight;
    private int price;
    private double total;

    public Cart(String picture, String productname, int category, int count, double weight, int price, double total) {
        this.picture = picture;
        this.productname = productname;
        this.category = category;
        this.count = count;
        this.weight = weight;
        this.price = price;
        this.total = total;
    }
    public Cart(){
        
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getProductid() {
        return productid;
    }

    public String getPicture() {
        return picture;
    }

    public String getProductname() {
        return productname;
    }

    public int getCount() {
        return count;
    }

    public double getWeight() {
        return weight;
    }

    public double getTotal() {
        return total;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
