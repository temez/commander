package dev.temez.commander.test.application;

import dev.temez.springlify.platform.bukkit.plugin.SpringlifyBukkitPlugin;
import org.jetbrains.annotations.NotNull;

public class CommanderTestPlugin extends SpringlifyBukkitPlugin {

  @Override
  public @NotNull Class<?> getApplicationClass() {
    return CommanderTestApplication.class;
  }
}
