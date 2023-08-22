package ch.tbz.animal.domain.stat;

import ch.tbz.animal.core.generic.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Setter
@Table(name="food")
@Entity
public class Food extends AbstractEntity {

    @Column(name="last_updated")
    private Integer last_updated;

    public Food(UUID id, Integer last_updated) {
        super(id);
        this.last_updated = last_updated;
    }

    public Food() {

    }
}
