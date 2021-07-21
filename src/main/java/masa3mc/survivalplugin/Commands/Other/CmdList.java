package masa3mc.survivalplugin.Commands.Other;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdList implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            //PlayerGet
            Player p = (Player) sender;

            //cmd-list
            p.sendMessage("§6コマンドの確認サイト");
            p.sendMessage("§6masa3mc.xyz/cmd/");

            return true;

        }else {
            sender.sendMessage("§b[§aspl§b]§c this command cannot use by console");
            return true;
        }
    }
}
