package com.eu.habbo.funcommands.eventloader;

import com.eu.habbo.Emulator;

public class LoadConfig {
    public static void loadConfig() {
        try {
            Emulator.getConfig().register("fun.cmd_hug.enable", "9");
        } catch (Exception ex) {
            Emulator.getLogging().logErrorLine(ex);
        }
    }
}
