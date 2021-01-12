package net.craftions.skywars.commands;

import net.craftions.skywars.SkyWars;
import net.craftions.skywars.util.Game;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandStart implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int time = 0;
        if(args.length == 0){
            time = SkyWars.timeToStart;
        }else {
            try {
                int i = Integer.parseInt(args[0]);
            }catch(NumberFormatException ex){
                time = SkyWars.timeToStart;
            }
        }
        Game.start(time);
        return true;
    }
}
