package RESTfulService.temacurs21;

import RESTfulService.temacurs21.dtos.AddressDTO;
import RESTfulService.temacurs21.dtos.CompanyDTO;
import RESTfulService.temacurs21.dtos.GeoDTO;
import RESTfulService.temacurs21.dtos.UserDTO;
import RESTfulService.temacurs21.model.Address;
import RESTfulService.temacurs21.model.Company;
import RESTfulService.temacurs21.model.Geo;
import RESTfulService.temacurs21.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setAddress(convertToAddressEntity(userDTO.getAddress()));
        user.setCompany(convertToCompanyEntity(userDTO.getCompany()));
        return user;
    }

    private Address convertToAddressEntity(AddressDTO addressDTO) {
        if (addressDTO == null) {
            return null;
        }
        Address address = modelMapper.map(addressDTO, Address.class);
        address.setGeo(convertToGeoEntity(addressDTO.getGeo()));
        return address;
    }

    private Geo convertToGeoEntity(GeoDTO geoDTO) {
        if (geoDTO == null) {
            return null;
        }
        return modelMapper.map(geoDTO, Geo.class);
    }

    private Company convertToCompanyEntity(CompanyDTO companyDTO) {
        if (companyDTO == null) {
            return null;
        }
        return modelMapper.map(companyDTO, Company.class);
    }

    public List<User> convertToEntityList(List<UserDTO> userDTOList) {
        return userDTOList.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }
}
