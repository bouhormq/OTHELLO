import java.util.ArrayList;
import java.util.Collections;

public class RankingGlobal {
	
	private ArrayList<String> ranking_name;
	private ArrayList<Integer> ranking_score;	

	public ArrayList<String> getRanking_name() {
		return ranking_name;
	}

	public void setRanking_name(ArrayList<String> ranking_name) {
		this.ranking_name = ranking_name;
	}

	public ArrayList<Integer> getRanking_score() {
		return ranking_score;
	}

	public void setRanking_score(ArrayList<Integer> ranking_score) {
		this.ranking_score = ranking_score;
	}
	
	public int setPlayerRanking(String player, int score, int position) {
		if (score == 0) {
			ranking_name.add(player);
			ranking_score.add(0);
			return ranking_name.size() + 1;
		}
		else {
			ranking_name.remove(position);
			ranking_score.remove(position);
			int index = Collections.binarySearch(ranking_score, score, Collections.reverseOrder());
			if (index >= 0) {
				index += 1;
			}
			else {
				index = -1 - index;
			}
			ranking_score.add(index, score);
			ranking_name.add(index, player);
			return index + 1;
		}
	}
}
