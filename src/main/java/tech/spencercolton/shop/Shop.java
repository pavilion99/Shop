package tech.spencercolton.shop;

import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import tech.spencercolton.shop.Inventories.MainShopInventory;
import tech.spencercolton.shop.Util.ShopCommand;

import java.io.File;

/**
 * @author Spencer Colton
 */
public class Shop extends JavaPlugin {

    private static Inventory main;
    private static File df;

    @Override
    public void onEnable() {
        ShopCommand.initCommands();

        df = this.getDataFolder();

        main = new MainShopInventory();
    }

    @Override
    public void onDisable() {

    }

    public static File getDf() {
        return df;
    }

}
