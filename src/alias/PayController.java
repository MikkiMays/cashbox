package alias;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PayController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text total;

    @FXML
    private Button usebonuses;

    @FXML
    private Button payButton;

    @FXML
    private Text usebonus;
    
    @FXML
    private Button back;
    
    @FXML
    private Text nomoney;
      
    @FXML
    private Text balCard;
    
    @FXML
    private AnchorPane root;

    @FXML
    void initialize() throws SQLException {
        Alias.yesorchange = 0;
        DatabaseHandler dbHandler = new DatabaseHandler();
        
        int b = Alias.choosed.getBonuscard().getBalance();
        total.setText(String.format("Total: %.2f rub", Alias.total));
        balCard.setText("Balance card: " + Alias.choosed.getCard().getBalance() +  " rub");
        
        if (!Alias.yesor && b != 0){
            usebonus.setVisible(true);
            usebonuses.setVisible(true);
            payButton.setLayoutX(200);
            payButton.setLayoutY(265);
            usebonus.setText("You have " + Alias.choosed.getBonuscard().getBalance() + " bonuses");
        }
        else{
            usebonus.setVisible(false);
            usebonuses.setVisible(false);
            payButton.setLayoutX(200);
            payButton.setLayoutY(193);
        }

        usebonuses.setOnAction(event ->{
            openScene("Accept.fxml");
            usebonuses.getScene().getWindow().hide(); 
            if (b > Alias.total){
                    Alias.bonus = (int)(b - Math.floor(Alias.total) + 1);
                    Alias.paidbonuses = (int)(Math.floor(Alias.total) - 1);
                    Alias.total = Alias.total - Math.floor(Alias.total) + 1; 
            } else
                try {
                    Alias.total = dbHandler.Total() - b;
                    Alias.bonus = 0;
                    Alias.paidbonuses = b;
                } catch (SQLException ex) {
                    Logger.getLogger(PayController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        
        payButton.setOnAction(event ->{
            nomoney.setVisible(false);
            if (Alias.choosed.getCard().getBalance() < Alias.total)
                nomoney.setVisible(true);
            else if (Alias.total == 1){
                Alias.choosed.getBonuscard().setBalance(Alias.bonus);
                Alias.choosed.getCard().setBalance(Alias.choosed.getCard().getBalance() - 1);
                dbHandler.updateUser(Alias.choosed);
                payButton.getScene().getWindow().hide();
                openScene("Check.fxml");
            }
            else try {
                if(Alias.total < dbHandler.Total())
                {
                    Alias.choosed.getBonuscard().setBalance(0);
                    Alias.choosed.getCard().setBalance(Alias.choosed.getCard().getBalance() - Alias.total);
                    dbHandler.updateUser(Alias.choosed);
                    payButton.getScene().getWindow().hide();
                    openScene("Check.fxml");
                }
                else {
                    Alias.paidbonuses = 0;
                    Alias.choosed.getCard().setBalance(Alias.choosed.getCard().getBalance() - Alias.total);
                    dbHandler.updateUser(Alias.choosed);
                    payButton.getScene().getWindow().hide();
                    openScene("Check.fxml");
                }
                dbHandler.updateUser(Alias.choosed);
            } catch (SQLException ex) {
                Logger.getLogger(PayController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        back.setOnAction(event ->{
            back.getScene().getWindow().hide();
            Alias.choosed.getBonuscard().setBalance(b);
            Alias.yesor = false;
            usebonus.setVisible(true);
            usebonuses.setVisible(true);
            openScene("Cart.fxml");
        });
    }
    private int checkDigit(String s){
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
