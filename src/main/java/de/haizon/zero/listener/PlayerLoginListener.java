package de.haizon.zero.listener;

import de.haizon.zero.permissions.PermissionBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.lang.reflect.Field;

/**
 * JavaDoc this file!
 * Created: 24.10.2022
 *
 * @author Haizoooon (maxhewa@gmail.com)
 */
public class PlayerLoginListener implements Listener {

    @EventHandler
    public void handle(PlayerLoginEvent event){

        Player player = event.getPlayer();

        try {
            Class<?> craftHumanEntity = Class.forName(
                    "org.bukkit.craftbukkit." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + ".entity.CraftHumanEntity"
            );
            Field field = craftHumanEntity.getDeclaredField("perm");
            field.setAccessible(true);
            field.set(player, new PermissionBase(player));
            field.setAccessible(false);
        } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
