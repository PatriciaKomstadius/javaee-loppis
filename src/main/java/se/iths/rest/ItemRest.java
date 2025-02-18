package se.iths.rest;

import se.iths.entity.Item;
import se.iths.service.ItemService;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;

@Path("item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemRest {

    //inject gör klassen ItemService tillgänglig i denna klass
    @Inject
    ItemService itemService;

    @Path("new")
    @POST
    public Response createItem(Item item){
        itemService.createItem(item);
        return Response.ok(item).build();
    }

    @Path("update")
    @PUT
    public Response updateItem(Item item){
        itemService.updateItem(item);
        return Response.ok(item).build();
    }

    @Path("{id}")
    @GET
    public Item getItem(@PathParam("id") Long id){
        return itemService.findItembyId(id);
    }

    @Path("getall")
    @GET
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }


}
