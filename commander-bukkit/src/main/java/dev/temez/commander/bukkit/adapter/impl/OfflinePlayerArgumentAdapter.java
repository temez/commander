package dev.temez.commander.bukkit.adapter.impl;

import dev.temez.commander.commons.adapter.ArgumentAdapter;
import dev.temez.commander.commons.exception.ConformableException;
import dev.temez.commander.commons.sender.Sender;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.HumanEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.springframework.stereotype.Component;


@Component
public final class OfflinePlayerArgumentAdapter implements ArgumentAdapter<OfflinePlayer> {

  @Override
  public @Unmodifiable @NotNull List<String> complete(@NotNull Sender<?> commandSender) {
    return Bukkit.getOnlinePlayers()
        .stream()
        .map(HumanEntity::getName)
        .toList();
  }

  @Override
  public @NotNull Class<OfflinePlayer> getTargetClass() {
    return OfflinePlayer.class;
  }

  @Override
  @SuppressWarnings("deprecation")
  public @NotNull OfflinePlayer parse(
      @NotNull Sender<?> commandSender,
      @NotNull String rawArgument
  ) throws ConformableException {
    OfflinePlayer player = Bukkit.getOfflinePlayer(rawArgument);
    if (!player.hasPlayedBefore()) {
      throw new ConformableException("commander-user-did-not-played-on-this-server");
    }
    return player;
  }
}
