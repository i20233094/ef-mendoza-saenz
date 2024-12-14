package pe.edu.ef_Mendoza_Saenz.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.ef_Mendoza_Saenz.dto.CarDetailDto;
import pe.edu.ef_Mendoza_Saenz.dto.CarDto;
import pe.edu.ef_Mendoza_Saenz.entity.Car;
import pe.edu.ef_Mendoza_Saenz.repository.CarRepository;
import pe.edu.ef_Mendoza_Saenz.service.ManagerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImplement implements ManagerService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {
        List<CarDto> cars = new ArrayList<>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car ->{
            cars.add(new CarDto(
                    car.getCar_id(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear()));
        });
            return cars;
    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {
      Optional<Car> optional = carRepository.findById(id);
      return optional.map(car  -> new CarDetailDto(
              car.getCar_id(),
              car.getMake(),
              car.getModel(),
              car.getYear(),
              car.getVin(),
              car.getLicense_plate(),
              car.getOwner_name(),
              car.getOwner_contact(),
              car.getPurchase_date(),
              car.getMileage(),
              car.getEngine_type(),
              car.getColor(),
              car.getInsurance_company(),
              car.getInsurance_policy_number(),
              car.getRegistration_expiration_date(),
              car.getService_due_date()
      ));
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
       Optional<Car> optional = carRepository.findById(carDto.car_id());
       return optional.map(car -> {
           car.setCar_id(carDto.car_id());
           car.setMake(carDto.make());
           car.setModel(carDto.model());
           car.setYear(carDto.year());
           carRepository.save(car);
           return true;
       }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car ->{
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarDetailDto carDetailDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDetailDto.car_id());
        if(optional.isEmpty()){
            Car car = new Car();
            car.setCar_id(carDetailDto.car_id());
            car.setMake(carDetailDto.make());
            car.setModel(carDetailDto.model());
            car.setYear(carDetailDto.year());
            car.setVin(carDetailDto.vin());
            car.setLicense_plate(carDetailDto.license_plate());
            car.setOwner_name(carDetailDto.owner_name());
            car.setOwner_contact(carDetailDto.owner_contact());
            car.setPurchase_date(carDetailDto.purchase_date());
            car.setMileage(carDetailDto.mileage());
            car.setEngine_type(carDetailDto.engine_type());
            car.setColor(carDetailDto.color());
            car.setInsurance_company(carDetailDto.insurance_company());
            car.setInsurance_policy_number(carDetailDto.insurance_policy_number());
            car.setRegistration_expiration_date(carDetailDto.registration_expiration_date());
            car.setService_due_date(carDetailDto.service_due_date());
            carRepository.save(car) ;
            return true;
        }
        return false;
    }
}
