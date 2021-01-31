package net.craftions.skywars.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class InteractEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (Objects.requireNonNull(e.getItem()).isSimilar(EventPlayerJoin.compass())) {
                Player p = e.getPlayer();
                Inventory Kitsauswahlinv = Bukkit.createInventory(null, InventoryType.PLAYER, "§6 Kits");

                Kitsauswahlinv.addItem(new ItemStack(Material.OAK_WOOD, 1));
                p.openInventory(Kitsauswahlinv);

            }
        }
    }
}
