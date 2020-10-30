package model;

public class Car {

    private int series;
    private String maker;
    private String model;

    public Car(int series, String maker, String model) {
        this.series = series;
        this.maker = maker;
        this.model = model;
    }
    public Car(){}

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
