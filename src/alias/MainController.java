package alias;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView bakery_button;

    @FXML
    private ImageView vegetFruits_button;

    @FXML
    private ImageView product_button;

    @FXML
    private ImageView cart_button;
    
    @FXML
    private Text cartCounter;
    
    @FXML
    private Hyperlink searchLink;
    
    @FXML
    private Button changeUser;

    @FXML
    void initialize() {
        cartCounter.setText(String.valueOf(Alias.cartCount));
        
        bakery_button.setPickOnBounds(true);
        vegetFruits_button.setPickOnBounds(true);
        product_button.setPickOnBounds(true);
        cart_button.setPickOnBounds(true);
        
        bakery_button.setOnMouseClicked((MouseEvent e) -> {
            bakery_button.getScene().getWindow().hide();
            openScene("Bakery.fxml");    
        });    
        vegetFruits_button.setOnMouseClicked((MouseEvent e) -> {
            bakery_button.getScene().getWindow().hide();
            openScene("vegetFruits.fxml");
        });
        product_button.setOnMouseClicked((MouseEvent e) -> {
            bakery_button.getScene().getWindow().hide();
            openScene("Products.fxml");
        });
        cart_button.setOnMouseClicked((MouseEvent e) -> {
            bakery_button.getScene().getWindow().hide();
            openScene("Cart.fxml");
        });
        searchLink.setOnAction(event ->{
            searchLink.getScene().getWindow().hide();
            openScene("Search.fxml");
        });
        changeUser.setOnAction(event ->{
            changeUser.getScene().getWindow().hide();
            Alias.yesorchange = 1;
            openScene("Accept.fxml");
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
}
