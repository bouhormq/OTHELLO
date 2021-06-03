import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.*;
import javafx.stage.FileChooser.ExtensionFilter;


public class EstadoMenuController extends Othello {

    @FXML
    private ImageView New;

    @FXML
    private ImageView Resume;

    @FXML
    void OnNew(MouseEvent event) throws IOException {
        musisoundeffect();
        super.estado = Estado.newGame;
        System.out.println(super.estado);
        FXMLLoader ModoJuegoMenu = new FXMLLoader(getClass().getResource("ModoJuegoMenu.fxml"));
        Parent root = ModoJuegoMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }

    @FXML
    void OnResume(MouseEvent event) throws IOException{
        musisoundeffect();
        super.estado = Estado.resumeGame;
        System.out.println(super.estado);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        String val;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Saved Game");
        fileChooser.setInitialDirectory(new File ("saves//"));
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Saved Games","*.txt"));
        File file = fileChooser.showOpenDialog(window.getScene().getWindow());
        if (file != null) {
            val = file.getPath();
            System.out.println(val);
            GuardarPartida cargarPartida = new GuardarPartida();
            cargarPartida.cargar(val);
            Game Game = new Game();
            Game.startCustomGame(window,super.estado,Othello.Nivel.easy,Othello.modoJuego.JvJ,Othello.tipoPartida.Normal,cargarPartida);

        } else  {
            System.out.println("error"); // or something else
        }
    }

    @FXML
    void OnBack(MouseEvent event) throws IOException{
        musisoundeffect();
        FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent root = MainMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }

}
