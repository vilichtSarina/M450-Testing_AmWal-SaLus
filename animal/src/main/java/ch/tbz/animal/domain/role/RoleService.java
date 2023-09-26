package ch.tbz.animal.domain.role;

import org.springframework.stereotype.Service;

@Service
public class RoleService {

    public final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleByName(String name) {
        return roleRepository.findByName(name).get(0);
    }
}
