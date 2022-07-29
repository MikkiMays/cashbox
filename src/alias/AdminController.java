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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button changebalance;

    @FXML
    private Button changestock;

    @FXML
    private TextField cardInstock;

    @FXML
    private TextField bonusbal;

    @FXML
    private Text name;
    
    @FXML
    private TextField namefield;

    @FXML
    private Text cardBalOrInstock;

    @FXML
    private Text bonusbalText;

    @FXML
    private Button apply;

    @FXML
    private Button find;
    
    @FXML
    private Text notfound;
    
    @FXML
    private Text checker;
    
    @FXML
    private Text success;
    
    @FXML
    private Button back;
    
    @FXML
    void initialize() {
        apply.setVisible(false);
        DatabaseHandler dbHandler = new DatabaseHandler();
        changebalance.setOnAction(event ->{
            namefield.setVisible(true);
            find.setVisible(true);
            name.setVisible(true);
            namefield.setDisable(false);
            
            cardInstock.setVisible(false);
            cardBalOrInstock.setVisible(false);
            bonusbal.setVisible(false);
            bonusbalText.setVisible(false);
            apply.setVisible(false);
            
            checker.setVisible(true);
            success.setVisible(false);
        });
        changestock.setOnAction(event -> {
            namefield.setVisible(true);
            namefield.setDisable(false);
            find.setVisible(true);
            name.setText("Name of product");
            name.setVisible(true);
            
            cardBalOrInstock.setText("Set stock");
            cardInstock.setVisible(false);
            cardBalOrInstock.setVisible(false);
            bonusbalText.setVisible(false);
            bonusbal.setVisible(false);
            apply.setVisible(false);
            
            checker.setVisible(false);
            success.setVisible(false);
        });
        find.setOnAction(event ->{ 
            if (checker.isVisible()){  
            String nm = namefield.getText().trim();
            ResultSet resUser = dbHandler.getAllUsers(nm);
            try {
                if(resUser.next()){
                    find.setVisible(true);
                    namefield.setDisable(true);
                    notfound.setVisible(false);
                    cardInstock.setVisible(true);
                    cardBalOrInstock.setVisible(true);
                    bonusbalText.setVisible(true);
                    bonusbal.setVisible(true);
                    apply.setVisible(true);
                } else{
                    notfound.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            } else{
                String nm = namefield.getText().trim();
                ResultSet resprod = dbHandler.getProduct(nm);
                    try {
                        if(resprod.next()){
                            find.setVisible(true);
                            namefield.setDisable(true);
                            notfound.setVisible(false);
                            cardInstock.setVisible(true);
                            cardBalOrInstock.setVisible(true);
                            apply.setVisible(true);
                        }else{
                            notfound.setVisible(true);
                        }
                            } catch (SQLException ex) {  
                        Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
                    }     
            }
        });
        apply.setOnAction(event ->{
            if(checker.isVisible()){
                String nm = namefield.getText().trim();
                ResultSet resUser = dbHandler.getAllUsers(nm);
                try {
                    if(resUser.next()){
                        int userid = resUser.getInt("idcustomer");
                        String nameu = resUser.getString("name");
                        String cardnum = resUser.getString("cardnum");
                        String bonuscardnum = resUser.getString("bonuscardnum");
                        
                        int idcard = resUser.getInt("idcard");
                        String cardnum2 = resUser.getString("cardnum");
                        double cardbalance = resUser.getDouble("cardbalance");
                        
                        int idbonuscard = resUser.getInt("idbonuscard");
                        String bonusnum = resUser.getString("bonusnum");
                        int bonusbalance = resUser.getInt("bonusbalance");
                        
                        Card card = new Card();
                        card.setId(idcard);
                        card.setNum(cardnum2);
                        card.setBalance(cardbalance);
                        
                        BonusCard bonuscard = new BonusCard();
                        bonuscard.setId(idbonuscard);
                        bonuscard.setNum(bonusnum);
                        bonuscard.setBalance(bonusbalance);
                        
                        User user = new User(userid, nameu, card, bonuscard);
                        
                        cardInstock.setVisible(true);
                        cardBalOrInstock.setVisible(true);
                        bonusbalText.setVisible(true);
                        bonusbal.setVisible(true);
                        apply.setVisible(true);
                        
                        Double carder = checkDigitDouble(cardInstock.getText().trim());
                        int bonuscarder = checkDigitInt(bonusbal.getText().trim());
                        
                        if (carder >= 0 && bonuscarder >= 0 && !cardInstock.getText().equals("") && !bonusbal.getText().equals(""))
                        {
                            user.getCard().setBalance(carder);
                            user.getBonuscard().setBalance(bonuscarder);
                            dbHandler.updateUser(user);
                            success.setVisible(true);
                        }
                        else{
                            Shake applybut = new Shake(apply);
                            applybut.playAnim();
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                String nm = namefield.getText().trim();
                ResultSet resprod = dbHandler.getProduct(nm);
                    try {
                        if(resprod.next()){
                            find.setVisible(false);
                            namefield.setDisable(true);
                            notfound.setVisible(false);
                            int ID = resprod.getInt("idproduct");
                            String prodname = resprod.getString("productname");
                            int category = resprod.getInt("categoryid");
                            String articul = resprod.getString("articul");
                            int price = resprod.getInt("price");
                            String picture = resprod.getString("productpicture");
                            int instock = resprod.getInt("instock");
                            double instockwei = resprod.getDouble("instockwei");
                            
                            cardInstock.setVisible(true);
                            cardBalOrInstock.setVisible(true);
                            apply.setVisible(true);
                            
                            Product pr = new Product(ID, prodname, category, articul, instock, instockwei, price, picture);
                            int stock = 0;
                            double stockwei = 0;
                            if(category == 1)
                                stock = checkDigitInt(cardInstock.getText().trim());
                            else  
                                stockwei = checkDigitDouble(cardInstock.getText().trim());
                            
                            if (!cardInstock.getText().equals("") && stock >= 0 && stockwei >= 0)
                            {
                                pr.setInstock(stock);
                                pr.setInstockwei(stockwei);
                                success.setVisible(true);
                                dbHandler.updateStock(pr);
                            }
                            else{
                                Shake applybut = new Shake(apply);
                                applybut.playAnim();
                            }
                        }
                    } catch (SQLException ex) {  
                        Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
                    }   
            }
        });
        back.setOnAction(event -> {
            back.getScene().getWindow().hide();
            Alias.menuitems.removeAll(Alias.menuitems);
            apply.setVisible(false);
            openScene("Enter.fxml");
        });
    }
    private double checkDigitDouble(String s){
        try {
            Double.parseDouble(s);
        return Double.parseDouble(s);
            } catch (NumberFormatException e) {
        return -1;
            }
    }
    private int checkDigitInt(String s){
        try {
            Integer.parseInt(s);
        return Integer.parseInt(s);
            } catch (NumberFormatException e) {
        return -1;
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
