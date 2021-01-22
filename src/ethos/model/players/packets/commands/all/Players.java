package ethos.model.players.packets.commands.all;

import org.apache.commons.lang3.text.WordUtils;

import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.model.players.Right;
import ethos.model.players.packets.commands.Command;
import ethos.util.Misc;

import java.util.Optional;

/**
 * Sends the player a message containing a list of all online staff members.
 * 
 * @author Emiel - Edit by Matt
 */
public class Players extends Command {

	@Override
	public void execute(Player c, String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < PlayerHandler.players.length; i++) {
			Player c2 = PlayerHandler.players[i];
			if (PlayerHandler.players[i] != null) {
				if (c2.getRights().isOrInherits(Right.PLAYER)) {
					int rights = c2.getRights().getPrimary().getValue() - 1;
					String line = String.format("%n");
					sb.append("<img="+rights+"> " + "<col=" + c2.getRights().getPrimary().getColor() + ">" + Misc.capitalize(c2.playerName)).append(line);
				}
			}
		}
		if (sb.length() > 0) {
			refresh(c);
			String result = sb.substring(0, sb.length());
			int counter = 8144;
			c.getPA().sendFrame126("                @dre@Players Online: " + PlayerHandler.getPlayerCount(), counter++);
			c.getPA().sendFrame126("", counter++);
				counter++; // 8146 is already being used
			String[] wrappedLines = WordUtils.wrap(result, 68).split(System.getProperty("line.separator"));
			for (String line : wrappedLines) {
			c.getPA().sendFrame126(line, counter++);
			
			c.getPA().showInterface(8134);
			}
		} else {
			c.sendMessage("@blu@There are currently no players online!");
		}
	}

	public void refresh(Player c) {
		c.getPA().sendFrame126("", 8147);
		c.getPA().sendFrame126("", 8148);
		c.getPA().sendFrame126("", 8149);
		c.getPA().sendFrame126("", 8150);
		c.getPA().sendFrame126("", 8151);
		c.getPA().sendFrame126("", 8152);
		c.getPA().sendFrame126("", 8153);
		c.getPA().sendFrame126("", 8154);
		c.getPA().sendFrame126("", 8155);
		c.getPA().sendFrame126("", 8156);
		c.getPA().sendFrame126("", 8157);
		c.getPA().sendFrame126("", 8158);
		c.getPA().sendFrame126("", 8159);
		c.getPA().sendFrame126("", 8160);
		c.getPA().sendFrame126("", 8161);
		c.getPA().sendFrame126("", 8162);
		c.getPA().sendFrame126("", 8163);
		c.getPA().sendFrame126("", 8164);
		c.getPA().sendFrame126("", 8165);
		c.getPA().sendFrame126("", 8166);
		c.getPA().sendFrame126("", 8177);
		c.getPA().sendFrame126("", 8178);
		c.getPA().sendFrame126("", 8179);
		c.getPA().sendFrame126("", 8180);
		c.getPA().sendFrame126("", 8181);
		c.getPA().sendFrame126("", 8182);
		c.getPA().sendFrame126("", 8183);
		c.getPA().sendFrame126("", 8184);
		c.getPA().sendFrame126("", 8185);
		c.getPA().sendFrame126("", 8186);
		c.getPA().sendFrame126("", 8187);
		c.getPA().sendFrame126("", 8188);
		c.getPA().sendFrame126("", 8189);
		c.getPA().sendFrame126("", 8190);
		c.getPA().sendFrame126("", 8191);
		c.getPA().sendFrame126("", 8192);
		c.getPA().sendFrame126("", 8193);
		c.getPA().sendFrame126("", 8194);
		c.getPA().sendFrame126("", 8194);
		c.getPA().sendFrame126("", 8195);
		c.getPA().sendFrame126("", 8196);
		c.getPA().sendFrame126("", 8197);
		c.getPA().sendFrame126("", 8198);
		c.getPA().sendFrame126("", 8199);
		c.getPA().sendFrame126("", 8200);
		c.getPA().sendFrame126("", 8201);
		
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Lists all players online");
	}

}
