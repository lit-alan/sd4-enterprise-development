    package com.sd4.L11.repo;

    import com.sd4.L11.entitys.Role;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.Optional;

    public interface RoleRepository extends JpaRepository<Role, Long> {
        Optional<Role> findByName(String name);
    }