package ethos.model.players.packets.commands.all;

import java.util.Optional;

import org.apache.commons.lang3.text.WordUtils;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;
import ethos.net.discord.DiscordMessager;

/**
 * Opens the help interface.
 * 
 * @author Emiel
 */
public class Help extends Command {

	@Override
	public void execute(Player c, String input) {
		c.getPA().closeAllWindows();
		c.getPA().showInterface(59525);
		DiscordMessager.sendStaffMessage(WordUtils.capitalize(c.playerName) + " is stuck, get on and help their asses!!!");
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Creates a help ticket");
	}

}
