package ethos;

import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.players.Player;

public class FoodDelay {
	
	public static void main(Player c) {
		CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container1) {
				c.sendAudio(317);
				container1.stop();
			}

			@Override
			public void stop() {
			}
		}, (int) 0.9);
	}

}
