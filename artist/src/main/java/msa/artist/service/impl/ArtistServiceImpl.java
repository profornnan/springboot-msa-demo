package msa.artist.service.impl;

import lombok.AllArgsConstructor;
import msa.artist.model.Artist;
import msa.artist.repository.ArtistRepository;
import msa.artist.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findByArtistId(String id) {
        return artistRepository.findByArtistId(id);
    }
}
