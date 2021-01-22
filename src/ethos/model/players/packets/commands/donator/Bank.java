package ethos.model.players.packets.commands.donator;

import java.util.concurrent.TimeUnit;

import ethos.model.players.Player;
import ethos.model.players.Right;
import ethos.model.players.RightGroup;
import ethos.model.players.packets.commands.Command;

/**
 * Open the banking interface.
 * 
 * @author Emiel
 */
public class Bank extends Command {

	@Override
	public void execute(Player c, String input) {
		long delay = getDelay(c);
		if (System.currentTimeMillis() - c.lastBank < delay) {
			c.sendMessage("You must wait another " + TimeUnit.MILLISECONDS.toSeconds(c.lastBank + delay - System.currentTimeMillis()) + " seconds before you can bank again.");
			return;
		} else {
		c.sendAudio(1877);
		c.getPA().openUpBank();
	}
}

		private long getDelay(Player player) {
			RightGroup rights = player.getRights();

			if (rights.isOrInherits(Right.MODERATOR)) {
				return 0;
			}
			if (rights.contains(Right.LEGENDARY) || rights.contains(Right.HELPER)) {
				return TimeUnit.SECONDS.toMillis(1);
			} else if (rights.contains(Right.EXTREME_DONATOR)) {
				return TimeUnit.SECONDS.toMillis(1);
			} else if (rights.contains(Right.SUPER_DONATOR)) {
				return TimeUnit.SECONDS.toMillis(30);
			} else if (rights.contains(Right.DONATOR)) {
				return TimeUnit.SECONDS.toMillis(60);
			} else if (rights.contains(Right.SUPPORTER)) {
				return TimeUnit.SECONDS.toMillis(60);
			} else if (rights.contains(Right.SPONSOR)) {
				return TimeUnit.SECONDS.toMillis(60);
			} else if (rights.contains(Right.CONTRIBUTOR) || 
						rights.contains(Right.HITBOX) || 
						rights.contains(Right.YOUTUBER)) {
				return TimeUnit.SECONDS.toMillis(60);
			} else {
				return TimeUnit.SECONDS.toMillis(60);
			}
		}
	}
