package ro.fishmc;

import me.fzzyhmstrs.fzzy_config.annotations.Comment;
import me.fzzyhmstrs.fzzy_config.annotations.TomlHeaderComment;
import me.fzzyhmstrs.fzzy_config.api.ConfigApi;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.util.EnumTranslatable;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedDouble;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
Config config = new Config();
public class ModConfig extends Config {
  public boolean aBoolean = true;
  public JavaTestConfig() {
        super(Identifier.of("config_test","java_config"),"test");
    }
}
