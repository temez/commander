package dev.temez.commander.commons.sender;

import org.jetbrains.annotations.NotNull;

public interface SenderDetailsFactory<T> {

  @NotNull T get(@NotNull Sender<?> commandSender);
}
