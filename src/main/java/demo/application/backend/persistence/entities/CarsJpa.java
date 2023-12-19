package demo.application.backend.persistence.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "car")
@Entity
public class CarsJpa {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "unique_id")
    private UUID uniqueId;
    private String marca;
    private String color;
    private String matricula;
    private LocalDateTime created;
}
