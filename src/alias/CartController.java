package alias;

import java.io.IOException;
import javafx.scene.control.Button;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text home;

    @FXML
    private ImageView imageview;

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView imageview2;

    @FXML
    private ImageView imageview3;

    @FXML
    private ImageView imageview4;

    @FXML
    private ImageView imageview5;

    @FXML
    private ImageView imageview6;

    @FXML
    private ImageView imageview7;

    @FXML
    private ImageView imageview8;

    @FXML
    private ImageView imageview9;

    @FXML
    private ImageView imageview10;

    @FXML
    private ImageView imageview11;

    @FXML
    private ImageView imageview12;

    @FXML
    private ImageView imageview13;

    @FXML
    private ImageView imageview14;

    @FXML
    private ImageView imageview15;

    @FXML
    private ImageView imageview16;

    @FXML
    private ImageView imageview17;

    @FXML
    private ImageView imageview18;

    @FXML
    private ImageView imageview19;

    @FXML
    private ImageView imageview20;

    @FXML
    private TextField count;

    @FXML
    private Button plus;

    @FXML
    private Button minus;

    @FXML
    private Text cost;

    @FXML
    private TextField count1;

    @FXML
    private Button plus1;

    @FXML
    private Button minus1;

    @FXML
    private Text cost1;

    @FXML
    private TextField count2;

    @FXML
    private Button plus2;

    @FXML
    private Button minus2;

    @FXML
    private Text cost2;

    @FXML
    private TextField count3;

    @FXML
    private Button plus3;

    @FXML
    private Button minus3;

    @FXML
    private Text cost3;

    @FXML
    private TextField count4;

    @FXML
    private Button plus4;

    @FXML
    private Button minus4;

    @FXML
    private Text cost4;

    @FXML
    private TextField count5;

    @FXML
    private Button plus5;

    @FXML
    private Button minus5;

    @FXML
    private Text cost5;

    @FXML
    private TextField count6;

    @FXML
    private Button plus6;

    @FXML
    private Button minus6;

    @FXML
    private Text cost6;

    @FXML
    private TextField count7;

    @FXML
    private Button plus7;

    @FXML
    private Button minus7;

    @FXML
    private Text cost7;

    @FXML
    private TextField count8;

    @FXML
    private Button plus8;

    @FXML
    private Button minus8;

    @FXML
    private Text cost8;

    @FXML
    private TextField count9;

    @FXML
    private Button plus9;

    @FXML
    private Button minus9;

    @FXML
    private Text cost9;

    @FXML
    private TextField count10;

    @FXML
    private Button plus10;

    @FXML
    private Button minus10;

    @FXML
    private Text cost10;

    @FXML
    private TextField count11;

    @FXML
    private Button plus11;

    @FXML
    private Button minus11;

    @FXML
    private Text cost11;

    @FXML
    private TextField count12;

    @FXML
    private Button plus12;

    @FXML
    private Button minus12;

    @FXML
    private Text cost12;

    @FXML
    private TextField count13;

    @FXML
    private Button plus13;

    @FXML
    private Button minus13;

    @FXML
    private Text cost13;

    @FXML
    private TextField count14;

    @FXML
    private Button plus14;

    @FXML
    private Button minus14;

    @FXML
    private Text cost14;

    @FXML
    private TextField weight;

    @FXML
    private Text cost15;

    @FXML
    private TextField weight1;

    @FXML
    private Text cost16;

    @FXML
    private TextField weight2;

    @FXML
    private Text cost17;

    @FXML
    private TextField weight3;

    @FXML
    private Text cost18;

    @FXML
    private TextField weight4;

    @FXML
    private Text cost19;

    @FXML
    private TextField weight5;

    @FXML
    private Text cost20;

    @FXML
    private Text result;
    
    @FXML
    private Text name;

    @FXML
    private Text name1;

    @FXML
    private Text name3;

    @FXML
    private Text name4;

    @FXML
    private Text name5;

    @FXML
    private Text name6;

    @FXML
    private Text name7;

    @FXML
    private Text name8;

    @FXML
    private Text name9;

    @FXML
    private Text name10;

    @FXML
    private Text name11;

    @FXML
    private Text name12;

    @FXML
    private Text name13;

    @FXML
    private Text name14;

    @FXML
    private Text name15;

    @FXML
    private Text name16;

    @FXML
    private Text name17;

    @FXML
    private Text name18;

    @FXML
    private Text name19;

    @FXML
    private Text name20;

    @FXML
    private Text name2;

    @FXML
    private Text outOfStock;

    @FXML
    private Text nothingCart;

    @FXML
    private Button pay;
    
    @FXML
    private Button clearAll;
    
    @FXML
    private ImageView deleter;

    @FXML
    private ImageView deleter1;

    @FXML
    private ImageView deleter2;

    @FXML
    private ImageView deleter3;

    @FXML
    private ImageView deleter4;

    @FXML
    private ImageView deleter5;
    
    @FXML
    private AnchorPane root;
       
    /*private TextField[] counters = {count, count1, count2, count3, count4, count5, count6, count7, count8, count9, count10, 
                                            count11, count12, count13, count14};
    
    private TextField[] weighters = {weight, weight1, weight2, weight3, weight4, weight5};
    
    private Button[] pluses = {plus, plus1, plus2, plus3, plus4, plus5, plus6, plus7, plus8, plus9, plus10, plus11, plus12, plus13, plus14};
    
    private Button[] minuses = {minus, minus1, minus2, minus3, minus4, minus5, minus6, minus7, minus8, minus9, minus10, minus11, minus12, minus13, minus14};
    
    private Text[] costers = {cost, cost1, cost2, cost3, cost4, cost5, cost6, cost7, cost8, cost9, cost10, cost11, cost12, cost13, cost14, 
                                        cost15, cost16, cost17, cost18, cost19, cost20};*/
    
    private ArrayList<Button> pluses = new ArrayList<Button>();
    private ArrayList<Button> minuses = new ArrayList<Button>();
    private ArrayList<TextField> counters = new ArrayList<TextField>();
    private ArrayList<TextField> weighters = new ArrayList<TextField>();
    private ArrayList<Text> costers = new ArrayList<Text>();
    private ArrayList<ImageView> prods = new ArrayList<ImageView>();
    private ArrayList<Text> names = new ArrayList<Text>();
    private ArrayList<ImageView> deleters = new ArrayList<ImageView>();
    private double res = 0;

    @FXML
    void initialize() throws SQLException {
        pluses.add(plus);
        pluses.add(plus1);
        pluses.add(plus2);
        pluses.add(plus3);
        pluses.add(plus4);
        pluses.add(plus5);
        pluses.add(plus6);
        pluses.add(plus7);
        pluses.add(plus8);
        pluses.add(plus9);
        pluses.add(plus10);
        pluses.add(plus11);
        pluses.add(plus12);
        pluses.add(plus13);
        pluses.add(plus14);
        
        minuses.add(minus);
        minuses.add(minus1);
        minuses.add(minus2);
        minuses.add(minus3);
        minuses.add(minus4);
        minuses.add(minus5);
        minuses.add(minus6);
        minuses.add(minus7);
        minuses.add(minus8);
        minuses.add(minus9);
        minuses.add(minus10);
        minuses.add(minus11);
        minuses.add(minus12);
        minuses.add(minus13);
        minuses.add(minus14);
        
        counters.add(count);
        counters.add(count1);
        counters.add(count2);
        counters.add(count3);
        counters.add(count4);
        counters.add(count5);
        counters.add(count6);
        counters.add(count7);
        counters.add(count8);
        counters.add(count9);
        counters.add(count10);
        counters.add(count11);
        counters.add(count12);
        counters.add(count13);
        counters.add(count14);
        
        weighters.add(weight);
        weighters.add(weight1);
        weighters.add(weight2);
        weighters.add(weight3);
        weighters.add(weight4);
        weighters.add(weight5);
        
        deleters.add(deleter);
        deleters.add(deleter1);
        deleters.add(deleter2);
        deleters.add(deleter3);
        deleters.add(deleter4);
        deleters.add(deleter5);
        
        costers.add(cost);
        costers.add(cost1);
        costers.add(cost2);
        costers.add(cost3);
        costers.add(cost4);
        costers.add(cost5);
        costers.add(cost6);
        costers.add(cost7);
        costers.add(cost8);
        costers.add(cost9);
        costers.add(cost10);
        costers.add(cost11);
        costers.add(cost12);
        costers.add(cost13);
        costers.add(cost14);
        costers.add(cost15);
        costers.add(cost16);
        costers.add(cost17);
        costers.add(cost18);
        costers.add(cost19);
        costers.add(cost20);
        
        names.add(name);
        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);
        names.add(name6);
        names.add(name7);
        names.add(name8);
        names.add(name9);
        names.add(name10);
        names.add(name11);
        names.add(name12);
        names.add(name13);
        names.add(name14);
        names.add(name15);
        names.add(name16);
        names.add(name17);
        names.add(name18);
        names.add(name19);
        names.add(name20);
        
        prods.add(imageview);
        prods.add(imageview1);
        prods.add(imageview2);
        prods.add(imageview3);
        prods.add(imageview4);
        prods.add(imageview5);
        prods.add(imageview6);
        prods.add(imageview7);
        prods.add(imageview8);
        prods.add(imageview9);
        prods.add(imageview10);
        prods.add(imageview11);
        prods.add(imageview12);
        prods.add(imageview13);
        prods.add(imageview14);
        prods.add(imageview15);
        prods.add(imageview16);
        prods.add(imageview17);
        prods.add(imageview18);
        prods.add(imageview19);
        prods.add(imageview20);
        
        
        home.setPickOnBounds(true);
        home.setOnMouseClicked((MouseEvent e) -> {
            home.getScene().getWindow().hide();
            openScene("Main.fxml");
        });
        int changerY = 0;
        DatabaseHandler dbHandler = new DatabaseHandler();
        res += dbHandler.Total();
        if (dbHandler.counterCart() == 0){
            nothingCart.setVisible(true);
            pay.setVisible(false);
            result.setVisible(false);
            clearAll.setVisible(false);
        }      
        else
        {
            nothingCart.setVisible(false);
            result.setVisible(true);
            pay.setVisible(true);
            clearAll.setVisible(true);
            
            pay.setOnAction(event -> {
                try {
                    Alias.total = dbHandler.Total();
                } catch (SQLException ex) {
                    Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Alias.bonus = Alias.choosed.getBonuscard().getBalance();
                pay.getScene().getWindow().hide();
                openScene("Pay.fxml");
            });
            clearAll.setOnAction(event ->{
                Alias.clearcart();
                clearAll.getScene().getWindow().hide();
                openScene("Cart.fxml");
            });
        ResultSet resCart = dbHandler.getCart();
        /*ResultSetMetaData rsmd = resCart.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
            while (resCart.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
            if (i > 1) System.out.print(",  ");
            String columnValue = resCart.getString(i);
            System.out.print(columnValue + " " + rsmd.getColumnName(i));
        }
        System.out.println("");
        }*/
        int i = 0;
        int countdelete = 0;
        while (resCart.next()){
            //for (int k = 0; k < dbHandler.counterCart(); k++){           
                int ID = resCart.getInt("productid");
                String prodname = resCart.getString("productname");
                int category = resCart.getInt("category");
                int price = resCart.getInt("price");
                String picture = resCart.getString("picture");
                int countca = resCart.getInt("count");
                double weightca = resCart.getDouble("weight");
                double total = resCart.getDouble("total");
                
                Cart cart = new Cart(picture, prodname, category, countca, weightca, price, total);
                Image image = new Image(getClass().getResourceAsStream("/alias/assets/" + picture));
                prods.get(i).setImage(image);
                
                Product pr = new Product();
                ResultSet resu = dbHandler.getProduct(prodname);
                if(resu.next()){
                    pr.setInstockwei(resu.getDouble("instockwei"));
                    pr.setInstock(resu.getInt("instock"));
                }
            if (category == 2){
                String weightS = String.valueOf(weightca);
                String proiz = String.format("%.2f", price * weightca);
                showerWEI(prods.get(i), names.get(i), weighters.get(countdelete), costers.get(i), deleters.get(countdelete), weightS, proiz, prodname, changerY);
                countdelete++;
            }
            else{
                String countS = String.valueOf(countca);
                String proiz = String.valueOf(price * countca);
                shower(prods.get(i), names.get(i), counters.get(i), costers.get(i), pluses.get(i), minuses.get(i), countS, proiz, prodname, changerY);
            }
            changerY += 100;
        root.setPrefHeight(root.getPrefHeight() + 60);
        
        
            if (category == 2){
                
                for (int j = 0; j < deleters.size(); j++){
                final int id = j;    
                deleters.get(id).setPickOnBounds(true); 
                    deleters.get(id).setOnMouseClicked((MouseEvent e) -> {
                        Alias.cartCount -= 1;
                        Alias.prod.setInstockwei(pr.getInstockwei() + cart.getWeight());
                        dbHandler.updateStock(Alias.prod);
                        dbHandler.removeFromCart(cart);
                        deleters.get(id).getScene().getWindow().hide();
                        openScene("Cart.fxml");
                    });
                }
                }
            if (category == 1){
                    final int b = i;
                    pluses.get(b).setOnAction(event -> {
                        try {
                            pluses(b, cart);
                        } catch (SQLException ex) {
                            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    minuses.get(b).setOnAction(event -> {
                        try {
                            minuses(b, cart);
                        } catch (SQLException ex) {
                            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
            }
            result.setText(String.format("Result: %.2f rub", res));
            i++;
            }
        
        }
    }
    public void shower (ImageView product, Text name, TextField count, Text cost, Button plus, Button minus, String countS, String costS, String nameS, int changerY){
        product.setLayoutX(50);
        product.setLayoutY(20 + changerY);
        product.setFitHeight(100);
        product.setFitWidth(100);
        product.setVisible(true);
        
        name.setText(nameS);
        name.setLayoutX(200);
        name.setLayoutY(90 + changerY);
        name.setVisible(true);
        
        plus.setVisible(true);
        plus.setLayoutX(450);
        plus.setLayoutY(70 + changerY);
        
        count.setText(countS);
        count.setLayoutX(373);
        count.setLayoutY(70 + changerY);
        count.setVisible(true);
        
        minus.setVisible(true);
        minus.setLayoutX(328);
        minus.setLayoutY(70 + changerY);
        
        cost.setText(costS + " rub");
        cost.setLayoutX(550);
        cost.setLayoutY(90 + changerY);
        cost.setVisible(true);
        
        result.setLayoutX(400);
        result.setLayoutY(150 + changerY);
        
        root.setPrefHeight(130 + changerY);
    }
    
    private void showerWEI(ImageView product, Text name, TextField weight, Text cost, ImageView deleter, String weightS, String costS, String nameS, int changerY){
        product.setLayoutX(50);
        product.setLayoutY(20 + changerY);
        product.setFitHeight(100);
        product.setFitWidth(100);
        product.setVisible(true);
        
        name.setText(nameS);
        name.setLayoutX(200);
        name.setLayoutY(90 + changerY);
        name.setVisible(true);
    
        weight.setText(weightS);
        weight.setLayoutX(373);
        weight.setLayoutY(70 + changerY);
        weight.setVisible(true);
        
        deleter.setVisible(true);
        deleter.setLayoutX(340);
        deleter.setLayoutY(70 + changerY);
         
        cost.setText(costS + " rub");
        cost.setLayoutX(550);
        cost.setLayoutY(90 + changerY);
        cost.setVisible(true);
        
        result.setLayoutX(400);
        result.setLayoutY(150 + changerY);
        
        root.setPrefHeight(130 + changerY);
    }
    
    private void pluses(int b, Cart cart) throws SQLException{
        DatabaseHandler dbHandler = new DatabaseHandler();
        Product pr = getProd(cart.getProductname());
        if (pr.getInstock() == 0){
            outOfStock.setVisible(true);
            outOfStock.setLayoutX(pluses.get(b).getLayoutX() - 90);
            outOfStock.setLayoutY(pluses.get(b).getLayoutY() - 10);
            pluses.get(b).setVisible(false);
        } else
        {
            Alias.cartCount += 1;
            res += cart.getPrice();
            result.setText("Result: " + res + " rub");
            counters.get(b).setText(Integer.toString(cart.getCount() + 1));
            cart.setCount(cart.getCount() + 1);
            cart.setTotal(cart.getCount() * cart.getPrice());
            dbHandler.updateCountCart(cart);
            pr.setInstock(pr.getInstock() - 1);
            dbHandler.updateStock(pr);
            costers.get(b).setText(Integer.toString(cart.getPrice() * cart.getCount()) + " rub");
        }
    }
 
    private void minuses(int b, Cart cart) throws SQLException{
        DatabaseHandler dbHandler = new DatabaseHandler();
        Product pr = getProd(cart.getProductname());
        if(!pluses.get(b).isVisible())
            pluses.get(b).setVisible(true);
        outOfStock.setVisible(false);
        if (cart.getCount() == 1){
            Alias.cartCount -= 1;
            pr.setInstock(pr.getInstock() + cart.getCount());
            dbHandler.updateStock(pr);
            dbHandler.removeFromCart(cart);
            minuses.get(b).getScene().getWindow().hide();
            openScene("Cart.fxml");
        }
        else{
            Alias.cartCount -= 1;
            res -= cart.getPrice();
            result.setText("Result: " + res + " rub");
            counters.get(b).setText(Integer.toString(cart.getCount() - 1));
            cart.setCount(cart.getCount() - 1);
            cart.setTotal(cart.getCount() * cart.getPrice());
            dbHandler.updateCountCart(cart);
            pr.setInstock(pr.getInstock() + 1);
            dbHandler.updateStock(pr);
            costers.get(b).setText(Integer.toString(cart.getPrice() * cart.getCount()) + " rub");
        }
    }
    
    private Product getProd(String productname) throws SQLException{
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet resprod = dbHandler.getProduct(productname);
        Product p = null;
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
            
            p = pr;
        }
            return p;
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
