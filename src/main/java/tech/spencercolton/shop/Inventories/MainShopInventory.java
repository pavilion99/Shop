package tech.spencercolton.shop.Inventories;

import org.bukkit.inventory.Inventory;
import org.json.simple.JSONObject;
import tech.spencercolton.shop.Exceptions.InventoryParseException;

/**
 * @author Spencer Colton
 */
public class MainShopInventory extends AbstractShopInventory {

    private Inventory i;

    public MainShopInventory(JSONObject j) {
        String a = j.toJSONString();
        try {
            Inventory g = parse(a);
            setInventory(g);
        } catch (InventoryParseException e) {

        }
    }

    @Override
    protected Inventory getInventory() {
        return i;
    }

    @Override
    protected void setInventory(Inventory i) {
        this.i = i;
    }

}
