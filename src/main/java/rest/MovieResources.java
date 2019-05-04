package rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Comment;
import domain.Movie;
import domain.services.MovieList;

@Path("/movies")
public class MovieResources {
private MovieList db = new MovieList();

@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Movie> getAll()
{
	return db.GetAll();
}
@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response Add(Movie movie) {
	db.add(movie);
	return Response.ok(movie.getId()).build();
}


  @GET
  
  @Path("/{id}")
  
  @Produces(MediaType.APPLICATION_JSON) public Response get(@PathParam("id")int
  id) { Movie result = db.get(id); if (result==null) { return
  Response.status(404).build(); } return Response.ok(result).build(); }
  
  @PUT
  
  @Path("/{id}")
  
  @Consumes(MediaType.APPLICATION_JSON) public Response
  update(@PathParam("id")int id, Movie m) { Movie result = db.get(id);
  if(result==null) return Response.status(404).build(); m.setId(id);
  db.update(m); return Response.ok().build();
  
  
  }
  
  @DELETE
  
  @Path("/{id}") public Response delete(@PathParam("id")int id) { Movie result
  = db.get(id); if(result==null) return Response.status(404).build();
  db.update(result); return Response.ok().build(); }
  
  @GET
  
  @Path("/{movieId}/comments")
  
  @Produces(MediaType.APPLICATION_JSON) 
  public List<Comment>  getComments(@PathParam("movieId")int movieId){
	  Movie result =  db.get(movieId);
	  if(result==null)return null;
	  if(result.getComments()==null)
  result.setComments(new ArrayList<Comment>());
	  return result.getComments();
	  }
    @POST
    @Path("/{id}/comments") 
   @Consumes(MediaType.APPLICATION_JSON)
    public Response   addComment(@PathParam("id")int movieId,Comment comment)
    { Movie result =   db.get(movieId);
    if(result==null)
    	return Response.status(404).build(); 
  if(result.getComments()==null) 
	  result.setComments(new ArrayList<Comment>());
   result.getComments().add(comment);
   return Response.ok().build();   }
  @DELETE
  @Path("/{id}/comments/{commentId}")
  public Response  deleteComment(@PathParam("id")int movieId,@PathParam("commentId")int  commentId) { 
  if(db.get(movieId).delete(db.get(movieId).getComment(commentId)))
	  return  Response.ok().build();
  return Response.status(404).build(); 
  }
  
  }
  
 
