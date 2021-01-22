package ethos.model.npcs.bosses.vorkath;

import ethos.Server;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.npcs.NPC;
import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.net.discord.DiscordMessager;
import ethos.util.Misc;

public class Vorkath {

	public static int attackStyle = 0;

	public static int[][] commonDrops = { { 562, 700 + Misc.random(300) }, { 1754, 14 + Misc.random(18) }, { 1752, 11 + Misc.random(19) },
			{ 450, 10 + Misc.random(20) }, { 6694, 10 + Misc.random(20) }, { 1988, 25 + Misc.random(25) }, { 1514, 50 },
			{ 995, 500000 + Misc.random(1000000) }, { 11937, 5 + Misc.random(5) } };

	public static int[][] uncommonDrops = { { 21338, 27 + Misc.random(10) }, { 11230, 50 + Misc.random(100) }, { 21930, 55 + Misc.random(45) },
			{ 22118, 1 }, { 1377, 1 }, { 1305, 1 }, { 4087, 1 }, { 4585, 1 },
			{ 560, 300 + Misc.random(200) }, { 1750, 10 + Misc.random(15) }, { 1748, 5 + Misc.random(20) },
			{ 9189, 25 + Misc.random(10) }, { 9190, 25 + Misc.random(10) }, { 9191, 31 }, { 9192, 30 },
			{ 9193, 7 + Misc.random(21) }, { 9194, 5 + Misc.random(5) }, { 9194, 26 + Misc.random(4) },
			{ 824, 86 + Misc.random(14) }, { 11232, 10 + Misc.random(40) }, { 11237, 27 + Misc.random(23) },
			{ 1616, 1 + Misc.random(2) }, { 537, 7 + Misc.random(21) } };

	public static int[][] rareDrops = { { 11935, 10 + Misc.random(20) }, { 12696, 10 + Misc.random(20) }, { 19732, 1 }, { 11730, 2 }, { 537, 10 + Misc.random(30) }, { 6571, 1 },
			{ 452, 25 + Misc.random(10) }, { 2364, 25 + Misc.random(10) }, { 11937, 25 + Misc.random(10) }, { 1373, 1 }, { 560, 45 }, { 563, 45 }, { 561, 67 },
			{ 1392, 5 + Misc.random(10) } };

	public static int[][] veryRareDrops = { { 11286, 1 }, { 22006, 1 }, { 19550, 1 }, { 19547, 1 }, { 19553, 1 }, { 19544, 1 }, { 12783, 1 } };

	public static int[] lootCoordinates = { 2272, 4061 };

