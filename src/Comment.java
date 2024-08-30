import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {

    private User author;
    private String comment;
    private  LocalDateTime time;

    public Comment(User author,String comment){
        this.author=author;
        this.comment=comment;
        this.time=LocalDateTime.now();
    }
    public String getCommentTime(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return time.format(myFormatObj);
    }
}
