package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("system:properties")
public interface CredentialsConfig extends Config {
    String login();
    String password();
    String server();
}
