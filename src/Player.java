
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.shape.*;
import javafx.scene.media.AudioClip;





public abstract class Player {
	
	protected String name;

	public void musisoundeffect() {
		AudioClip soundtrack = new AudioClip(this.getClass().getResource("click.wav").toString());
        soundtrack.play();
	}
	
	// Constructor de jugador
	public Player(String n){
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}

	public void program_buttons_custom(Integer i, Integer j, Button btn [][], Board b){
		btn[i][j].setOnAction(e -> {
			if (b.board[i][j].getContent() == Square.Content.EMPTY || b.board[i][j].getContent() == Square.Content.POSSIBLE) {
				Circle circle = new Circle();
				circle.setRadius(27);
				circle.setFill(javafx.scene.paint.Color.WHITE);
				btn[i][j].setGraphic(circle);
				b.board[i][j].setContent(Square.Content.WHITE);
			}
			else if (b.board[i][j].getContent() == Square.Content.WHITE) {
				Circle circle = new Circle();
				circle.setRadius(27);
				circle.setFill(javafx.scene.paint.Color.BLACK);
				btn[i][j].setGraphic(circle);
				b.board[i][j].setContent(Square.Content.BLACK);
			}
			else if (b.board[i][j].getContent() == Square.Content.BLACK) {
				btn[i][j].setGraphic(null);
				b.board[i][j].setContent(Square.Content.EMPTY);
			}
			System.out.print(btn[i][j].getStyle());
		});
	}
	
	public abstract void make_move(Board b, boolean black, Stage primaryStage, Button[][] btn, Player player, Boolean turn, Game stats, TextField roundstat, TextField turnstat, TextField scorestat, Button saveexit,Button exit,GridPane gridPaneC);
	
	private int path_score(Board b, Boolean black, int i, int j, Boolean left, Boolean right, Boolean up, Boolean down) {
		int sum = 0;
		Square.Content my_colour, your_colour;
		if (black) {
			my_colour = Square.Content.BLACK;
			your_colour = Square.Content.WHITE;
		}
		else {
			my_colour = Square.Content.WHITE;
			your_colour = Square.Content.BLACK;
		}
		
		while(i <= 7 && i >= 0 && j <= 7 && j >= 0 && b.board[i][j].getContent() == your_colour) {
			++sum;
			if (left && j >= 0) --j;
			if (right && j <= 7) ++j;
			if (up && i >= 0) --i;
			if (down && i <= 7) ++i;
		}
		if (i <= 7 && i >= 0 && j <= 7 && j >= 0 && b.board[i][j].getContent() == my_colour ) 
			return sum;
		else 
			return 0;
	}

	public void draw_button(Button[][] btn, Board b){
		for(int i=0; i<btn.length; i++){
			for(int j=0; j<btn.length;j++){
				btn[i][j].setGraphic(null);
				btn[i][j].setStyle("-fx-background-color: transparent;");
				if(b.board[i][j].getContent() == Square.Content.BLACK){
					btn[i][j].setStyle("-fx-background-color: green;");
					Circle circle = new Circle();
					circle.setRadius(27);
					circle.setFill(javafx.scene.paint.Color.BLACK);
					btn[i][j].setGraphic(circle);
				}
				else if (b.board[i][j].getContent() == Square.Content.WHITE){
					btn[i][j].setStyle("-fx-background-color: green;");
					Circle circle = new Circle();
					circle.setRadius(27);
					circle.setFill(javafx.scene.paint.Color.WHITE);
					btn[i][j].setGraphic(circle);
				}
				else if (b.board[i][j].getContent() == Square.Content.POSSIBLE){
					btn[i][j].setStyle("-fx-background-color: green; -fx-border-color: red; -fx-border-radius: 100;");
				}
				else{
					btn[i][j].setStyle("-fx-background-color: green;");
				}
			}
		}
	}
	
	protected int valid_move(Board b, int i, int j, Boolean black){
		int sum = 0;
		if (b.board[i][j].getContent() != Square.Content.POSSIBLE) 
			return sum;
		sum += path_score(b, black, i, j-1, true, false, false, false);
		sum += path_score(b, black, i, j+1, false, true, false, false);
		sum += path_score(b, black, i-1, j, false, false, true, false);
		sum += path_score(b, black, i+1, j, false, false, false, true);
		sum += path_score(b, black, i-1, j-1, true, false, true, false);
		sum += path_score(b, black, i+1, j-1, true, false, false, true);
		sum += path_score(b, black, i-1, j+1, false, true, true, false);
		sum += path_score(b, black, i+1, j+1, false, true, false, true);
		return sum;
	}
	
	public void custom_game( Board b, boolean black, Stage primaryStage, Button[][] btn, Player player1,Player player2, Boolean turn, Game stats, TextField roundstat, TextField turnstat, TextField scorestat, Button newGame, Button saveexit,Button exit, GridPane gridPaneC){
		newGame.setOnAction(e -> { 
			roundstat.setText("Round: " + stats.round);                   
			player1.make_move(b, false, primaryStage, btn, player2, turn, stats, roundstat,turnstat, scorestat, saveexit,exit,gridPaneC);
		});
	
		for(int i=0; i<btn.length; i++){
			for(int j=0; j<btn.length;j++){
				program_buttons_custom(i, j, btn, b);
			}
		}
	}
}