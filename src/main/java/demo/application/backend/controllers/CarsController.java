package demo.application.backend.controllers;

import demo.application.backend.domain.services.CarsService;
import demo.application.backend.persistence.entities.CarsJpa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
@Api(tags = "Cars")
public class CarsController {

    private final CarsService carsService;

    @ApiOperation(value = "Servicio que devuelve el listado de autos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Autos recuperadas satisfactoriamente"),
            @ApiResponse(code = 500, message = "Error interno")})
    @GetMapping(value = "/carList")
    public ResponseEntity<?> getCarsList() {
        return new ResponseEntity<>(carsService.getCarsList(), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Autos creado satisfactoriamente"),
            @ApiResponse(code = 500, message = "Error interno")})
    @PostMapping("/crearAuto")
    public ResponseEntity<?> crearAuto(@RequestBody CarsJpa carsJpa) {
        carsJpa.getUniqueId();
        return new ResponseEntity<>(carsService.crearAuto(carsJpa).getUniqueId().toString(), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Autos creado satisfactoriamente"),
            @ApiResponse(code = 500, message = "Error interno")})
    @PutMapping("/actualizarAuto")
    public ResponseEntity<?> actualizarAuto(@RequestBody CarsJpa carsJpa) {
        carsJpa.getUniqueId();
        return new ResponseEntity<>(carsService.actualizarAuto(carsJpa).getUniqueId().toString(), HttpStatus.OK);
    }
}
