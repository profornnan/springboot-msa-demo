package msa.support.service;

import lombok.RequiredArgsConstructor;
import msa.support.clients.ArtistClient;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import msa.support.clients.UserClient;
import msa.support.domain.Support;
import msa.support.domain.SupportRepository;
import msa.support.web.dto.SupportResponseDto;
import msa.support.web.dto.SupportSaveDto;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SupportService {

    private final SupportRepository supportRepository;

    private final UserClient userClient;
    private final ArtistClient artistClient;

    public List<SupportResponseDto> findAll() {
        List<SupportResponseDto> responseDtos = new ArrayList<>();
        List<Support> supportList = supportRepository.findAll();

        for (Support support : supportList) {
            support.withUserName(userClient.getUser(support.getUserId()).getName())
                    .withArtistName(artistClient.getArtist(support.getArtistId()).getArtistName());
            responseDtos.add(new SupportResponseDto((support)));
        }

        return responseDtos;
    }

    public List<SupportResponseDto> findByArtistId(String id) {
        List<SupportResponseDto> responseDtos = new ArrayList<>();
        List<Support> supportList = supportRepository.findByArtistId(id);

        for (Support support : supportList) {
            support.withUserName(userClient.getUser(support.getUserId()).getName())
                    .withArtistName(artistClient.getArtist(id).getArtistName());
            responseDtos.add(new SupportResponseDto((support)));
        }

        return responseDtos;
    }

    public List<SupportResponseDto> findByUserId(String id) {
        List<SupportResponseDto> responseDtos = new ArrayList<>();
        List<Support> supportList = supportRepository.findByUserId(id);

        for (Support support : supportList) {
            support.withUserName(userClient.getUser(id).getName())
                    .withArtistName(artistClient.getArtist(support.getArtistId()).getArtistName());
            responseDtos.add(new SupportResponseDto((support)));
        }

        return responseDtos;
    }

    public ObjectId save(SupportSaveDto requestDto) {
        return supportRepository.save(requestDto.toEntity()).getId();
    }
}
