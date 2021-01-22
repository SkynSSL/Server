package ethos.model.players;

import java.util.Calendar;

public class DailyLogin {

	private static Calendar cal = Calendar.getInstance();
	private static int year = cal.get(Calendar.YEAR);
	private static int date = cal.get(Calendar.DAY_OF_MONTH);
    private static int month = cal.get(Calendar.MONTH)+1;
    
    private Player c;
    
	DailyLogin(Player client) {
		this.c = client;
	}

	public static int getLastDayOfMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month -1, date);
		return calendar.getActualMaximum(date);
	}
	private void IncreaseStreak() {
		c.LastLoginYear = year;
		c.LastLoginDate = date;
		c.LastLoginMonth = month;
		c.LoginStreak++;
		switch(c.LoginStreak) {
		case 1: //1 login
			c.getItems().addItem(995, 50000);
			c.sendMessage("You have logged in for the first time! Log in tomorrow for a better reward");
			break;
		case 2: //2 logins
			c.getItems().addItem(1464, 1);
			c.sendMessage("You have logged in for the second time! Log in tomorrow for a better reward");
			break;
		case 3: //3 logins
			c.getItems().addItem(1464, 1);
			c.sendMessage("You have logged in for the third time! Log in tomorrow for a better reward");
			break;
		case 4: //4 logins
			c.getItems().addItem(1464, 2);
			c.sendMessage("You have logged in for the fourth time! Log in tomorrow for a better reward");
			break;
		case 5: //5 logins
			c.getItems().addItem(1464, 2);
			c.sendMessage("You have logged in for the fifth time! Log in tomorrow for a better reward");
			break;
		case 6: //6 logins
			c.getItems().addItem(1464, 3);
			c.sendMessage("You have logged in for the sixth time! Log in tomorrow for a better reward");
			break;
		case 7: //7 logins
			c.getItems().addItem(1464, 3);
			c.sendMessage("You have logged in for the seventh time! Log in tomorrow for a better reward");
			break;
		case 8: //8 logins
			c.getItems().addItem(1464, 4);
			c.sendMessage("You have logged in for the eighth time! Log in tomorrow for a better reward");
			break;
		case 9: //9 logins
			c.getItems().addItem(6199, 1);
			c.sendMessage("You have logged in for the ninth time! Log in tomorrow for a better reward");
			break;
		case 10: //10 logins
			c.getItems().addItem(21807, 1);
			c.sendMessage("You have logged in for the tenth time, and recieved a relic!");
			PlayerHandler.executeGlobalMessage("[@blu@News@bla@]@blu@ " + c.playerName + " @bla@has just logged in 10 days in a row!");
			c.LoginStreak = 0;
			break;
		}
	}
	private void RefreshDates() {
		cal = Calendar.getInstance();
	   year = cal.get(Calendar.YEAR);
	   date = cal.get(Calendar.DAY_OF_MONTH);
	   month = cal.get(Calendar.MONTH)+1;
	}
	void LoggedIn() {
		RefreshDates();
		if ((c.LastLoginYear == year) && (c.LastLoginMonth == month) && (c.LastLoginDate == date)) {
			c.sendMessage("You have already recieved your daily reward for today.");
			return;
		}
		if ((c.LastLoginYear == year) && (c.LastLoginMonth == month) && (c.LastLoginDate == (date - 1)))
			IncreaseStreak();
		else if ((c.LastLoginYear == year) && ((c.LastLoginMonth + 1) == month) && (1 == date))
			IncreaseStreak();
		else if ((c.LastLoginYear == year-1) && (1 == month) && (1 == date))
			IncreaseStreak();
		else {
			c.LoginStreak = 0;
			IncreaseStreak();
		}
	}
}