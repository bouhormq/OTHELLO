public class RankingPersonal {
	
	private String player;
	private int position;
	private int score;
	
	public RankingPersonal(String p, RankingGlobal r) {
		player = p;
		score = 0;
		position = r.setPlayerRanking(player, score, position);
	}
	
	public String getPlayer() {
		return player;
	}
	
	public void setPlayer(String p) {
		player = p;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s, RankingGlobal r) {
		if (s > score) {
			score = s;
			position = r.setPlayerRanking(player, s, position);
		}
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int p) {
		position = p;
	}
}
