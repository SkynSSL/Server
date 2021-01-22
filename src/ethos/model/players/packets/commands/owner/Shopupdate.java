package ethos.model.players.packets.commands.owner;


import ethos.Server;
import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;
import ethos.world.ShopHandler;

/**
 * Update the shops.
 * 
 * @author Emiel
 *
 */
public class Shopupdate extends Command {

	@Override
	public void execute(Player player, String input) {
		Server.shopHandler = new ShopHandler();
	}
}
