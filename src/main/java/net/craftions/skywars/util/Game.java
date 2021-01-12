package net.craftions.skywars.util;

import net.craftions.skywars.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Game {

    private static Boolean b0 = false;
    private static int id = 0;
    private static int count = 0;

    public static void start(int time){
        count = time;
        SkyWars.isStarting = true;
        id = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.skywars, new Runnable() {
            @Override
            public void run() {
                if(count == 0){
                    Bukkit.getScheduler().cancelTask(id);
                    start();
                }else {
                    if(count < 6){
                        Bukkit.broadcastMessage(SkyWars.prefix + "§7Das Spiel startet in §e" + count + "§r Sekunden.");
                    }else if(String.valueOf(count).endsWith("0") || String.valueOf(count).endsWith("5")){
                        Bukkit.broadcastMessage(SkyWars.prefix + "§7Das Spiel startet in §e" + count + "§r Sekunden.");
                    }
                }
                count--;
            }
        },0L, time*20);
    }

    protected static void start(){
        Player[] onlineArray = new Player[Bukkit.getOnlinePlayers().size()];
        int i = 0;
        for(Player p : Bukkit.getOnlinePlayers()){
            onlineArray[i] = p;
            i++;
        }
        SkyWars.isStarting = false;
        SkyWars.isStarted = true;
    }
}
