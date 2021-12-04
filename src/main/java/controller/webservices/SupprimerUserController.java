package controller.webservices;

import entity.Utilisateur;
import service.LoginService;
import service.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/SupprimerUser")
public class SupprimerUserController {


    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> listAll(){
        return UserService.getInstance().listAllUser();
    }
}
