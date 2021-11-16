package com.kani;

import com.kani.client.ToDoServiceClient;
import com.kani.dto.ToDoEntry;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/todo")
public class TodoResource {
    private static final Logger LOGGER = Logger.getLogger(TodoResource.class);

    @Inject
    @RestClient
    ToDoServiceClient toDoServiceClient;

    @GET
    public List<ToDoEntry> getAll(){
        LOGGER.info("Fetching all todos");
        return toDoServiceClient.getAll();
    }

    @PUT
    public ToDoEntry update(ToDoEntry toDoEntry){
        LOGGER.info("Updating todo entry : " + toDoEntry.getId());
        return toDoServiceClient.update(toDoEntry.getId(),toDoEntry.getText(),toDoEntry.getDone());
    }

    @POST
    public ToDoEntry create(ToDoEntry toDoEntry){
        LOGGER.info("Creating a new todo entry");
        return toDoServiceClient.create(toDoEntry.getText(),toDoEntry.getDone());}

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        LOGGER.info("Deleting a todo entry : " + id);
        toDoServiceClient.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("export")
    public Response export(){
        LOGGER.info("Exporting");
        toDoServiceClient.export();
        return Response.ok().build();
    }

}
