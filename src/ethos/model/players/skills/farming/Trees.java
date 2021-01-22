package ethos.model.players.skills.farming;

import ethos.Config;
import ethos.Server;
import ethos.model.content.SkillcapePerks;
import ethos.model.players.*;
import ethos.model.players.mode.ModeType;
import ethos.model.players.skills.Skill;
import ethos.model.players.skills.farming.Farming.State;
import ethos.model.players.skills.woodcutting.Woodcutting;
import ethos.util.Misc;

public class Trees {
	
	private Player c;
	
	public Trees(Player c) {
		this.c = c;
	}
	
	/*public boolean ReadyToGo() {
		if(c.getItems().playerHasItem(FarmingConstants.SEED_DIBBER))
	}*/
	
	public int properTimer = 0;
	
	private boolean hasMagicSecateurs() {
		return c.getItems().playerHasItem(7409) || c.getItems().isWearingItem(7409, 3) || SkillcapePerks.FARMING.isWearing(c) || SkillcapePerks.isWearingMaxCape(c);
	}
	
	public static int[] farmersOutfit = { 13640, 13642, 13644, 13646 };
	
	public int HarvestXP(int tree) {
		int xp = 0;
		switch(tree) {
			case 10820:
				return 60;
			case 10819:
				return 100;
			case 10822:
				return 175;
			case 10834:
				return 275;
		}
		return xp;
	}
	
	public int log(int tree) {
		switch(tree) {
		case 10820:
			return 1521;
		case 10819:
			return 1520;
		case 10822:
			return 1515;
		case 10834:
			return 1513;
		}
		return -1;
	}
	
	public void RakePatch(Player c) {
		if(c.getRaked() <= 0) {
			c.startAnimation(FarmingConstants.RAKING_ANIM);
			c.getItems().addItem(FarmingConstants.WEED, 3);
			c.getPA().checkObjectSpawn(FarmingConstants.HERB_PATCH_DEPLETED, 3010, 3378, 0, 10);
			c.sendMessage("You Rake the weeds from the patch.");
			c.sendMessage("You can now add your compost.");
			c.setRaked(1);
		}
	}
	
	public void addCompost(Player c) {
		if(c.getCompost() <= 0) {
			c.startAnimation(FarmingConstants.PUTTING_COMPOST);
			c.sendMessage("You Spread the compost over the patch.");
			c.sendMessage("You can now plant your seed.");
			c.setCompost(1);
		}
	}
	
	/*add rewards here*/
	public int DemonReward1[][] = {{6199, 1}, {995, 2500000}, {2528, 5}, {5304, 50}, {386, 50}, {6033, 100}};
	public int DemonReward2[][] = {{6199, 1}, {995, 2500000}, {2528, 5}, {5304, 50}, {386, 50}, {6033, 100}};
	public int DemonReward3[][] = {{6199, 1}, {995, 2500000}, {2528, 5}, {5304, 50}, {386, 50}, {6033, 100}};
	
	public int lesserDemon = 2006;
	public int GreaterDemon = 2025;
	public int BlackDemon = 1432;
	
