package demo.application.backend.persistence.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
public class ProductJpa {
    @Id
    @Column(name = "unique_id")
    @Type(type = "uuid-char")
    private UUID uniqueId;
    private String productName;
    private String description;
    private Double unitPrece;
}
