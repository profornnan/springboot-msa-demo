package msa.support.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SupportRepository extends MongoRepository<Support, String> {
    List<Support> findByArtistId(String id);
    List<Support> findByUserId(String id);
}
