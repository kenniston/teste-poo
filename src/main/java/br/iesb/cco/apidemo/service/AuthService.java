package br.iesb.cco.apidemo.service;

import br.iesb.cco.apidemo.dto.UserDTO;
import br.iesb.cco.apidemo.model.UserEntity;
import br.iesb.cco.apidemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Scope("singleton")
public class AuthService {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Autowired
    private UserRepository repo;

    public String login(UserDTO user) {
        String email = user.getEmail();
        String pass = user.getPassword();

        for (UserEntity u : repo.findAll()) {
            if (u.getEmail().equals(email) && u.getPassword().equals(pass)) {
                return u.getToken();
            }
        }
        return null;
    }

    public List<UserDTO> getUsers(String name) {
        String filter = name != null ? name : "";
        Optional<List<UserEntity>> result = repo.findByNameContaining(filter);

        List<UserDTO> lst = new ArrayList<>();

        if (result.isPresent()) {
            List<UserEntity> users = result.get();
            for (UserEntity u : users) {
                UserDTO dto = new UserDTO(u.getId(), u.getName(), u.getEmail(), u.getPassword());
                lst.add(dto);
            }
        }

        return lst;
    }

    public int signup(UserDTO user) {
        if (user.getName().trim().equals("") || user.getName().trim().split(" ").length < 2) {
            return 1;
        }

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
        if (!matcher.find()) {
            return 2;
        }

        if (user.getPassword().length() < 6) {
            return 3;
        }

        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());

        String token = UUID.randomUUID().toString();
        entity.setToken(token);

        repo.save(entity);

        return 0;
    }

}
