package ethos.model.players.packets.commands.all;

import ethos.model.npcs.drops.DropManager;
import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class Droprate extends Command {

    @Override
    public void execute(Player player, String input) {
        double DropRate = DropManager.getModifier(player);
        DropRate *= -100;
        player.forcedChat("My drop rate bonus is : " +DropRate+ "%.");
    }

}


