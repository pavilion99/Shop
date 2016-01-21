package tech.spencercolton.shop.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tech.spencercolton.shop.Commands.EditShopCmd;
import tech.spencercolton.shop.Commands.ShopCmd;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Spencer Colton
 */
public class ShopCommand implements CommandExecutor {

    private static Map<String, AbstractShopCommand> commands = new HashMap<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String... args) {
        String name = cmd.getName().toLowerCase();

        if(commands.containsKey(name)) {
            commands.get(name).execute(sender, args);
            return true;
        }

        return false;
    }

    public static void initCommands() {
        commands.put("shop", new ShopCmd());
        commands.put("editshop", new EditShopCmd());
    }

}
