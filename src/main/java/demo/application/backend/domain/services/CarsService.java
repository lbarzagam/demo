package demo.application.backend.domain.services;

import demo.application.backend.infra.exceptions.DomainEntityNotExistsException;
import demo.application.backend.infra.exceptions.DomainException;
import demo.application.backend.persistence.entities.CarsJpa;
import demo.application.backend.persistence.repository.CarsJpaRepository;
import demo.application.backend.utils.reflection.Util_Reflection;
import demo.application.backend.validators.CodigoErrorEnum;
import lombok.RequiredArgsConstructor;
import org.boon.core.reflection.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarsService {

    private final CarsJpaRepository carsRepository;

    public List<CarsJpa> getCarsList() {
       return carsRepository.findAll();
    }

    public CarsJpa crearAuto(CarsJpa carsJpa) {
        return carsRepository.save(carsJpa);
    }

    public CarsJpa actualizarAuto(CarsJpa carActualizado) {
        CarsJpa carBD = carsRepository.findById(carActualizado.getUniqueId())
                .orElseThrow(() -> new DomainEntityNotExistsException(CarsJpa.class, carActualizado.getUniqueId()));
        BeanUtils.copyProperties(carActualizado, carBD, Util_Reflection.getNullPropertyNames(carActualizado));
        return carsRepository.save(carBD);
    }

    public void deleteAuto(UUID idAuto) {
     try {
         carsRepository.deleteById(idAuto);
     }
     catch (Exception ex) {
         throw new DomainException(CodigoErrorEnum.ERROR_INTEGRIDAD_DATOS, ex.getMessage());
     }
    }
}
