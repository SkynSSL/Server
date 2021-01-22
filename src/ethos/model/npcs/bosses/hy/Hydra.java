package ethos.model.npcs.bosses.hy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import ethos.Server;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.content.instances.SingleInstancedArea;
import ethos.model.minigames.rfd.DisposeTypes;
import ethos.model.npcs.NPC;
import ethos.model.npcs.NPCHandler;
import ethos.model.players.Boundary;
import ethos.model.players.Player;
import ethos.util.Misc;
import ethos.world.objects.GlobalObject;

public class Hydra extends SingleInstancedArea {

	/**
	 * Player variables, start coordinates.
	 */
	private static final int START_X = 1359, START_Y = 10259;
	
	/**
	 * Npc variables, start coordinates.
	 */
	private static final int SPAWN_X = 1368, SPAWN_Y = 10269, CERBERUS_ID = 8615, SUMMONED_SOUL_RANGE = 8620, SUMMONED_SOUL_MAGIC = 8619, SUMMONED_SOUL_MELEE = 8621;


	public Hydra(Player player, Boundary boundary, int height) {
		super(player, boundary, height);
	}
	
	public void hydraSpecials() {
		NPC HYDRA = NPCHandler.getNpc(8615, height);
		
		if (HYDRA.isDead) {
			return;
		}
		
		int random = Misc.random(7);
		
		if (HYDRA.getHealth().getAmount() < 400) {
			if (random == 1) {
				List<NPC> ghost = Arrays.asList(NPCHandler.npcs);
				if (ghost.stream().filter(Objects::nonNull)
						.anyMatch(n -> n.npcType == SUMMONED_SOUL_RANGE || n.npcType == SUMMONED_SOUL_MAGIC
								|| n.npcType == SUMMONED_SOUL_MELEE && height == n.heightLevel && !n.isDead)) {
					return;
				}
				NPCHandler.npcs[HYDRA.getIndex()].forceChat("RAWRRRRRRRRRRRRRR");
				player.CERBERUS_ATTACK_TYPE = "GHOST_ATTACK";
				CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
					int ticks = 0;
					@Override
					public void execute(CycleEventContainer container) {
						if (player.disconnected) {
							stop();
							return;
						}
						switch (ticks++) {
						case 1:
							Server.npcHandler.spawnNpc(player, SUMMONED_SOUL_RANGE, 1369, 10265, height, 0, 600, 30, 170, 240, true, false);
							player.CERBERUS_ATTACK_TYPE = "MELEE";
							break;
							
						case 2:
							Server.npcHandler.spawnNpc(player, SUMMONED_SOUL_MAGIC, 1363, 10270, height, 0, 600, 30, 170, 240, true, false);
							break;
							
						case 3:
							Server.npcHandler.spawnNpc(player, SUMMONED_SOUL_MELEE, 1363, 10260, height, 0, 600, 30, 170, 240, true, false);
							break;
							
						case 5:
							NPCHandler.kill(SUMMONED_SOUL_RANGE, height);
							NPCHandler.kill(SUMMONED_SOUL_MAGIC, height);
							NPCHandler.kill(SUMMONED_SOUL_MELEE, height);
							container.stop();
							break;
						}
					}

					@Override
					public void stop() {

					}
				}, 2);
			}
		}
		
		if (HYDRA.getHealth().getAmount() < 201) {
			if (random == 5) {
				player.CERBERUS_ATTACK_TYPE = "GROUND_ATTACK";
			}
		}
	}

	/**
	 * Constructs the content by creating an event
	 */
	public void init() {
		Server.npcHandler.spawnNpc(player, CERBERUS_ID, SPAWN_X, SPAWN_Y, height, 0, 600, 23, 350, 540, false, false);
		player.getPA().movePlayer(START_X, START_Y, height);
		player.sendMessage("Prepare to fight...");
		
		player.CERBERUS_ATTACK_TYPE = "FIRST_ATTACK";

		Server.getGlobalObjects().add(new GlobalObject(23105, 1241, 1242, height, 0, 10, -1, -1));
		Server.getGlobalObjects().add(new GlobalObject(23105, 1240, 1242, height, 0, 10, -1, -1));
		Server.getGlobalObjects().add(new GlobalObject(23105, 1239, 1242, height, 0, 10, -1, -1));
		Server.getGlobalObjects().add(new GlobalObject(23105, 1240, 1236, height, 0, 10, -1, -1));
	}

	/**
	 * Disposes of the content by moving the player and finalizing and or removing any left over content.
	 * 
	 * @param dispose the type of dispose
	 */
	public final void end(DisposeTypes dispose) {
		if (player == null) {
			return;
		}
		
		if (dispose == DisposeTypes.COMPLETE) {
			//player.sendMessage("You killed cerberus.");
		} else if (dispose == DisposeTypes.INCOMPLETE) {
			Server.getGlobalObjects().remove(23105, height);				
			NPCHandler.kill(CERBERUS_ID, height);						
			NPCHandler.kill(SUMMONED_SOUL_RANGE, height);
			NPCHandler.kill(SUMMONED_SOUL_MAGIC, height);
			NPCHandler.kill(SUMMONED_SOUL_MELEE, height);
		}
	}

	@Override
	public void onDispose() {
		end(DisposeTypes.INCOMPLETE);
	}
	
}
