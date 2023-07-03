package com.test.test.mappers;

import com.test.test.dto.UserDTO;
import com.test.test.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper  implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getFname()
        );
    }
}
