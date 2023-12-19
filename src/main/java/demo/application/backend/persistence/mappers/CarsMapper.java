package demo.application.backend.persistence.mappers;

import demo.application.backend.domain.entities.Cars;
import demo.application.backend.persistence.entities.CarsJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarsMapper extends BaseJpaMapper<Cars, CarsJpa> {

}
