package configuration;

import org.aeonbits.owner.Config;

@Config.Sources({ "file:src/test/java/configuration/global.properties"})
public interface Configuration extends Config{

    @Config.Key("server.host")
    String host();

    @Config.Key("x.master.key")
    String key();
}
