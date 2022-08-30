package me.aa07.nochatsign;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class NoChatSign extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Enabled");
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void handleChat(AsyncChatEvent event) {
        event.setCancelled(true);

        Component target = Component.text(String.format("<%s> ", event.getPlayer().getName())).append(event.message());

        Bukkit.broadcast(target);
    }
}
