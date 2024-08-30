import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class User {

    private String name;
    private HashSet<User> following;                       //Following users
    private TreeSet<Post> favorites;                      //Favorite Posts
    private LinkedHashMap<Integer, Post> posts;          // User's posts
    private  int postCounter = 0;                       // Total  Post Number

    public User(String name){
        this.name = name;
        this.posts = new LinkedHashMap<Integer, Post>();
        this.following = new HashSet<>();
        this.favorites = new TreeSet<Post>();
    }
    public void follow(User user){
        following.add(user);
        System.out.println(name +" subscribed  -> "+user.getName());
    }

    public void createPost (String content){
        Post newPost=new Post(content);
        newPost.setPostId(postCounter);
        posts.put(newPost.getPostId(),newPost);
        System.out.println(name + " published  a new post : " + content);
        //System.out.println("This post made -> "+ newPost.getPostTime());
        ++this.postCounter;
    }
    public void addCommentToPost(User user,int postId,String comment){
        Comment newComment=new Comment(this,comment);
        Post post=user.getPosts().get(postId);
        if(post != null){
            post.addComment(newComment);
            System.out.println(name + " made a comment to "+ user.getName());
            System.out.println("This comment made  -> "+newComment.getCommentTime());
        }
    }
    public void addFavoriteToPost(User user, int postId){
        Post post=user.getPosts().get(postId);
        if(post != null){
            favorites.add(post);
            System.out.println(name + " liked "+ user.getName()+"'s post " );
        }
    }
    public void showFeed(){
        System.out.println("\n" +"--------- "+ name + "'s home page ---------");
        System.out.println(name+"'s Post Counter : "+ postCounter);
        showPost();
        System.out.println("--------- Following User Posts ---------");
        for (User user : following){

            System.out.println("< = "+user.getName()+" = >");
            showPostForFollowedUser(user);
        }
    }
    public void showPostForFollowedUser(User user){
        LinkedHashMap<Integer, Post> posts = user.getPosts();
        for(Map.Entry<Integer,Post> post : posts.entrySet()){
            System.out.println(post.getValue().getContent());
        }

    }
    public void showPost(){
        for(Map.Entry<Integer,Post> entry : posts.entrySet()){
            System.out.println(entry.getKey() + " -> "+entry.getValue().getContent());
        }
    }

    public String getName() {
        return name;
    }

    public LinkedHashMap<Integer, Post> getPosts() {
        return posts;
    }
}
