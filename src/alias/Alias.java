package alias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Alias extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Enter.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static Product prod;
    public static int check = 0;
    public static int cartCount = 0;
    public static double total;
    public static int bonus = 0;
    public static int paidbonuses = 0;
    public static User choosed;
    public static Cart cart = new Cart();
    public static ArrayList<MenuItem> menuitems = new ArrayList<MenuItem>();
    public static boolean yesor = false;
    public static int yesorchange = 0;
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }
    public static void clearcart(){
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet allcart = dbHandler.getCart();
                try {
                    while (allcart.next()){
                        ResultSet resprod = dbHandler.getProduct(allcart.getString("productname"));
                        if(resprod.next()){
                            int ID = resprod.getInt("idproduct");
                            String prodname = resprod.getString("productname");
                            int category = resprod.getInt("categoryID");
                            String articul = resprod.getString("articul");
                            int price = resprod.getInt("price");
                            String picture = resprod.getString("productpicture");
                            int instock = resprod.getInt("instock");
                            double instockwei = resprod.getDouble("instockwei");
                            
                            Cart cart = new Cart();
                            cart.setWeight(allcart.getDouble("weight"));
                            cart.setCount(allcart.getInt("count"));
                            
                            Product pr = new Product(ID, prodname, category, articul, instock, instockwei, price, picture);
                            pr.setInstockwei(pr.getInstockwei() + cart.getWeight());
                            pr.setInstock(pr.getInstock() + cart.getCount());
                            dbHandler.updateStock(pr);
                        }
                        Alias.cartCount = 0;
                        dbHandler.clearAll();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
