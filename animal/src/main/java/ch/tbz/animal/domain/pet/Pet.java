package ch.tbz.animal.domain.pet;

import ch.tbz.animal.core.generic.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Pet extends AbstractEntity {

    @Column(name = "name")
    private String name;


    public Pet() {

    }

//    @JoinTable(name = "owner")
//    @OneToOne
//    @NotNull
//    private User owner;
}
