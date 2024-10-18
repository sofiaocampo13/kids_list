package com.edu.umanizales.kids_list.controller;
import com.edu.umanizales.kids_list.model.Kid;
import com.edu.umanizales.kids_list.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listde")
public class ListDEController {

    @Autowired
    private ListDEService listDEService;

    @GetMapping
    public List getListChildren() {
        return listDEService.showKids();
    }

    @PostMapping
    public String addKidToFinal(@RequestBody Kid kid){
        listDEService.getListDE().add(kid);
        return "Adicionado exitosamente";
    }

    @PostMapping("/tostart")
    public String addKidToStart(@RequestBody Kid kid){
        listDEService.getListDE().addToStart(kid);
        return "Adicionado exitosamente";
    }

    @PostMapping("/inposition/{position}")
    public String addKidInPosition(@RequestBody Kid kidp, @PathVariable int position){
        if(position < 1 || position > listDEService.getListDE().getSize()) {
            return "Posicion no valida";
        }
        listDEService.getListDE().addInPosition(kidp, position);
        return "Adicionado exitosamente";
    }

    @PostMapping("/invert")
    public String invertKidsList(){
        listDEService.getListDE().invert();
        return "Lista invertida exitosamente";
    }

    @DeleteMapping ("/deleteid/{id_delete}")
    public String deleteKidById(@RequestBody Kid kidid, @PathVariable String id_delete){
        listDEService.getListDE().deleteById(kidid, id_delete);
        return "Eliminado exitosamente";
    }

    @DeleteMapping("/deletepst/{position}")
    public String deleteKidById(@RequestBody Kid kidpst, @PathVariable int position){
        listDEService.getListDE().deleteByPosition(kidpst, position);
        return "Eliminado exitosamente";
    }

    @GetMapping("mixbygender")
    public String mixByGender(){
        listDEService.getListDE().switchByGender();
        return "Mix by gender";
    }

    @PostMapping("/switchends")
    public String switchKidsListEnds(){
        listDEService.getListDE().switchEnds();
        return "Extremos intercambiandos exitosamente";
    }

} //Fin del controlador
