package ch.tbz.animal.domain.pet;

import ch.tbz.animal.core.generic.AbstractEntity;
import ch.tbz.animal.domain.stat.Food;
import ch.tbz.animal.domain.stat.Love;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;

import java.util.UUID;

@Entity
public class Pet extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @JoinTable(name = "food_time")
    @OneToOne
    private Food food;

    @JoinTable(name = "love_time")
    @OneToOne
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
