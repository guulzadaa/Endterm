import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private int nextId = 1; // Генерация ID

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public Optional<User> findByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    public User save(User user) {
        if (user.getId() == 0) { // Новый пользователь
            user = new User(nextId++, user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getNumber());
            users.add(user);
        } else { // Обновление пользователя
            users.replaceAll(u -> u.getId() == user.getId() ? user : u);
        }
        return user;
    }

    public void deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
