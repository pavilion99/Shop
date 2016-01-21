package tech.spencercolton.shop.Util;

import org.bukkit.command.CommandSender;

/**
 * @author Spencer Colton
 */
public abstract class AbstractShopCommand {

    public abstract void execute(CommandSender sender, String... args);

}
