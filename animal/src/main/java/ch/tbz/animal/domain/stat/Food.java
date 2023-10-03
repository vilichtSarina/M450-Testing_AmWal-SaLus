package ch.tbz.animal.domain.stat;

import ch.tbz.animal.core.generic.AbstractEntity;
import ch.tbz.animal.domain.pet.Pet;
import ch.tbz.animal.domain.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Table(name="food")
@Entity
public class Food extends AbstractEntity {
    @Column(name="last_updated")
    private LocalDateTime last_updated;

    public Food(UUID id, LocalDateTime last_updated) {
        super(id);
        this.last_updated = last_updated;
    }

    public Food() {

    }
}
