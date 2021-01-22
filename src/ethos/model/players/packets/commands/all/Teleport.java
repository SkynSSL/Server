package ethos.model.players.packets.commands.all;

import java.util.Optional;

import ethos.Config;
import ethos.Server;
import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

/**
 * Teleport the player to the mage bank.
 * 
 * @author Emiel
 */
public class Teleport extends Command {

	@Override
	public void execute(Player c, String input) {
		if (Server.getMultiplayerSessionListener().inAnySession(c)) {
			return;
		}
		if (c.teleTimer > 0) {
			return;
		} else if(c.wildLevel > Config.NO_TELEPORT_WILD_LEVEL) {
				c.sendMessage("You can't teleport above " + Config.NO_TELEPORT_WILD_LEVEL + " in the wilderness.");
				return;
				}
		c.getPA().showInterface(51000);
		c.getTeleport().selection(c, 0);
			}
		}
