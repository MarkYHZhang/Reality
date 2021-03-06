package me.cheesepro.reality.utils;

import me.cheesepro.reality.Reality;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Mark on 2015-04-03.
 */
public class Messenger {
    private Reality plugin;
    private String prefix = "";

    public Messenger(Reality plugin) {
        this.plugin = plugin;
    }

    public void send(Player p, String c, String msg) {
        if (c.equalsIgnoreCase("*")) {
            p.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&', msg));
        } else {
            p.sendMessage(prefix + " " + color(c).toString() + msg);
        }
    }

    public void send(Player p, ChatColor chatColor, String msg) {
        p.sendMessage(prefix + " " + chatColor.toString() + msg);
    }

    public void important(Player p, String msg) {
        empty(p);
        empty(p);
        send(p, "4", ChatColor.STRIKETHROUGH + "-------------------[" + ChatColor.RESET.toString() + ChatColor.RED + ChatColor.BOLD.toString() + "IMPORTANT" + ChatColor.DARK_RED.toString() + ChatColor.STRIKETHROUGH + "]--------------------");
        empty(p);
        send(p, "e", msg);
        empty(p);
        send(p, "4", ChatColor.STRIKETHROUGH + "--------------------------------------------------");
    }

    public void help(Player p, List<String> lines){
        empty(p);
        empty(p);
        send(p, "a", ChatColor.STRIKETHROUGH + "-----------------------[" + ChatColor.RESET.toString() + ChatColor.YELLOW + "HELP" + ChatColor.GREEN.toString() + ChatColor.STRIKETHROUGH + "]----------------------");
        for(String line : lines){
            send(p, "e", line);
        }
        send(p, "a", ChatColor.STRIKETHROUGH + "--------------------------------------------------");
    }

    public void board(Player p, String title, List<String> lines){
        empty(p);
        empty(p);
        send(p, "e", ChatColor.STRIKETHROUGH + "-----------------------[" + ChatColor.RESET.toString() + ChatColor.LIGHT_PURPLE + title + ChatColor.YELLOW.toString() + ChatColor.STRIKETHROUGH + "]----------------------");
        for(String line : lines){
            send(p, "f", line);
        }
        send(p, "e", ChatColor.STRIKETHROUGH + "--------------------------------------------------");
    }

    public void empty(Player p){
        p.sendMessage("");
    }
    public void empty(Player p, int amount){
        for(int i = 0; i<amount; i++){
            p.sendMessage("");
        }
    }

    public void broadcast(String msg) {
        Bukkit.broadcastMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&', msg));
    }

    public void noPermission(Player p) {
        send(p, "4", "Sorry, but you have insufficient permissions. ");
    }

    private ChatColor color(String c) {
        if (c.equalsIgnoreCase("4")) {
            return ChatColor.DARK_RED;
        } else if (c.equalsIgnoreCase("c")) {
            return ChatColor.RED;
        } else if (c.equalsIgnoreCase("6")) {
            return ChatColor.GOLD;
        } else if (c.equalsIgnoreCase("e")) {
            return ChatColor.YELLOW;
        } else if (c.equalsIgnoreCase("2")) {
            return ChatColor.DARK_GREEN;
        } else if (c.equalsIgnoreCase("a")) {
            return ChatColor.GREEN;
        } else if (c.equalsIgnoreCase("b")) {
            return ChatColor.AQUA;
        } else if (c.equalsIgnoreCase("3")) {
            return ChatColor.DARK_AQUA;
        } else if (c.equalsIgnoreCase("1")) {
            return ChatColor.DARK_BLUE;
        } else if (c.equalsIgnoreCase("9")) {
            return ChatColor.BLUE;
        } else if (c.equalsIgnoreCase("d")) {
            return ChatColor.LIGHT_PURPLE;
        } else if (c.equalsIgnoreCase("5")) {
            return ChatColor.DARK_PURPLE;
        } else if (c.equalsIgnoreCase("f")) {
            return ChatColor.WHITE;
        } else if (c.equalsIgnoreCase("7")) {
            return ChatColor.GRAY;
        } else if (c.equalsIgnoreCase("8")) {
            return ChatColor.DARK_GRAY;
        } else if (c.equalsIgnoreCase("0")) {
            return ChatColor.BLACK;
        }
        return ChatColor.WHITE;
    }
}
