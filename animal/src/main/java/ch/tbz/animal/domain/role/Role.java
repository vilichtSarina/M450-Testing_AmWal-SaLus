package ch.tbz.animal.domain.role;

import ch.tbz.animal.core.generic.AbstractEntity;
import ch.tbz.animal.domain.Authority;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Role extends AbstractEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_authority", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities = new HashSet<>();

    public Role() {
    }

    public Role(UUID id, String name, Set<Authority> authorities) {
        super(id);
        this.name = name;
        this.authorities = authorities;
    }
}
