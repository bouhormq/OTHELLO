import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.shape.*;


public class Game {
    
    Integer round = 1;
    Boolean turn = false;//{false for player 1 and true for player 2}
    // 2D array of Buttons with value of 8,8
    Button[][] btn = new Button[8][8];

    public Integer getRound() {
        return round;
    }
    public Boolean getTurn() {
        return turn;
    }

    public void update_round(TextField round) {
        ++this.round;
        round.setText("Round: " + this.round);
    }
    public void update_turn(TextField turn, TextField score, String playername, Board nameOfGame) {
        if(this.turn){
            turn.setText("Turn: " + playername + " (White)");
        }
        else{
            turn.setText("Turn: " + playername + " (Black)");
        }
        score.setText("Score W: " + nameOfGame.get_white_score() + " Score B: " + nameOfGame.get_black_score());
    }
    

    public void startGame(Stage primaryStage, Othello.Estado estado , Othello.Nivel nivel1, Othello.Nivel nivel2, Othello.ModoJuego modoJuego, Othello.TipoPartida tipoPartida, String nameplayer1, String nameplayer2) {
            Board nameOfGame = new Board();
            nameOfGame.init_board();
            nameOfGame.calc_pos(false);
            Player player1, player2;
            if (modoJuego == Othello.ModoJuego.JvJ) {
            	player1 = new PlayerHuman(nameplayer1);
            	player2 = new PlayerHuman(nameplayer2);
            }
            else if (modoJuego == Othello.ModoJuego.JvIA) {
            	player1 = new PlayerHuman(nameplayer1);
            	player2 = new PlayerIA(nameplayer2, nivel2.toString());
            }
            else {
            	player1 = new PlayerIA(nameplayer1, nivel1.toString());
            	player2 = new PlayerIA(nameplayer2, nivel2.toString());
            }
            
            if (tipoPartida == Othello.TipoPartida.Personalizada){
                Player customGameMaker;
                customGameMaker = new PlayerHuman("customGameMaker");
            
                //Adding GridPane
                GridPane gridPaneC = new GridPane();
                    
                // 2D array of Buttons with value of 5,5
                Button[][] btnC = new Button[8][8];
                    
                //Column is a vertical line and row is a horizontal line
                //Two FOR loops used for creating 2D array of buttons with values i,j
                for(Integer i=0; i<btnC.length; i++){
                    for(Integer j=0; j<btnC.length;j++){
                        btnC[i][j] = new Button();
                        btnC[i][j].setStyle("-fx-background-color: green;");
                        btnC[i][j].setPrefSize(70, 70);
                        if(nameOfGame.board[i][j].getContent() == Square.Content.BLACK){
                            //Initializing 2D buttons with values i,j
                            Circle circle = new Circle();
                            circle.setRadius(27);
                            circle.setFill(javafx.scene.paint.Color.BLACK);
                            btnC[i][j].setGraphic(circle);
                        }
                        else if (nameOfGame.board[i][j].getContent() == Square.Content.WHITE){
                            //Initializing 2D buttons with values i,j
                            Circle circle = new Circle();
                            circle.setRadius(27);
                            circle.setFill(javafx.scene.paint.Color.WHITE);
                            btnC[i][j].setGraphic(circle);
                        }
                        gridPaneC.add(btnC[i][j], i, j);
                    }
                }
                Button save = new Button("Save Game");
                Button exit = new Button("Exit Game");
                Button newGame = new Button("Start Game");
                Text roundstat = new Text();
                TextField roundtextField = new TextField();
                roundstat.textProperty().bind(roundtextField.textProperty());
                Text turnstat = new Text();
                TextField turntextField = new TextField();
                turnstat.textProperty().bind(turntextField.textProperty());
                Text scorestat = new Text();
                TextField scoretextField = new TextField();
                scorestat.textProperty().bind(scoretextField.textProperty());
                VBox stats = new VBox();
                stats.getChildren().addAll(roundstat,turnstat,scorestat,newGame,exit,save,gridPaneC);
                Scene scene = new Scene(stats);
                primaryStage.setScene(scene);
                primaryStage.show(); 
                customGameMaker.custom_game(nameOfGame, false, primaryStage, btnC,player1, player2, turn, this, roundtextField,turntextField, scoretextField, newGame,save,exit, gridPaneC);
            }
            
            else if(tipoPartida == Othello.TipoPartida.Normal){
                //Adding GridPane
            GridPane gridPane = new GridPane();
                
            //Column is a vertical line and row is a horizontal line
            //Two FOR loops used for creating 2D array of buttons with values i,j
            for(Integer i=0; i<btn.length; i++){
                for(Integer j=0; j<btn.length;j++){
                    btn[i][j] = new Button();
                    btn[i][j].setStyle("-fx-background-color: green;");
                    btn[i][j].setPrefSize(70, 70);
                    if(nameOfGame.board[i][j].getContent() == Square.Content.BLACK){
                        //Initializing 2D buttons with values i,j
                        Circle circle = new Circle();
                        circle.setRadius(27);
                        circle.setFill(javafx.scene.paint.Color.BLACK);
                        btn[i][j].setGraphic(circle);
                    }
                    else if (nameOfGame.board[i][j].getContent() == Square.Content.WHITE){
                        //Initializing 2D buttons with values i,j
                        Circle circle = new Circle();
                        circle.setRadius(27);
                        circle.setFill(javafx.scene.paint.Color.WHITE);
                        btn[i][j].setGraphic(circle);
                    }
                    else if (nameOfGame.board[i][j].getContent() == Square.Content.POSSIBLE){
                        //Initializing 2D buttons with values i,j
                        btn[i][j].setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY))); 
                        btn[i][j].setStyle("-fx-background-color: green; -fx-border-color: red; -fx-border-radius: 100;");
                    }
                    gridPane.add(btn[i][j], i, j);
                }
            }
                
            //Adding GridPane to the scene
            Button exit = new Button("Exit Game");
            Button save = new Button("Save Game");
            Text roundstat = new Text();
            TextField roundtextField = new TextField();
            roundtextField.setText("Round: " + this.round);
            roundstat.textProperty().bind(roundtextField.textProperty());
            Text turnstat = new Text();
            TextField turntextField = new TextField();
            turnstat.textProperty().bind(turntextField.textProperty());
            Text scorestat = new Text();
            TextField scoretextField = new TextField();
            scorestat.textProperty().bind(scoretextField.textProperty());
            VBox stats = new VBox();
            stats.getChildren().addAll(roundstat,turnstat,scorestat,save,exit,gridPane);
            Scene scene = new Scene(stats);
            primaryStage.setScene(scene);
            primaryStage.show();
            player1.make_move(nameOfGame, false, primaryStage, btn, player2, turn, this, roundtextField,turntextField, scoretextField, save,exit, gridPane);
            }
        }

        public void startCustomGame(Stage primaryStage, Othello.Estado estado , Othello.Nivel nivel, Othello.ModoJuego modoJuego, Othello.TipoPartida tipoPartida, GuardarPartida cargarPartida){
                //Adding GridPane
                Board nameOfGame = new Board();
                nameOfGame = cargarPartida.b;
                nameOfGame.calc_pos(false);
                round = cargarPartida.round;
                nameOfGame.b_score = cargarPartida.scoreb;
                nameOfGame.w_score = cargarPartida.scorew;
                Player player1, player2;
                
                player1 = new PlayerHuman(cargarPartida.player1);
                player2 = new PlayerHuman(cargarPartida.player2);
                
                GridPane gridPane = new GridPane();
                
                //Column is a vertical line and row is a horizontal line
                //Two FOR loops used for creating 2D array of buttons with values i,j
                for(Integer i=0; i<btn.length; i++){
                    for(Integer j=0; j<btn.length;j++){
                        btn[i][j] = new Button();
                        btn[i][j].setStyle("-fx-background-color: green;");
                        btn[i][j].setPrefSize(70, 70);
                        if(nameOfGame.board[i][j].getContent() == Square.Content.BLACK){
                            //Initializing 2D buttons with values i,j
                            Circle circle = new Circle();
                            circle.setRadius(27);
                            circle.setFill(javafx.scene.paint.Color.BLACK);
                            btn[i][j].setGraphic(circle);
                        }
                        else if (nameOfGame.board[i][j].getContent() == Square.Content.WHITE){
                            //Initializing 2D buttons with values i,j
                            Circle circle = new Circle();
                            circle.setRadius(27);
                            circle.setFill(javafx.scene.paint.Color.WHITE);
                            btn[i][j].setGraphic(circle);
                        }
                        else if (nameOfGame.board[i][j].getContent() == Square.Content.POSSIBLE){
                            //Initializing 2D buttons with values i,j
                            btn[i][j].setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY))); 
                            btn[i][j].setStyle("-fx-background-color: green; -fx-border-color: red; -fx-border-radius: 100;");
                        }
                        gridPane.add(btn[i][j], i, j);
                    }
                }
                    
                //Adding GridPane to the scene
                Button exit = new Button("Exit Game");
                Button save = new Button("Save Game");
                Text roundstat = new Text();
                TextField roundtextField = new TextField();
                roundtextField.setText("Round: " + this.round);
                roundstat.textProperty().bind(roundtextField.textProperty());
                Text turnstat = new Text();
                TextField turntextField = new TextField();
                turnstat.textProperty().bind(turntextField.textProperty());
                Text scorestat = new Text();
                TextField scoretextField = new TextField();
                scorestat.textProperty().bind(scoretextField.textProperty());
                VBox stats = new VBox();
                stats.getChildren().addAll(roundstat,turnstat,scorestat,exit,save,gridPane);
                Scene scene = new Scene(stats);
                primaryStage.setScene(scene);
                primaryStage.show();
                player1.make_move(nameOfGame, false, primaryStage, btn, player2, turn, this, roundtextField,turntextField, scoretextField, save,exit, gridPane);
                
        }
}
