import static org.junit.Assert.*;
import org.junit.Test;

public class OthelloTest {

	Othello othello = new Othello();
	@Test
	public void start() {
        assertNull(othello.estado);
		assertNull(othello.nivel1);
		assertNull(othello.modoJuego);
		assertNull(othello.tipoPartida);
		assertNull(othello.ranking);
		assertNull(othello.nameplayer1);
		assertNull(othello.nameplayer2);
	}
}
