import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.*;


public class NamePlayerMenu1Controller extends Othello{

    @FXML
    private TextField NamePlayer1;

    @FXML
    private ImageView Go;

    @FXML
    void OnGo(MouseEvent event) throws IOException{
        musisoundeffect();
        super.nameplayer1 = NamePlayer1.getText();
        System.out.println(super.nameplayer1);
        if(super.modoJuego == Othello.ModoJuego.IAvIA){
            FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("NivelPlayerMenu1.fxml"));
            Parent root = MainMenu.load();
            Scene one = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(one);
            window.show();
        }
        else{
            FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("NamePlayerMenu2.fxml"));
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