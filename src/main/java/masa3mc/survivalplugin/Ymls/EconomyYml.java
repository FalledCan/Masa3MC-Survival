package masa3mc.survivalplugin.Ymls;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class EconomyYml {
    private static File file;
    private static FileConfiguration cf;

    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("SurvivalPlugin").getDataFolder(), "Economy.yml");
        if(!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e){
                //lol
            }
        }
        cf = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return cf;
    }

    public static void save(){
        try {
            cf.save(file);
        }catch (IOException e){
            System.out.println("no save");
        }
    }

    public static void reload(){
        cf = YamlConfiguration.loadConfiguration(file);
    }
}
