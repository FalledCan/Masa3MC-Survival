package masa3mc.survivalplugin.Commands.Atm;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AtmCmp implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1){
            List<String> pm = new ArrayList<String>();
            pm.add("+");
            pm.add("-");
            Collections.sort(pm);
            return pm;

        }
        return null;
    }
}
