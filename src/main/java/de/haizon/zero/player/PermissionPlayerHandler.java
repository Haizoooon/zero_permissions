package de.haizon.zero.player;

import de.haizon.zero.group.PermissionGroup;
import de.haizon.zero.permissions.PermissionNode;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * JavaDoc this file!
 * Created: 24.10.2022
 *
 * @author Haizoooon (maxhewa@gmail.com)
 */
public class PermissionPlayerHandler {

    private final HashMap<Player, PermissionPlayer> permissionPlayerHashMap;

    public PermissionPlayerHandler() {
        permissionPlayerHashMap = new HashMap<>();
    }

    public void register(Player player){
        permissionPlayerHashMap.put(player, new PermissionPlayer() {
            @Override
            public UUID getUniqueId() {
                return player.getUniqueId();
            }

            @Override
            public String getName() {
                return player.getName();
            }

            @Override
            public PermissionGroup getGroup() {
                return null;
            }

            @Override
            public List<PermissionNode> getPermissions() {
                return null;
            }
        });
    }

}
