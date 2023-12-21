package dev.temez.commander.commons.chat;

import dev.temez.commander.commons.sender.Sender;
import org.jetbrains.annotations.NotNull;

public interface CommanderChatService {

  void sendError(
      @NotNull Sender<?> sender,
      @NotNull String messageKey,
      Object @NotNull ... replacers
  );
}
