package com.example.backend.repositories;

import com.example.backend.entities.Utente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Utente, Long> {
    //
}
