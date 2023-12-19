package demo.application.backend.persistence.repository;

import demo.application.backend.persistence.entities.ProductJpa;
import demo.application.backend.persistence.mappers.BaseJpaMapper;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductJpaRepository extends BaseJpaMapper<ProductJpa, UUID>, JpaSpecificationExecutor<ProductJpa> {
}
