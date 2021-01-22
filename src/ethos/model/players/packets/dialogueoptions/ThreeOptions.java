package ethos.model.players.packets.dialogueoptions;

import ethos.model.content.achievement_diary.ardougne.ArdougneDiaryEntry;
import ethos.model.content.achievement_diary.falador.FaladorDiaryEntry;
import ethos.model.content.achievement_diary.varrock.VarrockDiaryEntry;
import ethos.model.players.Boundary;
import ethos.model.players.Player;
import ethos.model.content.GambleJar;

/*
 * @author Matt
 * Three Option Dialogue actions
 */

public class ThreeOptions {

	/*
	 * Handles all first options on 'Three option' dialogues.
	 */
	public static void handleOption1(Player c) {
		switch (c.dialogueAction) {
		
		case 16050:
			
			break;
		
		case 7800:
			if (c.nlevel >= 9) {
			c.getDH().sendDialogues(7617, 10);
			} else {
				c.sendMessage("You need a necromancy level of 9 to do this.");
				c.getPA().closeAllWindows();
			}
			break;
		
		case 5000:
			c.getDH().sendNpcChat("There's 1/20 chance to get a pet after gamling a jar");
			break;
		case 152:
			c.getDH().sendDialogues(153, 1603);
			break;
		case 1428:
			c.getPrestige().openPrestige();
			break;
		case 809: // Withdraw
			// TODO: withdraw 10
			break;
		case 811: // Deposit
			// TODO: withdraw 10
			break;
		case 806:
			c.getDH().sendDialogues(811, 6773);
			break;

		case 71: // Jad, sell cape
			if (!c.getItems().playerHasItem(6570)) {
				c.sendMessage("You do not have a firecape.");
				return;
			}
			c.getItems().deleteItem(6570, 1);
			c.getItems().addItem(6529, 8_000);
			c.getPA().removeAllWindows();
			break;

		case 55:
			c.getCT().seas("TEN");
			c.dialogueAction = -1;
			c.getPA().removeAllWindows();
			break;
		case 56:
			c.getCT().swamp("TEN");
			c.dialogueAction = -1;
			c.getPA().removeAllWindows();
			break;
		}
		if (c.dialogueAction == 137) {
			c.sendAudio(1877);
			c.getPA().openUpBank();
			return;
		}
		if (c.dialogueAction == 126) {
			c.getPA().startTeleport(3039, 4835, 0, "modern", false);
			c.dialogueAction = -1;
			c.teleAction = -1;
			return;
		}
		switch (c.teleAction) {
		case 2:
			c.getPA().spellTeleport(1571, 3656, 0, false);
			break;
		}
		if (c.dialogueAction == 100) {
			c.getShops().openShop(80);
			return;
		}
		if (c.dialogueAction == 2245) {
			c.getPA().startTeleport(2110, 3915, 0, "modern", false);
			c.sendMessage("High Priest teleported you to @red@Lunar Island@bla@.");
			c.getPA().closeAllWindows();
		}
		if (c.dialogueAction == 508) {
			c.getDH().sendDialogues(1030, 925);
			return;
		}
		if (c.teleAction == 2) {
			// brim
			c.getPA().spellTeleport(1571, 3656, 0, false);
		}
		if (c.dialogueAction == 502) {
			c.getDH().sendDialogues(1030, 925);
			return;
		}
		if (c.dialogueAction == 251) {
			c.sendAudio(1877);
			c.getPA().openUpBank();
		}
		if (c.teleAction == 200) {
			c.getPA().spellTeleport(2662, 2652, 0, false);
		}
		if (c.doricOption) {
			c.getDH().sendDialogues(306, 284);
			c.doricOption = false;
		}
	}

