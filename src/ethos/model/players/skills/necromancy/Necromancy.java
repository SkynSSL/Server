package ethos.model.players.skills.necromancy;

import java.util.concurrent.TimeUnit;

import ethos.Server;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.npcs.NPC;
import ethos.model.npcs.NPCHandler;
import ethos.model.players.Boundary;
import ethos.model.players.Player;
import ethos.model.players.mode.ModeType;
import ethos.model.players.skills.Skill;
import ethos.util.Misc;

public class Necromancy {
	
	private static long lastMysteriousHerbFarm;
	//static NPC COW = NPCHandler.getNpc(2805);
	
	public static void main(Player player) {
	if (Boundary.isIn(player, Boundary.NECRO)) {
		int loot = Misc.random(25);
		
       	if (player.chosenCow == true) {
       			player.nxp += 1;
       		if (loot >= 0 && loot < 3) {
 				player.getItems().addItemUnderAnyCircumstance(13307, 3);
 				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Cow@bla@.");
 			} else if (loot >= 3 && loot < 6) {
 				player.getItems().addItemUnderAnyCircumstance(22405, 1);
 				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Cow@bla@.");
 			} else if (loot >= 6 && loot < 9) {
 				player.getItems().addItemUnderAnyCircumstance(22402, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Cow@bla@.");
 			} else if (loot >= 9 && loot < 12) {
 				player.getItems().addItemUnderAnyCircumstance(22403, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Cow@bla@.");
 			}
    	 }
       	
    	 if (player.chosenChicken == true) {
 			player.nxp += 1;
 			if (loot >= 0 && loot < 3) {
 				player.getItems().addItemUnderAnyCircumstance(13307, 3);
 				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Chicken@bla@.");
 			} else if (loot >= 3 && loot < 6) {
 				player.getItems().addItemUnderAnyCircumstance(22405, 1);
 				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Chicken@bla@.");
 			} else if (loot >= 6 && loot < 9) {
 				player.getItems().addItemUnderAnyCircumstance(22402, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Chicken@bla@.");
 			} else if (loot >= 9 && loot < 12) {
 				player.getItems().addItemUnderAnyCircumstance(22403, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Chicken@bla@.");
 			}
    	 }
    	 
    	 if (player.chosenGoblin == true) {
 			player.nxp += 1;
 			if (loot >= 0 && loot < 3) {
 				player.getItems().addItemUnderAnyCircumstance(13307, 3);
 				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Goblin@bla@.");
 			} else if (loot >= 3 && loot < 6) {
 				player.getItems().addItemUnderAnyCircumstance(22405, 1);
 				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Goblin@bla@.");
 			} else if (loot >= 6 && loot < 9) {
 				player.getItems().addItemUnderAnyCircumstance(22402, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Goblin@bla@.");
 			} else if (loot >= 9 && loot < 12) {
 				player.getItems().addItemUnderAnyCircumstance(22403, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Goblin@bla@.");
 			}
    	 }
    	 
    	 if (player.chosenCaveBug == true) {
 			player.nxp += 1;
 			if (loot >= 0 && loot < 3) {
 				player.getItems().addItemUnderAnyCircumstance(13307, 3);
 				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Cave Bug@bla@.");
 			} else if (loot >= 3 && loot < 6) {
 				player.getItems().addItemUnderAnyCircumstance(22405, 1);
 				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Cave Bug@bla@.");
 			} else if (loot >= 6 && loot < 9) {
 				player.getItems().addItemUnderAnyCircumstance(22402, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Cave Bug@bla@.");
 			} else if (loot >= 9 && loot < 12) {
 				player.getItems().addItemUnderAnyCircumstance(22403, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Cave Bug@bla@.");
 			}
    	 }
    	 
    	 if (player.chosenMan == true) {
  			player.nxp += 1;
  			if (loot >= 0 && loot < 3) {
 				player.getItems().addItemUnderAnyCircumstance(13307, 3);
 				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Man@bla@.");
 			} else if (loot >= 3 && loot < 6) {
 				player.getItems().addItemUnderAnyCircumstance(22405, 1);
 				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Man@bla@.");
 			} else if (loot >= 6 && loot < 9) {
 				player.getItems().addItemUnderAnyCircumstance(22402, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Man@bla@.");
 			} else if (loot >= 9 && loot < 12) {
 				player.getItems().addItemUnderAnyCircumstance(22403, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Man@bla@.");
 			}
    	 }
    	 
    	 if (player.chosenWoman == true) {
  			player.nxp += 1;
  			if (loot >= 0 && loot < 3) {
 				player.getItems().addItemUnderAnyCircumstance(13307, 3);
 				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Woman@bla@.");
 			} else if (loot >= 3 && loot < 6) {
 				player.getItems().addItemUnderAnyCircumstance(22405, 1);
 				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Woman@bla@.");
 			} else if (loot >= 6 && loot < 9) {
 				player.getItems().addItemUnderAnyCircumstance(22402, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Woman@bla@.");
 			} else if (loot >= 9 && loot < 12) {
 				player.getItems().addItemUnderAnyCircumstance(22403, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Woman@bla@.");
 			}
    	 }
    	 
    	 if (player.chosenFarmer == true) {
  			player.nxp += 1;
  			if (loot >= 0 && loot < 3) {
 				player.getItems().addItemUnderAnyCircumstance(13307, 3);
 				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Farmer@bla@.");
 			} else if (loot >= 3 && loot < 6) {
 				player.getItems().addItemUnderAnyCircumstance(22405, 1);
 				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Farmer@bla@.");
 			} else if (loot >= 6 && loot < 9) {
 				player.getItems().addItemUnderAnyCircumstance(22402, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Farmer@bla@.");
 			} else if (loot >= 9 && loot < 12) {
 				player.getItems().addItemUnderAnyCircumstance(22403, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Farmer@bla@.");
 			}
    	 }
    	 
    	 if (player.chosenThug == true) {
  			player.nxp += 1;
  			if (loot >= 0 && loot < 3) {
 				player.getItems().addItemUnderAnyCircumstance(13307, 3);
 				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Thug@bla@.");
 			} else if (loot >= 3 && loot < 6) {
 				player.getItems().addItemUnderAnyCircumstance(22405, 1);
 				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Thug@bla@.");
 			} else if (loot >= 6 && loot < 9) {
 				player.getItems().addItemUnderAnyCircumstance(22402, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Thug@bla@.");
 			} else if (loot >= 9 && loot < 12) {
 				player.getItems().addItemUnderAnyCircumstance(22403, 1);
 				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Thug@bla@.");
 				}
    	 	}
    	 
       	 if (player.chosenCrawlingHand == true && player.nlevel >= 2) {
   			player.nxp += 2;
   			if (loot >= 0 && loot < 4) {
  				player.getItems().addItemUnderAnyCircumstance(13307, 3);
  				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Crawling Hand@bla@.");
  			} else if (loot >= 3 && loot < 6) {
  				player.getItems().addItemUnderAnyCircumstance(22405, 1);
  				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Crawling Hand@bla@.");
  			} else if (loot >= 6 && loot < 9) {
  				player.getItems().addItemUnderAnyCircumstance(22402, 1);
  				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Crawling Hand@bla@.");
  			} else if (loot >= 9 && loot < 12) {
  				player.getItems().addItemUnderAnyCircumstance(22403, 1);
  				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Crawling Hand@bla@.");
  			}
       	 }       
       	 
      	 if (player.chosenDesertLizard == true && player.nlevel >= 2) {
    		player.nxp += 2;
    		if (loot >= 0 && loot < 4) {
   				player.getItems().addItemUnderAnyCircumstance(13307, 3);
   				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Desert Lizard@bla@.");
   			} else if (loot >= 3 && loot < 6) {
   				player.getItems().addItemUnderAnyCircumstance(22405, 1);
   				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Desert Lizard@bla@.");
   			} else if (loot >= 6 && loot < 9) {
   				player.getItems().addItemUnderAnyCircumstance(22402, 1);
   				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Desert Lizard@bla@.");
   			} else if (loot >= 9 && loot < 12) {
   				player.getItems().addItemUnderAnyCircumstance(22403, 1);
   				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Desert Lizard@bla@.");
   				}
      	 }
      	 
      	if (player.chosenBanshee == true && player.nlevel >= 2) {
			player.nxp += 2;
			if (loot >= 0 && loot < 4) {
				player.getItems().addItemUnderAnyCircumstance(13307, 3);
				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Banshee@bla@.");
			} else if (loot >= 3 && loot < 6) {
				player.getItems().addItemUnderAnyCircumstance(22405, 1);
				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Banshee@bla@.");
			} else if (loot >= 6 && loot < 9) {
				player.getItems().addItemUnderAnyCircumstance(22402, 1);
				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Banshee@bla@.");
			} else if (loot >= 9 && loot < 12) {
				player.getItems().addItemUnderAnyCircumstance(22403, 1);
				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Banshee@bla@.");
				}
  	 		}
      	
      	if (player.chosenKalphiteWorker == true && player.nlevel >= 2) {
			player.nxp += 2;
			if (loot >= 0 && loot < 4) {
				player.getItems().addItemUnderAnyCircumstance(13307, 3);
				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Kalphite Worker@bla@.");
			} else if (loot >= 3 && loot < 6) {
				player.getItems().addItemUnderAnyCircumstance(22405, 1);
				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Kalphite Worker@bla@.");
			} else if (loot >= 6 && loot < 9) {
				player.getItems().addItemUnderAnyCircumstance(22402, 1);
				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Kalphite Worker@bla@.");
			} else if (loot >= 9 && loot < 12) {
				player.getItems().addItemUnderAnyCircumstance(22403, 1);
				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Kalphite Worker@bla@.");
				}
  	 		}
      	
      	if (player.chosenChaosDruid == true && player.nlevel >= 2) {
			player.nxp += 2;
			if (loot >= 0 && loot < 4) {
				player.getItems().addItemUnderAnyCircumstance(13307, 3);
				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Chaos Druid@bla@.");
			} else if (loot >= 3 && loot < 6) {
				player.getItems().addItemUnderAnyCircumstance(22405, 1);
				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Chaos Druid@bla@.");
			} else if (loot >= 6 && loot < 9) {
				player.getItems().addItemUnderAnyCircumstance(22402, 1);
				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Chaos Druid@bla@.");
			} else if (loot >= 9 && loot < 12) {
				player.getItems().addItemUnderAnyCircumstance(22403, 1);
				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Chaos Druid@bla@.");
				}
  	 		}
      	
      	if (player.chosenSkeleton == true && player.nlevel >= 2) {
			player.nxp += 2;
			if (loot >= 0 && loot < 4) {
				player.getItems().addItemUnderAnyCircumstance(13307, 3);
				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Skeleton@bla@.");
			} else if (loot >= 3 && loot < 6) {
				player.getItems().addItemUnderAnyCircumstance(22405, 1);
				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Skeleton@bla@.");
			} else if (loot >= 6 && loot < 9) {
				player.getItems().addItemUnderAnyCircumstance(22402, 1);
				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Skeleton@bla@.");
			} else if (loot >= 9 && loot < 12) {
				player.getItems().addItemUnderAnyCircumstance(22403, 1);
				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Skeleton@bla@.");
				}
  	 		}
      	
      	if (player.chosenGhost == true && player.nlevel >= 2) {
			player.nxp += 2;
			if (loot >= 0 && loot < 4) {
				player.getItems().addItemUnderAnyCircumstance(13307, 3);
				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Ghost@bla@.");
			} else if (loot >= 3 && loot < 6) {
				player.getItems().addItemUnderAnyCircumstance(22405, 1);
				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Ghost@bla@.");
			} else if (loot >= 6 && loot < 9) {
				player.getItems().addItemUnderAnyCircumstance(22402, 1);
				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Ghost@bla@.");
			} else if (loot >= 9 && loot < 12) {
				player.getItems().addItemUnderAnyCircumstance(22403, 1);
				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Ghost@bla@.");
				}
  	 		}
      	
      	if (player.chosenSandCrab == true && player.nlevel >= 2) {
			player.nxp += 2;
			if (loot >= 0 && loot < 4) {
				player.getItems().addItemUnderAnyCircumstance(13307, 3);
				player.sendMessage("@bla@You've received @red@3 @bla@blood money from killing a @red@Sand Crab@bla@.");
			} else if (loot >= 3 && loot < 6) {
				player.getItems().addItemUnderAnyCircumstance(22405, 1);
				player.sendMessage("@bla@You've received a @red@vial of blood @bla@from killing a @red@Sand Crab@bla@.");
			} else if (loot >= 6 && loot < 9) {
				player.getItems().addItemUnderAnyCircumstance(22402, 1);
				player.sendMessage("@bla@You've received a @red@mysterious herb @bla@from killing a @red@Sand Crab@bla@.");
			} else if (loot >= 9 && loot < 12) {
				player.getItems().addItemUnderAnyCircumstance(22403, 1);
				player.sendMessage("@bla@You've received a @red@mysterious meat @bla@from killing a @red@Sand Crab@bla@.");
				}
  	 		}
		}
	}
	
	public static void farmMysteriousHerb(Player player) {
	        if (System.currentTimeMillis() - lastMysteriousHerbFarm < TimeUnit.SECONDS.toMillis(5)) {
	            player.sendMessage("You can only pick mysterious herbs from this bush every 5 seconds.");
	            return;
	        }
	        int level = player.playerLevel[player.playerFarming];
	        if (level < 56) {
	            player.sendMessage("You need a farming level of 56 to get this.");
	            return;
	        }
	        player.startAnimation(881);
	        lastMysteriousHerbFarm = System.currentTimeMillis();
	        player.getPA().addSkillXP(8, Skill.FARMING.getId(), true);
	        player.getItems().addItem(22402, 1);
	    }
	
	public static void resetCamera(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container1) {
			
			c.isFrozen = false;
			c.getPA().sendFrame107();
			container1.stop();
			
		}

		@Override
		public void stop() {
		}
	}, 8);
	}
	
    public long getLastMysteriousHerbFarm() {
        return lastMysteriousHerbFarm;
    }
    
    public void setLastMysteriousFarm(long millis) {
        Necromancy.lastMysteriousHerbFarm = millis;
    }
	
	 }
