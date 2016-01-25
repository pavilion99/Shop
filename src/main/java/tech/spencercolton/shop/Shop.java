package tech.spencercolton.shop;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import tech.spencercolton.shop.Inventories.ShopInventory;
import tech.spencercolton.shop.Util.JSONLoader;
import tech.spencercolton.shop.Util.ShopCommand;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Spencer Colton
 */
public class Shop extends JavaPlugin {

    private static File df;
    public static List<Inventory> immutableInventories = new ArrayList<>();
    public static Map<Player, Inventory> editingInventories = new HashMap<>();

    public static Map<String, ShopInventory> newInventory = new HashMap<>();

    @Override
    public void onEnable() {
        ShopCommand.initCommands();

        df = this.getDataFolder();

        JSONLoader.genMissing();
    }

    @Override
    public void onDisable() {

    }

    public static File getDf() {
        return df;
    }

}
