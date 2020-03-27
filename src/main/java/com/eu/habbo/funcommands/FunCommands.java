package com.eu.habbo.funcommands;

import com.eu.habbo.Emulator;
import com.eu.habbo.funcommands.commands.AfkCommand;
import com.eu.habbo.habbohotel.users.Habbo;
import com.eu.habbo.plugin.EventHandler;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.HabboPlugin;
import com.eu.habbo.plugin.events.emulator.EmulatorLoadedEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.eu.habbo.Emulator.ANSI_BLUE;
import static com.eu.habbo.Emulator.ANSI_WHITE;
import static com.eu.habbo.funcommands.eventloader.loadAll.loadAll;

/* Fun Commands
   A collection of fun to use commands for Arcturus.

   #Go Go Team Krews. Love for Harmony, Beny, Alejandro, ArpyAge, Layne, Bill, Ridge and Cronk.
 */
public class FunCommands extends HabboPlugin implements EventListener {
    public static FunCommands INSTANCE = null;

    @Override
    public void onEnable() {
        INSTANCE = this;
        Emulator.getPluginManager().registerEvents(this, this);
        if (Emulator.isReady) {
            AfkCommand.startBackgroundThread();
            this.checkDatabase();
        }
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean hasPermission(Habbo habbo, String s) {
        return false;
    }

    private boolean registerPermission(String name, String options, String defaultValue, boolean defaultReturn)
    {
        try (Connection connection = Emulator.getDatabase().getDataSource().getConnection())
        {
            try (PreparedStatement statement = connection.prepareStatement("ALTER TABLE  `permissions` ADD  `" + name +"` ENUM(  " + options + " ) NOT NULL DEFAULT  '" + defaultValue + "'"))
            {
                statement.execute();
                return true;
            }
        }
        catch (SQLException e)
        {}

        return defaultReturn;
    }

    @EventHandler
    public static void onEmulatorLoaded(EmulatorLoadedEvent event) throws Exception {
        INSTANCE.checkDatabase();
        AfkCommand.startBackgroundThread();
        loadAll();
        System.out.println("[" + ANSI_BLUE + "OFFICIAL PLUGIN" + ANSI_WHITE + "] " + "Fun Commands (1.0.0) has official loaded!");
    }

    public void checkDatabase() {
        boolean reloadPermissions = false;
        reloadPermissions = this.registerPermission("cmd_slime", "'0', '1', '2'", "1", reloadPermissions);
        reloadPermissions = this.registerPermission("cmd_hug", "'0', '1', '2'", "1", reloadPermissions);
        reloadPermissions = this.registerPermission("cmd_nuke", "'0', '1', '2'", "1", reloadPermissions);
        reloadPermissions = this.registerPermission("cmd_afk", "'0', '1', '2'", "1", reloadPermissions);
        reloadPermissions = this.registerPermission("cmd_tptome", "'0', '1', '2'", "0", reloadPermissions);
        reloadPermissions = this.registerPermission("cmd_superpull", "'0', '1', '2'", "0", reloadPermissions);
        reloadPermissions = this.registerPermission("cmd_superpush", "'0', '1', '2'", "0", reloadPermissions);

        if (reloadPermissions)
        {
            Emulator.getGameEnvironment().getPermissionsManager().reload();
        }

    }

    public static void main(String[] args)
    {
        System.out.println("Don't run this separately");
    }
}