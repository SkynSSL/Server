package ethos.model.players.packets.commands.all;

import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.model.players.packets.commands.Command;
import ethos.util.Misc;

/**
 * Auto Donation System / https://EverythingRS.com
 * @author Genesis
 *
 */

public class Claim extends Command {

	@Override
	public void execute(Player player, String input) {
		new java.lang.Thread() {
			public void run() {
				try {
					com.everythingrs.donate.Donation[] donations = com.everythingrs.donate.Donation
							.donations("el6GAR8F0Ay61qxZFYi7nbnnYNtdYxTj22vrT6uxJWFQRlXMnKlON1fszKZnmRdZrqrwCBzw", player.playerName);
					if (donations.length == 0) {
						player.sendMessage("You currently don't have any items waiting. You must donate first!");
						return;
					}
					if (donations[0].message != null) {
						player.sendMessage(donations[0].message);
						return;
					}
					for (com.everythingrs.donate.Donation donate : donations) {
						player.getItems().addItem(donate.product_id, donate.product_amount);
					}
					PlayerHandler.executeGlobalMessage("[@red@DONATE@bla@] Thank you @red@ " + Misc.capitalize(player.playerName) + " @bla@for donating!");
				} catch (Exception e) {
					player.sendMessage("Api Services are currently offline. Please check back shortly");
					e.printStackTrace();
				}
			}
		}.start();
	}

}