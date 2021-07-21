package masa3mc.survivalplugin.Commands.Other;

import masa3mc.survivalplugin.Scoreboards;
import masa3mc.survivalplugin.SurvivalPlugin;
import masa3mc.survivalplugin.Ymls.EconomyYml;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChests implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();

            Economy economy = SurvivalPlugin.getEconomy();

            if(player.hasPermission("spl.ender")) {
                if(!player.hasPermission("spl.ender.free")) {
                    if ((economy.getBalance(player) >= EconomyYml.get().getInt("Economy.enderchest"))) {

                        economy.withdrawPlayer(player, EconomyYml.get().getInt("Economy.enderchest"));
                        player.openInventory(player.getEnderChest());
                        //Scoreboards sb = new Scoreboards();
                        //sb.onSBs(player);
                        return true;
                    } else {
                        player.sendMessage("§b[§aspl§b]§c お金が足りません " + EconomyYml.get().getInt("Economy.enderchest") + "円必要");
                        return true;
                    }
                }else {
                    player.openInventory(player.getEnderChest());
                    return true;
                }
            }else {
                player.sendMessage("§b[§aspl§b] §cRank-Regular-1以上が必要です。");
                return true;
            }
        }else {
            sender.sendMessage("§b[§aspl§b]§c this command cannot use by console");
            return true;
        }
    }
}
