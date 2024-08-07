package ar.net.edufmass.springpetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Specialties")
public class Specialty extends BaseEntity {

    @Column(name = "description")
    private String description;

}
