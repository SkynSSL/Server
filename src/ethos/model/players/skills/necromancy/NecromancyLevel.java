package ethos.model.players.skills.necromancy;

import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.net.discord.DiscordMessager;
import ethos.util.Misc;

public class NecromancyLevel {

	public static void main(Player c) {

		if (c.nxp >= 0 && c.nxp < 50) {
			c.change = 1;
			if (c.change != c.nlevel) {
				c.sendMessage("Congratulations, you just advanced a Necromancy level");
			}
            c.nlevel = 1;
        } else if (c.nxp >= 50 && c.nxp  < 150) {
        	c.change = 2;
			if (c.change != c.nlevel) {
				c.sendMessage("Congratulations, you just advanced a Necromancy level");
			}
            c.nlevel = 2;
        } else if (c.nxp  >= 150 && c.nxp < 300) {
        	c.change = 3;
			if (c.change != c.nlevel) {
				c.sendMessage("Congratulations, you just advanced a Necromancy level");
			}
            c.nlevel = 3;
        } else if (c.nxp >= 300 && c.nxp< 550) {
			c.change = 4;
			if (c.change != c.nlevel) {
				c.sendMessage("Congratulations, you just advanced a Necromancy level");
			}
            c.nlevel = 4;
        } else if (c.nxp >= 550 && c.nxp < 800) {
			c.change = 5;
			if (c.change != c.nlevel) {
				c.sendMessage("Congratulations, you just advanced a Necromancy level");
			}
            c.nlevel = 5;
        } else if (c.nxp >= 800 && c.nxp < 1200) {
			c.change = 6;
			if (c.change != c.nlevel) {
				c.sendMessage("Congratulations, you just advanced a Necromancy level");
			}
            c.nlevel = 6;
        } else if (c.nxp >= 1200 && c.nxp < 2000) {
			c.change = 7;
			if (c.change != c.nlevel) {
				c.sendMessage("Congratulations, you just advanced a Necromancy level");
			}
            c.nlevel = 7;
        } else if (c.nxp >= 2000 && c.nxp < 3500) {
			c.change = 8;
			if (c.change != c.nlevel) {
				c.sendMessage("Congratulations, you just advanced a Necromancy level");
			}
            c.nlevel = 8;
        } else if (c.nxp >= 3500 && c.nxp < 6200) {
			c.change = 9;
			if (c.change != c.nlevel) {
				c.sendMessage("Congratulations, you just advanced a Necromancy level");
			}
            c.nlevel = 9;
        } else if (c.nxp >= 6200) {
			c.change = 10;
			if (c.change != c.nlevel) {
				c.sendMessage("Congratulations, you just advanced a Necromancy level");
				PlayerHandler.executeGlobalMessage(
						"<img=10>[@blu@News@bla@] " + "@red@" + Misc.capitalize(c.playerName) + " @bla@has reached level 10 Necromancy!");
				DiscordMessager.sendPrestige("[News] " + Misc.capitalize(c.playerName) + " has reached level 10 Necromancy!");
			}
            c.nlevel = 10;
        }
		if (c.nxp >= 7000) {
			c.nxp = 7000;
		}
	}
}
