package lessonfour.hometask.repository;

import lessonfour.hometask.model.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(Long id);
}
