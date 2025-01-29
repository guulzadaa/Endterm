import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    User registerUser(User user);
    boolean login(String email, String password);
    boolean changePassword(int id, String oldPassword, String newPassword);
    boolean isEmailTaken(String email);
    boolean isPhoneNumberValid(int number);
    void deleteUser(int id);
}
