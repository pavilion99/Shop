package tech.spencercolton.shop.Commands;

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
public class EditShopCmd extends AbstractShopCommand {

    @Override
    public void execute(CommandSender sender, String... args) {
        if(sender instanceof ConsoleCommandSender)
            return;

        String inv;
        if(args.length == 0)
            inv = "main";
        else
            inv = args[0];

        ShopInventory si = ShopInventoryFactory.getShopInventory(inv);

        if(si == null)
            return;

        Player p = (Player)sender;
        p.openInventory(si.getI());
        Shop.editingInventories.put(p, si.getI());
    }

}
