package tech.spencercolton.shop.Listeners;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

/**
 * @author Spencer Colton
 */
public class InventoryCloseListener implements Listener {

    @EventHandler
    @SuppressWarnings("unused")
    public void onEvent(InventoryCloseEvent e) {
        HumanEntity p = e.getPlayer();
        if(!(p instanceof Player))
            return;


    }

}
