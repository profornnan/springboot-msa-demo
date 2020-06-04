package msa.support.controller;

import msa.support.model.Support;
import msa.support.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/support")
public class SupportController {

    @Autowired
    private SupportService supportService;

    @GetMapping(value = "/")
    public List<Support> getAllSupport() {
        return supportService.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public List<Support> getSupportListByUserId(@PathVariable("id") String id) {
        return supportService.findByUserId(id);
    }
}
