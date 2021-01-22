package ethos.model.content;

import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.net.discord.DiscordMessager;
import ethos.util.Misc;

public class GambleJar {
	
	public static void execute(Player c) {
		
		int pet = Misc.random(19);
		
		if (!c.getItems().playerHasItem(22106) && !c.getItems().playerHasItem(12936) && !c.getItems().playerHasItem(13245) && !c.getItems().playerHasItem(12885) && !c.getItems().playerHasItem(13277) && !c.getItems().playerHasItem(12007) && !c.getItems().playerHasItem(19701)) {
			c.sendMessage("You do not have any jars to gamble");
			return;
		}
	
	if (c.getItems().playerHasItem(19701, 1)) {
		c.getItems().deleteItem(19701, 1);
		if (pet == 0) {
			c.getItems().addItem(21273, 1);
			PlayerHandler.executeGlobalMessage("[@red@PET@bla@] @cr20@" + c.playerName + " received a pet from gambling the jar of darkness!");
			DiscordMessager.sendLootations("[PET] " + c.playerName + " received a pet from gambling the jar of darkness!");
		}
		
		} if (c.getItems().playerHasItem(12007)) {
		c.getItems().deleteItem(12007, 1);
		if (pet == 0) {
			c.getItems().addItem(12655, 1);
			PlayerHandler.executeGlobalMessage("[@red@PET@bla@] @cr20@" + c.playerName + " received a pet from gambling the jar of dirt!");
			DiscordMessager.sendLootations("[PET] " + c.playerName + " received a pet from gambling the jar of dirt!");
		}
	
		} if (c.getItems().playerHasItem(13277)) {
		c.getItems().deleteItem(13277, 1);
		if (pet == 0) {
			c.getItems().addItem(13262, 1);
			PlayerHandler.executeGlobalMessage("[@red@PET@bla@] @cr20@" + c.playerName + " received a pet from gambling the jar of miasma!");
			DiscordMessager.sendLootations("[PET] " + c.playerName + " received a pet from gambling the jar of miasma!");
		}
	
		} if (c.getItems().playerHasItem(12885)) {
		c.getItems().deleteItem(12885, 1);
		if (pet == 0) {
			c.getItems().addItem(12647, 1);
			PlayerHandler.executeGlobalMessage("[@red@PET@bla@] @cr20@" + c.playerName + " received a pet from gambling the jar of sand!");
			DiscordMessager.sendLootations("[PET] " + c.playerName + " received a pet from gambling the jar of sand!");
		}
	
		} if (c.getItems().playerHasItem(13245)) {
		c.getItems().deleteItem(13245, 1);
		if (pet == 0) {
			c.getItems().addItem(13247, 1);
			PlayerHandler.executeGlobalMessage("[@red@PET@bla@] @cr20@" + c.playerName + " received a pet from gambling the jar of souls!");
			DiscordMessager.sendLootations("[PET] " + c.playerName + " received a pet from gambling the jar of souls!");
		}
	
		} if (c.getItems().playerHasItem(12936)) {
		c.getItems().deleteItem(12936, 1);
		if (pet == 0) {
			c.getItems().addItem(12921, 1);
			PlayerHandler.executeGlobalMessage("[@red@PET@bla@] @cr20@" + c.playerName + " received a pet from gambling the jar of swamp!");
			DiscordMessager.sendLootations("[PET] " + c.playerName + " received a pet from gambling the jar of swamp!");
		}
		
		} if (c.getItems().playerHasItem(22106)) {
			c.getItems().deleteItem(22106, 1);
			if (pet == 0) {
				c.getItems().addItem(21992, 1);
				PlayerHandler.executeGlobalMessage("[@red@PET@bla@] @cr20@" + c.playerName + " received a pet from gambling the jar of decay!");
				DiscordMessager.sendLootations("[PET] " + c.playerName + " received a pet from gambling the jar of decay!");
				}
		
		} else {
			c.sendMessage("Sorry but you did not win anything this time.");
			return;
		}
	}
}