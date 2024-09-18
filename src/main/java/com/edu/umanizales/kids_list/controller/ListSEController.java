package com.edu.umanizales.kids_list.controller;

import com.edu.umanizales.kids_list.model.Kid;
import com.edu.umanizales.kids_list.model.Node;
import com.edu.umanizales.kids_list.service.ListSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listse")
public class ListSEController {

    @Autowired
    private ListSEService listSEService;

    @GetMapping
    public Node getListChildren() {
        return listSEService.showKids();
    }

    @PostMapping
    public String addKidToFinal(@RequestBody Kid kid){
        listSEService.getListSE().add(kid);
        return "Adicionado exitosamente";
    }

    @PostMapping("/tostart")
    public String addKidToStart(@RequestBody Kid kid){
        listSEService.getListSE().addToStart(kid);
        return "Adicionado exitosamente";
    }

    // MI CODIGO
//    @PostMapping("/inposition/{position}")
//    public String addKidInPosition(@RequestBody Kid kidp, @PathVariable int position){
//        listSEService.getListSE().addInPosition(kidp, position);
//        return "Adicionado exitosamente";
//    }

    @PostMapping("/inposition/{position}")
    public String addKidInPosition(@RequestBody Kid kidp, @PathVariable int position){
        if(position < 1 || position > listSEService.getListSE().getSize()) {
            return "Posicion no valida";
        }
        listSEService.getListSE().addInPosition(kidp, position);
        return "Adicionado exitosamente";
    }

    @PostMapping("/invert")
    public String invertKidsList(){
        listSEService.getListSE().invert();
        return "Lista invertida exitosamente";
    }

    @DeleteMapping ("/deleteid/{id_delete}")
    public String deleteKidById(@RequestBody Kid kidid, @PathVariable String id_delete){
        listSEService.getListSE().deleteById(kidid, id_delete);
        return "Eliminado exitosamente";
    }

    @DeleteMapping("/deletepst/{position}")
    public String deleteKidById(@RequestBody Kid kidpst, @PathVariable int position){
        listSEService.getListSE().deleteByPosition(kidpst, position);
        return "Eliminado exitosamente";
    }

//    @PostMapping("/switchbygender")
//    public String switchKidsByGender(){
//        listSEService.getListSE().switchByGender();
//        return "Lista intercalada exitosamente";
//    }

    @GetMapping("mixbygender")
    public String mixByGender(){
        listSEService.getListSE().switchByGender();
        return "Mix by gender";
    }

    @PostMapping("/switchends")
    public String switchKidsListEnds(){
        listSEService.getListSE().switchEnds();
        return "Extremos intercambiandos exitosamente";
    }
}
