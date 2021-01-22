package ethos.model.players;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ethos.model.players.PlayerSave;;

public class Membership {

	public static void checkDate(Player c) {
		 if (getDaysLeft(c) >= 1) {
			c.sendMessage("You are a member, You have "
					+ getDaysLeft(c) + " days left.");

		} else if (c.membership && c.startDate <= 0) {

			c.sendMessage("Error #437: Report this error on the forums or to a staff member");

		} else if (getDaysLeft(c) <= 0) {
			c.membership = false;
			c.startDate = -1;
			c.sendMessage("Your membership has expired, you may renew at the in-game donation store.");
			PlayerSave.saveGame(c);
		}
	}

	public static int getDaysLeft(Player c) {
		if (c.startDate != -1) {
		return (30 - (getTodayDate(c) - c.startDate));
		} else {
		return 0;
		}
	}

	public static int getTodayDate(Player c) {
		Calendar cal = new GregorianCalendar();
		int dayofyear = cal.get(Calendar.DAY_OF_YEAR);
		return (dayofyear);
	}

	public Player c;

	public Membership(Player c) {
		this.c = c;
	}

	public static void giveMembership(Player c) {
		c.startDate = getTodayDate(c);
		c.membership = true;
		c.sendMessage("You have just received a month membership!");
		c.sendMessage("You are now a member. Please relog safely for your membership to take place.");
	}
}