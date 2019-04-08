/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 21/7/18
 */
package com.test.api.resources;

import com.test.api.Wrapper;
import com.test.api.entities.User;
import com.test.api.framework.Async;
import com.test.api.framework.utils.Database;
import com.test.api.services.UserDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private Async async;

    @GET
    @Path("user")
    public void getUser(@Suspended final AsyncResponse response) {
        async.execute(response, () -> {
            //Transaction t = null;
            try {
                Map<String, Object> res = new HashMap<>();
                Session s = Database.getSession();
                //t = s.getTransaction();
                //t.begin();
                UserDAO userDAO = new UserDAO();
                Optional<User> user = userDAO.getUser(s, "xxxxxx");
                /*if(user.isPresent()) {
                    res.put("user", user);
                } else {
                    throw new Exception("user not found");
                }*/
                response.resume(Response.status(Response.Status.OK).entity(user).build());
                //t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                //t.rollback();
                throw e;
                //throw new InternalServerErrorException(e);
            }
        });
    }

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    public void register(@Suspended final AsyncResponse response, @Valid Wrapper body) {
        async.execute(response, () -> {
            Transaction t = null;
            try {
                Map<String, Object> res = new HashMap<>();
                //Session s = Database.getSession();
                //t = s.getTransaction();
                //t.begin();
                User user =  body.getUser();
                //UserDAO userDAO = new UserDAO();
                System.out.println("sssssssss: " + user);
                //System.out.println("xxxxxx: "+ user.getFirstName()  );
                /*Optional<User> user = userDAO.getUser(s, "xxxxxx");
                if(user.isPresent()) {
                    res.put("user", user);
                } else {
                    throw new Exception("user not found");
                }*/
                response.resume(Response.status(Response.Status.OK).entity(res).build());
                //t.commit();
            } catch (Exception e) {
                e.printStackTrace();
                //t.rollback();
                throw new InternalServerErrorException(e);
            }
        });
    }
}
