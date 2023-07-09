package RESTfulService.temacurs21.repo;

import RESTfulService.temacurs21.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByNameAndEmail(String name, String email);
}
