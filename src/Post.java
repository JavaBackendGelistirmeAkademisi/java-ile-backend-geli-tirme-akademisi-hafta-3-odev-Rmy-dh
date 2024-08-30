import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.LinkedList;


public class Post implements Comparator<Post> {

    private  String content;
    private   int postId=0;
    private LocalDateTime time;
    private LinkedList<Comment> comments;


    public Post(String content){
        this.content=content;
        this.time=LocalDateTime.now();
        this.comments = new LinkedList<>();
        //++postId;
    }
    public String getPostTime(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return time.format(myFormatObj);
    }

    public int getPostId(){
        return this.postId;
    }
    public void addComment(Comment comment){
        this.comments.add(comment);
    }
    public String getContent(){
        return  this.content;
    }
    public void setPostId(int postId){
        this.postId=postId;
    }


    @Override
    public int compare(Post o1, Post o2) {
        return o1.getContent().compareTo(o2.getContent());
    }
}
