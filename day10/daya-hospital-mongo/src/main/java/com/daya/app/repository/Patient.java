package com.daya.app.repository;

import com.daya.app.model.PatientMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Patient extends MongoRepository<Hospital, Integer> {
}
