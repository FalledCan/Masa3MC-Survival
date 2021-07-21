package masa3mc.survivalplugin.Commands.Fly;

import masa3mc.survivalplugin.Scoreboards;
import masa3mc.survivalplugin.SurvivalPlugin;
import masa3mc.survivalplugin.Ymls.EconomyYml;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class FlyCmd implements CommandExecutor {

    public static HashMap<String,Integer> fly = new HashMap<String, Integer>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String spl = "§b[§aspl§b]§r";

        if(sender instanceof Player){

            Player player = ((Player) sender).getPlayer();

            Economy economy = SurvivalPlugin.getEconomy();

            if(player.hasPermission("spl.fly")){

                if(!player.hasPermission("spl.fly.free")) {
                    if (player.getAllowFlight() == false) {
                        if (economy.getBalance(player) >= EconomyYml.get().getInt("Economy.fly")) {
                            economy.withdrawPlayer(player, EconomyYml.get().getInt("Economy.fly"));
                            player.setAllowFlight(true);
                            player.sendMessage(spl + " §6flyモード on(1時間)");
                            fly.put(player.getName(), 72000);
                            //Scoreboards sb = new Scoreboards();
                            //sb.onSBs(player);
                            return true;
                        } else {
                            player.sendMessage(spl + " §cflyモードをonにするには" + EconomyYml.get().getInt("Economy.fly") + "円必要です");
                            return true;
                        }
                    } else {
                        return true;
                    }
                }else {
                    if (player.getAllowFlight() == false) {
                        player.setAllowFlight(true);
                        player.sendMessage(spl + " §6flyモード on(1時間)");
                        fly.put(player.getName(), 72000);
                        return true;
                    } else {
                        return true;
                    }
                }
            }else {
                player.sendMessage(spl +" Rank-Gold-1以上が必要です。");
                return true;
            }
        }else {
            sender.sendMessage(spl+ ChatColor.RED + "this command cannot use bybybybybyby console");
            return true;
        }
    }
}
