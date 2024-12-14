package pe.edu.ef_Mendoza_Saenz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.ef_Mendoza_Saenz.dto.CarDto;
import pe.edu.ef_Mendoza_Saenz.service.ManagerService;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<CarDto> cars = managerService.getAllCars();
            model.addAttribute("cars", cars);
            model.addAttribute("error", null);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrió un error al obtener los datos");

        }
        return "manager";

    }

}
