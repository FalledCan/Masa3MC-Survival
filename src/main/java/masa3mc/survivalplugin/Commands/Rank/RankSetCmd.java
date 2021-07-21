package masa3mc.survivalplugin.Commands.Rank;

import masa3mc.survivalplugin.Events;
import masa3mc.survivalplugin.RankUpDown.Rankdown;
import masa3mc.survivalplugin.RankUpDown.Rankup;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankSetCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if(!player.hasPermission("spl.admin")){
                player.sendMessage("§b[§aspl§b] §cあなたはpermissionの所持していません");
                return true;
            }
        }

        if(args.length == 3){
            if(args[0].equalsIgnoreCase("add")){
                Player player = Bukkit.getPlayer(args[1]);
                int point = Integer.parseInt(args[2]);
                if(!player.isOnline()){
                    sender.sendMessage("§cそのプレイヤーはオンラインではありません");
                    return true;
                }
                Events.point.put(player.getName(), Events.point.get(player.getName())+point);
                Rankup rankup = new Rankup();
                rankup.UserRankUp(player);
                sender.sendMessage("§b[§aspl§b]§6 " + player.getName() + "に" + point + "point追加しました。");
                return true;
            }else if(args[0].equalsIgnoreCase("take")){
                Player player = Bukkit.getPlayer(args[1]);
                int point = Integer.parseInt(args[2]);
                if(!player.isOnline()){
                    sender.sendMessage("§cそのプレイヤーはオンラインではありません");
                    return true;
                }
                Events.point.put(player.getName(), Events.point.get(player.getName())-point);
                Rankdown rankdown = new Rankdown();
                rankdown.UserRankDown(player);
                sender.sendMessage("§b[§aspl§b]§6 " + player.getName() + "に" + point + "point取りました。");
                return true;
            }
        }else {
            sender.sendMessage("§b[§aspl§b] §c/spl help§6を使用してください");
            return true;
        }
        return false;
    }
}
