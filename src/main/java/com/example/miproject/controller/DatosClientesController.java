package com.example.miproject.controller;

import com.example.miproject.entity.DatosClientesEntity;
import com.example.miproject.interfa.DatosClientesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/datocliente")
public class DatosClientesController {

    @Autowired
    private DatosClientesInterface datosClientesInterface;

    @GetMapping
    public List<DatosClientesEntity> busquedaDatoCliente (){
        return (List<DatosClientesEntity>) datosClientesInterface.findAll();
    }

    @PostMapping
    public void crearDatoCliente (@RequestBody DatosClientesEntity DatClient){
        datosClientesInterface.save(DatClient);
    }

    @PutMapping
    public void actualizarDatoCliente (@RequestBody DatosClientesEntity DatClient){
        datosClientesInterface.save(DatClient);
    }

    @DeleteMapping (value = "/{id}")
    public void eliminarDatoCliente (@PathVariable ("id") Integer id){
        datosClientesInterface.deleteById(id);
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity <DatosClientesEntity> actualizarDatoClienteEspecifico (@PathVariable ("id") Integer id, @RequestBody DatosClientesEntity DatCliEntJson){
        DatosClientesEntity DatCliEntBd = datosClientesInterface.findById(id).orElseThrow();

        if (!(DatCliEntJson.getNombCliente() == null)) {
            DatCliEntBd.setNombCliente(DatCliEntJson.getNombCliente());
        }

        if (!(DatCliEntJson.getApellCliente() == null)) {
            DatCliEntBd.setApellCliente(DatCliEntJson.getApellCliente());
        }

        if (!(DatCliEntJson.getDniCliente() == null)) {
            DatCliEntBd.setDniCliente(DatCliEntJson.getDniCliente());
        }

        if (!(DatCliEntJson.getCorreoCliente() == null)) {
            DatCliEntBd.setCorreoCliente(DatCliEntJson.getCorreoCliente());
        }

        DatosClientesEntity DatCliEntBdActu = datosClientesInterface.save(DatCliEntBd);

        return ResponseEntity.ok(DatCliEntBdActu);
    }

}
