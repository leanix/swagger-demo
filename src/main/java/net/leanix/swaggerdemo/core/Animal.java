package net.leanix.swaggerdemo.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Animal demo class.
 * 
 * 
 */
public class Animal
{
    @JsonProperty
    @NotEmpty
    private String name;
    
    @JsonProperty
    @NotEmpty
    private String race;
    
    @JsonProperty
    @NotNull
    private Gender gender;
    
    private boolean dangerous = false;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRace()
    {
        return race;
    }

    public void setRace(String race)
    {
        this.race = race;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    @ApiModelProperty(hidden = true)
    public boolean isDangerous()
    {
        return dangerous;
    }

    public void setDangerous(boolean dangerous)
    {
        this.dangerous = dangerous;
    }
    
}
