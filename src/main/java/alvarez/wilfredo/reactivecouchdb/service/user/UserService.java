package alvarez.wilfredo.reactivecouchdb.service.user;


import alvarez.wilfredo.reactivecouchdb.service.user.datasource.UserRepository;
import alvarez.wilfredo.reactivecouchdb.service.user.datasource.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<String> getAll() {
        return this.userRepository.getAll();
    }

    public User getUser(String id) {
        return this.userRepository.getUser(id);
    }

    public void saveUser(User u) {
        this.userRepository.saveUser(u);
    }
}
