package com.example.semestralna_praca_vaii.controller.vehicle;

import com.example.semestralna_praca_vaii.facade.dto.error.ErrorDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleUpdateDto;
import com.example.semestralna_praca_vaii.facade.vehicle.VehicleFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.websocket.server.PathParam;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleFacade vehicleFacade;

    @Autowired
    public VehicleController(VehicleFacade vehicleFacade) {
        this.vehicleFacade = vehicleFacade;
    }

    @Operation(summary = "Get all vehicles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" ,
                    description = "Found vehicles",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VehicleDto.class)) })
    })
    @GetMapping
    public ResponseEntity<PagedModel<VehicleDto>> getAllVehicles(@ParameterObject Pageable pageable){
        PagedModel<VehicleDto> vehicleDtoPagedModel = this.vehicleFacade.getAllVehicles(pageable);
        return new ResponseEntity<>(vehicleDtoPagedModel, HttpStatus.OK);
    }

    @Operation(summary = "Get vehicle by plate number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the vehicle",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VehicleDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid plate number",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Vehicle not found",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorDto.class)))
    })
    @GetMapping(path = "/vehicles/vehicle/{plate}")
    public ResponseEntity<VehicleDto> getVehicleByPlate(@Parameter(description = "plate of vehicle") @PathVariable("plate")String plate){
       VehicleDto vehicleDto = this.vehicleFacade.getVehicleByPlate(plate);
       return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }

    @Operation(summary = "Get vehicle by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the vehicle",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VehicleDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid email",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Vehicle not found",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorDto.class)))
    })
    @GetMapping(path = "/vehicle/{email}")
    public ResponseEntity<PagedModel<VehicleDto>> getAllVehiclesByEmail(@ParameterObject String email, @ParameterObject Pageable pageable){
        PagedModel<VehicleDto> vehicleDtoPagedModel = this.vehicleFacade.getVehicleByEmail(email,pageable);
        return new ResponseEntity<>(vehicleDtoPagedModel, HttpStatus.OK);
    }

    @Operation(summary = "Delete vehicle by plate number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Vehicle deleted successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VehicleDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid vehicle plate number",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Vehicle not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })
    @DeleteMapping(path = "/vehicle/{plate}")
    public ResponseEntity<Void> deleteVehicleByPlate(@Parameter(description = "plate of vehicle") @PathVariable("plate")String plate){
        this.vehicleFacade.deleteVehicleByPlate(plate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Create a new vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Vehicle created successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VehicleDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid vehicle data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "409",
                    description = "Vehicle already exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })
    @PostMapping(path = "/vehicle")
    public ResponseEntity<VehicleDto> addVehicle(@RequestBody VehicleCreateDto vehicleCreateDto){
        VehicleDto vehicleDto = this.vehicleFacade.addVehicle(vehicleCreateDto);
        return new ResponseEntity<>(vehicleDto, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Vehicle updated successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VehicleDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid vehicle data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "409",
                    description = "Vehicle already exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })
    @PutMapping(path = "/vehicle/{plate}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathParam("plate") String plate, @RequestBody VehicleUpdateDto vehicleCreateDto){
        VehicleDto vehicleDto = this.vehicleFacade.updateVehicle(plate,vehicleCreateDto);
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }

}
