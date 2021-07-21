package masa3mc.survivalplugin;

import fr.mrmicky.fastboard.FastBoard;
import masa3mc.survivalplugin.Commands.Atm.AtmCmd;
import masa3mc.survivalplugin.Commands.Atm.AtmCmp;
import masa3mc.survivalplugin.Commands.Fly.FlyCmd;
import masa3mc.survivalplugin.Commands.Fly.FlySpeedCmd;
import masa3mc.survivalplugin.Commands.Other.*;
import masa3mc.survivalplugin.Commands.Rank.RankCmd;
import masa3mc.survivalplugin.Commands.Rank.RankSetCmd;
import masa3mc.survivalplugin.Ymls.EconomyYml;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

public final class SurvivalPlugin extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static SurvivalPlugin plugin;
    public static Map<UUID, FastBoard> boards = new HashMap<>();

    @Override
    public void onEnable() {

        plugin = this;

        getLogger().info(ChatColor.GREEN +"SurvivalPluginが有効になりました。");

        loadYmlFiles();

        DBcontrol dBcontrol = new DBcontrol();

        dBcontrol.loadDB();
        for(Player player: Bukkit.getOnlinePlayers()){
            Events.point.put(player.getName(), dBcontrol.get(player.getUniqueId(),false));
        }

        Run run = new Run();
        run.crun();

        getServer().getPluginManager().registerEvents(new Events(),this);

        getCommand("spl").setExecutor(new SplCommands());

        getCommand("spl").setTabCompleter(new SplCmp());

        getCommand("atm").setExecutor(new AtmCmd());

        getCommand("atm").setTabCompleter(new AtmCmp());

        getCommand("fly").setExecutor(new FlyCmd());

        getCommand("cmd").setExecutor(new CmdList());

        getCommand("ender").setExecutor(new EnderChests());

        getCommand("rank").setExecutor(new RankCmd());

        getCommand("rankpoint").setExecutor(new RankSetCmd());

        getCommand("nick").setExecutor(new NickCmd());

        getCommand("admin").setExecutor(new AdminCmd());

        getCommand("fs").setExecutor(new FlySpeedCmd());

        //^e^
        for(Player player : Bukkit.getServer().getOnlinePlayers()){
            FastBoard board = new FastBoard(player);
            board.updateTitle("§a§lSurvival");
            boards.put(player.getUniqueId(),board);
        }

        //set up Economy
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }


    }

    private void loadYmlFiles() {
        //EconomyYml
        EconomyYml.setup();
        EconomyYml.get().options().copyDefaults(true);
        if(EconomyYml.get().get("Economy") == null){
            EconomyYml.get().set("Economy.Death", 5);
            EconomyYml.get().set("Economy.fly", 30000);
            EconomyYml.get().set("Economy.enderchest", 50);
        }
        EconomyYml.save();

    }

    public static SurvivalPlugin getPlugin(){
        return plugin;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    @Override
    public void onDisable() {

        getLogger().info(ChatColor.RED +"SurvivalPluginが無効になりました。");
        for(Player player: Bukkit.getOnlinePlayers()){
            DBcontrol dBcontrol = new DBcontrol();
            dBcontrol.update(player.getUniqueId(), String.valueOf(Events.point.get(player.getName())),null);
            Bukkit.getConsoleSender().sendMessage(player.getName() + "のランクポイントを保存しましたぞい!");
        }

    }

}
