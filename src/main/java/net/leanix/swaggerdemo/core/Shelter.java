package net.leanix.swaggerdemo.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Animal shelter (repository).
 *
 */
public class Shelter
{
    private final Map<String, Animal> animals = new ConcurrentHashMap<>();

    public Animal find(String name)
    {
        if (name == null)
            return null;
        
        if (animals.containsKey(name))
        {
            return animals.get(name);
        }
        
        return null;
    }

    public void add(Animal animal)
    {
        if (find(animal.getName()) != null)
        {
            throw new WebApplicationException(
                    "An animal with the given name already exists.",
                    Response.Status.CONFLICT
            );
        }

        animals.put(animal.getName(), animal);
    }

    /**
     * Remove an animal from the shelter.
     *
     * @param name
     */
    public void remove(String name)
    {
        Animal a = find(name);
        if (a == null)
        {
            throw new WebApplicationException(
                    "An animal with the given name does not exist.",
                    Response.Status.NOT_FOUND
            );
        }

        animals.remove(a.getName());
    }
    
    /**
     * Returns a list of all animals in the shelter.
     * 
     * @return 
     */
    public List<Animal> all()
    {
        return new ArrayList<>(animals.values());
    }
}
