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
public class A extends Command {

	@Override
	public void execute(Player c, String input) {
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Turn on autocast");
	}

}
