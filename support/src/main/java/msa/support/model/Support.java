package msa.support.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "support")
public class Support {
    @Id
    private String id;
    private String userId;
    private String artistId;
    private String amount;
    private String datetime;
    private String uid;

    @Transient
    private String userName = "";

    public Support withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }
}