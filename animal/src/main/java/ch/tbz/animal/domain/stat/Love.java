package ch.tbz.animal.domain.stat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Love {
    @Id
    @Column(name = "food_id", nullable = false)
    private Long loveId;

    @Column(name = "lastUpdated")
    private LocalDateTime lastUpdated;

    public Love() {
    }
}
