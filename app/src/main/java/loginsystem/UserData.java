package loginsystem;

/**
 * Created by pete on 11/15/14.
 */
public class UserData {
    private final String email;
    private final String password;
    private final String NickName;
    private final String F_Name;
    private final String L_Name;
    private final String Address;
    private final String City;
    private final String State;
    private final String ZIP;
    private final String Answer1;
    private final String Answer2;
    private final String Answer3;

    UserData(String email, String password, String NickName,
             String F_Name, String L_Name, String Address,
             String City, String State, String ZIP,
             String Answer1, String Answer2, String Answer3){
        this.email = email;
        this.password = password;
        this.NickName = NickName;
        this.F_Name = F_Name;
        this.L_Name = L_Name;
        this.Address = Address;
        this.City = City;
        this.State =State;
        this.ZIP = ZIP;
        this.Answer1 = Answer1;
        this.Answer2 = Answer2;
        this.Answer3 = Answer3;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getNickName(){
        return NickName;
    }

    public String getF_Name(){
        return F_Name;
    }

    public String getL_Name(){
        return L_Name;
    }

    public String getAddress(){
        return Address;
    }

    public String getCity(){
        return City;
    }

    public String getState(){
        return State;
    }

    public String getZIP(){
        return ZIP;
    }

    public String getAnswer1() { return Answer1; }

    public String getAnswer2() { return Answer2; }

    public String getAnswer3() { return Answer3; }
}
