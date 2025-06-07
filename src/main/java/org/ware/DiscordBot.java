package org.ware;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class DiscordBot {
    public static void main(String[] args) {
        // A token must be provided.
        if (args.length < 1) {
            throw new IllegalStateException("You have to provide a token as the first argument!");
        }

        /* Start the JDA bot builder, letting you provide the token externally rather
         * than writing it in your program's code. args[0] is the token. */
        JDABuilder jdaBotBuilder = JDABuilder.createDefault(args[0]);

        // Disable parts of the cache
        jdaBotBuilder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);

        // Enable the bulk delete event - this means you'll have to handle it yourself!
        jdaBotBuilder.setBulkDeleteSplittingEnabled(false);

        // Set activity (like "playing Something")
        jdaBotBuilder.setActivity(Activity.playing("with your heart"));

        // Set event listeners
        jdaBotBuilder.addEventListeners(new MessageListener(), new ReadyListener());

        try {
            // Create the instance of JDA
            JDA discordBot = jdaBotBuilder.build();

            // Optionally block until JDA is ready
            discordBot.awaitReady();
        } catch (InterruptedException e) {
            System.err.println("Couldn't login or was interrupted.");
            e.printStackTrace();
        }
    }
}