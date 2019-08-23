package pl.programmingschool.model;

public class User {
    private int id;
    private String email;
    private String userName;
    private String password;
    private int groupId;

    public User() {

    }

    public User(int id, String email, String userName, String password,int groupId) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.groupId=groupId;
    }

    public User(String email, String userName, String password, int groupId) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.groupId=groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "[UserName : " + this.userName + " password : " + this.password + " email : " + this.email;
    }
}
