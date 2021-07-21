package masa3mc.survivalplugin.Commands.Other;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplCmp implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1){
            List<String> cmd = new ArrayList<String>();
            cmd.add("sb");
            cmd.add("info");
            if(sender.hasPermission("spl.admin")){
                cmd.add("reload");
            }
            cmd.add("help");
            Collections.sort(cmd);
            return cmd;

        }
        return null;
    }
}
