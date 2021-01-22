package ethos.model.players.skills.herblore;

import ethos.Config;
import ethos.model.players.Player;
import ethos.model.players.skills.Skill;

public class SuperCombatPot {
	
	private Player c;
	
	public SuperCombatPot(Player client) {
		this.c = client;
	}
	
	public int Overload = 12695;
	public int Ingredients[] = {2442, 2440, 2436, 269};
	public int LvlReq = 90;
	public int XP = 150;
	
	public int getHerbloreLevel() {
		return c.getLevelForXP(c.playerXP[Skill.HERBLORE.getId()]);
	}
	
	public boolean hasAllIngredients() {
		if(c.getItems().playerHasItem(Ingredients[0]) && c.getItems().playerHasItem(Ingredients[1]) && c.getItems().playerHasItem(Ingredients[2])
				&& c.getItems().playerHasItem(Ingredients[3])) {
			return true;
		}
		return false;
	}
	
	public boolean correctAmount(int amt) {
		if(c.getItems().playerHasItem(Ingredients[0], amt) && c.getItems().playerHasItem(Ingredients[1], amt) && c.getItems().playerHasItem(Ingredients[2], amt)
				&& c.getItems().playerHasItem(Ingredients[3], amt)) {
			return true;
		}
	return false;
}
	
	public void makePot(Player c, int amt) {
		if(getHerbloreLevel() >= LvlReq) {
			if(hasAllIngredients() && correctAmount(amt)) {
				c.getItems().deleteItem2(Ingredients[0], amt);
				c.getItems().deleteItem2(Ingredients[1], amt);
				c.getItems().deleteItem2(Ingredients[2], amt);
				c.getItems().deleteItem2(Ingredients[3], amt);
				c.getItems().deleteItem2(Ingredients[4], amt);
				c.getItems().addItem(Overload, amt);
				c.getPA().addSkillXP((XP * amt) * Config.HERBLORE_EXPERIENCE, Skill.HERBLORE.getId(), true);
				
			} else {
				c.sendMessage("You need atleast 1 of each to make an overload.");
				c.sendMessage("@red@1x "+c.getItems().getItemName(Ingredients[0]));
				c.sendMessage("@red@1x "+c.getItems().getItemName(Ingredients[1]));
				c.sendMessage("@red@1x "+c.getItems().getItemName(Ingredients[2]));
				c.sendMessage("@red@1x "+c.getItems().getItemName(Ingredients[3]));
				c.sendMessage("@red@1x "+c.getItems().getItemName(Ingredients[4]));
				
			}
		} else {
			c.sendMessage("You need atleast "+LvlReq+" herblore to make overloads.");
		}
	}

}