package masa3mc.survivalplugin.Commands.Other;

import masa3mc.survivalplugin.SurvivalPlugin;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AdminCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if(player.hasPermission("spl.adminmode")) {
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                if(player.hasPermission("spl.admin")){
                    player.setGameMode(GameMode.SURVIVAL);
                    File f = new File(SurvivalPlugin.getPlugin().getDataFolder().getAbsolutePath(), "/admin/" + player.getUniqueId() + ".yml");
                    FileConfiguration c = YamlConfiguration.loadConfiguration(f);
                    ItemStack[] content = ((List<ItemStack>) c.get("inventory.armor")).toArray(new ItemStack[0]);
                    player.getInventory().setArmorContents(content);
                    content = ((List<ItemStack>) c.get("inventory.content")).toArray(new ItemStack[0]);
                    player.getInventory().setContents(content);
                    player.sendMessage("§b[§aspl§b]§6 §cAdmin§6モードが§coff§6になりました");
                    Bukkit.dispatchCommand(console, "lp user " + player.getName() + " permission unset spl.admin");
                    Bukkit.dispatchCommand(console, "lp user " + player.getName() + " permission unset group.admin");
                    Bukkit.dispatchCommand(console, "deop " + player.getName());
                }else {
                    player.setGameMode(GameMode.CREATIVE);
                    File f = new File(SurvivalPlugin.getPlugin().getDataFolder().getAbsolutePath(), "/admin/" + player.getUniqueId() + ".yml");
                    FileConfiguration c = YamlConfiguration.loadConfiguration(f);
                    c.set("inventory.armor", player.getInventory().getArmorContents());
                    c.set("inventory.content", player.getInventory().getContents());
                    try {
                        c.save(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.sendMessage("§b[§aspl§b]§6 §cAdmin§6モードが§aon§6になりました");
                    Bukkit.dispatchCommand(console, "lp user " + player.getName() + " permission set spl.admin");
                    Bukkit.dispatchCommand(console, "lp user " + player.getName() + " permission set group.admin");
                    Bukkit.dispatchCommand(console, "op " + player.getName());
                    player.getInventory().clear();
                }
            }else {
                player.sendMessage("§b[§aspl§b]§a §cあなたはpermissionをもっていません");
            }
        }else {
            sender.sendMessage("§b[§aspl§b]§c this command cannot use bybybybybyby console");
        }
        return true;
    }
}