	public static void drop(Player player) {
		Server.itemHandler.createGroundItem(player, 22124, lootCoordinates[0], lootCoordinates[1], player.heightLevel,
				1, player.getIndex());
		int roll = Misc.random(400);
		int roll2 = Misc.random(100);
		int roll3 = Misc.random(250);
		int roll4 = Misc.random(750);
		if (roll2 == 1) {
			Server.itemHandler.createGroundItem(player, 22111, lootCoordinates[0], lootCoordinates[1],
					player.heightLevel, 1, player.getIndex());
			return;
		}
		if (roll4 == 1) {
			 if (player.getItems().getItemCount(21992, true) == 0 && player.summonId != 21992) {
				 PlayerHandler.executeGlobalMessage("[@red@PET@bla@] @cr20@<col=255> " + player.playerName + "</col> recieved a pet from <col=255>Vorkath</col>.");
				 DiscordMessager.sendLootations("[PET] " + player.playerName + " recieved a pet from Vorkath.");
				 player.getItems().addItemUnderAnyCircumstance(21992, 1);
		}
	}
		if (roll3 == 1) {
			Server.itemHandler.createGroundItem(player, 22106, lootCoordinates[0], lootCoordinates[1],
					player.heightLevel, 1, player.getIndex());
			PlayerHandler.executeGlobalMessage(
					"[@red@Lootations@bla@]@blu@ @cr9@ <col=255>" + Misc.capitalize(player.playerName) + "</col> received a@blu@ Jar of Decay@bla@.");
			DiscordMessager.sendLootations("[Lootations] " + Misc.capitalize(player.playerName) + " received a Jar of Decay.");
			return;
		}
		if (roll == 1) {
			int veryRareItemRoll = Misc.random(veryRareDrops.length - 1);
			Server.itemHandler.createGroundItem(player, veryRareDrops[veryRareItemRoll][0], lootCoordinates[0],
					lootCoordinates[1], player.heightLevel, veryRareDrops[veryRareItemRoll][1], player.getIndex());
			PlayerHandler.executeGlobalMessage(
					"[@red@Lootations@bla@]@blu@ @cr9@ <col=255>" + Misc.capitalize(player.playerName) + "</col> received a very rare drop from @blu@Vorkath@bla@!");
			DiscordMessager.sendLootations("[Lootations] " + Misc.capitalize(player.playerName) + " received a very rare drop from Vorkath!");
		} else if (roll >= 2 && roll <= 25) {
			int rareItemRoll = Misc.random(rareDrops.length - 1);
			Server.itemHandler.createGroundItem(player, rareDrops[rareItemRoll][0], lootCoordinates[0],
					lootCoordinates[1], player.heightLevel, rareDrops[rareItemRoll][1], player.getIndex());
		} else if (roll > 25 && roll <= 100) {
			int uncommonItemRoll = Misc.random(uncommonDrops.length - 1);
			Server.itemHandler.createGroundItem(player, uncommonDrops[uncommonItemRoll][0], lootCoordinates[0],
					lootCoordinates[1], player.heightLevel, uncommonDrops[uncommonItemRoll][1], player.getIndex());
		} else {
			int commonItemRoll = Misc.random(commonDrops.length - 1);
			Server.itemHandler.createGroundItem(player, commonDrops[commonItemRoll][0], lootCoordinates[0],
					lootCoordinates[1], player.heightLevel, commonDrops[commonItemRoll][1], player.getIndex());
		}
	}

	public static boolean inVorkath(Player player) {
		return (player.absX > 2255 && player.absX < 2288 && player.absY > 4053 && player.absY < 4083);
	}

	public static void poke(Player player, NPC npc) {
		if(player.heightLevel == 0) {
			player.sendMessage("Vorkath isn't interested in fighting right now... try rejoining the instance.");
			return;
		}
		npc.requestTransform(8027);
		CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container) {
				npc.requestTransform(8028);
			}

			@Override
			public void stop() {
			}
		}, 7);

	}

	public static void enterInstance(Player player, int instance) {
		CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container) {
				if (player.absY == 4052 && player.absX != 2272) {
					player.setForceMovement(2272, 4054, 10, 10, "NORTH", 1660);
				}
				if (player.absY == 4052 && player.absX == 2272) {
					player.setForceMovement(player.absX, 4054, 10, 10, "NORTH", 839);
					player.getPA().movePlayer(player.absX, player.absY, player.getIndex() * 4);
					Server.npcHandler.spawnNpc(player, 8026, 2272, 4065, player.getIndex() * 4, 0, 750,
							player.antifireDelay > 0 ? 0 : 61, 560, 114, true, false);
					container.stop();
				}
			}

			@Override
			public void stop() {
			}
		}, 1);
	}

	public static void exit(Player player) {
		CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container) {
				if (player.absY == 4054 && player.absX != 2272) {
					player.setForceMovement(2272, 4052, 10, 10, "SOUTH", 1660);
				}
				if (player.absY == 4054 && player.absX == 2272) {
					player.setForceMovement(player.absX, 4052, 10, 10, "SOUTH", 839);
					player.getPA().movePlayer(player.absX, player.absY, 0);
					container.stop();
				}
			}

			@Override
			public void stop() {
			}
		}, 1);

	}

}
