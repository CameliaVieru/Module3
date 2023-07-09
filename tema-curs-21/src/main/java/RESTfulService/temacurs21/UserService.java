package RESTfulService.temacurs21;

import RESTfulService.temacurs21.dtos.AddressDTO;
import RESTfulService.temacurs21.dtos.UserDTO;
import RESTfulService.temacurs21.model.Address;
import RESTfulService.temacurs21.model.Geo;
import RESTfulService.temacurs21.model.User;
import RESTfulService.temacurs21.repo.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public List<UserDTO> mapJsonToDto() {
        RestTemplate restTemplate = new RestTemplate();
        List<UserDTO> usersDTO = new ObjectMapper().convertValue(restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", List.class), new TypeReference<>() {
        });
        return usersDTO;
    }

    public void saveUsers(){
        List<UserDTO> userDTOList =mapJsonToDto();
        List<User> users = userMapper.convertToEntityList(userDTOList);
        users.stream().forEach(userRepository::save);
    }

    public List<User> getAllRegisteredUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public Optional<User> getUserByNameAndEmail(String name, String email){
        return userRepository.getUserByNameAndEmail(name, email);
    }

    public User addUser(UserDTO userDTO) {
        User savedUser = userRepository.save(userMapper.convertToEntity(userDTO));
        return savedUser;
    }

    public void updateUserPhone(Long id, String phone){
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setPhone(phone);
            userRepository.save(user);
        }
    }

    public void updateUserAddress(Long id, AddressDTO addressDTO) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            enrichUserAddress(addressDTO, user);
            userRepository.save(user);
        }
    }

    private void enrichUserAddress(AddressDTO addressDTO, User user) {
        Address address = user.getAddress();
        Geo geo = address.getGeo();
        geo.setLat(addressDTO.getGeo().getLat());
        geo.setLng(addressDTO.getGeo().getLng());
        address.setGeo(geo);
        address.setCity(addressDTO.getCity());
        address.setSuite(addressDTO.getSuite());
        address.setZipcode(addressDTO.getZipcode());
        address.setStreet(addressDTO.getStreet());
        user.setAddress(address);
    }

    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            userRepository.delete(user);
        }
    }

}
