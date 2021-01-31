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

import java.util.Objects;

public class EventPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        e.getPlayer().getInventory().addItem(compass());
    }


    public static ItemStack compass(){
        ItemStack compass = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta meta = compass.getItemMeta();
        Objects.requireNonNull(meta).setDisplayName("§6 Kits");
        compass.setItemMeta(meta);
        return compass;
    }
}

