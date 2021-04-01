
package com.example.CRUD.controller;

import com.example.CRUD.model.CRUD;
import com.example.CRUD.repository.CrudRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontroller {
    @Autowired
    private CrudRepo cRepo;
   
    @RequestMapping("/home")
    public String home()
    {
        return "Hello Spring Boot";
    }
    @GetMapping("/getAll")
    public List<CRUD> getAllCRUD()
    {
        
        return cRepo.findAll();
    }
     @GetMapping("/getCrud/{id}")
    public Optional<CRUD> getCrud(@PathVariable String id)
    {
        return this.cRepo.findById(Integer.parseInt(id));
        
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCrud(@PathVariable String id)
    {
        try{
        cRepo.deleteById(Integer.parseInt(id));
       
    return  ResponseEntity.ok("Delete Sucessfully..");
    
        }
       catch(Exception e)
        {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        }
       
    }
    @PostMapping("/add")
    public  CRUD addCrud( @RequestBody CRUD cr)
    {
        return cRepo.save(cr);
   }
    
    
  @PostMapping("/update")
    public CRUD updateCrud( @RequestBody CRUD cr)
    {
        return cRepo.save(cr);
    }
    
    
    
}
