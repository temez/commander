package dev.temez.commander.test.configuraiton;

import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "test-plugin.localization")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocalizationConfiguration {

  @NotNull
  Map<String, String> messages;

  @Bean
  MiniMessage miniMessage() {
    return MiniMessage.miniMessage();
  }

}
