package org.ware;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingCommand implements Command {
    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Responde com a latência do gateway do bot.";
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        long gatewayPing = event.getJDA().getGatewayPing();
        event.getChannel().sendMessage("Pong! Latência: " + gatewayPing + "ms").queue();
    }
}