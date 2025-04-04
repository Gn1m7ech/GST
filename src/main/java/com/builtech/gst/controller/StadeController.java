package com.builtech.gst.controller;

import com.builtech.gst.dto.StadeDto;
import com.builtech.gst.entity.Stade;
import com.builtech.gst.service.StadeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping("/gst/stades")
public class StadeController {

    private final StadeService service;

    public StadeController(StadeService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Stade> createStade(@RequestBody @Valid StadeDto stade){
        if (stade.getName().isEmpty()||
                stade.getAdresse().isEmpty()||
                stade.getContact().isEmpty()||
                stade.getLocation().isEmpty()){
            throw new InvalidParameterException();
        }
        Stade stade1 = service.create(stade);
        return ResponseEntity.ok(stade1);
    }

    @PutMapping("/update/{stadeId}")
    public ResponseEntity<Stade> updateStade(@PathVariable long stadeId, @RequestBody @Valid StadeDto stade){
        if (stade.getName().isEmpty()||
                stadeId==0||
                stade.getAdresse().isEmpty()||
                stade.getContact().isEmpty()||
                stade.getLocation().isEmpty()){
            throw new InvalidParameterException();
        }
        Stade r = service.update(stadeId, stade);
        return ResponseEntity.ok(r);
    }

    @GetMapping("/")
    public ResponseEntity<List<Stade>> getAllStades(){
        return ResponseEntity.ok(service.allStades());
    }

    @GetMapping("/find/{stadeId}")
    public ResponseEntity<Stade> findStade(@PathVariable long stadeId){
        if(stadeId==0){
            throw new InvalidParameterException();
        }
        return ResponseEntity.ok(service.read(stadeId));
    }

    @DeleteMapping("/drop/{stadeId}")
    public ResponseEntity<String> dropStade(@PathVariable long stadeId){
        if(stadeId==0){
            throw new InvalidParameterException();
        }
        String w = service.delete(stadeId);
        return ResponseEntity.ok(w);
    }

}
