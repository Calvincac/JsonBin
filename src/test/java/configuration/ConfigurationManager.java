package configuration;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public Configuration getConfiguration() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
