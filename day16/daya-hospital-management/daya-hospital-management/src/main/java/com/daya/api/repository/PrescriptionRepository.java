package com.daya.api.repository;
import com.daya.api.model.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends MongoRepository<Prescription, String> {
    public List<Prescription> getByName(String patientName);
    public Prescription save(Prescription prescription);
}
