package com.kani.client;

import com.kani.dto.ToDoEntry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/rpc")
@RegisterRestClient(configKey = "todoservice")
public interface ToDoServiceClient {

    @GET
    @Path("/getAll")
    List<ToDoEntry> getAll();

    @POST
    @Path("/update")
    ToDoEntry update(@QueryParam("id") Integer id,
                     @QueryParam("text") String text,
                     @QueryParam("done") Boolean done);

    @POST
    @Path("/create")
    ToDoEntry create(@QueryParam("text") String text,
                     @QueryParam("done") Boolean done);

    @POST
    @Path("/delete")
    Response delete(@QueryParam("id") Long id);

    @GET
    @Path("export")
    Response export();
}
