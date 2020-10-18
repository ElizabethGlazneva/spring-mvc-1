package service;

import dao.CarDao;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private CarDao carDAO;

    @Autowired
    public CarServiceImpl(CarDao carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> getAllCars() {
        return this.carDAO.getAllCars();
    }

    @Override
    public List<Car> getLimitedNumberOfCars(int quantity) {
        return this.carDAO.getLimitedNumberOfCars(quantity);
    }
}
