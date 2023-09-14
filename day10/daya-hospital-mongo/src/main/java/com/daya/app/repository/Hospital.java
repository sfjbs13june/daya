package com.daya.app.repository;

import com.daya.app.model.HospitalMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Hospital extends MongoRepository<Hospital, Integer> {
}