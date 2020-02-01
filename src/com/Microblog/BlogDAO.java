package com.Microblog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry;


//Function: BlogComperator
//This function gets 2 objects (blogs) and returns the blog with the highest score (viewed the most)
//This function is used in order to get the Top-Trending blogs

class BlogComparator implements Comparator<Blog> {
    @Override
    public int compare(Blog a, Blog b) {
        return a.popularityScore > b.popularityScore ? -1 : 1;
    }
}

//Class: BlogDAO - Data Access Object
//This class contains a hashmap of exiting blogs (3)
//This class also handles with actions that need to be performed with the blogs
//Actions: Get Blog, Delete Blog, Update Existing Blog, Add New Blog, and get Top-Trending (3 Most viewed) Blogs.
public class BlogDAO {

	private static int topTrandingNum = 3;
    private static final Map<Integer, Blog> blogMap = new HashMap<Integer, Blog>();
    static {
        initEmps();
    }

    private static void initEmps() {
        Blog blog1 = new Blog(1, "this is a blog post",0);
        Blog blog2 = new Blog(2, "this is a blog post 2",0);
        Blog blog3 = new Blog(3, "this is a blog post 3",0);

        blogMap.put(blog1.getBlogId(), blog1);
        blogMap.put(blog2.getBlogId(), blog2);
        blogMap.put(blog3.getBlogId(), blog3);
    }
    
    //getBlog
    //Will show the relevant blog by its blogId (INT)
    //In addition, for every getBlog call, the popularity of the blog will be increased by 1
    public static Blog getBlog(Integer blogId) {
        if (blogMap.containsKey(blogId)) {
            Blog blog = blogMap.get(blogId);
            blog.setPopularityScore(blog.getPopularityScore() + 1);
            return blog;
        } else {
            return null;
        }
    }
    
    //deleteBlog
    //Will delete the relevant blog by its blogId (INT)
    public static void deleteBlog(Integer blogId) {
        if (blogMap.containsKey(blogId)) {
            blogMap.remove(blogId);
        }
    }

    //updateBlog
    //Will update an existing blog with a new content
    public static void updateBlog(Integer blogId, String blogContent) {
        blogMap.put(blogId , new Blog(blogId, blogContent, 5));
    }

    //addBlog 
    //Will add a new blog to the DB
    //The id of the blog will be calculated as: (last blogId + 1)
    //The popularity of a new blog will be 0
    public static void addBlog(String blogContent) {
    	int maxId = Collections.max(blogMap.entrySet(), Map.Entry.comparingByKey()).getKey();
        blogMap.put(maxId +1, new Blog(maxId +1 ,blogContent,0));
    }

    //getTopTrendingBlogs
    //Will show the Top-3 Trending blog (by popularity - most viewed)
    public static List<Blog> getTopTrendingBlogs() {
    	List<Blog> blogs = new ArrayList<Blog>(blogMap.values());
    	Collections.sort(blogs, new BlogComparator());
    	return blogs.subList(0, topTrandingNum);
    }
}



