package alias;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProductsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text home;

    @FXML
    private ImageView cart_button;

    @FXML
    private ImageView milk;

    @FXML
    private ImageView chocolate;

    @FXML
    private ImageView crisps;

    @FXML
    private ImageView juice;

    @FXML
    private ImageView yogurt;

    @FXML
    private ImageView paper;
    
    @FXML
    private Text cartCounter;

    @FXML
    void initialize() {
        cartCounter.setText(String.valueOf(Alias.cartCount));
        
        home.setPickOnBounds(true);
        milk.setPickOnBounds(true);
        chocolate.setPickOnBounds(true);
        crisps.setPickOnBounds(true);
        juice.setPickOnBounds(true);
        yogurt.setPickOnBounds(true);
        paper.setPickOnBounds(true);
        
        milk.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("milk");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        chocolate.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("chocolate");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        crisps.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("crisps");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        juice.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("juice");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        yogurt.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("yogurt");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        paper.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("paper");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        home.setOnMouseClicked((MouseEvent e) ->{
            home.getScene().getWindow().hide();
            openScene("Main.fxml");
        });
        cart_button.setOnMouseClicked((MouseEvent e) ->{
            cart_button.getScene().getWindow().hide();
            openScene("Cart.fxml");
        });
    }
    private void prodinsetter(String productname) throws SQLException{
        cartCounter.setText(String.valueOf(Alias.cartCount));
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet resprod = dbHandler.getProduct(productname);
            while(resprod.next()){
                int ID = resprod.getInt("idproduct");
                String prodname = resprod.getString("productname");
                int category = resprod.getInt("categoryID");
                String articul = resprod.getString("articul");
                int price = resprod.getInt("price");
                String picture = resprod.getString("productpicture");
                int instock = resprod.getInt("instock");
                double instockwei = resprod.getDouble("instockwei");
            
            Product pr = new Product(ID, prodname, category, articul, instock, instockwei, price, picture);
            setter(pr);
        }
    }
    private void setter(Product pr) throws SQLException{
        Cart cart = new Cart();
        cart.setProductname(pr.getName());
        cart.setCategory(1);
        cart.setPrice(pr.getPrice());
        cart.setPicture(pr.getPicture());
        pr.setInstockwei(0);
        DatabaseHandler dbHandler = new DatabaseHandler();
        if (pr.getInstock() == 0)
            System.out.println("Out of stock");
        else 
        if (!dbHandler.inCart(cart.getProductname())){
                cart.setCount(1);
                pr.setInstock(pr.getInstock() - 1);
                dbHandler.updateStock(pr);
                Alias.cartCount += 1;
                cartCounter.setText(String.valueOf(Alias.cartCount));
                cart.setTotal(cart.getCount() * cart.getPrice());
                dbHandler.addToCart(cart);
        }
        else
        {
            Alias.cartCount += 1;
            cartCounter.setText(String.valueOf(Alias.cartCount));
            ResultSet getPrC = dbHandler.getProductCart(cart);
            while(getPrC.next()){
                cart.setCount(getPrC.getInt("count"));
                cart.setCount(cart.getCount() + 1);
                pr.setInstock(pr.getInstock() - 1);
                dbHandler.updateStock(pr);
                cart.setTotal(cart.getCount() * cart.getPrice());
                dbHandler.updateCountCart(cart);
            }
        }
    }
    public void openScene(String window){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));
            
            try{
                loader.load();
            }
            catch(IOException p){
                p.printStackTrace();
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
}
