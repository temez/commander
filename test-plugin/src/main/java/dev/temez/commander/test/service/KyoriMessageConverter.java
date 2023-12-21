package dev.temez.commander.test.service;

import dev.temez.commander.commons.message.MessageConverter;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class KyoriMessageConverter implements MessageConverter {

  @NotNull MiniMessage miniMessage;

  @Override
  public @NotNull Component fromString(@NotNull String s) {
    return miniMessage.deserialize(s);
  }

}
