package pe.edu.ef_Mendoza_Saenz.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.ef_Mendoza_Saenz.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
