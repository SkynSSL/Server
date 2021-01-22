package ethos.model.minigames;

import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.util.Misc;

/**
 * @author Sanity
 */

public class FightPits {

	private int[] playerInPits = new int[200];

	private int GAME_TIMER = 140;
	private int GAME_START_TIMER = 40;

	private int gameTime = -1;
	private int gameStartTimer = 30;
	private int properTimer = 0;
	private int playersRemaining = 0;

	private String pitsChampion = "Nobody";

	public void process() {
		if (properTimer > 0) {
			properTimer--;
			return;
		} else {
			properTimer = 4;
		}
		if (gameStartTimer > 0) {
			gameStartTimer--;
			updateWaitRoom();
		}
		if (gameStartTimer == 0) {
			startGame();
		}
		if (gameTime > 0) {
			gameTime--;
			if (playersRemaining == 1)
				endPitsGame(getLastPlayerName());
		} else if (gameTime == 0)
			endPitsGame("Nobody");
	}

	private String getLastPlayerName() {
		for (int j = 0; j < playerInPits.length; j++) {
			if (playerInPits[j] > 0)
				return PlayerHandler.players[playerInPits[j]].playerName;
		}
		return "Nobody";
	}

	private void updateWaitRoom() {
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				Player c = PlayerHandler.players[j];
				if (c.getPA().inPitsWait()) {
					c.getPA().sendFrame126("Next Game Begins In : " + ((gameStartTimer * 3) + (gameTime * 3)) + " seconds.", 6570);
					c.getPA().sendFrame126("Champion: " + pitsChampion, 6572);
					c.getPA().sendFrame126("", 6664);
					c.getPA().walkableInterface(6673);
				}
			}
		}
	}

	private void startGame() {
		if (getWaitAmount() < 2) {
			gameStartTimer = GAME_START_TIMER / 2;
			// System.out.println("Unable to start fight pits game due to lack of players.");
			return;
		}
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				Player c = PlayerHandler.players[j];
				if (c.getPA().inPitsWait())
					addToPitsGame(j);
			}
		}
		System.out.println("Fight Pits game started.");
		gameStartTimer = GAME_START_TIMER + GAME_TIMER;
		gameTime = GAME_TIMER;
	}

	private int getWaitAmount() {
		int count = 0;
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				Player c = PlayerHandler.players[j];
				if (c.getPA().inPitsWait())
					count++;
			}
		}
		return count;
	}

	public void removePlayerFromPits(int playerId) {
		for (int j = 0; j < playerInPits.length; j++) {
			if (playerInPits[j] == playerId) {
				Player c = PlayerHandler.players[playerInPits[j]];
				c.getPA().movePlayer(2399, 5173, 0);
				playerInPits[j] = -1;
				playersRemaining--;
				c.inPits = false;
				break;
			}
		}
	}

	private void endPitsGame(String champion) {
		for (int j = 0; j < playerInPits.length; j++) {
			if (playerInPits[j] < 0)
				continue;
			if (PlayerHandler.players[playerInPits[j]] == null)
				continue;
			Player c = PlayerHandler.players[playerInPits[j]];
			c.getPA().movePlayer(2399, 5173, 0);
			c.inPits = false;
		}
		playerInPits = new int[200];
		pitsChampion = champion;
		playersRemaining = 0;
		pitsSlot = 0;
		gameStartTimer = GAME_START_TIMER;
		gameTime = -1;
		System.out.println("Fight Pits game ended.");
	}

	private int pitsSlot = 0;

	private void addToPitsGame(int playerId) {
		if (PlayerHandler.players[playerId] == null)
			return;
		playersRemaining++;
		Player c = PlayerHandler.players[playerId];
		c.getPA().walkableInterface(-1);
		playerInPits[pitsSlot++] = playerId;
		c.getPA().movePlayer(2392 + Misc.random(12), 5139 + Misc.random(25), 0);
		c.inPits = true;
	}
}