package ethos.mining;

import ethos.Server;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.util.Misc;
import ethos.world.objects.GlobalObject;


/**
 * Handles The Spawn Event For The Random Spawning Mining Event
 * 
 * It Delays Every 30 Minutes Meaning 3600 Seconds Until The Object Spawns
 * With A Random Location
 * 
 * @author Su
 * @date Oct 29, 2018, 9:47:54 PM
 */
public class SpawnEvent {
	
	/*
	 * Spawns The Mining Rock Every 30 Minutes
	 */
	public static void handleSpawn(Player c) {
		CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container1) {
				
				if (Misc.random(10) == 0) {
					Server.getGlobalObjects().add(new GlobalObject(28496, 3005, 3632, 0, 0, 10, 3600, -1)); //Dark Warriors Fortress Spawn Location
					PlayerHandler.executeGlobalMessage("@blu@Mining Event: @bla@Fairy Rock Has Landed At The Dark Warriors Fortress!");
					handleAutoDeSpawn(c);
				} else if (Misc.random(8) == 0) {
					Server.getGlobalObjects().add(new GlobalObject(28496, 2937, 3146, 0, 0, 10, 3600, -1)); //Karamja Spawn Location
					PlayerHandler.executeGlobalMessage("@blu@Mining Event: @bla@Fairy Rock Has Landed In Karamja!");
					handleAutoDeSpawn(c);
				} else if (Misc.random(8) == 0) {
					Server.getGlobalObjects().add(new GlobalObject(28496, 3565, 3321, 0, 0, 10, 3600, -1)); //Barrows Spawn Location
					PlayerHandler.executeGlobalMessage("@blu@Mining Event: @bla@Fairy Rock Has Landed At Barrows!");
					handleAutoDeSpawn(c);
				} else {
					Server.getGlobalObjects().add(new GlobalObject(28496, 3116, 3492, 0, 0, 10, 3600, -1)); //Home Spawn Location
					PlayerHandler.executeGlobalMessage("@blu@Mining Event: @bla@Fairy Rock Has Landed At Home!");
					handleAutoDeSpawn(c);
				}
				
					
				container1.stop();
			}

			@Override
			public void stop() {
			}
		}, 3600);
	}
	
	/*
	 * Auto Deletes The Fairy Rock 1800 Seconds After It Spawns
	 */
	private static void handleAutoDeSpawn(Player c) {
		CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container1) {
				
				PlayerHandler.executeGlobalMessage("@blu@Mining Event: @bla@Fairy Rock Has Been Depleted!");
				Server.getGlobalObjects().add(new GlobalObject(-1, 3005, 3632, 0, 0, 10, -1, -1));
				Server.getGlobalObjects().add(new GlobalObject(-1, 2937, 3146, 0, 0, 10, -1, -1));
				Server.getGlobalObjects().add(new GlobalObject(-1, 3565, 3321, 0, 0, 10, -1, -1));
				Server.getGlobalObjects().add(new GlobalObject(-1, 3116, 3492, 0, 0, 10, -1, -1));
				c.isMiningEventActive = true;
				
				container1.stop();
			}

			@Override
			public void stop() {
			}
		}, 1800);
	}
	
	/*
	 * Manually Deletes The Fairy Rock If Called
	 */
	public static void handleDeSpawn(Player c) {
		PlayerHandler.executeGlobalMessage("@blu@Mining Event: @bla@Fairy Rock Has Been Depleted!");
		Server.getGlobalObjects().add(new GlobalObject(-1, 3005, 3632, 0, 0, 10, -1, -1));
		Server.getGlobalObjects().add(new GlobalObject(-1, 2937, 3146, 0, 0, 10, -1, -1));
		Server.getGlobalObjects().add(new GlobalObject(-1, 3565, 3321, 0, 0, 10, -1, -1));
		Server.getGlobalObjects().add(new GlobalObject(-1, 3116, 3492, 0, 0, 10, -1, -1));
		c.isMiningEventActive = true;
	}

}
