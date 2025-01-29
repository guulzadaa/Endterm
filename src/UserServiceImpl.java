import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository = new UserRepository();

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User registerUser(User user) {
        if (isEmailTaken(user.getEmail())) {
            throw new RuntimeException("Email already registered.");
        }
        if (!isPhoneNumberValid(user.getNumber())) {
            throw new RuntimeException("Invalid phone number.");
        }
        user.setPassword(hashPassword(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public boolean login(String email, String password) {
        return userRepository.findByEmail(email)
                .map(user -> user.getPassword().equals(hashPassword(password)))
                .orElse(false);
    }

    @Override
    public boolean changePassword(int id, String oldPassword, String newPassword) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(hashPassword(oldPassword))) {
                user.setPassword(hashPassword(newPassword));
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean isPhoneNumberValid(int number) {
        String phone = String.valueOf(number);
        return phone.matches("\\d{10}");
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    private String hashPassword(String password) {
        return String.valueOf(password.hashCode());
    }
}
