package ethos.model.players.packets.commands.all;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class Points extends Command {

	@Override
	public void execute(Player c, String input) {
	    	if (c.inRaids()) {
	    	int points = c.getRaidPoints();
	    	c.sendMessage("@blu@Current Raid Points: @red@"+points);
	    	} else {
	    		c.sendMessage("@red@You are not in raids!");
	    }
	}
}
