package com.eu.habbo.funcommands.eventloader;

import com.eu.habbo.Emulator;

public class LoadTexts {
    public static void loadTexts() {
        try {
            Emulator.getTexts().register("commands.description.cmd_slime", ":slime <username>");
            Emulator.getTexts().register("fun.cmd_slime.keys", "slime;slimed;goop;nickelodeon");
            Emulator.getTexts().register("fun.cmd_slime.throws", "* Throws slime at %username%s direction *");
            Emulator.getTexts().register("fun.cmd_slime.missed", "* Missed %username%s face *");
            Emulator.getTexts().register("fun.cmd_slime.slimed", "* Gets covered in slime by %username% *");

            Emulator.getTexts().register("commands.description.cmd_hug", ":hug <username>");
            Emulator.getTexts().register("fun.cmd_hug.keys", "hug;cuddle");
            Emulator.getTexts().register("fun.hugmessages.huggedperson", "* Gets a warm hug from %hugger% *");
            Emulator.getTexts().register("fun.hugmessages.hugger", "* Hugs %huggedperson% tightly *");
            Emulator.getTexts().register("fun.hugmessages.tofar", "%huggedperson% is too far to hug. Get a bit closer and try again!");

            Emulator.getTexts().register("commands.description.cmd_nuke", ":nuke <username>");
            Emulator.getTexts().register("fun.cmd_nuke.keys", "nuke;nade;grenade;explode;boom");
            Emulator.getTexts().register("fun.nuke.self", "You can't nuke yourself, silly!");
            Emulator.getTexts().register("fun.nuke.action", "* Launches nuke towards %username% *");
            Emulator.getTexts().register("fun.nuke.nuked", "* %username% gets obliterated *");

            Emulator.getTexts().register("commands.description.cmd_afk", ":afk");
            Emulator.getTexts().register("fun.cmd_afk.keys", "brb;afk;");
            Emulator.getTexts().register("fun.cmd_afk.afk", "* %username% is now AFK! *");
            Emulator.getTexts().register("fun.cmd_afk.back", "* %username% is now back! *");
            Emulator.getTexts().register("fun.cmd_afk.time", "* %username% has now been away for %time% minutes *");

            Emulator.getTexts().register("fun.cmd_tptome.keys", "tptome;tp");
            Emulator.getTexts().register("commands.description.cmd_tptome", ":tptome <username>");
            Emulator.getTexts().register("fun.error.not_found", "Could not find %user%");
            Emulator.getTexts().register("fun.error.tp_self", "You cannot teleport yourself in front of you");
            Emulator.getTexts().register("commands.success.cmd_tptome.tptome", "* Teleports %user% to %gender_name% *");

            Emulator.getTexts().register("fun.cmd_superpush.keys", "spush;superpush");
            Emulator.getTexts().register("fun.cmd_superpull.keys", "spull;superpull");

        } catch (Exception ex) {
            Emulator.getLogging().logErrorLine(ex);
        }
    }
}
