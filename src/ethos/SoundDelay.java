package ethos;

import ethos.event.CycleEvent;
import ethos.event.CycleEventContainer;
import ethos.event.CycleEventHandler;
import ethos.model.players.Player;
import ethos.util.Misc;

public class SoundDelay {
	
	public static void arrowDelay1(Player c) {
		CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container1) {
				if (Misc.random(3) == 0) {
					arrowDelay2(c);
					c.sendAudio(361);
				} else if (Misc.random(3) == 0) {
					arrowDelay2(c);
					c.sendAudio(367);
				} else {
					arrowDelay2(c);
					c.sendAudio(370);
				}
				container1.stop();
			}

			@Override
			public void stop() {
			}
		}, (int) 1);
	}
	
	public static void arrowDelay2(Player c) {
		CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
			@Override
			public void execute(CycleEventContainer container2) {
				if (Misc.random(3) == 0) {
					c.sendAudio(361);
				} else if (Misc.random(3) == 0) {
					c.sendAudio(367);
				} else {
					c.sendAudio(370);
				}
				container2.stop();
			}

			@Override
			public void stop() {
			}
		}, (int) 1.5);
	}

}
