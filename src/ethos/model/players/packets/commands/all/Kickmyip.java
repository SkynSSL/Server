package ethos.model.players.packets.commands.all;

import ethos.Server;
import ethos.event.CycleEventHandler;
import ethos.model.multiplayer_session.MultiplayerSession;
import ethos.model.multiplayer_session.MultiplayerSessionFinalizeType;
import ethos.model.players.ConnectedFrom;
import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

/**
 * Forces a given player to log out.
 * 
 * @author Emiel
 */
public class Kickmyip extends Command {

	@Override
	public void execute(Player c, String input) {
		if (Server.getMultiplayerSessionListener().inAnySession(c)) {
			MultiplayerSession session = Server.getMultiplayerSessionListener().getMultiplayerSession(c);
			session.finish(MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
			c.outStream.createFrame(109);
			CycleEventHandler.getSingleton().stopEvents(c);
			c.properLogout = true;			
			c.disconnected = true;
			c.logoutDelay = Long.MAX_VALUE;
			ConnectedFrom.addConnectedFrom(c, c.connectedFrom);
		}
		c.sendMessage("Kicked all your accounts.");
	} 
}
