package dev.temez.commander.velocity.command;

import com.velocitypowered.api.proxy.ProxyServer;
import dev.temez.commander.commons.command.platform.PlatformCommand;
import dev.temez.commander.commons.command.platform.PlatformCommandRegistrar;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class VelocityCommandRegistrar implements PlatformCommandRegistrar {

  @NotNull ProxyServer proxyServer;

  @Override
  public void register(@NotNull PlatformCommand platformCommand) {
    platformCommand.register(platformCommand);
  }
}
