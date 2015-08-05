package net.leanix.swaggerdemo;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.leanix.swaggerdemo.core.Animal;
import net.leanix.swaggerdemo.core.Gender;
import net.leanix.swaggerdemo.core.Shelter;
import net.leanix.swaggerdemo.resources.PetResource;


public class SwaggerDemoApplication extends Application<AppConfiguration>
{

    public static void main(String[] args) throws Exception
    {
        new SwaggerDemoApplication().run(args);
    }

    @Override
    public String getName()
    {
        return "swagger-demo";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap)
    {
        // nothing to do yet
    }

    @Override
    public void run(
            AppConfiguration configuration,
            Environment environment
    )
    {
        environment.jersey().register(new PetResource(createShelter()));
    }

    private Shelter createShelter()
    {
        Animal joe = new Animal();
        joe.setDangerous(true);
        joe.setGender(Gender.MALE);
        joe.setName("Joe the Ripper");
        joe.setRace("dog");
        
        Shelter shelter = new Shelter();
        shelter.add(joe);
        
        return shelter;
    }
}
