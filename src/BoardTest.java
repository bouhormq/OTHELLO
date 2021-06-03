import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {

	Board board = new Board();
	@Test
	public void init_board() {
		board.init_board();
	}
	
	@Test
	public void printBoard() {

		board.init_board();
		board.printBoard();
	}
	
	@Test
	public void gameEnded() {
		
		Boolean res;
		res = board.gameEnded(false);
		assertFalse(res);
	}
	
	@Test
	public void change_square() {
		
		board.modifying = true;
		
		board.change_square(1,1);
		assertEquals("Content is not WHITE" , Square.Content.WHITE, board.board[1][1].getContent() );
		board.change_square(1,1);
		assertEquals("Content is not BLACK", Square.Content.BLACK , board.board[1][1].getContent() );
		board.change_square(1,1);
		assertEquals("Content is not EMPTY", Square.Content.EMPTY , board.board[1][1].getContent() );
		
		board.modifying = false;
		
	}
	
	@Test
	public void calc_pos() {
		

		board.init_board();
		board.calc_pos(false);
		board.printBoard();
		assertEquals("Content is not POSSIBLE", Square.Content.POSSIBLE , board.board[3][5].getContent() );
	
	}
	
	@Test
	public void set_square() {
		

		board.init_board();
		board.set_square(3,5,false);
		board.printBoard();
		assertEquals("Conquering FAILED 1" , Square.Content.BLACK, board.board[3][4].getContent() );
		assertEquals("Conquering FAILED 2" , Square.Content.BLACK, board.board[3][5].getContent() );
	}	
	
}
