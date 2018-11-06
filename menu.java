import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class menu {    
    ObservableList<String> gameTypeList = FXCollections.observableArrayList("--Select--", "One Game", "Five Games", "Unlimited");

    @FXML
    private Label lblGameType; 
    @FXML
    private ChoiceBox cbGameType; 
    
    @FXML    
    private void initialize()
    {
        cbGameType.setValue("--Select--");
        cbGameType.setItems(gameTypeList);
        
        //Detect the game type selection, change label and pics
        cbGameType.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {            
            if ("--Select--".equals(newValue))
            {    
                lblGameType.setText("Choose how many games...");
            }    
            else if ("One Game".equals(newValue))
            {    
                lblGameType.setText("One game being played...");
                cbGameType.setValue("--Select--");
                try 
                {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/one-game.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("R P S - One Game");
                    stage.show();
                } 
                catch(Exception e) 
                {
                    e.printStackTrace();
                }
            }
            else if ("Five Games".equals(newValue))
            {    
                lblGameType.setText("Five games being played...");
                cbGameType.setValue("--Select--");
                try 
                {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/five-games.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("R P S - Five Games");
                    stage.show();
                } 
                catch(Exception e) 
                {
                    e.printStackTrace();
                }
            }
            else if ("Unlimited".equals(newValue))
            {    
                lblGameType.setText("Unlimited games being played...");
                cbGameType.setValue("--Select--");
                try 
                {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/unlimited-games.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("R P S - Unlimited Games");
                    stage.show();
                } 
                catch(Exception e) 
                {
                    e.printStackTrace();
                }
            }              
        });
    }
}
                
            
    
          
            

  

