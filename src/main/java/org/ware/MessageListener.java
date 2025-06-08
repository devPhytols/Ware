package org.ware;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    private final CommandHandler commandHandler;

    public MessageListener() {
        this.commandHandler = new CommandHandler("!"); // Define o prefixo
        // Registra os comandos
        commandHandler.registerCommand(new PingCommand());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // Ignora mensagens de bots
        if (event.getAuthor().isBot()) {
            return;
        }

        // Log de mensagens
        if (event.getChannelType() == ChannelType.PRIVATE) {
            System.out.printf("[PM] %s: %s\n",
                    event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
        } else if (event.getChannelType() == ChannelType.TEXT) {
            System.out.printf("[%s][%s] %s: %s\n",
                    event.getGuildChannel().getGuild().getName(),
                    event.getChannel().asTextChannel().getName(),
                    event.getMember() != null ? event.getMember().getEffectiveName() : "Unknown Member",
                    event.getMessage().getContentDisplay());
            // Processa comandos apenas em canais de texto
            commandHandler.handle(event);
        }
    }
}