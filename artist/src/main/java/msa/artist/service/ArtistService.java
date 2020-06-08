package msa.artist.service;

import msa.artist.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> findAll();
    Artist findByArtistId(String id);
}
