package msa.artist.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "artist")
public class Artist {
    @Id
    private String id;
    private String artistId;
    private String artistName;
}
