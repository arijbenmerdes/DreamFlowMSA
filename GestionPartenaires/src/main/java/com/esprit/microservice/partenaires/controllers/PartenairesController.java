package com.esprit.microservice.partenaires.controllers;

import com.esprit.microservice.partenaires.entities.Partenaires;
import com.esprit.microservice.partenaires.services.PartenairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partenaires")
public class PartenairesController {

    @Autowired
    private PartenairesService service;

    @PostMapping("/create")
    public ResponseEntity<Partenaires> create(@RequestBody Partenaires p) {

        return new ResponseEntity<>(service.save(p), HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public List<Partenaires> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partenaires> getById(@PathVariable Long id) {
        Partenaires p = service.getPartnerById(id);

        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si l'ID est introuvable
        }
        return new ResponseEntity<>(p, HttpStatus.OK); // 200 OK si tout va bien    }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Partenaires> update(@PathVariable Long id, @RequestBody Partenaires updatedPartner) {
        try {
            Partenaires updatedEntity = service.update(id, updatedPartner); // Mise à jour via le service
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK); // 200 OK si tout va bien    }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean isDeleted = service.delete(id); // Supposons que `service.delete` renvoie un boolean.
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content si suppression réussie
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si l'entité à supprimer n'existe pas
    }

}
