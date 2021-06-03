import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;  
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;


public class GuardarPartida {

	String player1;
	int scoreb;
	String player2;
	int scorew;
	int round;
	Board b = new Board();
	
	public void guardar(String player1, String player2, Integer round, Board b, Integer scoreb, Integer scorew) {
		
		java.util.Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmm");
		String now = formatter.format(date);
		String filename = player1 + "-" + player2 + "-" + now + ".txt";
		String filepath = "saves//";
		
		File folder = new File(filepath);
		folder.mkdir();
		
		
	    try {  
	      File save = new File(filepath , filename); 
		  System.out.println("Path: " + save.getAbsolutePath()); 
	      if (save.createNewFile()) {  
	    	  FileWriter writer = new FileWriter(filepath + filename);
	    	  
	          writer.write("Player1: " + player1);
	          writer.write(System.getProperty( "line.separator" ));
	          
	          writer.write("ScoreB: " + scoreb);
	          writer.write(System.getProperty( "line.separator" ));

	          writer.write("Player2: " + player2);
	          writer.write(System.getProperty( "line.separator" ));
	          
	          writer.write("ScoreW: " + scorew);
	          writer.write(System.getProperty( "line.separator" ));
	          
	          writer.write("Round: " + round);
	          writer.write(System.getProperty( "line.separator" ));
	          writer.write(System.getProperty( "line.separator" ));
	          
	          writer.write("Board: ");
	          writer.write(System.getProperty( "line.separator" ));
	          
	          for (int i = 0; i < 8; ++i) {
	        	  for (int j = 0; j < 8; ++j) {
	        		  
	        		  if(b.board[i][j].content == Square.Content.EMPTY) writer.write("0");
	        		  else if(b.board[i][j].content == Square.Content.BLACK) writer.write("B");
	        		  else if(b.board[i][j].content == Square.Content.WHITE) writer.write("W");
	        		  else if(b.board[i][j].content == Square.Content.POSSIBLE) writer.write("P");
	        	  }
		          writer.write(System.getProperty( "line.separator" ));
	          }
	          
	          writer.close();
	      } 
	      else {  
	        System.out.println("File already exists.");  
	      }  
	    } 
	    
	    catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();  
	    }  
	}
	
	public void cargar(String filename) {
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line =  br.readLine()) != null){
				
				if (line.contains("Player1: ")) {
			        player1 = line.split(":")[1].trim();
			        System.out.println(player1);
			    }
				
				else if (line.contains("ScoreB: ")) {
					
			        String aux = line.split(":")[1].trim();
					scoreb = java.lang.Integer.parseInt(aux);
					System.out.println(scoreb);
			    }
				
				else if (line.contains("Player2: ")) {
					
			        player2 = line.split(":")[1].trim();
			        System.out.println(player2);
			    }
				
				else if (line.contains("ScoreW: ")) {
					
			        String aux = line.split(":")[1].trim();
					scorew = java.lang.Integer.parseInt(aux);
					System.out.println(scorew);
			    }
				
				else if (line.contains("Round: ")) {
					
			        String aux = line.split(":")[1].trim();
					round = java.lang.Integer.parseInt(aux);
					System.out.println(round);
			    }
				
				else if (line.contains("Board: ")) {
										
					for (int i = 0; i < 8; ++i) {
						line =  br.readLine();
			        	for (int j = 0; j < 8; ++j) {
			        		  
			        		if(line.charAt(j) == '0') b.board[i][j].setContent(Square.Content.EMPTY);
			        		else if(line.charAt(j) == 'B') b.board[i][j].setContent(Square.Content.BLACK);
			        		else if(line.charAt(j) == 'W') b.board[i][j].setContent(Square.Content.WHITE);
			        		else if(line.charAt(j) == 'P') b.board[i][j].setContent(Square.Content.POSSIBLE);
			        	}
			        }
					b.printBoard();
				}
				
			}
			br.close();
		}
		
		catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
}
