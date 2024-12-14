package pe.edu.ef_Mendoza_Saenz.response;

import pe.edu.ef_Mendoza_Saenz.dto.CarDto;

public record FindCarsResponse(
        String code,
        String error,
        Iterable<CarDto> users) {
}
