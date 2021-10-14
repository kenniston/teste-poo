package br.iesb.cco.apidemo.repository;

import br.iesb.cco.apidemo.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/*
    Referencia Spring Data:
        https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 */
 public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<List<UserEntity>> findByNameContaining(String name);

}



