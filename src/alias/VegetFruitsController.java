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

public class VegetFruitsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text home;

    @FXML
    private ImageView cart_button;

    @FXML
    private ImageView tomato;

    @FXML
    private ImageView coconut;

    @FXML
    private ImageView potato;

    @FXML
    private ImageView cucumber;

    @FXML
    private ImageView banana;

    @FXML
    private ImageView apple;
    
    @FXML
    private Text cartCounter;

    @FXML
    void initialize() {
        
        cartCounter.setText(String.valueOf(Alias.cartCount));
        
        home.setPickOnBounds(true);
        tomato.setPickOnBounds(true);
        coconut.setPickOnBounds(true);
        potato.setPickOnBounds(true);
        cucumber.setPickOnBounds(true);
        banana.setPickOnBounds(true);
        apple.setPickOnBounds(true);
        
        Alias.check = 0;
        tomato.setOnMouseClicked((MouseEvent e) ->{
            tomato.getScene().getWindow().hide();
            try {
                prodinweighter("tomato");
            } catch (SQLException ex) {
                Logger.getLogger(VegetFruitsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        coconut.setOnMouseClicked((MouseEvent e) ->{
            coconut.getScene().getWindow().hide();
            try {
                prodinweighter("coconut");
            } catch (SQLException ex) {
                Logger.getLogger(VegetFruitsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        potato.setOnMouseClicked((MouseEvent e) ->{
            potato.getScene().getWindow().hide();
            try {
                prodinweighter("potato");
            } catch (SQLException ex) {
                Logger.getLogger(VegetFruitsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        cucumber.setOnMouseClicked((MouseEvent e) ->{
            cucumber.getScene().getWindow().hide();
            try {
                prodinweighter("cucumber");
            } catch (SQLException ex) {
                Logger.getLogger(VegetFruitsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        banana.setOnMouseClicked((MouseEvent e) ->{
            banana.getScene().getWindow().hide();
            try {
                prodinweighter("banana");
            } catch (SQLException ex) {
                Logger.getLogger(VegetFruitsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        apple.setOnMouseClicked((MouseEvent e) ->{
            apple.getScene().getWindow().hide();
            try {
                prodinweighter("apple");
            } catch (SQLException ex) {
                Logger.getLogger(VegetFruitsController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void prodinweighter(String productname) throws SQLException{ 
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
            Alias.prod = pr;
            openScene("weight.fxml");
        }
    }
}
