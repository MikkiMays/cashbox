package alias;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SearchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text home;

    @FXML
    private TextField searchField;

    @FXML
    private Text notfound;

    @FXML
    private Button search;

    @FXML
    private Text name;

    @FXML
    private Text cost;

    @FXML
    private ImageView imageview;

    @FXML
    void initialize() throws SQLException {
        
        home.setPickOnBounds(true);
        home.setOnMouseClicked((MouseEvent e) ->{
            home.getScene().getWindow().hide();
            openScene("Main.fxml");
        });
        DatabaseHandler dbHandler = new DatabaseHandler();
        search.setOnAction(event ->{
            String field = searchField.getText().trim();
                ResultSet resprod = dbHandler.getProduct(field);
                    try {
                        if(resprod.next()){
                            int ID = resprod.getInt("idproduct");
                            String prodname = resprod.getString("productname");
                            int category = resprod.getInt("categoryID");
                            String articul = resprod.getString("articul");
                            int price = resprod.getInt("price");
                            String picture = resprod.getString("productpicture");
                            int instock = resprod.getInt("instock");
                            double instockwei = resprod.getDouble("instockwei");
                            
                            Product pr = new Product(ID, prodname, category, articul, instock, instockwei, price, picture);
                            
                            Image image = new Image(getClass().getResourceAsStream("/alias/assets/" + picture));
                                imageview.setImage(image);
                                clicker(imageview, pr);
                                notfound.setVisible(false);
                                imageview.setVisible(true);
                                imageview.setLayoutX(90);
                                imageview.setLayoutY(210);
                                imageview.setFitHeight(145);
                                imageview.setFitWidth(160);
                                
                                name.setVisible(true);
                                name.setText(prodname);
                                name.setLayoutX(333);
                                name.setLayoutY(292);
                                
                                cost.setVisible(true);
                                cost.setText("cost " + price + " rub");
                                cost.setLayoutX(333);
                                cost.setLayoutY(322);
                        }
                        else{
                            imageview.setVisible(false);
                            name.setVisible(false);
                            cost.setVisible(false);
                            notfound.setVisible(true);
                        }
                    } catch (SQLException ex) {  
                        Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
                    }           
            
        });
    }
    
    private void clicker(ImageView imageview, Product pr){
        imageview.setPickOnBounds(true);
        if (pr.getCategory() == 2)
            imageview.setOnMouseClicked((MouseEvent e) ->{
                Alias.check = 1;
                Alias.prod = pr;
                imageview.getScene().getWindow().hide();
                openScene("weight.fxml");
        }); else
        imageview.setOnMouseClicked((MouseEvent e) ->{
            try {
                setter(pr);
            } catch (SQLException ex) {
                Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
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
                cart.setTotal(cart.getCount() * cart.getPrice());
                dbHandler.addToCart(cart);
        }
        else
        {
            Alias.cartCount += 1;
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
