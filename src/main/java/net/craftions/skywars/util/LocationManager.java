package net.craftions.skywars.util;

import org.bukkit.Location;

import java.util.HashMap;

public class LocationManager {

    private HashMap<String, Location> locs = new HashMap<String, Location>();

    public Location getLocation(String name){
        return locs.get(name);
    }

    public void setLocation(String name, Location loc){
        locs.put(name, loc);
    }
}
