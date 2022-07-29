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

public class BakeryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text home;
    
    @FXML
    private ImageView cart_button;

    @FXML
    private ImageView bread;

    @FXML
    private ImageView cake;

    @FXML
    private ImageView croissant;

    @FXML
    private ImageView doughnut;

    @FXML
    private ImageView muffin;

    @FXML
    private ImageView bun;

    @FXML
    private ImageView pretzel;

    @FXML
    private ImageView cookies;

    @FXML
    private ImageView eclair;
    
    @FXML
    private Text cartCounter;

    @FXML
    void initialize() throws SQLException{
        cartCounter.setText(String.valueOf(Alias.cartCount));
        
        home.setPickOnBounds(true);
        bread.setPickOnBounds(true);
        cake.setPickOnBounds(true);
        croissant.setPickOnBounds(true);
        doughnut.setPickOnBounds(true);
        muffin.setPickOnBounds(true);
        bun.setPickOnBounds(true);
        pretzel.setPickOnBounds(true);
        cookies.setPickOnBounds(true);
        eclair.setPickOnBounds(true);
        cart_button.setPickOnBounds(true);

        bread.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("bread");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        cake.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("cake");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        croissant.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("croissant");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        doughnut.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("doughnut");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        muffin.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("muffin");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bun.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("bun");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        pretzel.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("pretzel");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        cookies.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("cookies");
            } catch (SQLException ex) {
                Logger.getLogger(BakeryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        eclair.setOnMouseClicked((MouseEvent e) ->{
            try {
                prodinsetter("eclair");
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
        });///cartCounter.setText(String.valueOf(Alias.cartCount));
    }
    private void prodinsetter(String productname) throws SQLException{
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
