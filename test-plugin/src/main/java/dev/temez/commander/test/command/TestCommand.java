package dev.temez.commander.test.command;

import dev.temez.commander.commons.annotation.Command;
import dev.temez.commander.commons.annotation.CommandRoot;
import dev.temez.commander.commons.annotation.SubCommand;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Command(
    name = "test",
    type = Command.CommandType.SHARED,
    description = "test-command-description",
    alias = "t"
)
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class TestCommand {

  @CommandRoot
  public void execute(
      @NotNull CommandSender commandSender,
      @NotNull Integer integer,
      @NotNull Integer anotherInteger
  ) {
  }

  @SubCommand(
      name = "sub",
      description = "test-subcommand-description",
      type = Command.CommandType.INGAME
  )
  public void executeSubCommand(
      @NotNull Player player,
      @NotNull String string
  ) {
  }

}
