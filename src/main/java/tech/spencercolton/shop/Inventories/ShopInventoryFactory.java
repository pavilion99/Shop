package tech.spencercolton.shop.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import tech.spencercolton.shop.Exceptions.InventoryParseException;
import tech.spencercolton.shop.Util.JSONLoader;

import java.io.IOException;
import java.util.Map;

/**
 * @author Spencer Colton
 */
public abstract class ShopInventoryFactory {

    private static final int INVENTORY_SIZE = 36;

    @SuppressWarnings("unchecked")
    public static ShopInventory getShopInventory(String s) {
        try {
            JSONObject j = JSONLoader.get(s);

            assert j.get("items") instanceof Map;
            Map<Integer, Map<String, Object>> items = (Map) j.get("items");

            assert j.get("actions") instanceof Map;
            Map<Integer, String> actions = (Map) j.get("actions");

            assert j.get("name") instanceof String;
            String title = (String) j.get("name");

            Inventory e = Bukkit.createInventory(null, INVENTORY_SIZE, title);
            for (int i = 0; i < INVENTORY_SIZE; i++) {
                if (items.get(i) == null)
                    continue;

                e.setItem(i, ItemStack.deserialize(items.get(i)));
            }

            return new ShopInventory(title, e, actions);
        } catch(InventoryParseException|IOException|ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
