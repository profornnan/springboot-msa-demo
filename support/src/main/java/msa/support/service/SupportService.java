package msa.support.service;


import msa.support.model.Support;

import java.util.List;

public interface SupportService {
    List<Support> findAll();
    List<Support> findByUserId(String id);
}
