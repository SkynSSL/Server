package ethos.construction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ethos.Server;
import ethos.model.players.Player;
import ethos.world.objects.GlobalObject;

public class ConstSave {
	
	public static void addSpawn(Player player, String object) {
		String filePath = "./Data/" + player.playerName + " Saved Objects.txt";
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(filePath, true));
			switch (object.toString()) {
			
			case "crate":
				bw.write("1	"+player.absX+"	"+player.absY+"	"+player.getHeightLevel+"	"+"0"+"	"+"10");
				Server.getGlobalObjects().add(new GlobalObject(1, player.absX, player.absY, player.getHeight()));
				System.out.println("Debug");
				break;

			case "test":
				
				break;
				
			}
			player.sendMessage("@red@You set spawn at: X: " + player.absX + ", Y: " + player.absY);
			bw.newLine();
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ignored) {
				}
			}
		}
	}

}
