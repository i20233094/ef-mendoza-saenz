package pe.edu.ef_Mendoza_Saenz.service;

import pe.edu.ef_Mendoza_Saenz.dto.CarDetailDto;
import pe.edu.ef_Mendoza_Saenz.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManagerService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
