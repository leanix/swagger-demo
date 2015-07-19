package net.leanix.swaggerdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;



/**
 * Configuration.
 * 
 * 
 */
public class AppConfiguration extends Configuration
{
    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getDefaultName()
    {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name)
    {
        this.defaultName = name;
    }
}
