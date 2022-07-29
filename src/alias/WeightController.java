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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WeightController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text home;

    @FXML
    private TextField valueWeight;

    @FXML
    private Button enterWeight_button;

    @FXML
    private ImageView imageview;
    
    @FXML
    private Text name;
    
    @FXML
    private Text instockwei;
    
    @FXML
    private Button back;

    @FXML
    void initialize() {
        Image image = new Image(getClass().getResourceAsStream("/alias/assets/" + Alias.prod.getPicture()));
        imageview.setImage(image);
        shower(imageview, name, Alias.prod.getName(), instockwei);
        Cart cart = new Cart();
        cart.setProductname(Alias.prod.getName());
        cart.setCategory(2);
        cart.setPrice(Alias.prod.getPrice());
        cart.setPicture(Alias.prod.getPicture());
        enterWeight_button.setOnAction(event -> {
            double a = checkDigit(valueWeight.getText().trim());
            if (a > 0 && a <= Alias.prod.getInstockwei() && Alias.prod.getInstockwei() - a >= 0){
                try {
                    setter(Alias.prod, cart, a);
                } catch (SQLException ex) {
                    Logger.getLogger(WeightController.class.getName()).log(Level.SEVERE, null, ex);
                }
                enterWeight_button.getScene().getWindow().hide();
                if(Alias.check == 0)
                    openScene("vegetFruits.fxml");
                else
                    openScene("Search.fxml");
                } 
            else{
                Shake enterWeightButton = new Shake(enterWeight_button);
                enterWeightButton.playAnim();
            }
        });
        
        back.setOnAction(event ->{
            back.getScene().getWindow().hide();
            if(Alias.check == 0)
                openScene("vegetFruits.fxml");
            else
                openScene("Search.fxml");
        });
    }
    
    public void shower(ImageView product, Text name, String nameS, Text instockwei){
        product.setLayoutX(63);
        product.setLayoutY(121);
        product.setFitHeight(200);
        product.setFitWidth(200);
        
        name.setText(nameS);
        
        instockwei.setText("In stock: " + Alias.prod.getInstockwei() + " kg");
    }
    
    private void setter(Product pr, Cart cart, double wei) throws SQLException{
        DatabaseHandler dbHandler = new DatabaseHandler();
        Alias.prod.setInstock(0);
        if (pr.getInstockwei() == 0){
                Shake enterWeightButton = new Shake(enterWeight_button);
                enterWeightButton.playAnim();
        }
            else
        if (!dbHandler.inCart(cart.getProductname())){
            cart.setWeight(wei);
            Alias.cart.setWeight(wei);
            pr.setInstockwei(pr.getInstockwei() - wei);
            Alias.prod.setInstockwei(pr.getInstockwei());
            dbHandler.updateStock(pr);
            Alias.cartCount += 1;
            cart.setTotal(wei * cart.getPrice());
            dbHandler.addToCart(cart);
        }
        else
        {
            Alias.prod.setInstockwei(pr.getInstockwei() + Alias.cart.getWeight());
            dbHandler.updateStock(Alias.prod);
            dbHandler.removeFromCart(cart);
            cart.setWeight(wei);
            pr.setInstockwei(pr.getInstockwei() - wei);
            dbHandler.updateStock(pr);
            cart.setTotal(wei * cart.getPrice());
            dbHandler.addToCart(cart);
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
    
    private double checkDigit(String s){
        try {
            Double.parseDouble(s);
        return Double.parseDouble(s);
            } catch (NumberFormatException e) {
        return -1;
            }
    }
}
