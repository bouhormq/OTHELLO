import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.*;


public class ModoJuegoMenuController extends Othello{

    @FXML
    private ImageView JvJ;

    @FXML
    private ImageView JVIA;

    @FXML
    private ImageView IAvIA;

    @FXML
    void OnIAvIA(MouseEvent event) throws IOException{
        musisoundeffect();
        super.modoJuego = ModoJuego.IAvIA;
        System.out.println(super.modoJuego);
        FXMLLoader ModoJuegoMenu = new FXMLLoader(getClass().getResource("NamePlayerMenu1.fxml"));
        Parent root = ModoJuegoMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }

    @FXML
    void OnJvIA(MouseEvent event) throws IOException{
        musisoundeffect();
        super.modoJuego = ModoJuego.JvIA;
        System.out.println(super.modoJuego);
        FXMLLoader ModoJuegoMenu = new FXMLLoader(getClass().getResource("NamePlayerMenu1.fxml"));
        Parent root = ModoJuegoMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }

    @FXML
    void OnJvJ(MouseEvent event) throws IOException{
        musisoundeffect();
        super.modoJuego = ModoJuego.JvJ;
        System.out.println(super.modoJuego);
        FXMLLoader ModoJuegoMenu = new FXMLLoader(getClass().getResource("NamePlayerMenu1.fxml"));
        Parent root = ModoJuegoMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }

    @FXML
    void OnBack(MouseEvent event) throws IOException{
        musisoundeffect();
        FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("EstadoMenu.fxml"));
        Parent root = MainMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }
}