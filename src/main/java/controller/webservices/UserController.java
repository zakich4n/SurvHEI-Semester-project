package controller.webservices;

import entity.Utilisateur;
import service.LoginService;
import service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Users")
public class UserController {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> listAll(){
        return UserService.getInstance().listAllUser();
    }


    @DELETE
    @Path("/{IDUser}")
    public void deleteCity(@PathParam("IDUser") int IDUser){
        UserService.getInstance().deleteUser(IDUser);
    }
}
