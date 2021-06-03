import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.*;

public class TipoPartidaMenuController extends Othello{

    @FXML
    private ImageView Back;

    @FXML
    private ImageView Normal;

    @FXML
    private ImageView Custom;

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

    @FXML
    void OnCustom(MouseEvent event) throws IOException {
        super.tipoPartida = TipoPartida.Personalizada; 
        System.out.println(super.tipoPartida);
        Game Game = new Game();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Game.startGame(window,super.estado,super.nivel1, super.nivel2, super.modoJuego,super.tipoPartida,super.nameplayer1,super.nameplayer2);
        System.out.println("ERROR");
    }

    @FXML
    void OnNormal(MouseEvent event) throws IOException {
        super.tipoPartida = TipoPartida.Normal; 
        System.out.println(super.tipoPartida);
        Game Game = new Game();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Game.startGame(window,super.estado,super.nivel1, super.nivel2, super.modoJuego,super.tipoPartida,super.nameplayer1,super.nameplayer2);
        System.out.println("ERROR");
    }
}