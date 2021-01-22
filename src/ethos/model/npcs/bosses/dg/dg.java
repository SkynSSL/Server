package ethos.model.npcs.bosses.dg;

import ethos.model.npcs.NPC;
import ethos.model.npcs.NPCHandler;
import ethos.model.players.Player;

public class dg {
	
	public static int specialAmount = 0;
	
	public static void DgSpecial(Player player) {
		NPC Dg = NPCHandler.getNpc(6295);
		
		if (Dg.isDead) {
			return;
		}
		if (Dg.getHealth().getAmount() < 1400 ||
			Dg.getHealth().getAmount() < 1100 ||
			Dg.getHealth().getAmount() < 900 ||
			Dg.getHealth().getAmount() < 700 ||
			Dg.getHealth().getAmount() < 400 ||
			Dg.getHealth().getAmount() < 100) {
				Dg.startAnimation(5016);
				Dg.underAttackBy = -1;
				Dg.underAttack = false;
				NPCHandler.dgAttack = "SPECIAL";
				specialAmount++;
			}
		}
}