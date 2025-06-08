package org.ware;

import java.util.HashMap;
import java.util.Map;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandHandler {
    private final Map<String, Command> commands = new HashMap<>();
    private final String prefix;

    public CommandHandler(String prefix) {
        this.prefix = prefix;
    }

    public void registerCommand(Command command) {
        commands.put(command.getName().toLowerCase(), command);
    }

    public void handle(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }

        String content = event.getMessage().getContentRaw().trim();
        if (content.startsWith(prefix)) {
            String[] args = content.substring(prefix.length()).split("\\s+");
            String commandName = args[0].toLowerCase();
            Command command = commands.get(commandName);

            if (command != null) {
                command.execute(event, args);
            } else {
                event.getChannel().sendMessage("Comando desconhecido: " + commandName).queue();
            }
        }
    }
}