	/*
	 * Handles all 2nd options on 'Three option' dialogues.
	 */
	public static void handleOption2(Player c) {

		switch (c.dialogueAction) {
		
		case 16050:
			c.getDH().sendDialogues(16052, 5419);
			break;
		
		case 7800:
			if (c.nlevel >= 10) {
			c.getDH().sendDialogues(7619, 10);
			} else {
				c.sendMessage("You need a necromancy level of 10 to do this.");
				c.getPA().closeAllWindows();
			}
			break;
			
		case 1428:
			c.getDH().sendNpcChat3("Prestiging will increase your drop rate.", "Experience rate: " + (c.prestige() * 100) + "%", "Your current prestige points: " + c.prestigePoints, 2989, "Ak-Haranu");
			c.nextChat = -1;
			break;
		case 809: // Withdraw
			// TODO: withdraw 100
			break;
		case 5000:
			GambleJar.execute(c);
			c.nextChat = -1;
			c.getPA().closeAllWindows();
			break;
		case 811: // Deposit
			// TODO: withdraw 100
			break;
		case 806:
			c.getDH().sendDialogues(809, 6773);
			break;
		case 71: // Jad, keep cape
			c.getPA().removeAllWindows();
			break;

		case 55:
			c.getCT().seas("HUNDRED");
			c.getPA().removeAllWindows();
			break;
		case 56:
			c.getCT().swamp("HUNDRED");
			c.getPA().removeAllWindows();
			break;
		}
		ethos.model.items.bank.BankPin pin = c.getBankPin();
		if (c.dialogueAction == 137) {
			pin = c.getBankPin();
			if (!pin.getPin().isEmpty()) {
				c.sendMessage("You already have a bank pin.");
				c.getPA().removeAllWindows();
			} else {
				pin.open(1);
			}
			return;
		}
		if (c.dialogueAction == 126) {
			if (Boundary.isIn(c, Boundary.VARROCK_BOUNDARY)) {
				c.getDiaryManager().getVarrockDiary().progress(VarrockDiaryEntry.TELEPORT_ESSENCE_VAR);
			}
			if (Boundary.isIn(c, Boundary.ARDOUGNE_BOUNDARY)) {
				c.getDiaryManager().getArdougneDiary().progress(ArdougneDiaryEntry.TELEPORT_ESSENCE_ARD);
			}
			if (Boundary.isIn(c, Boundary.FALADOR_BOUNDARY)) {
				c.getDiaryManager().getFaladorDiary().progress(FaladorDiaryEntry.TELEPORT_ESSENCE_FAL);
			}
			c.getPA().startTeleport(2929, 4813, 0, "modern", false);
			c.dialogueAction = -1;
			c.teleAction = -1;
			return;
		}
		switch (c.teleAction) {
		case 2:
			c.getPA().spellTeleport(1663, 3527, 0, false);
			c.teleAction = -1;
			break;
		}
		if (c.dialogueAction == 100) {
			c.getDH().sendDialogues(545, 315);
			return;
		}
		if (c.dialogueAction == 2245) {
			c.getPA().startTeleport(3230, 2915, 0, "modern", false);
			c.sendMessage("High Priest teleported you to @red@Desert Pyramid@bla@.");
			c.getPA().closeAllWindows();
		}
		if (c.dialogueAction == 508) {
			c.getDH().sendDialogues(1027, 925);
			return;
		}
		if (c.teleAction == 2) {
			// Tav
			c.getPA().spellTeleport(1663, 3527, 0, false);
		}
		if (c.dialogueAction == 502) {
			c.getDH().sendDialogues(1027, 925);
			return;
		}
		if (c.teleAction == 200) {
			c.getPA().spellTeleport(3365, 3266, 0, false);

		}
		if (c.doricOption) {
			c.getDH().sendDialogues(303, 284);
			c.doricOption = false;
		}
	}

	/*
	 * Handles all 3rd options on 'Three option' dialogues.
	 */
	public static void handleOption3(Player c) {
		switch (c.dialogueAction) {
		
		case 7800:
			c.getPA().closeAllWindows();
			break;
			
		case 809: // Withdraw
			// TODO: withdraw all
			break;
		case 811: // Deposit
			// TODO: withdraw all
			break;
		case 806:
			c.getDH().sendDialogues(807, 6773);
			break;
		case 71: // Bargain cape
			c.getDH().sendDialogues(72, 2180);
			break;
		case 55:
			c.getCT().seas("THOUSAND");
			c.getPA().removeAllWindows();
			break;
		case 56:
			c.getCT().swamp("THOUSAND");
			c.getPA().removeAllWindows();
			break;

		case 5000:
			c.getPA().removeAllWindows();
			c.nextChat = -1;
			break;
			
		case 126:
			if (c.dialogueAction == 126) {
				if (c.getItems().getItemCount(5509, true) == 1) {
					c.getDH().sendNpcChat("You already seem to have a pouch.");
				} else {
					c.getItems().addItem(5509, 1);
					c.getDH().sendItemStatement("The mage hands you a pouch", 5509);
					c.sendMessage("[Rc Pouch] Kill npcs with the pouch in inventory to upgrade it! 1\100 chance");
				}
			}
			break;
		}
		if (c.dialogueAction == 137) {
			c.getPA().removeAllWindows();
			return;
		}
		switch (c.teleAction) {
		case 2:
			c.getPA().spellTeleport(1262, 3501, 0, false);
			return;
		}
		if (c.dialogueAction == 14400 || c.dialogueAction == 100) {
			c.getPA().closeAllWindows();
		}
		if (c.dialogueAction == 2245) {
			c.getPA().closeAllWindows();
		}
		if (c.dialogueAction == 508) {
			c.nextChat = 0;
			c.getPA().closeAllWindows();
		}
		if (c.dialogueAction == 502 || c.dialogueAction == 1428) {
			c.nextChat = 0;
			c.getPA().closeAllWindows();
		}
		if (c.teleAction == 2) {
			c.getPA().spellTeleport(1262, 3501, 0, false);
		}
		if (c.dialogueAction == 251) {
			c.getDH().sendDialogues(1015, 394);
		}
		if (c.teleAction == 200) {
			c.getPA().spellTeleport(2439, 5169, 0, false);
			c.sendMessage("Use the cave entrance to start.");
		}
		if (c.doricOption) {
			c.getDH().sendDialogues(299, 284);
		}
	}

}