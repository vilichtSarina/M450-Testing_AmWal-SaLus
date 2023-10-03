package ch.tbz.animal.domain.pet;

import ch.tbz.animal.core.generic.AbstractEntity;
import ch.tbz.animal.domain.stat.Food;
import ch.tbz.animal.domain.stat.Love;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "pet")
@Entity
public class Pet extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "love_id", referencedColumnName = "id")
    private Love love;

    public Pet(UUID id, String name, Food food, Love love) {
        super(id);
        this.name = name;
        this.food = food;
        this.love = love;
    }

    public Pet() {

    }
}
