package dev.temez.commander.test.command.adapter;

import dev.temez.commander.commons.adapter.ArgumentAdapter;
import dev.temez.commander.commons.annotation.context.External;
import dev.temez.commander.commons.exception.ConformableException;
import dev.temez.commander.commons.sender.Sender;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@External
@Component
public class ExternalIntegerAdapter implements ArgumentAdapter<Integer> {

  @Override
  public @NotNull Class<Integer> getTargetClass() {
    return Integer.class;
  }

  @Override
  public @NotNull Integer parse(@NotNull Sender<?> commandSender, @NotNull String rawArgument)
      throws ConformableException {
    return Integer.parseInt(rawArgument);
  }
}
