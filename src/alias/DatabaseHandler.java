
package alias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        
        return dbConnection;
    }
    
    public void addToCart(Cart pr){ 
            String insert = "INSERT INTO cart (picture, productname, category, count, weight, price, total) VALUES(?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, pr.getPicture());
            prSt.setString(2, pr.getProductname());
            prSt.setInt(3, pr.getCategory());
            prSt.setInt(4, pr.getCount());
            prSt.setDouble(5, pr.getWeight());
            prSt.setInt(6, pr.getPrice());
            prSt.setDouble(7, pr.getTotal());
          
            prSt.executeUpdate(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void removeFromCart(Cart cart){
        String delete = "DELETE FROM cart WHERE productname=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.setString(1, cart.getProductname());
            prSt.executeUpdate(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public ResultSet getProduct(String name){
        ResultSet resSet = null;
        
        String select = "SELECT * FROM products WHERE productname=? OR articul ='" + name + "'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, name);
            
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }
    
    public int counterCart() throws SQLException{
        String select = "SELECT COUNT(productid) FROM cart";
        ResultSet resSet = null;
        int count = 0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);          
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e){}
        while(resSet.next())
            count = resSet.getInt(1);
        return count;
    }
    
    public int counterProd() throws SQLException{
        String select = "SELECT COUNT(idproduct) FROM products";
        ResultSet resSet = null;
        int count = 0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);          
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        while(resSet.next())
            count = resSet.getInt(1);
        return count;
    }
    
    public boolean inCart(String name) throws SQLException{
        String select = "SELECT productname FROM cart WHERE productname =?";
        ResultSet resSet = null;
        boolean check = false;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);  
            prSt.setString(1, name);
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        while(resSet.next())
            if (name.equals(resSet.getString("productname"))){
                check = true;
                break;
            }
            else check = false;
        return check;
    }
    
    public void updateStock(Product pr){
        String update = "UPDATE alias.products SET instock=?, instockwei=? WHERE productname=?;";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setInt(1, pr.getInstock()); 
            prSt.setDouble(2, pr.getInstockwei());  
            prSt.setString(3, pr.getName());
            prSt.executeUpdate(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void updateCountCart(Cart cart){
        String update = "UPDATE cart SET count=?, weight=?, total=? WHERE productname=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setInt(1, cart.getCount());
            prSt.setDouble(2, cart.getWeight());
            prSt.setDouble(3, cart.getTotal());
            prSt.setString(4, cart.getProductname());
            prSt.executeUpdate(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public ResultSet getUserName(){
        String select = "SELECT name FROM customers";
        ResultSet resSet = null;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }
    
    public ResultSet getUser(int id){
        String select = "SELECT * FROM \n" +
                "((alias.customers \n" +
                "INNER JOIN alias.cards ON customers.cardnum = cards.cardnum )\n" +
                "INNER JOIN alias.bonuscards ON customers.bonuscardnum = bonuscards.bonusnum) WHERE idcustomer =?;";
        ResultSet resSet = null;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, id);
            resSet = prSt.executeQuery(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }
    
    public double Total() throws SQLException{
        String select = "SELECT SUM(total) FROM cart";
        ResultSet resSet = null;
        double total = 0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        while(resSet.next())
            total = resSet.getDouble(1);
        return total;
    }
    
    public void clearAll(){
        String delete = "DELETE FROM cart";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.executeUpdate(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        Alias.cartCount = 0;
    }
    
    public ResultSet getProductCart(Cart cart){
        ResultSet resSet = null;
        
        String select = "SELECT * FROM cart WHERE productname=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, cart.getProductname());
            
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }
    public ResultSet getCart(){
        ResultSet resSet = null;
        
        String select = "SELECT * FROM cart";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }
    
    public void updateUser(User user){
        String updatecard = "UPDATE cards SET cardbalance=? WHERE idcard=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(updatecard);
            prSt.setDouble(1, user.getCard().getBalance());
            prSt.setInt(2, user.getId());
            prSt.executeUpdate(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        String updatebonus = "UPDATE bonuscards SET bonusbalance=? WHERE idbonuscard=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(updatebonus);
            prSt.setDouble(1, user.getBonuscard().getBalance());
            prSt.setInt(2, user.getId());
            prSt.executeUpdate(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void addOrder(Order order){
        String insert = "INSERT INTO orders (customerid, paidbybonus, total) VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, order.getCustomerid());
            prSt.setInt(2, order.getPaidbybonus());
            prSt.setDouble(3, order.getTotal());
          
            prSt.executeUpdate(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    public int getOrderId() throws SQLException{
        String select = "SELECT idorder FROM orders";
        ResultSet resSet = null;
        int id = 0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        while(resSet.next())
            id = resSet.getInt("idorder");
        return id;
    }
    
    public void addOrderDetails(OrderDetail odets){
        String insert = "INSERT INTO orderdetails (orderid, productid, categoryid, quantity, weight) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, odets.getOrderid());
            prSt.setInt(2, odets.getProductid());
            prSt.setInt(3, odets.getCategory());
            prSt.setInt(4, odets.getQuantity());
            prSt.setDouble(5, odets.getWeight());
          
            prSt.executeUpdate(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public ResultSet getAllUsers(String name){
        String select = "SELECT * FROM \n" +
                "((alias.customers \n" +
                "INNER JOIN alias.cards ON customers.cardnum = cards.cardnum )\n" +
                "INNER JOIN alias.bonuscards ON customers.bonuscardnum = bonuscards.bonusnum) WHERE name =?;";
        ResultSet resSet = null;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, name);
            resSet = prSt.executeQuery(); 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }
}