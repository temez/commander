package dev.temez.commander.test.service;

import dev.temez.commander.commons.chat.CommanderChatService;
import dev.temez.commander.commons.chat.CommanderLocalizationService;
import dev.temez.commander.commons.sender.Sender;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class CommanderChatServiceImpl implements CommanderChatService {

  @NotNull CommanderLocalizationService localizationService;

  @Override
  public void sendError(@NotNull Sender<?> sender, @NotNull String messageKey,
                        Object @NotNull ... replacers) {
    Component message = localizationService
        .localizeComponent(sender, "error-prefix")
        .append(
            localizationService.localizeComponent(
                sender,
                messageKey,
                replacers
            )
        );
    sender.sendMessage(message);
  }
}
