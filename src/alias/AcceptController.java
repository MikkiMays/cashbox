package alias;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AcceptController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text text;

    @FXML
    private Button yes;

    @FXML
    private Button cancel;

    @FXML
    void initialize() {
        if (Alias.yesorchange == 1)
            text.setText("          You sure want to change user?\n             Cart will be delete");
        yes.setOnAction(event ->{
            Alias.yesor = true;
            if (Alias.yesorchange == 0)
                openScene("Pay.fxml");
            else
                openScene("Enter.fxml");
            yes.getScene().getWindow().hide();
        });
        cancel.setOnAction(event ->{
            Alias.yesor = false;
            if (Alias.yesorchange == 0)
                openScene("Pay.fxml");
            else
                openScene("Main.fxml");
            cancel.getScene().getWindow().hide();
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

