package de.haizon.zero.player;

import de.haizon.zero.group.PermissionGroup;
import de.haizon.zero.permissions.PermissionNode;

import java.util.List;
import java.util.UUID;

/**
 * JavaDoc this file!
 * Created: 24.10.2022
 *
 * @author Haizoooon (maxhewa@gmail.com)
 */
public interface PermissionPlayer {

    UUID getUniqueId();

    String getName();

    PermissionGroup getGroup();

    List<PermissionNode> getPermissions();

}
