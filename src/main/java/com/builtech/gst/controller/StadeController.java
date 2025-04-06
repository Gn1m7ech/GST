package com.builtech.gst.controller;

import com.builtech.gst.dto.StadeDto;
import com.builtech.gst.dto.StadeRequest;
import com.builtech.gst.entity.Stade;
import com.builtech.gst.mapper.StadeMapper;
import com.builtech.gst.service.StadeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping("/gst/stades")
public class StadeController {

    private final StadeService service;
    private final StadeMapper mapper;

    public StadeController(StadeService service, StadeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StadeDto> createStade(@RequestBody @Validated StadeRequest stade){
        if (stade.getName().isEmpty()||
                stade.getAdresse().isEmpty()||
                stade.getContact().isEmpty()||
                stade.getLocation().isEmpty()){
            throw new InvalidParameterException();
        }
        Stade stade1 = service.create(stade);
        return ResponseEntity.ok(mapper.INSTANCE.stadeToDto(stade1));
    }

    @PutMapping("/update/{stadeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StadeDto> updateStade(@PathVariable long stadeId, @RequestBody @Validated StadeRequest stade){
        if (stade.getName().isEmpty()||
                stadeId==0||
                stade.getAdresse().isEmpty()||
                stade.getContact().isEmpty()||
                stade.getLocation().isEmpty()){
            throw new InvalidParameterException();
        }
        Stade r = service.update(stadeId, stade);
        return ResponseEntity.ok(mapper.INSTANCE.stadeToDto(r));
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<StadeDto>> getAllStades(){
        List<StadeDto> list = service.allStades().stream()
                .map(stade -> mapper.INSTANCE.stadeToDto(stade) )
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/find/{stadeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StadeDto> findStade(@PathVariable long stadeId){
        if(stadeId==0){
            throw new InvalidParameterException();
        }
        return ResponseEntity.ok(mapper.INSTANCE.stadeToDto(service.read(stadeId)));
    }

    @DeleteMapping("/drop/{stadeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> dropStade(@PathVariable long stadeId){
        if(stadeId==0){
            throw new InvalidParameterException();
        }
        String w = service.delete(stadeId);
        return ResponseEntity.ok(w);
    }

}
