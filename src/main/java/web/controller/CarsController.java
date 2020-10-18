package web.controller;

import model.Car;
import service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getAllCars(ModelMap model) {
        List<Car> cars = this.carService.getAllCars();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping(params = "count")
    public String getLimitedNumberOfCars(@RequestParam("count") int quantity, ModelMap model) {
        List<Car> cars = null;
        if (quantity < 0 || quantity >= 5) {
            return "redirect:/cars";
        } else {
            cars = this.carService.getLimitedNumberOfCars(quantity);
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