	public void spawnDemon(Player c, int level){
		c.setDemon(1);
		c.sendMessage("As you plant the seed a raging Demon Spawns! @red@Kill It!");
		switch(level) {
		case 0: // lvl 1 (easy)
			Server.npcHandler.spawnNpc(c, lesserDemon, c.absX - 1, c.absY, c.getHeightLevel(), 0, 200, 35, 250, 300, true, true);
			break;
		case 1:
			Server.npcHandler.spawnNpc(c, GreaterDemon, c.absX - 1, c.absY, c.getHeightLevel(), 0, 250, 45, 300, 370, true, true);
			break;
		case 2:
			Server.npcHandler.spawnNpc(c, BlackDemon, c.absX - 1, c.absY, c.getHeightLevel(), 0, 200, 55, 450, 500, true, true);
			break;
		}
	}
	
	
	public void plantSeed(Player c, int seedId, int objectId, int x, int y) {
		int DemonRoll = Misc.random(5000);
		int r = Misc.random(2);
		if(DemonRoll == 365) {
			spawnDemon(c, r);
		}
		switch(seedId) {
			case 5312:
				
				if(objectId == FarmingConstants.HERB_PATCH_DEPLETED) {
					if(c.getItems().playerHasItem(FarmingConstants.SEED_DIBBER)) {
						if(x == 3010 && y == 3378 || x == 3083 && y == 3500) {
							handleTree(c, FarmingConstants.OAK_TREE, seedId, x, y);
							c.setCompost(0);
							c.setRaked(0);
						} else {
							c.sendMessage("Please use the patch by the pond or the one at home for trees!");
						}
					} else {
						c.sendMessage("You need a seed Dibber to plant this seed!");
					}
				} else {
					c.sendMessage("You need to Rake the patch first!");
				}
				
				break;
			case 5313:
				if(c.getLevelForXP(c.playerXP[Skill.FARMING.getId()]) < 30) {
				if(objectId == FarmingConstants.HERB_PATCH_DEPLETED) {
					if(c.getItems().playerHasItem(FarmingConstants.SEED_DIBBER)) {
						if(x == 3010 && y == 3378 || x == 3083 && y == 3500) {
							handleTree(c, FarmingConstants.WILLOW_TREE, seedId, x, y);
							c.setCompost(0);
							c.setRaked(0);
						} else {
							c.sendMessage("Please use the patch by the pond or the one at home for trees!");
						}
					} else {
						c.sendMessage("You need a seed Dibber to plant this seed!");
					}
				} else {
					c.sendMessage("You need to Rake the patch first!");
				}
				} else {
					c.sendMessage("You need 30 farming to plant Willow trees.");
				}
				break;
			case 5315:
				if(c.getLevelForXP(c.playerXP[Skill.FARMING.getId()]) < 60) {
				if(objectId == FarmingConstants.HERB_PATCH_DEPLETED) {
					if(c.getItems().playerHasItem(FarmingConstants.SEED_DIBBER)) {
						if(x == 3010 && y == 3378 || x == 3083 && y == 3500) {
							handleTree(c, FarmingConstants.YEW_TREE, seedId, x, y);
							c.setCompost(0);
							c.setRaked(0);
						} else {
							c.sendMessage("Please use the patch by the pond or the one at home for trees!");
						}
					} else {
						c.sendMessage("You need a seed Dibber to plant this seed!");
					}
				} else {
					c.sendMessage("You need to Rake the patch first!");
				}
				} else {
					c.sendMessage("You need 60 farming to plant Yew trees.");
				}
				break;
			case 5316:
				if(c.getLevelForXP(c.playerXP[Skill.FARMING.getId()]) < 75) {
				if(objectId == FarmingConstants.HERB_PATCH_DEPLETED) {
					if(c.getItems().playerHasItem(FarmingConstants.SEED_DIBBER)) {
						if(x == 3010 && y == 3378 || x == 3083 && y == 3500) {
							handleTree(c, FarmingConstants.MAGIC_TREE, seedId, x, y);
							c.setCompost(0);
							c.setRaked(0);
						} else {
							c.sendMessage("Please use the patch by the pond or the one at home for trees!");
						}
					} else {
						c.sendMessage("You need a seed Dibber to plant this seed!");
					}
				} else {
					c.sendMessage("You need to Rake the patch first!");
				}
				} else {
					c.sendMessage("You need 75 farming to plant Magic trees.");
				}
				break;
		}
	}
	
	public void handleTree(Player c, int treeId, int seed, int x, int y) {
		int pieces = 0;
		for (int aFarmersOutfit : farmersOutfit) {
			if (c.getItems().isWearingItem(aFarmersOutfit)) {
				pieces++;
			}
		}
		final TreeData.Trees Tree = TreeData.getTreeForSeed(seed);
		double regExperience = Tree.getPlantingXp() + Tree.getPlantingXp() / 20 * pieces;
		switch(treeId) {
			case FarmingConstants.OAK_TREE:
				c.getItems().deleteItem2(Tree.getSeedId(), 1);
				c.setLogTimer(hasMagicSecateurs() ? Tree.getGrowthTime() / 2 : Tree.getGrowthTime());
				c.setLogAmount(5 + Misc.random(20));
				c.getPA().addSkillXP((int) regExperience, Config.FARMING, true);
				c.sendMessage("You planted the acorn now wait "+c.getLogTimer()+" seconds for it to grow.");
				updateObjects(c,  treeId, x, y);
				c.setHasTree(1);
			break;
			case FarmingConstants.WILLOW_TREE:
				c.getItems().deleteItem2(Tree.getSeedId(), 1);
				c.setLogTimer(hasMagicSecateurs() ? Tree.getGrowthTime() / 2 : Tree.getGrowthTime());
				c.setLogAmount(5 + Misc.random(20));
				c.getPA().addSkillXP((int) regExperience, Config.FARMING, true);
				c.sendMessage("You planted the Willow Seed now wait "+c.getLogTimer()+" seconds for it to grow.");
				updateObjects(c,  treeId, x, y);
				c.setHasTree(1);
			break;
			case FarmingConstants.YEW_TREE:
				c.getItems().deleteItem2(Tree.getSeedId(), 1);
				c.setLogTimer(hasMagicSecateurs() ? Tree.getGrowthTime() / 2 : Tree.getGrowthTime());
				c.setLogAmount(5 + Misc.random(20));
				c.getPA().addSkillXP((int) regExperience, Config.FARMING, true);
				c.sendMessage("You planted the Yew Seed now wait "+c.getLogTimer()+" seconds for it to grow.");
				updateObjects(c,  treeId, x, y);
				c.setHasTree(1);
			break;
			case FarmingConstants.MAGIC_TREE:
				c.getItems().deleteItem2(Tree.getSeedId(), 1);
				c.setLogTimer(hasMagicSecateurs() ? Tree.getGrowthTime() / 2 : Tree.getGrowthTime());
				c.setLogAmount(5 + Misc.random(20));
				c.getPA().addSkillXP((int) regExperience, Config.FARMING, true);
				c.sendMessage("You planted the Magic Seed now wait "+c.getLogTimer()+" seconds for it to grow.");
				updateObjects(c,  treeId, x, y);
				c.setHasTree(1);
			break;
		}
	}
	
