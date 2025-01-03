package com.example.semestralna_praca_vaii.controller.vehicle;

import com.example.semestralna_praca_vaii.facade.vehicle.VehicleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleFacade vehicleFacade;

    @Autowired
    public VehicleController(VehicleFacade vehicleFacade) {
        this.vehicleFacade = vehicleFacade;
    }
}
