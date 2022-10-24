package de.haizon.zero.permissions;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissibleBase;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaDoc this file!
 * Created: 24.10.2022
 *
 * @author Haizoooon (maxhewa@gmail.com)
 */
public class PermissionBase extends PermissibleBase {

    private Player player;

    public PermissionBase(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public boolean hasPermission(String inName) {
        List<String> permissions = new ArrayList<>(); // list of all permission from the player and the group

        if(permissions.contains(inName)){
            return true;
        }

        if(permissions.contains("-" + inName)){
            return false;
        }
        if(permissions.contains("*") || player.isOp()){
            return true;
        }

        return permissions.contains(inName);
    }

}
