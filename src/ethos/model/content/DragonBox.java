package ethos.model.content;

import ethos.Server;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.players.Player;
import ethos.util.Misc;
import ethos.world.objects.GlobalObject;

public class DragonBox {
	
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
	
	private static void openDelay(Player c) {
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
	
	private static void kneel(Player c) {
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
	
	private static void unkneel(Player c) {
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
	
	private static void loopLoot(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container5) {
			c.i = c.i + 1;
			int loot = Misc.random(75);
			c.getPA().createPlayersStillGfx(385, c.absX - 1, c.absY, 110, 0);
			
			if (loot >= 0 && loot < 35) {
				
			Server.itemHandler.removeGroundItem(c, 537, c.absX - 1, c.absY, c.getHeight(), false);	
			Server.itemHandler.createGroundItem(c, 537, c.absX - 1, c.absY, c.getHeight(), 25);
			Server.itemHandler.removeGroundItem(c, 1305, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4587, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1215, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1377, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4087, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4585, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11738, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11286, c.absX -1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 35 && loot < 40) {
				
			Server.itemHandler.removeGroundItem(c, 1305, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 1305, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 537, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4587, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1215, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1377, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4087, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4585, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11738, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11286, c.absX -1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 45 && loot < 50) {
				
			Server.itemHandler.removeGroundItem(c, 4587, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 4587, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 1305, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 537, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1215, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1377, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4087, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4585, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11738, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11286, c.absX -1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 50 && loot < 55) {
				
			Server.itemHandler.removeGroundItem(c, 1215, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 1215, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 1305, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4587, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 537, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1377, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4087, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4585, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11738, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11286, c.absX -1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 55 && loot < 60) {
				
			Server.itemHandler.removeGroundItem(c, 1377, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 1377, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 1305, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4587, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1215, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 537, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4087, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4585, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11738, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11286, c.absX -1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 60 && loot < 65) {
				
			Server.itemHandler.removeGroundItem(c, 4087, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 4087, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 1305, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4587, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1215, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1377, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 537, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4585, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11738, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11286, c.absX -1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 65 && loot < 70) {
				
			Server.itemHandler.removeGroundItem(c, 4585, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 4585, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 1305, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4587, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1215, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1377, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4087, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 537, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11738, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11286, c.absX -1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 70 && loot < 75) {
				
			Server.itemHandler.removeGroundItem(c, 11738, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 11738, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 1305, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4587, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1215, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1377, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4087, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4585, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 537, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11286, c.absX -1, c.absY, c.getHeight(), false);
			}
			
			if (loot >= 75) {
				
			Server.itemHandler.removeGroundItem(c, 11286, c.absX - 1, c.absY, c.getHeight(), false);
			Server.itemHandler.createGroundItem(c, 11286, c.absX - 1, c.absY, c.getHeight(), 1);
			Server.itemHandler.removeGroundItem(c, 1305, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4587, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1215, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 1377, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4087, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 4585, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 11738, c.absX -1, c.absY, c.getHeight(), false);
			Server.itemHandler.removeGroundItem(c, 537, c.absX -1, c.absY, c.getHeight(), false);
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
	
	private static void stopAll(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container6) {
			c.i = 0;
			if (Server.itemHandler.getGroundItem(537, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 537, c.absX - 1, c.absY, c.getHeight(), true);
			} else if (Server.itemHandler.getGroundItem(1305, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 1305, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(4587, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 4587, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(1215, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 1215, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(1377, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 1377, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(4078, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 4078, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(4087, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 4087, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(4087, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 4087, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(4585, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 4585, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(11738, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 11738, c.absX - 1, c.absY, c.getHeight(), true);
			}else if (Server.itemHandler.getGroundItem(11286, c.absX - 1, c.absY, c.getHeightLevel) != null) {
				Server.itemHandler.removeGroundItem(c, 11286, c.absX - 1, c.absY, c.getHeight(), true);
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
	
	private static void deleteChest(Player c) {
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