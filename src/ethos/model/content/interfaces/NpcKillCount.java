package ethos.model.content.interfaces;

import ethos.Server;
import ethos.model.players.Player;

public class NpcKillCount {
	
	private static Player c;
	
	public NpcKillCount(Player client){
		this.c = client;
	}
	
	
	public String npcKiller1 = "";
	public String npcKiller2 = "";
	
	public String getRecentKill() {
		String Recent;
		Recent = Server.npcHandler.getNpcName(c.recentKill);
		if(Recent == "Hans" || Recent == "hans") {
			Recent = "Nothing";
		}
		return Recent;
	}
	
	public static void setRecentKill(int npc) {
		c.recentKill = npc;
	}
	
	
	
	public void Display(Player c){
		
		c.getPA().showInterface(49500);
		c.getPA().sendFrame126("RockCrabs(-): "+c.RockCrabs, 43008);
		c.getPA().sendFrame126("Cows: "+c.Cows, 43009);
		c.getPA().sendFrame126("Yaks: "+c.Yaks, 43010);
		c.getPA().sendFrame126("Bandits(-): "+c.Bandits, 43011);
		c.getPA().sendFrame126("Elfs: "+c.Elfs, 43012);
		c.getPA().sendFrame126("Dagannoths: "+c.Dags, 43013);
		c.getPA().sendFrame126("Dragons: "+c.Dragons, 43014);
		c.getPA().sendFrame126("Gorillas: "+c.Gorillas, 43015);
		c.getPA().sendFrame126("Smoke Devils: "+c.SmokeDevils, 43016);
		c.getPA().sendFrame126("BarrelChest: "+c.BarrelChest, 43017);
		c.getPA().sendFrame126("KBD: "+c.KBD, 43018);
		c.getPA().sendFrame126("Giant Mole: "+c.Mole, 43019);
		c.getPA().sendFrame126("Kal Queen: "+c.KQ, 43020);
		c.getPA().sendFrame126("GWD Monsters: "+c.GWD, 43021);
		c.getPA().sendFrame126("Corp: "+c.Corp, 43022);
		c.getPA().sendFrame126("Kraken: "+c.Kraken, 43023);
		c.getPA().sendFrame126("Zulrah: "+c.Zul, 43024);
		c.getPA().sendFrame126("Cerberus: "+c.Cer, 43025);
		c.getPA().sendFrame126("TSD: "+c.TSD, 43026);
		c.getPA().sendFrame126("Abyssal Sire: "+c.AbyssalSire, 43027);
		c.getPA().sendFrame126("LizardMan: "+c.LM, 43028);
		c.getPA().sendFrame126("Vorkath: "+c.Vork, 43029);
		c.getPA().sendFrame126("Rats: "+c.Rats, 43030);
		c.getPA().sendFrame126("HobGoblin: "+c.HobGoblin, 43031);
		c.getPA().sendFrame126("Giants: "+c.Giants, 43032);
		c.getPA().sendFrame126("Demons: "+c.Demons, 43033);
		c.getPA().sendFrame126("Skeletons: "+c.Skeletons, 43034);
		c.getPA().sendFrame126("Ghosts: "+c.Ghosts, 43035);
		c.getPA().sendFrame126("Bats: "+c.Bats, 43036);
		c.getPA().sendFrame126("Chaos Dwarfs: "+c.Dwarfs, 43037);
		c.getPA().sendFrame126("Chaos Druids: "+c.Druids, 43038);
		c.getPA().sendFrame126("Knights: "+c.Knights, 43039);
		c.getPA().sendFrame126("Magic Axe: "+c.MagicAxe, 43040);
		c.getPA().sendFrame126("DarkBeasts: "+c.DB, 43041);
		c.getPA().sendFrame126("BV: "+c.Bloodveld, 43042);
		c.getPA().sendFrame126("HellHound: "+c.HellHound, 43043);
		c.getPA().sendFrame126("Cave Crawler: "+c.CaveCrawler, 43044);
		c.getPA().sendFrame126("Cave Bug: "+c.CaveBug, 43045);
		c.getPA().sendFrame126("Cave Horror: "+c.CaveHorror, 43046);
		c.getPA().sendFrame126("Cockatrice: "+c.Cockatrice, 43047);
		c.getPA().sendFrame126("RockSlug: "+c.RockSlug, 43048);
		c.getPA().sendFrame126("Pyrefiend: "+c.Pyrefiend, 43049);
		c.getPA().sendFrame126("Basilisk: "+c.Basilisk, 43050);
		c.getPA().sendFrame126("Jelly: "+c.Jelly, 43051);
		c.getPA().sendFrame126("Turoth: "+c.Turoth, 43052);
		c.getPA().sendFrame126("Kurask: "+c.Kurasks, 43053);
		c.getPA().sendFrame126("Warrior: "+c.Warriors, 43054);
		c.getPA().sendFrame126("Wyverns: "+c.Wyverns, 43055);
		c.getPA().sendFrame126("Wilderness: "+c.Wild, 43056);
		c.getPA().sendFrame126("Slayer Tower: "+c.Slayer, 43057);
		c.getPA().sendFrame126("Boss: "+c.Boss, 43058);
		c.getPA().sendFrame126(getRecentKill(), 49511);
		c.getPA().sendFrame126(""+c.Total, 49512);
		
		
	}
	
	public void handleButtonClick(Player c, int buttonId) {
		switch(buttonId) {
		case 193100:
			if(c.Total >= 500) {
				if(c.getItems().freeSlots() > 0) {
					c.getItems().addItem(13346, 1);
					c.Total -= 500;
					Display(c);
				} else {
					c.sendMessage("You need at least 1 free spot in your inventory.");
					c.sendMessage("You also need at least 500 Total kills to get a ultra mystery box!");
					c.sendMessage("A ultra mystery box is a spin for a very rare item.");
				}
			} else {
				c.sendMessage("You need at least 500 Total kills to get a ultra mystery box!");
			}
			break;
		}
	}
	

}
