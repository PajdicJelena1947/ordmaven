/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.entity.Karton;
import com.entity.Pregled;
import com.service.LekarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jelena.pajdic
 */
@RestController
public class LekarRestController {
    @Autowired
    private LekarService lService;
    
    
    @RequestMapping(value = "/svipacijentiLekar/{brojLicence}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Karton>> sviPacijentiLekar(@PathVariable("brojLicence") String brojLicence) {
        List<Karton> kartoni=lService.sviPacijenti(brojLicence);
        return new ResponseEntity<List<Karton>>(kartoni, HttpStatus.OK);
    }
     @RequestMapping(value = "/svipreglediLekar/{brojLicence}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pregled>> sviPreglediLekar(@PathVariable("brojLicence") String brojLicence) {
        List<Pregled> pregledi=lService.sviPregledi(brojLicence);
        return new ResponseEntity<List<Pregled>>(pregledi, HttpStatus.OK);
    }
    @RequestMapping(value = "/svipreglediPacijentLekar/{jmbg}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pregled>> sviPreglediPacijent(@PathVariable("jmbg") String jmbg) {
        List<Pregled> pregledi=lService.preglediPacijenta(jmbg);
        return new ResponseEntity<List<Pregled>>(pregledi, HttpStatus.OK);
    }
    
    
}
