package ethos.model.content;

import ethos.Server;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.players.Player;
import ethos.util.Misc;
import ethos.world.objects.GlobalObject;

public class StarterCrate {
	
	static Player c;
	public static int inUse = 0;
	
	public static void run(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container1) {
			
			openDelay(c);
			inUse++;
			c.isFrozen = true;
				
			container1.stop();
		}

		@Override
		public void stop() {
		}
	}, 1);
	}
	
	public static void openDelay(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container2) {
			Server.getGlobalObjects().add(new GlobalObject(21300, c.absX - 1, c.absY, c.getHeight(), 3, 10, 200, 21300));
			loopLoot(c);
			c.turnPlayerTo(c.absX - 1, c.absY);
			kneel(c);
			c.gfx(1118, c.getHeight());
			container2.stop();
		}

		@Override
		public void stop() {
		}
	}, (int) 6.2);
	}
	
	public static void kneel(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container3) {
					c.startAnimation(1331);
					unkneel(c);
					container3.stop();
		}

		@Override
		public void stop() {
		}
	}, 1);
	}
	
	public static void unkneel(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container4) {
					c.startAnimation(1332);
					container4.stop();
		}

		@Override
		public void stop() {
		}
	}, 8);
	}
	
	public static void loopLoot(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container5) {
			c.i = c.i + 1;
			int loot = Misc.random(29);
			c.getPA().createPlayersStillGfx(385, c.absX - 1, c.absY, 110, 0);
			
			if (loot >= 0 && loot < 4) {
				
			Server.itemHandler.removeGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), false);	
			Server.itemHandler.createGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), 150);
			Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 4 && loot < 9) {
				
			Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), 3);
			Server.itemHandler.removeGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 9 && loot < 13) {
				
			Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), 500000);
			Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 13 && loot < 16) {
				
			Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), 15);
			Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 16 && loot < 19) {
				
			Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), 10);
			Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 19 && loot < 23) {
				
			Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), Misc.random(1) + 1);
			Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 284, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), false);
			}
			
			if (loot == 23) {
				
			Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 24 && loot < 26) {
				
			Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 26 && loot < 28) {
				
			Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 28 && loot < 30) {
				
			Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), false);
			}
			
			if (c.i == 6) {
				stopAll(c);
				container5.stop();
			}

		}
		@Override
		public void stop() {
		}
	}, 2);
	}
	
	public static void stopAll(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container6) {
			c.i = 0;
			if (Server.itemHandler.getGroundItem(7462, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 7462, c.absX - 1, c.absY, c.getHeight(), true);
			} else if (Server.itemHandler.getGroundItem(2528, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 2528, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(3025, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 3025, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(2435, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 2435, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(995, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 995, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(990, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 990, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(386, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 386, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(2503, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 2503, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(2497, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 2497, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(2491, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 2491, c.absX - 1, c.absY, c.getHeight(), true);
			}
			
			c.spawnObject = true;
			c.runningDelay = true;
			deleteChest(c);
			
			container6.stop();

		}

		@Override
		public void stop() {
		}
	}, 3);
	}
	
	public static void deleteChest(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container7) {
			
					Server.getGlobalObjects().remove(21300, c.absX - 1, c.absY, c.getHeight());
					Server.getGlobalObjects().add(new GlobalObject (21299, c.absX - 1, c.absY, c.getHeight(), 3, 10, 200, 21299));
					c.isFrozen = false;
					inUse = 0;
					container7.stop();
		}

		@Override
		public void stop() {
		}
	}, 3);
	}
}