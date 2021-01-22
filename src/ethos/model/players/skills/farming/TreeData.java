package ethos.model.players.skills.farming;

import ethos.model.items.ItemAssistant;
import ethos.model.players.skills.farming.FarmingHerb.Herb;

public class TreeData {
	
	public enum Trees {
		OAK(5312, 1521, 120, 60, 15, 50),
		WILLOW(5313, 1520, 200, 100, 30, 125),
		YEW(5315, 1515, 375, 175, 60, 300),
		MAGIC(5316, 1513, 575, 275, 75, 550);
		
		int seedId, Log, plantXp, harvestXp, levelRequired, time;
		
		

		Trees(int seedId, int Log, int plantXp, int harvestXp, int levelRequired, int time) {
			this.seedId = seedId;
			this.Log = Log;
			this.plantXp = plantXp;
			this.harvestXp = harvestXp;
			this.levelRequired = levelRequired;
			this.time = time;
			
		}
		
		public int getSeedId() {
			return seedId;
		}

		public int getLog() {
			return Log;
		}

		public int getPlantingXp() {
			return plantXp;
		}

		public int getHarvestingXp() {
			return harvestXp;
		}

		public int getLevelRequired() {
			return levelRequired;
		}

		public int getGrowthTime() {
			return time;
		}

		public String getSeedName() {
			return ItemAssistant.getItemName(seedId);
		}

		public String getLogName() {
			return ItemAssistant.getItemName(Log);
		}
		
		
		
	}

	public static Trees getTreeForSeed(int seed) {
			for (Trees t : Trees.values())
				if (t.getSeedId() == seed)
					return t;
			return null;
		}

	

}
