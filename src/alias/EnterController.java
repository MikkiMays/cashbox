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
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EnterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem us1;

    @FXML
    private MenuItem us2;

    @FXML
    private MenuItem us3;

    @FXML
    private Text cardBal;

    @FXML
    private Text bonusCardBal;

    @FXML
    private Button choose;
    
    @FXML
    private ImageView admin;

    @FXML
    void initialize() throws SQLException {
        admin.setPickOnBounds(true);
        Alias.clearcart();
        Alias.menuitems.add(us1);
        Alias.menuitems.add(us2);
        Alias.menuitems.add(us3);
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet resname = dbHandler.getUserName();
        int i = 0;
        while(resname.next()){
            Alias.menuitems.get(i).setText(resname.getString(1));
            i++;
        }
        us1.setOnAction(event ->{
            try {
                action(1);
            } catch (SQLException ex) {
                Logger.getLogger(EnterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        us2.setOnAction(event ->{
            try {
                action(2);
            } catch (SQLException ex) {
                Logger.getLogger(EnterController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Alias.choosed = Alias.users.get(1);
        });
        us3.setOnAction(event ->{
            try {
                action(3);
            } catch (SQLException ex) {
                Logger.getLogger(EnterController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Alias.choosed = Alias.users.get(2);
        });
        choose.setOnAction(event ->{
            choose.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Main.fxml"));
            Alias.menuitems.removeAll(Alias.menuitems);
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
        });
        admin.setOnMouseClicked((MouseEvent) ->{
            admin.getScene().getWindow().hide();
            openScene("Admin.fxml");
        });
    }
    private void action(int id) throws SQLException{
        DatabaseHandler dbHandler = new DatabaseHandler();
            ResultSet res = dbHandler.getUser(id);
                while(res.next()){
                    int userid = res.getInt("idcustomer");
                    String name = res.getString("name");
                    String cardnum = res.getString("cardnum");
                    int bonuscardnum = res.getInt("bonuscardnum");
                    
                    int idcard = res.getInt("idcard");
                    String cardnum2 = res.getString("cardnum");
                    double cardbalance = res.getDouble("cardbalance");
                    
                    int idbonuscard = res.getInt("idbonuscard");
                    String bonusnum = res.getString("bonusnum");
                    int bonusbalance = res.getInt("bonusbalance");
                    
                    Card card = new Card();
                    card.setId(idcard);
                    card.setNum(cardnum2);
                    card.setBalance(cardbalance);
                    
                    BonusCard bonuscard = new BonusCard();
                    bonuscard.setId(idbonuscard);
                    bonuscard.setNum(bonusnum);
                    bonuscard.setBalance(bonusbalance);
                    
                    User user = new User(userid, name, card, bonuscard);
                    Alias.choosed = user;
                    
                    bonusCardBal.setText("Bonus card balance: " + String.valueOf(bonusbalance) + " rub");
                    cardBal.setText("Card balance: " + String.valueOf(cardbalance) + " rub");
                    bonusCardBal.setVisible(true);
                    cardBal.setVisible(true);
                    choose.setVisible(true);
                    //Alias.choosed = Alias.users.get(0);
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
