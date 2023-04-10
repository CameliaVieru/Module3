package Controller;

import Model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringController {

    @PostMapping("/message")
    public ResponseEntity<Message> getMessage(@RequestHeader ("authentication") String authentication, @RequestBody Message message){
        if(authentication.equals("devmind-api-key")) {
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
