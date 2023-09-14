package com.daya.app.repo;


import com.daya.app.model.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Hospital, Integer> {
}

