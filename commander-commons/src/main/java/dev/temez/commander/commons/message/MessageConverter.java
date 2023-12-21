package dev.temez.commander.commons.message;

import java.util.List;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public interface MessageConverter {

  @NotNull Component fromString(@NotNull String s);

}
