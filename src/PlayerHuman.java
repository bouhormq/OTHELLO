import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import javafx.stage.*;
import javafx.stage.FileChooser.ExtensionFilter;





public class PlayerHuman extends Player{

	public PlayerHuman(String n) {
		super(n);
	}


	public void program_buttons(Integer i, Integer j, Board b, boolean black, Stage primaryStage, Button[][] btn, Player player, Boolean turn, Game stats, TextField roundstat, TextField turnstat, TextField scorestat, Button saveexit,Button exit, GridPane gridPaneC){
		btn[i][j].setOnAction(e -> {
			if (!b.set_square( i, j, !black)) {
				System.out.println("INVALID MOVE! TRY AGAIN:");
				make_move(b, black, primaryStage, btn, player, turn,stats,roundstat,turnstat,scorestat,saveexit,exit,gridPaneC);
			}
			else{
				draw_button(btn,b);
				musisoundeffect();
				if (!b.gameEnded(!turn)){
					stats.update_round(roundstat);
					System.out.print("Other player makes move");
					
					if(turn){
						stats.turn = turn;
						player.make_move(b, false, primaryStage, btn, this, !turn,stats,roundstat,turnstat,scorestat,saveexit,exit,gridPaneC);
					}
					else{
						stats.turn = turn;
						player.make_move(b, true, primaryStage, btn, this, !turn,stats,roundstat,turnstat,scorestat,saveexit,exit,gridPaneC);
					}
				}
				else {
					System.out.print("Game Ended No Empty Squares, GG!");
					FXMLLoader ModoJuegoMenu = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
					Parent root = null;
					try{
						root = ModoJuegoMenu.load();
					}
					catch(IOException ex){
						System.out.println ("Couldnt Exit");
					}
					Scene one = new Scene(root);
					primaryStage.setScene(one);
					primaryStage.show();
						}
					}
		});
	}


	public void make_move(Board b, boolean black, Stage primaryStage, Button[][] btn, Player player, Boolean turn, Game stats, TextField roundstat, TextField turnstat, TextField scorestat, Button saveexit,Button exit, GridPane gridPaneC){
		VBox vbox = new VBox();
		vbox.getChildren().addAll(roundstat,turnstat,scorestat,saveexit,exit,gridPaneC);
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show(); 
		System.out.println(turn);
		stats.turn = turn;
		stats.update_turn(turnstat, scorestat,this.name,b);
		saveexit.setOnAction(e -> {
			GuardarPartida partidaguardada;
			partidaguardada = new GuardarPartida();
			partidaguardada.guardar(this.name, player.name,stats.round, b, b.b_score, b.w_score);
		});
		exit.setOnAction (e ->  {
			FXMLLoader ModoJuegoMenu = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
			Parent root = null;
			try{
				root = ModoJuegoMenu.load();
			}
			catch(IOException ex){
				System.out.println ("Couldnt Exit");
			}
			Scene one = new Scene(root);
			primaryStage.setScene(one);
			primaryStage.show();
		});
		draw_button(btn, b);
		for(int i=0; i<btn.length; i++){
			for(int j=0; j<btn.length;j++){
				program_buttons(i, j, b, black, primaryStage, btn, player, turn,stats,roundstat,turnstat,scorestat,saveexit,exit,gridPaneC);
			}
		}
	}
}