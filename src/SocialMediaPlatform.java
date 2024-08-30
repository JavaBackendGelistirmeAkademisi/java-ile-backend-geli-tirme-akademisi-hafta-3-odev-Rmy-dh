public class SocialMediaPlatform {

    public static void main(String[] args){
        User merve = new User("Merve");
        User cenk = new User("Cenk");
        User didem = new User ("Didem");

        merve.follow(cenk);
        merve.follow(didem);

        cenk.createPost("I have started a new job");


        didem.createPost("You can do it.");
        cenk.createPost("What a day !");

        merve.addFavoriteToPost(cenk,2);
        merve.addFavoriteToPost(didem,3);

        merve.createPost("Hello everyone :) ");
        merve.createPost(" :) ");



        merve.addCommentToPost(cenk,1,"Congrulations");
        merve.showFeed();

    }

}
