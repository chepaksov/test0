package model;

public class User {
    private long id;
    private String name;
    private String password;
    private String example;

    public User() {

    }

    public User(String name, String password, String example) {
        this.name = name;
        this.password = password;
        this.example = example;
    }

    public User(long id, String name, String password, String example) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.example = example;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }




}
