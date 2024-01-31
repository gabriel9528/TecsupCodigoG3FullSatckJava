package com.tablasRelacionadasCRUD.service.User;

import com.tablasRelacionadasCRUD.entity.Usuario;
import com.tablasRelacionadasCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public Usuario createUser(Usuario usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public Usuario getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
