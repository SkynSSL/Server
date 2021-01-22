package ethos.net.discord;

import java.awt.Color;
import java.net.URI;

import org.json.JSONObject;

import ethos.net.discord.Misc;

import ethos.net.discord.DiscordMessage;
import ethos.net.discord.WebhookClient;
import ethos.net.discord.WebhookClientBuilder;
import ethos.net.discord.DiscordEmbed;
import ethos.ServerProperties;

public class DiscordMessager extends JSONObject {

    public static boolean active = false;

    static ServerProperties SP             = new ServerProperties();
    private static String announcementHook  = SP.getProperty("announcementHook");
    private static String newplayersHook   = SP.getProperty("newplayersHook");
    private static String lootationsHook   = SP.getProperty("lootationsHook");
    private static String staffHook        = SP.getProperty("staffHook");
    private static String ingameHook       = SP.getProperty("ingameHook");
    private static String debugHook        = SP.getProperty("debugHook");
    private static String priestiegeHook   = SP.getProperty("priestiegeHook");

    private static void discordSendMsg(String msg, String webhook, String botUsername, Color color) {
        if (webhook != "") {
            try {
                WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook

                new DiscordEmbed.Builder().withTitle("SkyScape") // The title of the embed element
                    .withURL("www.skyscapelive.com") // The URL of the embed element
                    .withColor(color) // The color of the embed. You can leave this at null for no color
                    .withDescription( "Remember, you can mute any specific channel by clicking the bell in the top right of Discord.")
                    .build();

                DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)) // The content of the
                    .withUsername(botUsername) // Override the username of the bot
                    .build(); // Build the message

                client.sendPayload(message);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendAnnouncement(String msg) {
        discordSendMsg(msg, announcementHook, "Announcement Bot", Color.GREEN);
    }

    public static void sendPrestige(String msg) {
        discordSendMsg(msg, priestiegeHook, "Leveling Bot", Color.GREEN);
    }

    public static void sendLootations(String msg) {
        discordSendMsg(msg, lootationsHook, "Lootations Bot", Color.GREEN);
    }

    public static void sendNewPlayers(String msg) {
        discordSendMsg(msg, newplayersHook, "New Players Bot", Color.GREEN);
    }

    public static void sendStaffMessage(String msg) {
        discordSendMsg(msg, staffHook, "Staff Bot", Color.ORANGE);
    }

    public static void sendInGameMessage(String msg) {
        discordSendMsg(msg, staffHook, "In-Game Bot", Color.BLUE);
    }

    public static void sendDebugMessage(String msg) {
        discordSendMsg(msg, debugHook, "Debug Bot", Color.MAGENTA);
    }
}
