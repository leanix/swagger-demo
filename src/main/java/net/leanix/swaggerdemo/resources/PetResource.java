package net.leanix.swaggerdemo.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
            value = "getAll",
            notes = "Lists all the animals in the shelter.", 
            responseContainer = "List", 
            response = Animal.class
    )
    public List<Animal> getAll(@ApiParam(access = AppSwaggerSpecFilter.INTERNAL_PARAMETER) @QueryParam("dangerous") boolean dangerous)
    {
        return shelter.all();
    }
    
    @GET
    @Path("/{name}")
    @ApiOperation(value = "byName", notes = "Get a pet by its name", response = Animal.class)
    public Animal byName(@PathParam("name") String name)
    {
        return shelter.find(name);
    }
    
    @POST
    @ApiOperation(value = "add", notes="Add a pet to the shelter", response = Animal.class)
    @ApiResponses(value = {@ApiResponse(code = 422, message = "Invalid entity")})
    public Animal add(@Valid Animal pet)
    {
        shelter.add(pet);
        return pet;
    }
}
