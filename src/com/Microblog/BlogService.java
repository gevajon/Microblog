package com.Microblog;

import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Class: BlogService
//For each page in the MicroBlog it will go through "/blog"
@Path("/blog")
public class BlogService {
	
	// URI:
	// /blog/{blogID} 
	//This GET Request will show the blog that was requested (by ID)
	//In case there will no be such ID on the DB - an error message will be shown
	@GET
	@Path("/{blogID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBlog(@PathParam("blogID")Integer blogId) {
		Blog blog = BlogDAO.getBlog(blogId);
		if (blog != null) {
			String blogContent = blog.getBlogText();
			return Response.status(200).entity(blogContent).build();
		} else {
			return Response.status(200).entity("blog not found").build();
		}
	}
	
	// URI:
	// /blog/top
	//This GET Request will show the Top Trending (TOP-3) Blogs
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/top")
	public Response getTopTrendingBlogs() {
		List<Blog> blogs = BlogDAO.getTopTrendingBlogs();
		if (blogs != null && !blogs.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (Blog blog : blogs) {
				sb.append(blog.getBlogText());
				sb.append("\n");
			}
			return Response.status(200).entity(sb.toString()).build();
		} else {
			return Response.status(200).entity("blog not found").build();
		}
	}
	
	// URI:
	// /blog/add/{text}
	//This POST Request will put add a new Blog to the DB
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add/{text}")
	public void addBlog( @PathParam("text") String blogContent) {
		BlogDAO.addBlog(blogContent);
	}

	// URI:
	// /blog/update/{blogID}/{text}
	//This PUT Request will update an exisitng blog with a new text
	@PUT
	@Path("/update/{blogID}/{text}")
	public void updateBlog(@PathParam("blogID") Integer blogId, @PathParam("text") String blogText) {
		BlogDAO.updateBlog(blogId, blogText);
	}

	// URI:
	// /blog/delete/{blogID}
	//This Delete Request will delete an existing blog from the DB
	@DELETE
	@Path("/delete/{blogID}")
	public void deleteEmployee(@PathParam("blogID") Integer blogId) {
		BlogDAO.deleteBlog(blogId);
	}
}
