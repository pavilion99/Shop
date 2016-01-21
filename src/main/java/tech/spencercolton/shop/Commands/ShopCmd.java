package tech.spencercolton.shop.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
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


    }

}
