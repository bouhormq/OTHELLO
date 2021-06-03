import java.util.Scanner;

public class BoardDriver {
	
	public static void main(String[] args) {
		
		String aux = "Hello";

		Board board = new Board();
		board.init_board();
		board.printBoard();
		System.out.println("Invoca la funcion junto a sus parametros, la funcion y cada parametro en lineas diferentes");
		System.out.println("Para acabar escribe: end");
		Scanner s = new Scanner(System.in);
		while (!aux.equals("end")) {
		
			System.out.println("Nombre de la funcion:");
			aux = s.nextLine();
			
			if (aux.equals("set_square")) {
				
				int x, y;
				String temp;
				Boolean white;
				
				System.out.println("Fila:");
				x = s.nextInt();
				System.out.println("Columna:");
				y = s.nextInt();
				
				System.out.println("Introduce una de las siguientes (blancas/negras)");
				temp = s.nextLine();
				
				if (temp == "blancas") white = true;
				else white = false;
				
				board.set_square(x,y,white);
				board.printBoard();
			}
			
			else if (aux.equals("calc_pos")) {
				
				Boolean white;
				String temp;
				
				System.out.println("Introduce una de las siguientes (blancas/negras)");
				temp = s.nextLine();
				
				if (temp == "blancas") white = true;
				else white = false;
				
				board.calc_pos(white);
				board.printBoard();
				
			}
			else if (aux.equals("change_square")) {
				
				int x, y;
				x = s.nextInt();
				y = s.nextInt();
				
				board.change_square(x,y);
				board.printBoard();
				
			}
			else if (aux.equals("gameEnded")) {
				if(board.gameEnded(true)) System.out.println("Game ended");
				else System.out.println("Game not ended");
			}
		}
		
		s.close();
	}
}
