package de.haizon.zero.database;

/*

  » de.stickmc.skyblock.database

  » Methode/Class coded by Haizoooon#6495
  » This Class/Source cannot be modified without permission.
  » Please refrain from recoding
  » Questions may be asked in Discord

  » Package coded at: 12.03.2021 / 15:35

 */

public enum DatabaseType {

    VARCHAR("varchar(255)"),
    INT("int"),
    LONG("long"),
    TEXT("text");

    private final String display;

    DatabaseType(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
