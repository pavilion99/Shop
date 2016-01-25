package tech.spencercolton.shop.Inventories;

import lombok.Getter;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Spencer Colton
 */
public class ShopInventory extends ShopInventoryFactory {

    @Getter
    private final UUID id;

    @Getter
    private Inventory i;

    @Getter
    private String name;

    private static Map<Inventory, ShopInventory> invs = new HashMap<>();

    @Getter
    private Map<Integer, String> actions = new HashMap<>();

    ShopInventory(String s, Inventory i, Map<Integer, String> actions) {
        id = UUID.randomUUID();
        name = s;
        this.i = i;
        this.actions = actions;
        invs.put(i, this);
    }

    public static ShopInventory getByInventory(Inventory i) {
        return invs.get(i);
    }

}
