package com.tablasRelacionadasCRUD.service.User;

import com.tablasRelacionadasCRUD.entity.Usuario;

public interface UserService {
    public Usuario createUser(Usuario usuario);
    public Usuario getUserById(Long id);
}
