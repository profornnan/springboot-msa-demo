package msa.artist.controller;

import lombok.AllArgsConstructor;
import msa.artist.model.Artist;
import msa.artist.service.ArtistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/artist")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping(value = "/")
    public List<Artist> getAllArtist() {
        return artistService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Artist getArtistById(@PathVariable("id") String id) {
        return artistService.findByArtistId(id);
    }
}
