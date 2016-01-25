package tech.spencercolton.shop.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import tech.spencercolton.shop.Inventories.ShopInventory;
import tech.spencercolton.shop.Shop;

/**
 * @author Spencer Colton
 */
public class InventoryClickListener implements Listener {

    @EventHandler
    @SuppressWarnings("unused")
    public void onEvent(InventoryClickEvent e) {
        Inventory i = e.getClickedInventory();
        if(!Shop.immutableInventories.contains(i))
            return;

        e.setCancelled(true);
        ItemStack g = e.getCurrentItem();
        int h = e.getSlot();

        ShopInventory si = ShopInventory.getByInventory(i);
        assert si != null;

        String a = si.getActions().get(h);
        if(a == null)
            return;

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), a);
    }

}
