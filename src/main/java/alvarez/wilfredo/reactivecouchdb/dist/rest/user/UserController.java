package alvarez.wilfredo.reactivecouchdb.dist.rest.user;

import alvarez.wilfredo.reactivecouchdb.service.user.UserService;
import alvarez.wilfredo.reactivecouchdb.service.user.datasource.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<String>> getAll() {
        List<String> userList = userService.getAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User u) {
        userService.saveUser(u);
        return ResponseEntity.ok().build();
    }
}
