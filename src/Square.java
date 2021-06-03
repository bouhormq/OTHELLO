public class Square {

		public enum Content{
			
			EMPTY, BLACK, WHITE, POSSIBLE;
		}
		
		Boolean empty = true;
		Content content = Content.EMPTY;
		
		public void setContent(Content c) {
			
			switch(c) {
			case BLACK:
				if (empty) empty = false;
				content = Content.BLACK;
				break;
			
			case WHITE:
				if (empty) empty = false;
				content = Content.WHITE;
				break;
				
			case POSSIBLE:
				content = Content.POSSIBLE;
				break;
			
			case EMPTY:
				if (!empty) empty = true;
				content = Content.EMPTY;
				break;		
			}
			
		}
		
		public Content getContent() {
			
			return content; //retorna el contenido de la casilla
		}
		
		public Boolean isEmpty() {
			
			return empty; //retorna cierto si la casilla esta vacia
		}
}
