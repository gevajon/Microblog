package com.Microblog;

//Class: Blog
public class Blog {

    public int blogId;
    public String blogText;

    public int getPopularityScore() {
        return popularityScore;
    }

    public void setPopularityScore(int popularityScore) {
        this.popularityScore = popularityScore;
    }

    public int popularityScore;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public Blog(int blogId, String blogText, int popularityScore) {
        this.blogId = blogId;
        this.blogText = blogText;
        this.popularityScore = 0;
    }
}
