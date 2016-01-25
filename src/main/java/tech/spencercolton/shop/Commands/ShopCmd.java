package tech.spencercolton.shop.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import tech.spencercolton.shop.Inventories.ShopInventory;
import tech.spencercolton.shop.Inventories.ShopInventoryFactory;
import tech.spencercolton.shop.Shop;
import tech.spencercolton.shop.Util.AbstractShopCommand;

/**
 * @author Spencer Colton
 */
public class ShopCmd extends AbstractShopCommand {

    @Override
    public void execute(CommandSender sender, String... args) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage(ChatColor.RED + "Sorry, this command cannot be run from the console.");
            return;
        }

        Player p = (Player)sender;

        ShopInventory inv = ShopInventoryFactory.getShopInventory("main");

        assert inv != null;

        if(!Shop.immutableInventories.contains(inv.getI()))
            Shop.immutableInventories.add(inv.getI());

        p.openInventory(inv.getI());
    }

}
