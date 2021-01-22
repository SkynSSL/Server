package ethos.model.content;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ethos.Config;
import ethos.Server;
import ethos.model.items.GameItem;
import ethos.model.players.Boundary;
import ethos.model.players.Player;
import ethos.model.players.PlayerHandler;
import ethos.model.players.Right;
import ethos.util.Misc;

public class DeadlyChest {

	private static final int KEY2 = 13302;
	private static final int PKTicket = 2996;
	private static final int KEY_HALVE4 = 964;
	private static final int KEY_HALVE5 = 6104;
	private static final int ANIMATION = 881;

	private static final Map<Rarity, List<GameItem>> items = new HashMap<>();

	static {
		items.put(Rarity.COMMON1, Arrays.asList(
				new GameItem(13440, 15), //Raw Anglerfish Noted
				new GameItem(13440, 10), //Raw Anglerfish Noted
				new GameItem(13440, 5), //Raw Anglerfish Noted
				new GameItem(390, 15), //Raw Manta Noted
				new GameItem(390, 10), //Raw Manta Noted
				new GameItem(390, 5), //Raw Manta Noted
				new GameItem(3143, 15), //Raw Manta Noted
				new GameItem(3143, 10), //Raw Manta Noted
				new GameItem(3143, 5), //Raw Manta Noted
				new GameItem(11733, 1), //Overload (1)
				new GameItem(11732, 1), //Overload (2)
				new GameItem(11731, 1), //Overload (3)
				new GameItem(11730, 1), //Overload (4)
				new GameItem(1512, 10), //Logs
				new GameItem(1512, 20), //Logs
				new GameItem(1512, 30), //Logs
				new GameItem(1512, 40), //Logs
				new GameItem(1516, 10), //Yew Logs
				new GameItem(1516, 20), //Yew Logs
				new GameItem(1516, 30), //Yew Logs
				new GameItem(1516, 40), //Yew Logs
				new GameItem(1518, 10), //Maple Logs
				new GameItem(1518, 20), //Maple Logs
				new GameItem(1518, 30), //Maple Logs
				new GameItem(1518, 40), //Maple Logs
				new GameItem(44, 10), //Rune Arrowtips
				new GameItem(44, 20), //Rune Arrowtips
				new GameItem(44, 30), //Rune Arrowtips
				new GameItem(44, 40), //Rune Arrowtips
				new GameItem(554, 100), //Fire Rune
				new GameItem(555, 100), //Water Rune
				new GameItem(556, 100), //Air Rune
				new GameItem(557, 100), //Earth Rune
				new GameItem(558, 100), //Mind Rune
				new GameItem(559, 100), //Body Rune
				new GameItem(560, 100), //Death Rune
				new GameItem(561, 100), //Nature Rune
				new GameItem(562, 100), //Chaos Rune
				new GameItem(563, 100), //Law Rune
				new GameItem(564, 100), //Cosmic Rune
				new GameItem(565, 100), //Blood Rune
				new GameItem(1079, 1), //Rune Platelegs
				new GameItem(1093, 1), //Rune Plateskirt
				new GameItem(1113, 1), //Rune Chianbody
				new GameItem(1127, 1), //Rune Platebody
				new GameItem(1147, 1), //Rune Med Helm
				new GameItem(1163, 1), //Rune Full Helm
				new GameItem(1185, 1), //Rune SQ Shield
				new GameItem(1201, 1), //Rune Kiteshield
				new GameItem(1213, 1), //Rune Dagger
				new GameItem(1247, 1), //Rune Spear
				new GameItem(1275, 1), //Rune Pickaxe
				new GameItem(1289, 1), //Rune Sword
				new GameItem(1303, 1), //Rune Longsword
				new GameItem(1319, 1), //Rune 2h Sword
				new GameItem(1333, 1), //Rune Scimitar
				new GameItem(1347, 1), //Rune Warhammer
				new GameItem(1359, 1), //Rune Axe
				new GameItem(1373, 1), //Rune Battleaxe
				new GameItem(1436, 250), //Rune Essence
				new GameItem(4131, 1), //Rune Boots
				new GameItem(12379, 1), //Rune Cane
				new GameItem(537, 25), //Dragon Bones Noted
				new GameItem(1149, 1), //Dragon Med Helm
				new GameItem(1187, 1), //Dragon SQ Shield
				new GameItem(1215, 1), //Dragon Dagger
				new GameItem(1249, 1), //Dragon Spear
				new GameItem(1305, 1), //Dragon Longsword
				new GameItem(1377, 1), //Dragon Battleaxe
				new GameItem(1434, 1), //Dragon Mace
				new GameItem(1631, 3), //Uncut Dragonstone
				new GameItem(1748, 20), //Black Dragonhide Noted
				new GameItem(1750, 20), //Red Dragonhide Noted
				new GameItem(1752, 20), //Blue Dragonhide Noted
				new GameItem(1754, 20), //Green Dragonhide Noted
				new GameItem(7158, 1), //Dragon 2h Sword
				new GameItem(11212, 75), //Dragon Arrows
				new GameItem(11230, 75), //Dragon Darts
				new GameItem(11935, 50), //Dark Crab Noted
				new GameItem(12696, 5), //Super Combat Potion Noted (4)
				new GameItem(12730, 2), //Stamina Potion (4)
				new GameItem(12728, 2), //Air Rune Pack
				new GameItem(12730, 2), //Water Rune Pack
				new GameItem(12732, 2), //Earth Rune Pack
				new GameItem(12734, 2), //Fire Rune Pack
				new GameItem(12746, 2), //Mind Rune Pack
				new GameItem(12738, 2), //Chaos Rune Pack
				new GameItem(11990, 1), //Fedora
				new GameItem(437, 25), //Copper Ore
				new GameItem(439, 25), //Tin Ore
				new GameItem(441, 25), //Iron Ore
				new GameItem(443, 25), //Silver Ore
				new GameItem(445, 25), //Gold Ore
				new GameItem(448, 25), //Mith Ore
				new GameItem(450, 10), //Addy Ore
				new GameItem(452, 10), //Rune Ore
				new GameItem(1618, 10), //Uncut Diamond Noted
				new GameItem(1620, 10), //Uncut Ruby Noted
				new GameItem(1622, 10), //Uncut Emerald Noted
				new GameItem(1624, 10), //Uncut Saphhire Noted
				new GameItem(1626, 10), //Uncut Opal Noted
				new GameItem(1628, 10), //Uncut Jade Noted
				new GameItem(1630, 10))); //Uncut Red Topaz Noted
		
		items.put(Rarity.UNCOMMON1, Arrays.asList(
				new GameItem(1514, 10), //Magic Logs
				new GameItem(1514, 20), //Magic Logs
				new GameItem(1514, 30), //Magic Logs
				new GameItem(1514, 40), //Magic Logs
				new GameItem(2513, 1), //Dragon Chainbody
				new GameItem(4087, 1), //Dragon Platelegs
				new GameItem(4585, 1), //Dragon Plateskirt
				new GameItem(4587, 1), //Dragon Scimitar
				new GameItem(11256, 1), //Dragon Impling Jar
				new GameItem(11944, 15), //Lava Dragon Bones Noted
				new GameItem(19732, 1))); //Lucky Impling Jar
		items.put(Rarity.RARE1, Arrays.asList(
				new GameItem(6739, 1), //Dragon Axe
				new GameItem(11840, 1), //Dragon Boots
				new GameItem(11920, 1), //Dragon Pickaxe
				new GameItem(11335, 1), //Dragon Full Helm
				new GameItem(11889, 1), //Zamorakian Hasta
				new GameItem(11928, 1), //Odium Shard 1
				new GameItem(11929, 1), //Odium Shard 2
				new GameItem(11930, 1), //Odium Shard 3
				new GameItem(11931, 1), //Malediction Shard 1
				new GameItem(11932, 1), //Malediction Shard 2
				new GameItem(11933, 1), //Malediction Shard 3
				new GameItem(11998, 1), //Smoke Battlestaff
				new GameItem(12000, 1), //Mystic Smoke Battlestaff
				new GameItem(12020, 1), //Gem Bag
				new GameItem(12373, 1), //Dragon Cane
				new GameItem(12393, 1), //Royal
				new GameItem(12395, 1), //Royal
				new GameItem(12397, 1), //Royal
				new GameItem(12439, 1), //Royal
				new GameItem(12391, 1), //Gilded Boots
				new GameItem(12765, 1), //Dark Bow
				new GameItem(12829, 1))); // Spirit Shield
		items.put(Rarity.LEGENDARY1, Arrays.asList(
				new GameItem(13576, 1), //Dragon Warhammer
				new GameItem(20784, 1), //Dragon Claws
				new GameItem(21009, 1), //Dragon Sword
				new GameItem(21012, 1), //Dragon Hunter Crossbow
				new GameItem(21028, 1), //Dragon Harpoon
				new GameItem(11924, 1), //Odium Ward
				new GameItem(11926, 1), //Malediction Ward
				new GameItem(12002, 1), //Occult Necklace
				new GameItem(12004, 1), //Kraken Tentacle
				new GameItem(12006, 1), //Abyssal Whip
				new GameItem(12399, 1), //Partyhat & Specs
				new GameItem(12436, 1), //Amulet Of Fury (or)
				new GameItem(12596, 1), //Ranger's Tunic
				new GameItem(22500, 1), //Divine
				new GameItem(22501, 1), //Statius full helm
				new GameItem(22502, 1), //Statius platebody
				new GameItem(22503, 1), //Statius platelegs
				new GameItem(22504, 1), //Statius warhammer
				new GameItem(22505, 1), //Vesta's longsword
				new GameItem(22506, 1), //Vesta's spear
				new GameItem(22507, 1), //Vesta's chainbody
				new GameItem(22508, 1), //Vesta's plateskirt
				new GameItem(12927, 1))); //Serpentine Visage
	}

