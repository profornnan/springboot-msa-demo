package msa.artist.repository;

import msa.artist.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<Artist, String> {
    Artist findByArtistId(String id);
}
