package net.craftions.skywars.util;

import net.craftions.skywars.SkyWars;
import net.craftions.skywars.teams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
        ArrayList<Player> onlinePlayers = Bukkit.getOnlinePlayers().stream().collect(Collectors.toCollection(ArrayList::new));
        int currentIndex = 0;
        for(int i = 0; i < SkyWars.teams; i++){
            for(int j = 0; j < onlinePlayers.size(); j++){
                Teams.teams[i].addPlayer(onlinePlayers.get(currentIndex));
                onlinePlayers.get(currentIndex).teleport(Teams.teams[i].getSpawn());
                onlinePlayers.get(currentIndex).sendMessage(SkyWars.prefix + "§7Du bist in Team " + Teams.teams[i].getColorCode() + Teams.teams[i].getName());
                // TODO Kits
                currentIndex++;
            }
        }
        // ** OLD **
        /* if(Bukkit.getOnlinePlayers().size() / SkyWars.teamSize == SkyWars.teams){
            int currentIndex = 0;
            for(int i = 0; i < SkyWars.teams; i++){
                for(int j = 0; j < onlinePlayers.size(); j++){
                    Teams.teams[i].addPlayer(onlinePlayers.get(currentIndex));
                    currentIndex++;
                }
            }
        }else {
        } */
        // ** OLD **
        SkyWars.isStarting = false;
        SkyWars.isStarted = true;
    }
}
