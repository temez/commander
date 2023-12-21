package dev.temez.commander.test.command.validation;

import dev.temez.commander.commons.exception.ValidationException;
import dev.temez.commander.commons.sender.Sender;
import dev.temez.commander.commons.validaiton.CommandFilter;
import dev.temez.commander.test.command.validation.annotation.RandomCommandAccess;
import java.util.Random;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RandomCommandAccessFilter implements CommandFilter<RandomCommandAccess> {

  Random random = new Random();

  @Override
  public @NotNull Class<RandomCommandAccess> getFilterAnnotationType() {
    return RandomCommandAccess.class;
  }

  @Override
  public void filter(
      @NotNull Sender<?> sender,
      @NotNull RandomCommandAccess annotation
  ) throws ValidationException {
    if (random.nextInt(100) < annotation.value()) {
      throw new ValidationException("bad-luck");
    }
  }
}
