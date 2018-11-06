import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;   
import javafx.stage.Stage;

public class main extends Application 
{
    public static void main(String[] args) {
        Application.launch(main.class, args);
    }
    
    static Stage stg;
    @Override
    public void start(Stage stage) throws Exception {
    this.stg = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
        stage.setTitle("R P S");
        stage.setScene(new Scene(root, 262, 329));
        stage.show();
    }
}
