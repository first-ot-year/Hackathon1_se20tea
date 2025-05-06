package User.appication;

import User.domain.UserConsumptionDTO;
import User.domain.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user,
                                           @RequestParam Long companyId) {
        return ResponseEntity.ok(userService.createUser(user, companyId));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam Long companyId) {
        return ResponseEntity.ok(userService.getAllUsersByCompany(companyId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/limits")
    public ResponseEntity<UserLimit> assignLimit(@PathVariable Long id,
                                                 @RequestBody UserLimit limit) {
        return ResponseEntity.ok(userService.assignLimitToUser(id, limit));
    }

    @GetMapping("/{id}/consumption")
    public ResponseEntity<UserConsumptionDTO> getConsumption(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserConsumption(id));
    }

}
