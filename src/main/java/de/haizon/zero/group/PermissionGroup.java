package de.haizon.zero.group;

import de.haizon.zero.permissions.PermissionNode;
import de.haizon.zero.player.PermissionPlayer;

import java.util.List;

/**
 * JavaDoc this file!
 * Created: 24.10.2022
 *
 * @author Haizoooon (maxhewa@gmail.com)
 */
public interface PermissionGroup {

    String getName();

    String getPrefix();

    List<PermissionNode> getPermissions();

    List<PermissionPlayer> getPlayers();

}
