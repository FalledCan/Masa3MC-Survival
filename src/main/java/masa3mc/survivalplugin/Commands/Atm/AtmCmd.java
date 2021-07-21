package masa3mc.survivalplugin.Commands.Atm;

import masa3mc.survivalplugin.DBcontrol;
import masa3mc.survivalplugin.SurvivalPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AtmCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String spl = "§b[§aspl§b]§r ";

        if (sender instanceof Player) {
            DBcontrol dBcontrol = new DBcontrol();
            Player player = ((Player) sender).getPlayer();
            if(player.hasPermission("spl.atm")) {
                if (args.length == 0) {

                    player.sendMessage(spl + "/atm + [amount] -預金");
                    player.sendMessage(spl + "/atm - [amount] -引き出し");

                    player.sendMessage(spl + "§6ATM:残高は§a" + dBcontrol.get(player.getUniqueId(), true) + "§6円");
                    return true;
                }

                Economy economy = SurvivalPlugin.getEconomy();
                if (args[0].equalsIgnoreCase("+")) {
                    if(args.length == 2) {
                        long money = Integer.parseInt(args[1]);
                        if(money < 0){
                            player.sendMessage(spl + "§c0~1000000000円で指定してください。");
                            return true;
                        }
                        if(money >= 1000000000){
                            player.sendMessage(spl + "§c0~1000000000円で指定してください。");
                            return true;
                        }
                        if (economy.getBalance(player) >= money) {
                            economy.withdrawPlayer(player, money);
                            long atm = dBcontrol.get(player.getUniqueId(), true);
                            dBcontrol.update(player.getUniqueId(),null, String.valueOf(atm + money));
                            player.sendMessage(spl + "§6ATM:残高は§a" + dBcontrol.get(player.getUniqueId(), true) + "§6円");
                            return true;
                        } else {
                            player.sendMessage(spl + "§cお金が足りません");
                            return true;
                        }
                    }else {
                        player.sendMessage(spl + "/atm + [amount] -預金");
                        player.sendMessage(spl + "/atm - [amount] -引き出し");
                        return true;
                    }
                } else if (args[0].equalsIgnoreCase("-")) {
                    if(args.length == 2){
                        long money = Integer.parseInt(args[1]);
                        if(money < 0){
                            player.sendMessage(spl + "§c0~1000000000円で指定してください。");
                            return true;
                        }
                        if(money >= 1000000000){
                            player.sendMessage(spl + "§c0~1000000000円で指定してください。");
                            return true;
                        }
                        if (dBcontrol.get(player.getUniqueId(), true) >= money) {
                            economy.depositPlayer(player, money);
                            long atm = dBcontrol.get(player.getUniqueId(), true);
                            dBcontrol.update(player.getUniqueId(),null, String.valueOf(atm - money));
                            player.sendMessage(spl + "§6ATM:残高は§a" + dBcontrol.get(player.getUniqueId(), true) + "§6円");
                            return true;
                    }else {
                            player.sendMessage(spl + "§cお金が足りません");
                            return true;
                        }

                    } else {
                        player.sendMessage(spl + "/atm + [amount] -預金");
                        player.sendMessage(spl + "/atm - [amount] -引き出し");
                        return true;
                    }
                }else {
                    player.sendMessage(spl + "§c/atm");
                    return true;
                }
            }else {
                player.sendMessage("§cRank Regular-1以上が必要です。");
                return true;
            }
        }else {
            sender.sendMessage(spl+ ChatColor.RED + "this command cannot use by console");
            return true;
        }
    }
}
