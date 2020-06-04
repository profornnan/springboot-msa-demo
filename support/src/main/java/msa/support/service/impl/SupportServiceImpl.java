package msa.support.service.impl;

import msa.support.clients.UserClient;
import msa.support.model.Support;
import msa.support.repository.SupportRepository;
import msa.support.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportServiceImpl implements SupportService {

    @Autowired
    private SupportRepository supportRepository;

    @Autowired
    UserClient userClient;

    @Override
    public List<Support> findAll() {
        return supportRepository.findAll();
    }

    @Override
    public List<Support> findByUserId(String id) {

        List<Support> supportList = supportRepository.findByUserId(id);

        for(Support support : supportList) {
            support.withUserName(userClient.getUser(id).getUserName());
        }

        return supportList;
    }

}
