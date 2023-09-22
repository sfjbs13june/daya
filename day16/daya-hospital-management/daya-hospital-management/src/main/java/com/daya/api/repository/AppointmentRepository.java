package com.daya.api.repository;
import com.daya.api.model.Appontment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appontment, String> {
    public List<Appontment> getByName(String doctorName);
    public Appontment save(Appontment appointment);
}
