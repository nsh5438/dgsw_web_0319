package kr.hs.dgsw.web_0319;

public class User {
    private String name;
    private String email;
    private String userid;

    public User(){

    }
    public User(String name, String email,String userid){
        this.name = name;
        this.email = email;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
