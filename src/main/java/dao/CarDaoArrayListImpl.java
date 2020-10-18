package dao;

import model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDaoArrayListImpl implements CarDao {
    private List<Car> cars;

    public CarDaoArrayListImpl() {
        this.cars = new ArrayList<>();
        this.cars.add(new Car(1, "Maker1", "Model1"));
        this.cars.add(new Car(2, "Maker2", "Model2"));
        this.cars.add(new Car(3, "Maker3", "Model3"));
        this.cars.add(new Car(4, "Maker4", "Model4"));
        this.cars.add(new Car(5, "Maker5", "Model5"));
        this.cars.add(new Car(6, "Maker6", "Model6"));
        this.cars.add(new Car(7, "Maker7", "Model7"));
    }


    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getLimitedNumberOfCars(int quantity) {
        return cars.subList(0, quantity);
    }
}
