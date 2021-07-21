package masa3mc.survivalplugin;

import fr.mrmicky.fastboard.FastBoard;
import masa3mc.survivalplugin.Commands.Fly.FlyCmd;
import masa3mc.survivalplugin.RankUpDown.Rankup;
import masa3mc.survivalplugin.Ymls.EconomyYml;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.*;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Random;

public class Events implements Listener {

    public static HashMap<String, Long> point = new HashMap<String, Long>();

    //Death - penalty
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        Player player = event.getEntity().getPlayer();

        //Economy
        Economy economy = SurvivalPlugin.getEconomy();
        int a = (int)economy.getBalance(player) * EconomyYml.get().getInt("Economy.Death")/100;
        economy.withdrawPlayer(player, a);
        player.setLevel(0);

    }

    //join event
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FastBoard board = new FastBoard(player);
        board.updateTitle("§a§lSurvival");
        SurvivalPlugin.boards.put(player.getUniqueId(),board);
        if(FlyCmd.fly.get(player.getName()) != null){
            player.setAllowFlight(true);
        }
        DBcontrol dBcontrol = new DBcontrol();

        //first
        if (!player.hasPlayedBefore()){

            dBcontrol.insert(player.getUniqueId());

            //firstItems
            //slot0
            ItemStack item1 = new ItemStack(Material.STONE_SWORD);
            ItemMeta meta1 = item1.getItemMeta();
            meta1.setDisplayName(ChatColor.GOLD + "firstItem");
            item1.setItemMeta(meta1);
            player.getInventory().setItem(0, item1);

            //slot1
            ItemStack item2 = new ItemStack(Material.STONE_PICKAXE);
            ItemMeta meta2 = item2.getItemMeta();
            meta2.setDisplayName(ChatColor.GOLD + "firstItem");
            item2.setItemMeta(meta2);
            player.getInventory().setItem(1, item2);

            //slot2
            ItemStack item3 = new ItemStack(Material.STONE_SHOVEL);
            ItemMeta meta3 = item3.getItemMeta();
            meta3.setDisplayName(ChatColor.GOLD + "firstItem");
            item3.setItemMeta(meta3);
            player.getInventory().setItem(2, item3);

            //slot3
            ItemStack item4 = new ItemStack(Material.STONE_AXE);
            ItemMeta meta4 = item4.getItemMeta();
            meta4.setDisplayName(ChatColor.GOLD + "firstItem");
            item4.setItemMeta(meta4);
            player.getInventory().setItem(3, item4);

            //slot4
            ItemStack item5 = new ItemStack(Material.COOKED_BEEF, 20);
            ItemMeta meta5 = item5.getItemMeta();
            meta5.setDisplayName(ChatColor.GOLD + "firstItem");
            item5.setItemMeta(meta5);
            player.getInventory().setItem(4, item5);

            //slot5
            ItemStack item6 = new ItemStack(Material.CLOCK);
            ItemMeta meta6 = item6.getItemMeta();
            meta6.setDisplayName(ChatColor.GOLD + "menu");
            item6.setItemMeta(meta6);
            player.getInventory().setItem(5, item6);

            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            Bukkit.dispatchCommand(console, "lp user " + player.getName() + " permission set group.beginner");
        }

        //join-Title
        player.sendTitle("§6§l- §a§lSurvival §6§l-", "§7Masa3MCNetwork", 20, 100, 20);

        //join-Message
        player.sendMessage("§7サーバー§cルール§7を守り遊ぼう!");
        player.sendMessage("§7Survivalサーバーで使えるコマンド一覧は[/cmd]で確認できます!");

        point.put(player.getName(), dBcontrol.get(player.getUniqueId(),false));


    }

    @EventHandler
    public void onQuitEvent(PlayerQuitEvent event){

        Player player = event.getPlayer();

        if(SurvivalPlugin.boards.get(player.getUniqueId()) != null)
            SurvivalPlugin.boards.remove(player.getUniqueId());

        DBcontrol dBcontrol = new DBcontrol();

        dBcontrol.update(player.getUniqueId(), String.valueOf(point.get(player.getName())),null);
        point.remove(player.getName());

    }


    private Rankup rankup;

    //mob-point
    @EventHandler
    public void onkillmob(EntityDeathEvent event) {

        if(event.getEntity().getKiller() instanceof Player) {
            Player player = event.getEntity().getKiller();
            if (!player.hasPermission("spl.admin")) {
                Entity death = event.getEntity();
                Economy economy = SurvivalPlugin.getEconomy();
                rankup = new Rankup();
                if (death.getType().equals(EntityType.ZOMBIE.isSpawnable())) {
                    int r = new Random().nextInt(5);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 1);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        economy.depositPlayer(player, 5);
                    }
                }

                if (death.getType().equals(EntityType.SKELETON)) {
                    int r = new Random().nextInt(5);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 1);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        economy.depositPlayer(player, 5);
                    }
                }

                if (death.getType().equals(EntityType.CREEPER)) {
                    int r = new Random().nextInt(15);
                    if (r < 3) {
                        point.put(player.getName(),point.get(player.getName()) + 2);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 2 point"));
                        economy.depositPlayer(player, 5);
                    }
                }

                if (death.getType().equals(EntityType.SPIDER)) {
                    int r = new Random().nextInt(15);
                    if (r < 3) {
                        point.put(player.getName(),point.get(player.getName()) + 2);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 2 point"));
                        economy.depositPlayer(player, 4);
                    }
                }

                if (death.getType().equals(EntityType.BLAZE)) {
                    int r = new Random().nextInt(5);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 1);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        economy.depositPlayer(player, 5);
                    }
                }

                if (death.getType().equals(EntityType.HUSK)) {
                    int r = new Random().nextInt(5);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 1);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        economy.depositPlayer(player, 5);
                    }
                }

                if (death.getType().equals(EntityType.GHAST)) {
                    int r = new Random().nextInt(5);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 1);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        economy.depositPlayer(player, 5);
                    }
                }

                if (death.getType().equals(EntityType.CAVE_SPIDER)) {
                    int r = new Random().nextInt(15);
                    if (r < 3) {
                        point.put(player.getName(),point.get(player.getName()) + 2);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 2 point"));
                        economy.depositPlayer(player, 4);
                    }
                }

                if (death.getType().equals(EntityType.DROWNED)) {
                    int r = new Random().nextInt(5);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 1);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        economy.depositPlayer(player, 5);
                    }
                }

                if (death.getType().equals(EntityType.ENDERMAN)) {
                    int r = new Random().nextInt(5);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 1);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        economy.depositPlayer(player, 3);
                    }
                }

                if (death.getType().equals(EntityType.PIGLIN)) {
                    int r = new Random().nextInt(5);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 1);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        economy.depositPlayer(player, 5);
                    }
                }

                if (death.getType().equals(EntityType.SLIME)) {
                    int r = new Random().nextInt(5);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 1);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        economy.depositPlayer(player, 1);
                    }
                }

                if (death.getType().equals(EntityType.WITHER_SKELETON)) {
                    int r = new Random().nextInt(3);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 2);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 2 point"));
                        economy.depositPlayer(player, 5);
                    }
                }

                if (death.getType().equals(EntityType.ZOMBIFIED_PIGLIN)) {
                    int r = new Random().nextInt(5);
                    if (r == 1) {
                        point.put(player.getName(),point.get(player.getName()) + 1);
                        rankup.UserRankUp(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        economy.depositPlayer(player, 5);
                    }
                }

                if (death.getType().equals(EntityType.ENDER_DRAGON)) {
                    point.put(player.getName(),point.get(player.getName()) + 20);
                    rankup.UserRankUp(player);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 20 point"));
                    economy.depositPlayer(player, 1000);
                }

                if (death.getType().equals(EntityType.WITHER)) {
                    point.put(player.getName(),point.get(player.getName()) + 25);
                    rankup.UserRankUp(player);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 25 point"));
                    economy.depositPlayer(player, 1500);
                }
            }
        }
    }

    @EventHandler(ignoreCancelled = true,priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("spl.admin")){
            rankup = new Rankup();
            if(!player.getWorld().getName().equals("lobby")){
                if(!player.getWorld().getName().equals("shop")){
                    if(!player.getWorld().getName().equals("tutorial")){
                        int r = new Random().nextInt(4);
                        if (r < 1) {
                            point.put(player.getName(),point.get(player.getName()) + 1);
                            rankup.UserRankUp(player);
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        }
                    }
                }
            }
        }
    }

    @EventHandler(ignoreCancelled = true,priority = EventPriority.HIGHEST)
    public void onBlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("spl.admin")){
            rankup = new Rankup();
            if(!player.getWorld().getName().equals("lobby")){
                if(!player.getWorld().getName().equals("shop")){
                    if(!player.getWorld().getName().equals("tutorial")){
                        int r = new Random().nextInt(4);
                        if (r < 1) {
                            point.put(player.getName(),point.get(player.getName()) + 1);
                            rankup.UserRankUp(player);
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent event){
        Player player = (Player) event.getWhoClicked();
        if(!player.hasPermission("spl.admin")){
            int r = new Random().nextInt(3);
            if (r < 1) {
                rankup = new Rankup();
                point.put(player.getName(),point.get(player.getName()) + 1);
                rankup.UserRankUp(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
            }
        }
    }

    @EventHandler
    public void onFish(PlayerFishEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("spl.admin")) {
            if (event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
                rankup = new Rankup();
                point.put(player.getName(),point.get(player.getName()) + 1);
                rankup.UserRankUp(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§arank + 1 point"));
            }
        }
    }

    //Anvil color
    @EventHandler
    public void onRenameItem(PrepareAnvilEvent event){
        if(event.getResult() != null && event.getResult().hasItemMeta() && event.getInventory().getRenameText() != ""){
            ItemStack re = event.getResult();
            ItemMeta rem = re.getItemMeta();
            String nc = ChatColor.translateAlternateColorCodes('&', event.getInventory().getRenameText());
            rem.setDisplayName(nc);
            re.setItemMeta(rem);
        }
    }

    //Changed world
    @EventHandler
    public void onChangedWorld(PlayerChangedWorldEvent event){
        Player player = event.getPlayer();
        if(FlyCmd.fly.get(player.getName()) != null) {
            player.setAllowFlight(true);
        }
        for(Player p : Bukkit.getOnlinePlayers()){
            if(p.hasPermission("spl.admin")){
                p.sendMessage("§b[§aspl§b]§r §6" + player.getName() + " §cmoved from §b" + event.getFrom().getName() + " §cto §b" + player.getWorld().getName());
            }

        }
        Bukkit.getConsoleSender().sendMessage("§b[§aspl§b]§r §6" + player.getName() + " §cmoved from §b" + event.getFrom().getName() + " §cto §b" + player.getWorld().getName());

    }
    @EventHandler
    public void ARST(PlayerArmorStandManipulateEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equalsIgnoreCase("lobby")){
            if(!player.getGameMode().equals(GameMode.CREATIVE)){
                event.setCancelled(true);
            }
        }
    }

}