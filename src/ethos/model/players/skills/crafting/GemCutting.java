package ethos.model.players.skills.crafting;

import ethos.Config;
import ethos.model.players.Player;
import ethos.model.players.skills.Skill;
import ethos.util.Misc;

public class GemCutting {
	
	private Player c;
	
	public GemCutting(Player client) {
		this.c = client;
	}
	
	
	public int LvlReq[] = {1, 25, 40, 50, 65, 80}; // not real rs levels
	
	public int XP[] = {30, 50, 65, 80, 105, 125}; // not real rs xp
	
	public int Gems[] = {1623, 1621, 1619, 1617, 1631, 6571};
	
	public int Chisel = 1755;
	
	public boolean hasChisel() {
		if(c.getItems().playerHasItem(Chisel)) {
			return true;
		}
		return false;
	}
	
	public boolean hasGem() {
		if(c.getItems().playerHasItem(Gems[0]) || c.getItems().playerHasItem(Gems[1]) || c.getItems().playerHasItem(Gems[2])
				|| c.getItems().playerHasItem(Gems[3]) || c.getItems().playerHasItem(Gems[4]) || c.getItems().playerHasItem(Gems[5])) {
			return true;
		}
		return false;
	}
	
	public int Products[][] = {
			//ring, necklace, amulet, bracelet
			
			//Sapphire
			{2550, 3853, 1727, 11074},
			
			//Emerald
			{2552, 5521, 1729, 11076},
			
			//Ruby
			{2568, 1660, 1725, 11085},
			
			//Diamond
			{2570, 11090, 1731, 11092},
			
			//DragonStone
			{2572, 11968, 1712, 11126},
			
			//Onyx
			{6575, 11128, 6585, 11130}
	};
	
	public int Furyor = 12436;
	
	public int Sapphire = LvlReq[0];
	public int Emerald = LvlReq[1];
	public int Ruby = LvlReq[2];
	public int Diamond = LvlReq[3];
	public int Dragonstone = LvlReq[4];
	public int Onyx = LvlReq[5];
	
	public int SapRing = Products[0][0];
	public int SapNeck = Products[0][1];
	public int SapAmmy = Products[0][2];
	public int SapBracelet = Products[0][3];
	
	public int EmerRing = Products[1][0];
	public int EmerNeck = Products[1][1];
	public int EmerAmmy = Products[1][2];
	public int EmerBracelet = Products[1][3];
	
	public int RubyRing = Products[2][0];
	public int RubyNeck = Products[2][1];
	public int RubyAmmy = Products[2][2];
	public int RubyBracelet = Products[2][3];
	
	public int DiaRing = Products[3][0];
	public int DiaNeck = Products[3][1];
	public int DiaAmmy = Products[3][2];
	public int DiaBracelet = Products[3][3];
	
	public int DragRing = Products[4][0];
	public int DragNeck = Products[4][1];
	public int DragAmmy = Products[4][2];
	public int DragBracelet = Products[4][3];
	
	public int OnyxRing = Products[5][0];
	public int OnyxNeck = Products[5][1];
	public int OnyxAmmy = Products[5][2];
	public int OnyxBracelet = Products[5][3];
	
	
	public int getCraftLevel() {
		return c.getLevelForXP(c.playerXP[Skill.CRAFTING.getId()]);
	}
	
