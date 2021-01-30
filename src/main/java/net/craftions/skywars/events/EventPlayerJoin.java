package net.craftions.skywars.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.graalvm.compiler.phases.schedule.SchedulePhase;

public class EventPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        e.getPlayer().getInventory().addItem(compass());


    }

    public void onClick(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getItem().isSimilar(compass())){
                Player p = e.getPlayer();
                Inventory kitsauswahlinv = Bukkit.createInventory(null, InventoryType.CHEST,"§6 Kits");


            }
        }


    }

    public ItemStack compass(){
        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName("§6 Kits");
        compass.setItemMeta(meta);
        return compass;

    }
}
