package ethos.model.players.packets;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.text.WordUtils;

import ethos.Server;
import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.content.help.HelpDatabase;
import ethos.model.content.help.HelpRequest;
import ethos.model.content.presets.Preset;
import ethos.model.items.bank.BankPin;
import ethos.model.players.PacketType;
import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.model.players.Right;
import ethos.model.players.skills.necromancy.Necromancy;
import ethos.util.Misc;

public class InputField implements PacketType {
	
	public static void run(Player c) {
	CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
		@Override
		public void execute(CycleEventContainer container1) {
			
			container1.stop();
		}

		@Override
		public void stop() {
		}
	}, 1);
	}

	@Override
	public void processPacket(Player player, int packetType, int packetSize) {
		int id = player.inStream.readInteger();
		String text = player.inStream.readString();
		if (player.getInterfaceEvent().isActive()) {
			player.sendMessage("Please finish what you're doing.");
			return;
		}
		if (player.getTutorial().isActive()) {
			player.getTutorial().refresh();
			return;
		}
		//System.out.println("ID: " + id);
		switch (id) {
		
		case 9007: //Necromancy
				int spawnId = 0;
				try {
					spawnId = Integer.parseInt(text);
				} catch (NumberFormatException e) {
					player.sendMessage("@bla@Please enter a @red@number@bla!");
					return;
				}
				if (spawnId <= 0 || spawnId > 25) {
					player.sendMessage("@bla@You can only spawn a maximum of @red@25 @bla@monsters.");
					return;
				}
				if (player.getItems().playerHasItem(22405, spawnId)) {
					player.getItems().deleteItem(22405, spawnId);
					//player.getPA().sendFrame177(57, 50, 750, 5, 5);
	        		//Necromancy.resetCamera(player);
	        		player.getPA().movePlayer(3504, 3234, player.getIndex() * 4);
	        		player.getPA().closeAllWindows();
	        		
		         for(int i=0; i<spawnId; i++) {
		        	 if (player.chosenCow == true) {
		        		 Server.npcHandler.spawnNpc(player, 2805, 3503, 3225, player.getIndex() * 4, 1, 8, 2, 1, 1, false, true);
		        	 }
		        	 if (player.chosenChicken == true) {
		        		 Server.npcHandler.spawnNpc(player, 2692, 3503, 3225, player.getIndex() * 4, 1, 8, 2, 1, 1, false, true);
		        	 }
		        	 if (player.chosenGoblin == true) {
		        		 Server.npcHandler.spawnNpc(player, 2245, 3503, 3225, player.getIndex() * 4, 1, 8, 2, 1, 1, false, true);
		        	 }
		        	 if (player.chosenCaveBug == true) {
		        		 Server.npcHandler.spawnNpc(player, 481, 3503, 3225, player.getIndex() * 4, 1, 8, 2, 1, 1, false, true);
		        	 }
		        	 if (player.chosenMan == true) {
		        		 Server.npcHandler.spawnNpc(player, 3078, 3503, 3225, player.getIndex() * 4, 1, 8, 2, 1, 1, false, true);
		        	 }
		        	 if (player.chosenWoman == true) {
		        		 Server.npcHandler.spawnNpc(player, 3083, 3503, 3225, player.getIndex() * 4, 1, 8, 2, 1, 1, false, true);
		        	 }
		        	 if (player.chosenFarmer == true) {
		        		 Server.npcHandler.spawnNpc(player, 3088, 3503, 3225, player.getIndex() * 4, 1, 8, 2, 1, 1, false, true);
		        	 }
		        	 if (player.chosenThug == true) {
		        		 Server.npcHandler.spawnNpc(player, 2883, 3503, 3225, player.getIndex() * 4, 1, 8, 2, 1, 1, false, true);
		        	 }
		        	 if (player.chosenBanshee == true) {
		        		 Server.npcHandler.spawnNpc(player, 414, 3503, 3225, player.getIndex() * 4, 2, 16, 2, 2, 2, false, true);
		        	 }
		        	 if (player.chosenDesertLizard == true) {
		        		 Server.npcHandler.spawnNpc(player, 459, 3503, 3225, player.getIndex() * 4, 2, 16, 2, 2, 2, false, true);
		        	 }
		        	 if (player.chosenCrawlingHand == true) {
		        		 Server.npcHandler.spawnNpc(player, 457, 3503, 3225, player.getIndex() * 4, 2, 16, 2, 2, 2, false, true);
		        	 }
		        	 if (player.chosenKalphiteWorker == true) {
		        		 Server.npcHandler.spawnNpc(player, 955, 3503, 3225, player.getIndex() * 4, 2, 16, 2, 2, 2, false, true);
		        	 }
		        	 if (player.chosenSkeleton == true) {
		        		 Server.npcHandler.spawnNpc(player, 70, 3503, 3225, player.getIndex() * 4, 2, 16, 2, 2, 2, false, true);
		        	 }
		        	 if (player.chosenChaosDruid == true) {
		        		 Server.npcHandler.spawnNpc(player, 2878, 3503, 3225, player.getIndex() * 4, 2, 16, 2, 2, 2, false, true);
		        	 }
		        	 if (player.chosenGhost == true) {
		        		 Server.npcHandler.spawnNpc(player, 97, 3503, 3225, player.getIndex() * 4, 2, 16, 2, 2, 2, false, true);
		        	 }
		        	 if (player.chosenSandCrab == true) {
		        		 Server.npcHandler.spawnNpc(player, 5935, 3503, 3225, player.getIndex() * 4, 2, 16, 2, 2, 2, false, true);
		        	 }
		        }
				} else {
					player.sendMessage("@bla@You need @red@" + spawnId + "x @bla@vials of blood to resurrect this monster.");
				}
			break;
		
		case 38011: //Wogw donation amount
			player.wogwDonationAmount = Long.parseLong(text);
			if (player.wogwOption.isEmpty()) {
				player.sendMessage("You must choose something to donate towards.");
				return;
			}
			player.getPA().sendFrame171(0, 38020);
			player.getPA().sendFrame126("Are you sure you want to contribute\\n" + Misc.getValueWithoutRepresentation(player.wogwDonationAmount) + " gp?", 38022);
			break;
		
			/**
			 * Player shop name
			 */
		case 28054:
			player.sendMessage("Setting player shop name to: " + text);
			break;
			
			/**
			 * Player shop description
			 */
		case 28055:
			player.sendMessage("Setting player shop description to: " + text);
			break;

		case 33205:
			player.getPunishmentPanel().setReason(text);
			break;

		case 33211:
			player.getPunishmentPanel().setDuration(Integer.parseInt(text));
			break;

		case 53536:
			if (text.length() > 16) {
				player.sendMessage("Custom title length can only be sixteen characters, no more.");
				return;
			}
			player.getTitles().setTemporaryCustomTitle(text);
			break;
			
		case 39806:
			Server.getDropManager().search(player, text);
			break;

		case 59527:
			if (text.length() < 25) {
				player.sendMessage("Your help request must contain 25 characters for the description.");
				return;
			}
			List<Player> staff = PlayerHandler.nonNullStream().filter(Objects::nonNull).filter(p -> p.getRights().isOrInherits(Right.HELPER)).collect(Collectors.toList());
			if (HelpDatabase.getDatabase().requestable(player)) {
				HelpDatabase.getDatabase().add(new HelpRequest(player.playerName, player.connectedFrom, text));
				if (staff.size() > 0) {
					PlayerHandler.sendMessage("[HelpDB] " + WordUtils.capitalize(player.playerName) + "" + " is requesting help, type ::helpdb to view their request.", staff);
					player.sendMessage("You request has been sent, please wait as a staff member gets back to you.");
				} else {
					player.sendMessage("There are no staff online to help you at this time, please be patient.");
				}
			}
			player.getPA().removeAllWindows();
			break;

		case 32002:
			Preset preset = player.getPresets().getCurrent();
			if (preset == null) {
				player.sendMessage("You must select a preset before changing the name.");
				return;
			}
			preset.setAlias(text);
			player.getPresets().refreshMenus(preset.getMenuSlot(), preset.getMenuSlot() + 1);
			break;

		case 58063:
			if (player.getPA().viewingOtherBank) {
				player.getPA().resetOtherBank();
				return;
			}
			if (player.isBanking) {
				player.getBank().getBankSearch().setText(text);
				player.getBank().setLastSearch(System.currentTimeMillis());
				if (text.length() > 2) {
					player.getBank().getBankSearch().updateItems();
					player.getBank().setCurrentBankTab(player.getBank().getBankSearch().getTab());
					player.getItems().resetBank();
					player.getBank().getBankSearch().setSearching(true);
				} else {
					if (player.getBank().getBankSearch().isSearching())
						player.getBank().getBankSearch().reset();
					player.getBank().getBankSearch().setSearching(false);
				}
			}
			break;

		case 59507:
			if (player.getBankPin().getPinState() == BankPin.PinState.CREATE_NEW)
				player.getBankPin().create(text);
			else if (player.getBankPin().getPinState() == BankPin.PinState.UNLOCK)
				player.getBankPin().unlock(text);
			else if (player.getBankPin().getPinState() == BankPin.PinState.CANCEL_PIN)
				player.getBankPin().cancel(text);
			else if (player.getBankPin().getPinState() == BankPin.PinState.CANCEL_REQUEST)
				player.getBankPin().cancel(text);
			break;

		default:
			break;
		}
	}

}
