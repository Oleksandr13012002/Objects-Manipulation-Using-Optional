package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> findUserById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<List<User>> findAllUsers() {
        return users.isEmpty() ? Optional.empty() : Optional.of(users);
    }
}
