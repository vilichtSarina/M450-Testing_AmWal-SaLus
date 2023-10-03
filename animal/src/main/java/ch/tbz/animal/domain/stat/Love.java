package ch.tbz.animal.domain.stat;

import ch.tbz.animal.core.generic.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table(name = "love")
@Entity
public class Love extends AbstractEntity {
    @Column(name="last_updated")
    private LocalDateTime last_updated;

    public Love(UUID id, LocalDateTime last_updated) {
        super(id);
        this.last_updated = last_updated;
    }

    public Love() {

    }
}
