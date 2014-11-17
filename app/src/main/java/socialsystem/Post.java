package socialsystem;

public class Post {

    private final String name;
    private final String city;
    private final String ZIP;
    private final String comment;

    Post(String name, String city, String ZIP, String comment){
        this.name = name;
        this.city = city;
        this.ZIP = ZIP;
        this.comment = comment;
    }

    String getPosterName(){
        return name;
    }

    String getComment(){
        return comment;
    }

    String getCity(){ return city; }

    String getZIP(){ return ZIP; }
}
