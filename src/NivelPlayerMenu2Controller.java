import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.*;

public class NivelPlayerMenu2Controller extends Othello{

    @FXML
    private ImageView Easy;

    @FXML
    private ImageView Medium;

    @FXML
    private ImageView Hard;

    @FXML
    void OnEasy(MouseEvent event) throws IOException{
        musisoundeffect();
        super.nivel2 = Nivel.easy;
        System.out.println(super.nivel2);
        FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("TipoPartidaMenu.fxml"));
        Parent root = MainMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }

    @FXML
    void OnHard(MouseEvent event) throws IOException{
        musisoundeffect();
        super.nivel2 = Nivel.hard;
        System.out.println(super.nivel2);
        FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("TipoPartidaMenu.fxml"));
        Parent root = MainMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }

    @FXML
    void OnMedium(MouseEvent event) throws IOException{
        musisoundeffect();
        super.nivel2 = Nivel.medium;
        FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("TipoPartidaMenu.fxml"));
        Parent root = MainMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
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
