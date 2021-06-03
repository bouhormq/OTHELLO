import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.*;


public class RankingMenuController extends Othello{

    @FXML
    private ImageView Personal;

    @FXML
    private ImageView Global;

    @FXML
    void OnGlobal(MouseEvent event) {
        musisoundeffect();
        this.ranking = Ranking.globalRanking;
        System.out.println(this.ranking);
    }

    @FXML
    void OnPersonal(MouseEvent event) {
        musisoundeffect();
        this.ranking = Ranking.personalRanking;
        System.out.println(this.ranking);
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