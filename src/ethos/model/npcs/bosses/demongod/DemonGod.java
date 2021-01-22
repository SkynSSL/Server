package ethos.model.npcs.bosses.demongod;

import ethos.Server;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.players.Player;

public class DemonGod {

	public static void enterInstance(Player player, int instance) {
		CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container) {
					player.getPA().movePlayer(2898, 2793, player.getIndex() * 4);
					Server.npcHandler.spawnNpc(player, 6295, 2890, 2793, player.getIndex() * 4, 0, 1500, player.antifireDelay > 0 ? 0 : 45, 450, 76, true, false);
					container.stop();
			}
			@Override
			public void stop() {
			}
		}, 1);
	}
	
	public static boolean inGodDemon(Player player) {
		return (player.absX > 2884 && player.absX < 2912 && player.absY > 2782 && player.absY < 2805);
	}
}