	public void updateObjects(Player c, int treeId, int x, int y) {
		c.getPA().checkObjectSpawn(treeId, x, y, 0, 10);
	}
	
	public void removeTree(Player c, int x, int y) {
		c.setHasTree(0);
		c.getPA().checkObjectSpawn(FarmingConstants.GRASS_OBJECT, x, y, 0, 10);
	}
	
	public  void TreeProcess(Player c) {
		if(properTimer > 0) {
			properTimer--;
		} else {
			properTimer = 4;
		}
		if(c.getLogTimer() > 0) {
			c.LogTimer--;
		}
		if(c.getLogTimer() <= 0) {
			c.sendMessage("Your Tree has fully grew you can now cut it down!");
			c.setLogTimer(0);
		}
	}
	
	public void cutDownTree(Player c, int treeId, int x, int y) {
		if(c.getItems().freeSlots() < 0) {
			c.sendMessage("You need more free spots to cut the tree.");
			return;
		}
		switch(treeId) {
			case FarmingConstants.OAK_TREE:
				if(c.getLogTimer() <= 0) {
					if(c.getLogAmount() > 0) {
						c.startAnimation(879);
						c.getItems().addItem(log(treeId), 1);
						c.getPA().addSkillXP(HarvestXP(treeId), Config.FARMING, true);
						c.setLogAmount(c.getLogAmount() - 1);
					} else {
						c.sendMessage("The tree has been completely chopped down.");
						removeTree(c, x, y);
					}
				} else {
					c.sendMessage("This tree is still growing you have another "+c.getLogTimer()+ " seconds...");
				}
				break;
			case FarmingConstants.WILLOW_TREE:
				if(c.getLogTimer() <= 0) {
					if(c.getLogAmount() > 0) {
						c.startAnimation(879);
						c.getItems().addItem(log(treeId), 1);
						c.getPA().addSkillXP(HarvestXP(treeId), Config.FARMING, true);
						c.setLogAmount(c.getLogAmount() - 1);
					} else {
						c.sendMessage("The tree has been completely chopped down.");
						removeTree(c, x, y);
					}
				} else {
					c.sendMessage("This tree is still growing you have another "+c.getLogTimer()+ " seconds...");
				}
				break;
			case FarmingConstants.YEW_TREE:
				if(c.getLogTimer() <= 0) {
					if(c.getLogAmount() > 0) {
						c.startAnimation(879);
						c.getItems().addItem(log(treeId), 1);
						c.getPA().addSkillXP(HarvestXP(treeId), Config.FARMING, true);
						c.setLogAmount(c.getLogAmount() - 1);
					} else {
						c.sendMessage("The tree has been completely chopped down.");
						removeTree(c, x, y);
					}
				} else {
					c.sendMessage("This tree is still growing you have another "+c.getLogTimer()+ " seconds...");
				}
				break;
			case FarmingConstants.MAGIC_TREE:
				if(c.getLogTimer() <= 0) {
					if(c.getLogAmount() > 0) {
						c.startAnimation(879);
						c.getItems().addItem(log(treeId), 1);
						c.getPA().addSkillXP(HarvestXP(treeId), Config.FARMING, true);
						c.setLogAmount(c.getLogAmount() - 1);
					} else {
						c.sendMessage("The tree has been completely chopped down.");
						removeTree(c, x, y);
					}
				} else {
					c.sendMessage("This tree is still growing you have another "+c.getLogTimer()+ " seconds...");
				}
				break;
		}
	}

}
