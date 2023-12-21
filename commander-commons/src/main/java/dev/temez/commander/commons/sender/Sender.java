package dev.temez.commander.commons.sender;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public interface Sender<T> {

  @NotNull T getPlatformSender();

  boolean isConsoleSender();

  void sendMessage(@NotNull Component component);
}
