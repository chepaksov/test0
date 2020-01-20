package web.model;


public class Car {


    private Long id;


    private String name;


    private int series;


    public Car() {

    }

    public Car(Long id, String name, int series) {
        this.id = id;
        this.name = name;
        this.series = series;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

