package web.model;

import javax.persistence.*;



@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "series")
    private int series;


    public User() {

    }

    public User(int id, String name, int series) {
        this.id = id;
        this.name = name;
        this.series = series;
    }

    public User(String name, int series) {
        this.name = name;
        this.series = series;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }


}

