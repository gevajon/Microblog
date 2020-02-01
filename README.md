# Jonathan Geva
# Microblog
General:

The Microblog is a blog service that allows saving, updating and reading blog posts. 
In this program, you will be able to Read, Write, Update, Delete and get the Top Trending blogs.

---------------------------------------------------------------------------------------------------------------------------------------------------

Installation Instructions and Running Commands:

1) Use eclipse environment and import the project.
2) Add a tomcat v7.0 to your eclipse environment.
3) Run the server.
4) When the server is up, you can use your browser \ Postman API-Client software to perform these actions:

	- View a blog - http://localhost:8080/Microblog/rest/blog/{blogID}
	- Write a new blog - http://localhost:8080/Microblog/rest/blog/add/{text}
	- Update an existing blog - http://localhost:8080/Microblog/rest/blog/update/{blogID}/{text}
	- Delete an existing blog - http://localhost:8080/Microblog/rest/blog/delete/{blogID}
	- Get Top-Trending blogs - http://localhost:8080/Microblog/rest/blog/top

---------------------------------------------------------------------------------------------------------------------------------------------------

Test examples and screenshots are attached in the MicroBlog.pdf file.
