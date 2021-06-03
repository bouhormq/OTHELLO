import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.media.AudioClip;


public class Othello extends Application{

    

    static Estado estado;
    public enum Estado{
			
        newGame, resumeGame;
    }
    static Nivel nivel1; //{easy, medium, hard}
    static Nivel nivel2; //{easy, medium, hard}
    public enum Nivel{
			
        easy, medium, hard;
    }
    static ModoJuego modoJuego; //{JvJ, JvIA, IAvIA}
    public enum ModoJuego{
			
        JvJ, JvIA, IAvIA;
    }
    static TipoPartida tipoPartida; //{Normal, Personalizada}
    public enum TipoPartida{
			
        Normal, Personalizada;
    }
    static Ranking ranking; //{globalRanking, personalRanking} 
    public enum Ranking{
			
        globalRanking, personalRanking;
    }

    

    static String nameplayer1;
    static String nameplayer2;
    Stage window;


    Scene MenuPrincipal, MenuPartidaEstado, MenuRanking, MenuPartidaNueva, MenuPartidaNuevaTipo, MenuPartidaNuevaNivel, MenuPartidaLogin1, MenuPartidaLogin2, EmpezarPartida;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void musicost() {
		AudioClip soundtrack = new AudioClip(this.getClass().getResource("ost.mp3").toString());
        soundtrack.play();
	}
    public void musisoundeffect() {
		AudioClip soundtrack = new AudioClip(this.getClass().getResource("click.mp3").toString());
        soundtrack.play();
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
        musicost();
        window = primaryStage;        
        window.setTitle("Othello");

        FXMLLoader MainMenu = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent root = MainMenu.load();
        Scene one = new Scene(root);
        window.setScene(one);
        window.show();
    }
}
