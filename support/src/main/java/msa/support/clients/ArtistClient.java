package msa.support.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import msa.support.domain.Artist;

@Component
@FeignClient(url="http://localhost:8003", value="artist")
public interface ArtistClient {

    @GetMapping("/api/artist/{id}")
    Artist getArtist(@PathVariable String id);
}