	private static GameItem randomChestRewards2(int chance) {
		int random = Misc.random(chance);
		List<GameItem> itemList = random < chance ? items.get(Rarity.COMMON1) : items.get(Rarity.UNCOMMON1);
		return Misc.getRandomItem(itemList);
	}
	
	private static GameItem randomChestRewards3(int chance) {
		int random2 = Misc.random(chance);
		List<GameItem> itemList2 = random2 < chance ? items.get(Rarity.COMMON1) : items.get(Rarity.RARE1);
		return Misc.getRandomItem(itemList2);
	}
	
	private static GameItem randomChestRewards4(int chance) {
		int random2 = Misc.random(chance);
		List<GameItem> itemList2 = random2 < chance ? items.get(Rarity.COMMON1) : items.get(Rarity.LEGENDARY1);
		return Misc.getRandomItem(itemList2);
	}

	public static void makeKey2(Player c) {
		if (c.getItems().playerHasItem(KEY_HALVE4, 1) && c.getItems().playerHasItem(KEY_HALVE5, 1)) {
			c.getItems().deleteItem(KEY_HALVE4, 1);
			c.getItems().deleteItem(KEY_HALVE5, 1);
			c.getItems().addItem(KEY2, 1);
		}
	}

	public static void searchChest2(Player c) {
		if (c.getItems().playerHasItem(KEY2)) {
			c.getItems().deleteItem(KEY2, 1);
			c.startAnimation(ANIMATION);
			c.getItems().addItem(PKTicket, 3);
			GameItem reward2 = Boundary.isIn(c, Boundary.DONATOR_ZONE) && c.getRights().isOrInherits(Right.DONATOR) ? randomChestRewards2(2) : randomChestRewards2(9);
			GameItem reward3 = Boundary.isIn(c, Boundary.DONATOR_ZONE) && c.getRights().isOrInherits(Right.DONATOR) ? randomChestRewards3(2) : randomChestRewards3(20);
			GameItem reward4 = Boundary.isIn(c, Boundary.DONATOR_ZONE) && c.getRights().isOrInherits(Right.DONATOR) ? randomChestRewards4(2) : randomChestRewards4(40);
			if (!c.getItems().addItem(reward2.getId(), reward2.getAmount())) {
				Server.itemHandler.createGroundItem(c, reward2.getId(), c.getX(), c.getY(), c.heightLevel, reward2.getAmount());
			}
			if (!c.getItems().addItem(reward3.getId(), reward3.getAmount())) {
				Server.itemHandler.createGroundItem(c, reward3.getId(), c.getX(), c.getY(), c.heightLevel, reward3.getAmount());
			}
			if (!c.getItems().addItem(reward4.getId(), reward4.getAmount())) {
				Server.itemHandler.createGroundItem(c, reward4.getId(), c.getX(), c.getY(), c.heightLevel, reward4.getAmount());
			}
			c.sendMessage("@blu@You stick your hand in the chest and pull an item out of the chest.");
			c.isSkulled = true;
			c.skullTimer = Config.SKULL_TIMER;
			c.headIconPk = 1;
			c.getPA().requestUpdates();
			PlayerHandler.executeGlobalMessage("[@red@Wild@bla@] @red@" + Misc.capitalize(c.playerName) + " @bla@has just opened the wildy chest!");
		} else {
			c.sendMessage("@blu@The chest is locked, it won't budge!");
		}
	}

	enum Rarity {
		UNCOMMON1, COMMON1, RARE1, LEGENDARY1
	}

}