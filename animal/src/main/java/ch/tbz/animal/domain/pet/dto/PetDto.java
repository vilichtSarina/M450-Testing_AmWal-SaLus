package ch.tbz.animal.domain.pet.dto;

import ch.tbz.animal.core.generic.AbstractDTO;
import ch.tbz.animal.domain.stat.Food;
import ch.tbz.animal.domain.stat.Love;
import jakarta.persistence.Column;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PetDto extends AbstractDTO {
    private String name;
    private Food food;
    private Love love;

    public PetDto(String name, Food food, Love love) {
        this.name = name;
        this.food = food;
        this.love = love;
    }

    public PetDto() {
    }
}
