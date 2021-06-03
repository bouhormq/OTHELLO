import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.*;

public class NamePlayerMenu2Controller extends Othello {

    @FXML
    private ImageView Playe;

    @FXML
    private TextField NamePlayer2;

    @FXML
    private ImageView Go;

    @FXML
    void OnGo(MouseEvent event) throws IOException {
        musisoundeffect();
        super.nameplayer2 = NamePlayer2.getText(); 
        System.out.println(super.nameplayer2);
        if (super.modoJuego != Othello.ModoJuego.JvJ){
            FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("NivelPlayerMenu2.fxml"));
            Parent root = MainMenu.load();
            Scene one = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(one);
            window.show();
        }
        else{
            FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("TipoPartidaMenu.fxml"));
            Parent root = MainMenu.load();
            Scene one = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(one);
            window.show();
        }
    }

    @FXML
    void OnBack(MouseEvent event) throws IOException{
        musisoundeffect();
        FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("ModoJuegoMenu.fxml"));
        Parent root = MainMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }

}
