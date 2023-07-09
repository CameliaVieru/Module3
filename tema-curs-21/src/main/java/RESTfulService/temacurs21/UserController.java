package RESTfulService.temacurs21;


import RESTfulService.temacurs21.dtos.AddressDTO;
import RESTfulService.temacurs21.dtos.UserDTO;
import RESTfulService.temacurs21.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userServiceAPI;

    @PostMapping("/save")
    public ResponseEntity<Response> saveUsers() {
        userServiceAPI.saveUsers();
        return ResponseEntity.status(200).body(new Response("Users saved successfully"));
    }

    @PostMapping("/user/add")
    public ResponseEntity<Response> addUser(@RequestBody UserDTO userDTO) {
        Response response = Response.builder().result(userServiceAPI.addUser(userDTO).toString()).build();
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(200).body(userServiceAPI.getAllRegisteredUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> user = userServiceAPI.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.status(200).body(user);
        }
        throw new ResourceException("User with Id: " + id + " not found");
    }

    @GetMapping("/user/email")
    public @ResponseBody ResponseEntity<Optional<User>> getUserByNameAndEmail(@RequestParam(name = "name") String name,
                                                                              @RequestParam(name = "email") String email) {
        Optional<User> user = userServiceAPI.getUserByNameAndEmail(name, email);
        if (user.isPresent()) {
            return ResponseEntity.status(200).body(user);
        }
        throw new ResourceException("User with email: " + email + " not found");
    }

    @PutMapping("/{id}/phone")
    public ResponseEntity<Response> updateUserPhone(@PathVariable Long id, @RequestParam String phone) {
        Optional<User> user = userServiceAPI.getUserById(id);
        if (user.isPresent()){
            userServiceAPI.updateUserPhone(id, phone);
            return ResponseEntity.status(200).body(new Response("User phone updated successfully"));
        }
        throw new ResourceException("User with id: " + id + " not found");
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<Response> updateUserAddress(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        Optional<User> user = userServiceAPI.getUserById(id);
        if (user.isPresent()){
            userServiceAPI.updateUserAddress(id,addressDTO);
            return ResponseEntity.status(200).body(new Response("User address updated successfully"));
        }
        throw new ResourceException("User with id: " + id + " not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable Long id) {
        Optional<User> user = userServiceAPI.getUserById(id);
        if (user.isPresent()){
            userServiceAPI.deleteUser(id);
            return ResponseEntity.status(200).body(new Response("User deleted successfully"));
        }
        throw new ResourceException("User with id: " + id + " not found");
    }

    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<String> handleUserNotFoundException(ResourceException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
