package tech.spencercolton.shop.Inventories;

import org.bukkit.inventory.Inventory;
import tech.spencercolton.shop.Exceptions.InventoryParseException;

/**
 * @author Spencer Colton
 */
public abstract class AbstractShopInventory {

    public Inventory renderInventory() {
        return this.getInventory();
    }

    public static Inventory parse(String s) throws InventoryParseException {

        return null;
    }

    protected abstract Inventory getInventory();
    protected abstract void setInventory(Inventory i);

}
