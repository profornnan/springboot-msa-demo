package msa.support.repository;

import msa.support.model.Support;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SupportRepository extends MongoRepository<Support, String> {
    List<Support> findByUserId(String id);
}
