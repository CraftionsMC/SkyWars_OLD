package net.craftions.skywars.teams;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Team {

    private String name, colorCode;
    private Location spawn;
    private ArrayList<Player> players;

    public Team(String name, String colorCode, Location spawn) {
        this.name = name;
        this.colorCode = colorCode;
        this.spawn = spawn;
    }

    public String getColorCode() {
        return colorCode;
    }

    public String getName() {
        return name;
    }

    public Location getSpawn() {
        return spawn;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPLayer(Player p){
        players.add(p);
    }
}
