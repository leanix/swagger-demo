package net.leanix.swaggerdemo.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import net.leanix.swaggerdemo.swagger.AppSwaggerSpecFilter;
import net.leanix.swaggerdemo.core.Animal;
import net.leanix.swaggerdemo.core.Shelter;

/**
 * Pet resource.
 *
 *
 */
@Api(value="pets")
@Path("/pets")
@Produces(MediaType.APPLICATION_JSON)
public class PetResource
{

    private final Shelter shelter;

    @Inject
    public PetResource(Shelter shelter)
    {
        this.shelter = shelter;
    }

    /**
     * Lists all the animals in the shelter.
     * 
     * @param dangerous
     * @return
     */
    @GET
    @ApiOperation(
            value = "Lists all the animals in the shelter.", 
            responseContainer = "List", 
            response = Animal.class
    )
    public List<Animal> getAll(@ApiParam(access = AppSwaggerSpecFilter.INTERNAL_PARAMETER) @QueryParam("dangerous") boolean dangerous)
    {
        return shelter.all();
    }
    
    @GET
    @Path("/{name}")
    @ApiOperation(value = "Get a pet by its name", response = Animal.class)
    public Animal byName(@PathParam("name") String name)
    {
        return shelter.find(name);
    }
}
