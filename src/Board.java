public class Board {

	Square [][] board;
	
	Boolean modifying = false;

	int w_score;
	int b_score;
	
	public Board(){
		System.out.println("Game Started!");
		board = new Square[8][8];
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j){
				board[i][j] = new Square();	
			}
		}

	}
	
	//constructor copia
	public Board(Board b) {
		this.board = b.board;
		this.modifying = b.modifying;
		this.b_score = b.b_score;
		this.w_score = b.w_score;
	}
	
	public void init_board() {
		//inicializa el tablero con las cuatro casillas centrales
		
		for (int i = 3; i < 5; ++i) {
			for (int j = 3; j < 5; ++j){
				if (i == j)board[i][j].setContent(Square.Content.BLACK);
				else board[i][j].setContent(Square.Content.WHITE);
			}
		}
		w_score = 2;
		b_score = 2;
	}

	public void printBoard() {
		for (int i = 0; i < 8; ++i) {
			System.out.print("|");
			for (int j = 0; j < 8; ++j){
				if (board[i][j].getContent() == Square.Content.BLACK){
					System.out.print("X");
				}
				else if(board[i][j].getContent() == Square.Content.WHITE){
					System.out.print("O");
				}
				else if (board[i][j].getContent() == Square.Content.EMPTY){
					System.out.print(" ");
				}
				System.out.print("|");
			}
			System.out.println("");
		}
	}

	public Boolean gameEnded(Boolean otherplayercolor) {
		Player Tester;
		Tester = new PlayerIA("Tester", "easy");
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j){
				if (Tester.valid_move(this, i, j, !otherplayercolor) != 0){
					return false;
				}
			}
		}
		System.out.print("Game Ended No Empty Squares, GG!");
		return true;
	}
	
	public int get_white_score() {
		//retorna la puntuacion del jugador de las blancas
		return w_score;
	}
	
	public int get_black_score() {
		//retorna la puntuacion del jugador de las negras
		return b_score;
	}
	
	
	public void change_square(int i, int j) {
		//Cada vez que seleccionemos una casilla cambiar� ciclicamente.
		
		if(modifying) {
			switch(board[i][j].content) {
			
			case EMPTY:
				board[i][j].setContent(Square.Content.WHITE);
				break;
				
			case WHITE:
				board[i][j].setContent(Square.Content.BLACK);
				break;
				
			case BLACK:
				board[i][j].setContent(Square.Content.EMPTY);
				break;
			
			case POSSIBLE:
				break;
			}		
		}
		calc_score();
	}

	
	
	
	
	public int conquering(int i, int j, int inci, int incj, int x, Boolean white) {
		//algoritmo que coloca fichas en las casillas pertinentes
		
		if (i < 0 || j < 0 || i > 7 || j > 7 || board[i][j].content == Square.Content.EMPTY || board[i][j].content == Square.Content.POSSIBLE) return 0;
		else {	
			if (board[i][j].content == Square.Content.WHITE && white) return x;
			else if (board[i][j].content == Square.Content.BLACK && !white) return x;
			else {
				x = conquering(i + inci, j + incj, inci, incj, x + 1, white);
				if (white && x > 0)board[i][j].setContent(Square.Content.WHITE);
				else if (x > 0)board[i][j].setContent(Square.Content.BLACK);
				return conquering(i + inci, j + incj, inci, incj, x + 1, white);
			
			}
		}
	}
	
	public Boolean set_square(int i, int j, Boolean white) {
		//coloca una ficha en una casilla
		
		if (board[i][j].content != Square.Content.POSSIBLE) return false;
		
		if (white)board[i][j].setContent(Square.Content.BLACK);
		else board[i][j].setContent(Square.Content.WHITE);
		
		//un conquering para cada direccion
		conquering(i+1, j, 1, 0, 1, !white);
		conquering(i+1, j+1, 1, 1, 1, !white);
		conquering(i, j+1, 0, 1, 1, !white);
		conquering(i-1, j+1, -1, 1, 1, !white);
		conquering(i-1, j, -1, 0, 1, !white);
		conquering(i-1, j-1, -1, -1, 1, !white);
		conquering(i, j-1, 0, -1, 1, !white);
		conquering(i+1, j-1, 1, 0, 1, !white);
		calc_pos(white);
		calc_score();
		return true; 
	}
	
	public void search(int i, int j, int inci, int incj, Boolean white, Boolean path) {
		//algoritmo de busqueda de casillas posibles		
		
		if (i < 0 || j < 0 || i > 7 || j > 7) return;
		else {	
			if (board[i][j].content == Square.Content.EMPTY && path) { 
				
				board[i][j].setContent(Square.Content.POSSIBLE);
				return;
			}
			else if (board[i][j].content == Square.Content.EMPTY && !path) return;
			else if (board[i][j].content == Square.Content.POSSIBLE) return;
			else if (board[i][j].content == Square.Content.WHITE && white) return;
			else if (board[i][j].content == Square.Content.BLACK && !white) return;
			else {

				search(i + inci, j + incj, inci, incj, white, true);
			}
		}
		return;
	}
	
	public void calc_pos(Boolean white) {
		//calcula las casillas posibles
		
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
			
				if (board[i][j].content == Square.Content.POSSIBLE) board[i][j].setContent(Square.Content.EMPTY);
			}
		}
		
		Square.Content act;
		if(white) act = Square.Content.WHITE;
		else act = Square.Content.BLACK;
			
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				
				if (board[i][j].content == act) {

					search(i, j+1, 0, 1, white, false);
					search(i+1, j+1, 1, 1, white, false);
					search(i+1, j, 1, 0, white, false);
					search(i+1, j-1, 1, -1, white, false);
					search(i, j-1, 0, -1, white, false);
					search(i-1, j-1, -1, -1, white, false);
					search(i-1, j, -1, 0, white, false);
					search(i-1, j+1, -1, 1, white, false);				
				}
			}
		}
	}
	
	public void calc_score() {
		//calcula las puntuaciones de cada jugador
		
		b_score = 0;
		w_score = 0;
		
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
			
				if (board[i][j].content == Square.Content.BLACK) ++b_score;
				else if (board[i][j].content == Square.Content.WHITE) ++w_score;
			}
		}
	}
	
}
