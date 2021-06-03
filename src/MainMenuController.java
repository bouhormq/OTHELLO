import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.*;




public class MainMenuController extends Othello{


    @FXML
    private ImageView StartGame;

    @FXML
    private ImageView Ranking;

    @FXML
    void ranking(MouseEvent event) throws IOException {
        musisoundeffect();
        FXMLLoader RankingMenu = new FXMLLoader(getClass().getResource("RankingMenu.fxml"));
        Parent root = RankingMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }

    @FXML
    void startGame(MouseEvent event) throws IOException{
        musisoundeffect();
        FXMLLoader TipoPartidaMenu = new FXMLLoader(getClass().getResource("EstadoMenu.fxml"));
        Parent root = TipoPartidaMenu.load();
        Scene one = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(one);
        window.show();
    }

}
