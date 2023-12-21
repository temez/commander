package dev.temez.commander.commons.execution.preprocessor.impl;

import dev.temez.commander.commons.command.RegisteredCommand;
import dev.temez.commander.commons.exception.ConformableException;
import dev.temez.commander.commons.execution.CommandExecution;
import dev.temez.commander.commons.execution.preprocessor.ExecutionPreprocessor;
import java.util.Comparator;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class SubcommandPreprocessor implements ExecutionPreprocessor {

  private @Nullable RegisteredCommand getSubCommand(
      @NotNull CommandExecution execution
  ) {
    List<String> args = execution.getArguments();
    String argumentsString = String.join(" ", args);

    RegisteredCommand command = execution.getCommand();
    return command.getSubcommands()
        .stream()
        .sorted(Comparator.comparingInt(a -> a.getName().length()))
        .filter(subcommand -> argumentsString.startsWith(subcommand.getName()))
        .findFirst()
        .orElse(null);
  }

  @Override
  public void process(@NotNull CommandExecution execution) throws ConformableException {
    RegisteredCommand subCommand = getSubCommand(execution);
    if (subCommand != null) {
      execution.setCommand(subCommand);
      execution.setArguments(
          execution.getArguments()
              .stream()
              .skip(1)
              .toList()
      );
    }
  }
}
