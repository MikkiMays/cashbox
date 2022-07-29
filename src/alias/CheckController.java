package alias;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CheckController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text prod;

    @FXML
    private Text prod1;

    @FXML
    private Text prod2;

    @FXML
    private Text prod3;

    @FXML
    private Text prod4;

    @FXML
    private Text prod5;

    @FXML
    private Text prod6;

    @FXML
    private Text prod7;

    @FXML
    private Text prod8;

    @FXML
    private Text prod9;

    @FXML
    private Text prod10;

    @FXML
    private Text prod11;

    @FXML
    private Text prod12;

    @FXML
    private Text prod13;

    @FXML
    private Text prod14;

    @FXML
    private Text prod15;

    @FXML
    private Text prod16;

    @FXML
    private Text prod17;

    @FXML
    private Text prod19;

    @FXML
    private Text prod18;

    @FXML
    private Text prod20;

    @FXML
    private Text id;

    @FXML
    private Text underline;

    @FXML
    private Text cost;

    @FXML
    private Text count;

    @FXML
    private Text resu;

    @FXML
    private Text cya;

    @FXML
    private Text underline1;

    @FXML
    private Text underline2;

    @FXML
    private Text underline3;

    @FXML
    private Text underline4;

    @FXML
    private Text underline5;

    @FXML
    private Text underline6;

    @FXML
    private Text underline7;

    @FXML
    private Text underline8;

    @FXML
    private Text underline9;

    @FXML
    private Text underline10;

    @FXML
    private Text underline11;

    @FXML
    private Text underline12;

    @FXML
    private Text underline13;

    @FXML
    private Text underline14;

    @FXML
    private Text underline15;

    @FXML
    private Text underline16;

    @FXML
    private Text underline17;

    @FXML
    private Text underline18;

    @FXML
    private Text underline19;

    @FXML
    private Text underline20;

    @FXML
    private Text count1;

    @FXML
    private Text count2;

    @FXML
    private Text count3;

    @FXML
    private Text count4;

    @FXML
    private Text count5;

    @FXML
    private Text count6;

    @FXML
    private Text count7;

    @FXML
    private Text count8;

    @FXML
    private Text count9;

    @FXML
    private Text count10;

    @FXML
    private Text count11;

    @FXML
    private Text count12;

    @FXML
    private Text count13;

    @FXML
    private Text count14;

    @FXML
    private Text count15;

    @FXML
    private Text count16;

    @FXML
    private Text count17;

    @FXML
    private Text count18;

    @FXML
    private Text count19;

    @FXML
    private Text count20;

    @FXML
    private Text cost1;

    @FXML
    private Text cost2;

    @FXML
    private Text cost3;

    @FXML
    private Text cost4;

    @FXML
    private Text cost5;

    @FXML
    private Text cost6;

    @FXML
    private Text cost7;

    @FXML
    private Text cost8;

    @FXML
    private Text cost9;

    @FXML
    private Text cost10;

    @FXML
    private Text cost11;

    @FXML
    private Text cost12;

    @FXML
    private Text cost13;

    @FXML
    private Text cost14;

    @FXML
    private Text cost15;

    @FXML
    private Text cost16;

    @FXML
    private Text cost17;

    @FXML
    private Text cost18;

    @FXML
    private Text cost19;

    @FXML
    private Text cost20;

    @FXML
    private Text resu1;

    @FXML
    private Text resu2;

    @FXML
    private Text resu3;

    @FXML
    private Text resu4;

    @FXML
    private Text resu5;

    @FXML
    private Text resu6;

    @FXML
    private Text resu7;

    @FXML
    private Text resu8;

    @FXML
    private Text resu9;

    @FXML
    private Text resu10;

    @FXML
    private Text resu11;

    @FXML
    private Text resu12;

    @FXML
    private Text resu13;

    @FXML
    private Text resu14;

    @FXML
    private Text resu15;

    @FXML
    private Text resu16;

    @FXML
    private Text resu17;

    @FXML
    private Text resu18;

    @FXML
    private Text resu19;

    @FXML
    private Text resu20;

    @FXML
    private Text id1;

    @FXML
    private Text id2;

    @FXML
    private Text id3;

    @FXML
    private Text id4;

    @FXML
    private Text id5;

    @FXML
    private Text id6;

    @FXML
    private Text id7;

    @FXML
    private Text id8;

    @FXML
    private Text id9;

    @FXML
    private Text id10;

    @FXML
    private Text id11;

    @FXML
    private Text id12;

    @FXML
    private Text id13;

    @FXML
    private Text id14;

    @FXML
    private Text id15;

    @FXML
    private Text id16;

    @FXML
    private Text id17;

    @FXML
    private Text id18;

    @FXML
    private Text id19;

    @FXML
    private Text id20;

    @FXML
    private Text total;
    
    @FXML
    private AnchorPane root;
    
    @FXML
    private Text paidbonus;

    private ArrayList<Text> ids = new ArrayList<Text>();
    private ArrayList<Text> names = new ArrayList<Text>();
    private ArrayList<Text> counters = new ArrayList<Text>();
    private ArrayList<Text> costers = new ArrayList<Text>();
    private ArrayList<Text> ress = new ArrayList<Text>();
    private ArrayList<Text> underlines = new ArrayList<Text>();
    
    @FXML
    void initialize() throws SQLException {
        ids.add(id);
        ids.add(id1);
        ids.add(id2);
        ids.add(id3);
        ids.add(id4);
        ids.add(id5);
        ids.add(id6);
        ids.add(id7);
        ids.add(id8);
        ids.add(id9);
        ids.add(id10);
        ids.add(id11);
        ids.add(id12);
        ids.add(id13);
        ids.add(id14);
        ids.add(id15);
        ids.add(id16);
        ids.add(id17);
        ids.add(id18);
        ids.add(id19);
        ids.add(id20);
        
        names.add(prod);
        names.add(prod1);
        names.add(prod2);
        names.add(prod3);
        names.add(prod4);
        names.add(prod5);
        names.add(prod6);
        names.add(prod7);
        names.add(prod8);
        names.add(prod9);
        names.add(prod10);
        names.add(prod11);
        names.add(prod12);
        names.add(prod13);
        names.add(prod14);
        names.add(prod15);
        names.add(prod16);
        names.add(prod17);
        names.add(prod18);
        names.add(prod19);
        names.add(prod20);
        
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
        counters.add(count15);
        counters.add(count16);
        counters.add(count17);
        counters.add(count18);
        counters.add(count19);
        counters.add(count20);
        
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
        
        ress.add(resu);
        ress.add(resu1);
        ress.add(resu2);
        ress.add(resu3);
        ress.add(resu4);
        ress.add(resu5);
        ress.add(resu6);
        ress.add(resu7);
        ress.add(resu8);
        ress.add(resu9);
        ress.add(resu10);
        ress.add(resu11);
        ress.add(resu12);
        ress.add(resu13);
        ress.add(resu14);
        ress.add(resu15);
        ress.add(resu16);
        ress.add(resu17);
        ress.add(resu18);
        ress.add(resu19);
        ress.add(resu20);
        
        underlines.add(underline);
        underlines.add(underline1);
        underlines.add(underline2);
        underlines.add(underline3);
        underlines.add(underline4);
        underlines.add(underline5);
        underlines.add(underline6);
        underlines.add(underline7);
        underlines.add(underline8);
        underlines.add(underline9);
        underlines.add(underline10);
        underlines.add(underline11);
        underlines.add(underline12);
        underlines.add(underline13);
        underlines.add(underline14);
        underlines.add(underline15);
        underlines.add(underline16);
        underlines.add(underline17);
        underlines.add(underline18);
        underlines.add(underline19);
        underlines.add(underline20);
        
        int changerY = 0;
        int i = 0;
        DatabaseHandler dbHandler = new DatabaseHandler();
        
                Order order = new Order(1, Alias.choosed.getId(), Alias.paidbonuses, Alias.total);
                dbHandler.addOrder(order);
                
            ResultSet resprodcart = dbHandler.getCart();
            while(resprodcart.next()){
                String idS = Integer.toString(i + 1);
                String nameS = resprodcart.getString("productname");
                String resS = String.valueOf(resprodcart.getDouble("total"));
                int categ = resprodcart.getInt("category");
                String countS;
                int cnt = 0;
                double wei = 0;
                if (categ == 1){
                    countS = String.valueOf(resprodcart.getInt("count"));
                    cnt = Integer.parseInt(countS);
                }
                else{
                    countS = String.valueOf(resprodcart.getDouble("weight"));
                    wei = Double.parseDouble(countS);
                }
                String costS = String.valueOf(resprodcart.getInt("price"));
                
                ResultSet respr = dbHandler.getProduct(nameS);
                int idprod = 0;
                if(respr.next())
                    idprod = respr.getInt("idproduct");
                OrderDetail ordets = new OrderDetail(1, dbHandler.getOrderId(), idprod, categ, cnt, wei);
                dbHandler.addOrderDetails(ordets);
                
                Text id = ids.get(i);
                Text name = names.get(i);
                Text count = counters.get(i);
                Text cost = costers.get(i);
                Text res = ress.get(i);
                Text underline = underlines.get(i);
                shower(id, name, count, cost, res, underline, idS, nameS, countS, costS, resS, changerY);
                changerY += 21;
                i++;
            }
        cya.setLayoutX(130);
        cya.setLayoutY(240 + changerY);
        paidbonus.setLayoutX(260);
        paidbonus.setLayoutY(200 + changerY);
        paidbonus.setText("Paid by bonuses: " + Alias.paidbonuses);
        total.setLayoutX(260);
        total.setLayoutY(180 + changerY);
        total.setText(String.format("Total: %.2f Rub", Alias.total));
        dbHandler.clearAll();
    }
    public void shower (Text id, Text name, Text count, Text cost, Text res, Text underline, String idS, String nameS, String countS, String costS, String resS, int changerY){
        
        underline.setLayoutX(49);
        underline.setLayoutY(163 + changerY);
        underline.setVisible(true); 
        
        id.setText(idS);
        id.setLayoutX(53);
        id.setLayoutY(163 + changerY);
        id.setVisible(true);
        
        name.setText(nameS);
        name.setLayoutX(83);
        name.setLayoutY(163 + changerY);
        name.setVisible(true);
        
        count.setVisible(true);
        count.setLayoutX(265);
        count.setLayoutY(163 + changerY);
        count.setText(countS);
          
        cost.setText(costS);
        cost.setLayoutX(308);
        cost.setLayoutY(163 + changerY);
        cost.setVisible(true);
        
        res.setText(resS);
        res.setLayoutX(354);
        res.setLayoutY(163 + changerY);
        res.setVisible(true);
        
        root.setPrefHeight(287 + changerY);
    }
}
