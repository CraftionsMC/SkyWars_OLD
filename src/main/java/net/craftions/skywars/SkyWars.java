package net.craftions.skywars;

import net.craftions.skywars.commands.CommandStart;
import net.craftions.skywars.teams.Team;
import net.craftions.skywars.teams.Teams;
import net.craftions.skywars.util.Config;
import net.craftions.skywars.util.LocationManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyWars extends JavaPlugin {

    public static final String prefix = "[§eSky§cWars§r] ";
    public static Boolean isStarted = false;
    public static Boolean isStarting = false;
    public static Integer timeToStart = 60;
    public static Integer timeToStop = 600;
    public static Integer teamSize = 1;
    public static Integer teams = 4;
    public static SkyWars skywars;
    public static LocationManager locationManager = new LocationManager();

    @Override
    public void onEnable() {
        // Plugin startup logic
        Config.loadConfig();
        Config.initConfig();
        skywars = this;
        getCommand("start").setExecutor(new CommandStart());
        Teams.teams[0] = new Team("Rot", "§c", locationManager.getLocation("spawn_rot"));
        Teams.teams[1] = new Team("Blau", "§1", locationManager.getLocation("spawn_blue"));
        Teams.teams[2] = new Team("Grün", "§2", locationManager.getLocation("spawn_green"));
        Teams.teams[3] = new Team("Gelb", "§e", locationManager.getLocation("spawn_yellow"));
        System.out.println(prefix + "Loaded SkyWars v" + this.getDescription().getVersion() + " by " + this.getDescription().getAuthors().toString());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
