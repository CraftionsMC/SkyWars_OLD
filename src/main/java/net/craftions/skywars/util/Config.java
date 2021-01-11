package net.craftions.skywars.util;

import net.craftions.skywars.SkyWars;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private static FileConfiguration c = null;

    public static void loadConfig(){
        c = YamlConfiguration.loadConfiguration(new File("plugins/SkyWars/config.yml"));
    }

    public static void initConfig(){
        SkyWars.locationManager.setLocation("spawn_red", c.getLocation("team.red.spawn"));
        SkyWars.locationManager.setLocation("spawn_blue", c.getLocation("team.blue.spawn"));
        SkyWars.locationManager.setLocation("spawn_green", c.getLocation("team.green.spawn"));
        SkyWars.locationManager.setLocation("spawn_yellow", c.getLocation("team.yellow.spawn"));
    }

    public static void saveConfig() throws IOException {
        c.save(new File("plugins/SkyWars/config.yml"));
    }
}
