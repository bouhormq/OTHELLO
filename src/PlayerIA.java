import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;



public class PlayerIA extends Player{

	private String dificultad;

	public PlayerIA(String n, String d) {
		super(n);
		dificultad = d;
	}
	
	public String getDificultad() {
		return dificultad;
	}
	
	public void setDificultad(String d) {
		dificultad = d;
	}
	
	public void make_move(Board b, boolean black, Stage primaryStage, Button[][] btn, Player player, Boolean turn, Game stats, TextField roundstat, TextField turnstat, TextField scorestat, Button saveexit,Button exit, GridPane gridPaneC) {
		stats.update_turn(turnstat, scorestat,this.name,b);
		stats.update_round(roundstat);
		int posx = 0;
		int posy = 0;
		if(dificultad == "easy"){
			int max_score = 0;
			for (int i = 0; i < 8; ++i) {
				for (int j = 0; j < 8; ++j) {
					int score = super.valid_move(b, i, j, black);
					if (max_score < score) {
						max_score = score;
						posx = i;
						posy = j;
					}
				}
			}
		}
		else if (dificultad == "medium"){
			int min_op_score = 64;
			for (int i = 0; i < 8; ++i) {
				for (int j = 0; j < 8; ++j) {
					if (super.valid_move(b, i, j, black) > 0) {
						Board new_b = new Board(b);
						b.set_square(i, j, !black);
						int max_score = 0;
						for (int k = 0; k < 8; ++k) {
							for (int l = 0; l < 8; ++l) {
								int score = super.valid_move(new_b, k, l, !black);
								if (max_score < score) {
									max_score = score;
								}
							}
						}
						if (max_score < min_op_score) {
							min_op_score = max_score;
							posx = i;
							posy = j;
						}
					}
				}
			}
		}
		else {
			int min_op_score = 64;
			Boolean corner = false;
			Boolean border = false;
			Boolean center = false;
			Boolean C = false;

			//bucle para examinar las esquinas
			for (int i = 0; i < 8; i += 7) {
				for (int j = 0; j < 8; j += 7) {
					if (super.valid_move(b, i, j, black) > 0) {
						corner = true;
						Board new_b = new Board(b);
						b.set_square(i, j, !black);
						int max_score = 0;
						for (int k = 0; k < 8; ++k) {
							for (int l = 0; l < 8; ++l) {
								int score = super.valid_move(new_b, k, l, !black);
								if (max_score < score) {
									max_score = score;
								}
							}
						}
						if (max_score < min_op_score) {
							min_op_score = max_score;
							posx = i;
							posy = j;
						}
					}
				}
			}

			//bucles para examinar los borders excepto las casillas C
			if (!corner){
				for (int i = 2; i < 6; ++i) {
					for (int j = 0; j < 8; j += 7) {
						if (super.valid_move(b, i, j, black) > 0) {
							border = true;
							Board new_b = new Board(b);
							b.set_square(i, j, !black);
							int max_score = 0;
							for (int k = 0; k < 8; ++k) {
								for (int l = 0; l < 8; ++l) {
									int score = super.valid_move(new_b, k, l, !black);
									if (max_score < score) {
										max_score = score;
									}
								}
							}
							if (max_score < min_op_score) {
								min_op_score = max_score;
								posx = i;
								posy = j;
							}
						}
					}
				}
				for (int j = 2; j < 6; ++j) {
					for (int i = 0; i < 8; i += 7) {
						if (super.valid_move(b, i, j, black) > 0) {
							border = true;
							Board new_b = new Board(b);
							b.set_square(i, j, !black);
							int max_score = 0;
							for (int k = 0; k < 8; ++k) {
								for (int l = 0; l < 8; ++l) {
									int score = super.valid_move(new_b, k, l, !black);
									if (max_score < score) {
										max_score = score;
									}
								}
							}
							if (max_score < min_op_score) {
								min_op_score = max_score;
								posx = i;
								posy = j;
							}
						}
					}
				}
			}

			//bucle para examinar las casillas centrales excepto las casillas X
			if (!border) {
				for (int i = 1; i < 7; ++i) {
					for (int j = 1; j < 7; ++j) {
						if ( !(i == 1 && j == 1) && !(i == 1 && j == 6) && !(i == 6 && j == 1) && !(i == 6 && j == 6)) {
							if (super.valid_move(b, i, j, black) > 0) {
								center = true;
								Board new_b = new Board(b);
								b.set_square(i, j, !black);
								int max_score = 0;
								for (int k = 0; k < 8; ++k) {
									for (int l = 0; l < 8; ++l) {
										int score = super.valid_move(new_b, k, l, !black);
										if (max_score < score) {
											max_score = score;
										}
									}
								}
								if (max_score < min_op_score) {
									min_op_score = max_score;
									posx = i;
									posy = j;
								}
							}
						}
					}
				}
			}

			//bucles para examinar las casillas C
			if (!center) {
				for (int i = 0; i < 8; i += 7) {
					for (int j = 1; j < 7; j += 5) {
						if (super.valid_move(b, i, j, black) > 0) {
							C = true;
							Board new_b = new Board(b);
							b.set_square(i, j, !black);
							int max_score = 0;
							for (int k = 0; k < 8; ++k) {
								for (int l = 0; l < 8; ++l) {
									int score = super.valid_move(new_b, k, l, !black);
									if (max_score < score) {
										max_score = score;
									}
								}
							}
							if (max_score < min_op_score) {
								min_op_score = max_score;
								posx = i;
								posy = j;
							}
						}
					}
				}
				for (int j = 0; j < 8; j += 7) {
					for (int i = 1; i < 7; i += 5) {
						if (super.valid_move(b, i, j, black) > 0) {
							C = true;
							Board new_b = new Board(b);
							b.set_square(i, j, !black);
							int max_score = 0;
							for (int k = 0; k < 8; ++k) {
								for (int l = 0; l < 8; ++l) {
									int score = super.valid_move(new_b, k, l, !black);
									if (max_score < score) {
										max_score = score;
									}
								}
							}
							if (max_score < min_op_score) {
								min_op_score = max_score;
								posx = i;
								posy = j;
							}
						}
					}
				}
			}

			if (!C) {
				for (int i = 1; i < 7; i += 5) {
					for (int j = 1; j < 7; j += 5) {
						if (super.valid_move(b, i, j, black) > 0) {
							Board new_b = new Board(b);
							b.set_square(i, j, !black);
							int max_score = 0;
							for (int k = 0; k < 8; ++k) {
								for (int l = 0; l < 8; ++l) {
									int score = super.valid_move(new_b, k, l, !black);
									if (max_score < score) {
										max_score = score;
									}
								}
							}
							if (max_score < min_op_score) {
								min_op_score = max_score;
								posx = i;
								posy = j;
							}
						}
					}
				}
			}
		}

		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
		b.set_square(posx, posy, !black);
		draw_button(btn, b);
		if (!b.gameEnded(!turn)){
			System.out.print("Other player makes move");
			if(turn){
				player.make_move(b, false, primaryStage, btn, this, !turn,stats,roundstat,turnstat,scorestat,saveexit,exit,gridPaneC);
			}
			else{
				player.make_move(b, true, primaryStage, btn, this, !turn,stats,roundstat,turnstat,scorestat,saveexit,exit,gridPaneC);
			}
		}
	}
	
}
