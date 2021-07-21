package masa3mc.survivalplugin.Commands.Other;

import fr.mrmicky.fastboard.FastBoard;
import masa3mc.survivalplugin.SurvivalPlugin;
import masa3mc.survivalplugin.Ymls.EconomyYml;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class SplCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String spl = "§b[§aspl§b]§r ";

        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if(args.length == 0){
                player.sendMessage(spl + "§c/spl help§6を使用してください");
                return true;
            }

            if(args[0].equalsIgnoreCase("help")){
                player.sendMessage(spl + "SurvivalPluginのコマンドリストです");
                player.sendMessage(spl + "/atm - ATM");
                player.sendMessage(spl + "/fly - flyをon/offします");
                player.sendMessage(spl + "/cmd - survivalで使えるコマンドを表示します");
                player.sendMessage(spl + "/ender - エンダーチェストを開きます");
                player.sendMessage(spl + "/spl sb - scoreboardのon/offの設定");
                player.sendMessage(spl + "/spl info - SurvivalPluginの情報が出ます");
                player.sendMessage(spl + "/rank - 自分のランクを確認できます");
                player.sendMessage(spl + "/nick [nickname] - ニックネームを変更できます");
                if(player.hasPermission("spl.admin")) {
                    player.sendMessage(spl + "/spl reload - SurvivalPluginがリロードされます");
                    player.sendMessage(spl + "/rankpoint [add/take] [player] [point] - rankpointの追加と取り上げ");
                }
            }else if(args[0].equalsIgnoreCase("reload")){
                if(player.hasPermission("spl.admin")) {
                    EconomyYml.reload();
                    player.sendMessage(spl + "§6reload完了");
                }else {
                    player.sendMessage(spl + "§cあなたはpermissionをもっていません");
                }
            }else if(args[0].equalsIgnoreCase("info")){
                PluginDescriptionFile pdf = SurvivalPlugin.getPlugin().getDescription();
                player.sendMessage(spl + "§6SurvivalPlugin - info");
                player.sendMessage(spl + "§6version - §a" + pdf.getVersion());
                player.sendMessage(spl + "§6authors - §aW_Siro");
            }else if(args[0].equalsIgnoreCase("sb")){
                if(SurvivalPlugin.boards.get(player.getUniqueId()) != null) {
                    FastBoard board = SurvivalPlugin.boards.get(player.getUniqueId());
                    board.delete();
                    SurvivalPlugin.boards.remove(player.getUniqueId());
                    player.sendMessage(spl + "§6scoreboardの表示 §coff");
                }else {
                    FastBoard board = new FastBoard(player);
                    board.updateTitle("§a§lSurvival");
                    SurvivalPlugin.boards.put(player.getUniqueId(),board);
                    player.sendMessage(spl + "§6scoreboardの表示 §aon");
                }
            }else {
                player.sendMessage(spl + "§c/spl help§6を使用してください");
            }
        }else {
            sender.sendMessage("§b[§aspl§b]§c this command cannot use by console");
        }
    return true;
    }
}