	public void cutGem(Player c, String Product, int Gem) {
		
		if(hasChisel() == false) {
			c.sendMessage("You need a chisel to cut gems.");
			return;
		}
		if(!hasGem()) {
			c.sendMessage("You need a gem to cut!");
			return;
		}
		switch(Gem) {
			case 1623:
				int amt = c.getItems().getItemAmount(Gems[0]);
					if(getCraftLevel() < Sapphire) {
						c.sendMessage("You need atleast "+Sapphire+" Crafting to cut sapphire gems.");
						return;
					}
			switch(Product) {
				case "Ring":
					c.getItems().deleteItem2(Gems[0], amt);
					c.getItems().addItem(SapRing, amt);
					c.getPA().addSkillXP((XP[0] * amt) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into ring of recoils.");
				break;
				case "Necklace":
					c.getItems().deleteItem2(Gems[0], amt);
					c.getItems().addItem(SapNeck, amt);
					c.getPA().addSkillXP((XP[0] * amt) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into Games Necklaces(8)");
				break;
				case "Amulet":
					c.getItems().deleteItem2(Gems[0], amt);
					c.getItems().addItem(SapAmmy, amt);
					c.getPA().addSkillXP((XP[0] * amt) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into Amulets of magic.");
				break;
				case "Bracelet":
					c.getItems().deleteItem2(Gems[0], amt);
					c.getItems().addItem(SapBracelet, amt);
					c.getPA().addSkillXP((XP[0] * amt) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into Clay Bracelets");
				break;
			}
			break;
			case 1621:
				int amt1 = c.getItems().getItemAmount(Gems[1]);
				if(getCraftLevel() < Emerald) {
					c.sendMessage("You need atleast "+Emerald+" Crafting to cut Emerald gems.");
					return;
				}
				switch(Product) {
				case "Ring":
					c.getItems().deleteItem2(Gems[1], amt1);
					c.getItems().addItem(EmerRing, amt1);
					c.getPA().addSkillXP((XP[1] * amt1) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(EmerRing)+".");
				break;
				case "Necklace":
					c.getItems().deleteItem2(Gems[1], amt1);
					c.getItems().addItem(EmerNeck, amt1);
					c.getPA().addSkillXP((XP[1] * amt1) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(EmerNeck)+".");
				break;
				case "Amulet":
					c.getItems().deleteItem2(Gems[1], amt1);
					c.getItems().addItem(EmerAmmy, amt1);
					c.getPA().addSkillXP((XP[1] * amt1) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(EmerAmmy)+".");
				break;
				case "Bracelet":
					c.getItems().deleteItem2(Gems[1], amt1);
					c.getItems().addItem(EmerBracelet, amt1);
					c.getPA().addSkillXP((XP[1] * amt1) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(EmerBracelet)+".");
				break;
			}
			break;
			case 1619:
				int amt2 = c.getItems().getItemAmount(Gems[2]);
				if(getCraftLevel() < Ruby) {
					c.sendMessage("You need atleast "+Ruby+" Crafting to cut Ruby gems.");
					return;
				}
				switch(Product) {
				case "Ring":
					c.getItems().deleteItem2(Gems[2], amt2);
					c.getItems().addItem(RubyRing, amt2);
					c.getPA().addSkillXP((XP[2] * amt2) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(RubyRing)+".");
				break;
				case "Necklace":
					c.getItems().deleteItem2(Gems[2], amt2);
					c.getItems().addItem(RubyNeck, amt2);
					c.getPA().addSkillXP((XP[2] * amt2) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(RubyNeck)+".");
				break;
				case "Amulet":
					c.getItems().deleteItem2(Gems[2], amt2);
					c.getItems().addItem(RubyAmmy, amt2);
					c.getPA().addSkillXP((XP[2] * amt2) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(RubyAmmy)+".");
				break;
				case "Bracelet":
					c.getItems().deleteItem2(Gems[2], amt2);
					c.getItems().addItem(RubyBracelet, amt2);
					c.getPA().addSkillXP((XP[2] * amt2) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(RubyBracelet)+".");
				break;
			}
			break;
			case 1617:
				int amt3 = c.getItems().getItemAmount(Gems[3]);
				if(getCraftLevel() < Diamond) {
					c.sendMessage("You need atleast "+Diamond+" Crafting to cut Diamond gems.");
					return;
				}
				switch(Product) {
				case "Ring":
					c.getItems().deleteItem2(Gems[3], amt3);
					c.getItems().addItem(DiaRing, amt3);
					c.getPA().addSkillXP((XP[3] * amt3) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(DiaRing)+".");
				break;
				case "Necklace":
					c.getItems().deleteItem2(Gems[3], amt3);
					c.getItems().addItem(DiaNeck, amt3);
					c.getPA().addSkillXP((XP[3] * amt3) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(DiaNeck)+".");
				break;
				case "Amulet":
					c.getItems().deleteItem2(Gems[3], amt3);
					c.getItems().addItem(DiaAmmy, amt3);
					c.getPA().addSkillXP((XP[3] * amt3) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(DiaAmmy)+".");
				break;
				case "Bracelet":
					c.getItems().deleteItem2(Gems[3], amt3);
					c.getItems().addItem(DiaBracelet, amt3);
					c.getPA().addSkillXP((XP[3] * amt3) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(DiaBracelet)+".");
				break;
			}
			break;
			case 1631:
				int amt4 = c.getItems().getItemAmount(Gems[4]);
				if(getCraftLevel() < Dragonstone) {
					c.sendMessage("You need atleast "+Dragonstone+" Crafting to cut Dragonstone gems.");
					return;
				}
				switch(Product) {
				case "Ring":
					c.getItems().deleteItem2(Gems[4], amt4);
					c.getItems().addItem(DragRing, amt4);
					c.getPA().addSkillXP((XP[4] * amt4) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(DragRing)+".");
				break;
				case "Necklace":
					c.getItems().deleteItem2(Gems[4], amt4);
					c.getItems().addItem(DragNeck, amt4);
					c.getPA().addSkillXP((XP[4] * amt4) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(DragNeck)+".");
				break;
				case "Amulet":
					c.getItems().deleteItem2(Gems[4], amt4);
					c.getItems().addItem(DragAmmy, amt4);
					c.getPA().addSkillXP((XP[4] * amt4) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(DragAmmy)+".");
				break;
				case "Bracelet":
					c.getItems().deleteItem2(Gems[4], amt4);
					c.getItems().addItem(DragBracelet, amt4);
					c.getPA().addSkillXP((XP[4] * amt4) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(DragBracelet)+".");
				break;
			}
			break;
			case 6571:
				int amt5 = c.getItems().getItemAmount(Gems[5]);
				if(getCraftLevel() < Onyx) {
					c.sendMessage("You need atleast "+Onyx+" Crafting to cut Onyx gems.");
					return;
				}
				switch(Product) {
				case "Ring":
					c.getItems().deleteItem2(Gems[5], amt5);
					c.getItems().addItem(OnyxRing, amt5);
					c.getPA().addSkillXP((XP[5] * amt5) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(OnyxRing)+".");
				break;
				case "Necklace":
					c.getItems().deleteItem2(Gems[5], amt5);
					c.getItems().addItem(OnyxNeck, amt5);
					c.getPA().addSkillXP((XP[5] * amt5) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(OnyxNeck)+".");
				break;
				case "Amulet":
					int chance = Misc.random(5000);
					if(chance == 4516) {
						c.getItems().deleteItem2(Gems[5], 1);
						c.getItems().addItem(Furyor, 1);
						c.getPA().addSkillXP((XP[5] + 65 ) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
						c.sendMessage("You got lucky and and crafted an amulet of fury (or)!");
					} else {
						c.getItems().deleteItem2(Gems[5], amt5);
						c.getItems().addItem(OnyxAmmy, amt5);
						c.getPA().addSkillXP((XP[5] * amt5) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
						c.sendMessage("You craft all your gems into "+c.getItems().getItemName(OnyxAmmy)+".");
					}
				break;
				case "Bracelet":
					c.getItems().deleteItem2(Gems[5], amt5);
					c.getItems().addItem(OnyxBracelet, amt5);
					c.getPA().addSkillXP((XP[5] * amt5) * Config.CRAFTING_EXPERIENCE, Skill.CRAFTING.getId(), true);
					c.sendMessage("You craft all your gems into "+c.getItems().getItemName(OnyxBracelet)+".");
				break; 
			}
			break;
		}
	}
}