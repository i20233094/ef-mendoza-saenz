package pe.edu.ef_Mendoza_Saenz.response;

import pe.edu.ef_Mendoza_Saenz.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto user) {

}
