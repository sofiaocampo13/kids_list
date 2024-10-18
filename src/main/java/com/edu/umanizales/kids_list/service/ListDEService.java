package com.edu.umanizales.kids_list.service;

import com.edu.umanizales.kids_list.model.ListDE;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ListDEService {
    private ListDE listDE;

    @PostConstruct
    public void init () {
        listDE = new ListDE();
    }

    public List showKids() {
        return listDE.show();
    }

} //Fin del servicio
