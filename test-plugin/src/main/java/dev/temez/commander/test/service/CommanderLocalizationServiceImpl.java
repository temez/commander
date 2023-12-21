package dev.temez.commander.test.service;

import dev.temez.commander.commons.chat.CommanderLocalizationService;
import dev.temez.commander.commons.message.MessageConverter;
import dev.temez.commander.commons.sender.Sender;
import dev.temez.commander.test.configuraiton.LocalizationConfiguration;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class CommanderLocalizationServiceImpl implements CommanderLocalizationService {

  @NotNull LocalizationConfiguration localizationConfiguration;

  @NotNull MessageConverter messageConverter;

  @Override
  public @NotNull Component localizeComponent(
      @NotNull Sender<?> sender,
      @NotNull String messageKey,
      Object @NotNull ... replacers
  ) {
    return messageConverter.fromString(localizeString(sender, messageKey, replacers));
  }

  @Override
  public @NotNull String localizeString(
      @NotNull Sender<?> sender,
      @NotNull String messageKey,
      Object @NotNull ... replacers
  ) {
    String localizedMessage = localizationConfiguration.getMessages().getOrDefault(
        messageKey, "messages:" + messageKey
    );
    return String.format(localizedMessage, replacers);
  }
}
