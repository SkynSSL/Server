package ethos.model.players.packets.objectoptions.impl;

import ethos.model.players.Boundary;
import ethos.model.players.Player;

public class Raid2Objects {
	
	public static boolean clickObject1(Player player, int objectId, int objX, int objY) {
		
		/*if (!Boundary.isIn(player, Boundary.RAID_MAIN)) {
			return false;
		}*/
		if (objectId == 4954) {
			if (objX == 3179 && objY == 4447) {
				player.getPA().movePlayer(3280, 4312, 0);
			}
		}
		
		if (objectId == 32755) {
			if (objX == 3185 && objY == 4445) {
				player.getPA().movePlayer(3183, 4446, 0);
			} else if (objX == 3185 && objY == 4446) {
				player.getPA().movePlayer(3183, 4446, 0);
			} else if (objX == 3185 && objY == 4447) {
				player.getPA().movePlayer(3183, 4446, 0);
			} else if (objX == 3185 && objY == 4448) {
				player.getPA().movePlayer(3183, 4446, 0);
			} else if (objX == 3278 && objY == 4307) {
				player.getPA().movePlayer(3295, 4253, 0);
			} else if (objX == 3279 && objY == 4307) {
				player.getPA().movePlayer(3295, 4253, 0);
			} else if (objX == 3280 && objY == 4307) {
				player.getPA().movePlayer(3295, 4253, 0);
			} else if (objX == 3281 && objY == 4307) {
				player.getPA().movePlayer(3295, 4253, 0);
			} else if (objX == 3296 && objY == 4255) {
				player.getPA().movePlayer(3170, 4381, 1);
			} else if (objX == 3295 && objY == 4255) {
				player.getPA().movePlayer(3170, 4381, 1);
			} else if (objX == 3169 && objY == 4379) {
				player.getPA().movePlayer(3168, 4305, 1);
			} else if (objX == 3170 && objY == 4379) {
				player.getPA().movePlayer(3168, 4305, 1);
			} else if (objX == 3171 && objY == 4379) {
				player.getPA().movePlayer(3168, 4305, 1);
			}
		}
		
		player.sendMessage("Clicked "+objectId+" at "+objX+", "+objY+"");
		return false;
	}
}