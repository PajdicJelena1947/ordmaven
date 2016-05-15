/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.Karton;
import com.entity.Lekar;
import com.entity.Pregled;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jelena.pajdic
 */
public interface PregledRepository extends CrudRepository<Pregled, Long> {
    
    Long countByVremeAndLekarId(Date vreme,Lekar lekar);
    Pregled findById(int id);
    List<Pregled> findByjmbg(Karton karton);
    @Query(value="SELECT * FROM `pregled` JOIN `karton` on pregled.jmbg=?1;",nativeQuery=true)
    List<Pregled> findByJmbg(String jmbg);
}
