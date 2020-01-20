package hiber.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name = "cars")
public class Car {


    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "series")
    private int series;

    public Car() {

    }

    public Car(String name, int series) {
        this.name = name;
        this.series = series;
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

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="name",   unique = true, updatable = true, insertable = true)




    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }







}
