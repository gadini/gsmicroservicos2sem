package com.github.gadini.gs.gs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.gadini.gs.gs.dtos.SafraRequestCreateDto;
import com.github.gadini.gs.gs.dtos.SafraRequestUpdateDto;
import com.github.gadini.gs.gs.dtos.SafraResponseDto;
import com.github.gadini.gs.gs.mapper.SafraMapper;
import com.github.gadini.gs.gs.repository.SafraRepository;
import com.github.gadini.gs.gs.service.SafraService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/safras")
@RequiredArgsConstructor
public class SafraController {
	
	private final SafraService safraService;
	private final SafraMapper safraMapper;
	private final SafraRepository safraRepository;
	
	@GetMapping
	public ResponseEntity<List<SafraResponseDto>> list(){
		List<SafraResponseDto> dtos = safraService.list()
				.stream().map(e -> safraMapper.toDto(e)).toList();
		return ResponseEntity.ok().body(dtos);
	}
	
	@PostMapping
    public ResponseEntity<SafraResponseDto> create(@RequestBody SafraRequestCreateDto dto) {        

        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
        			safraMapper.toDto(
                        safraService.save(safraMapper.toModel(dto)))
        			);
    }
	
	@PutMapping("{id}")
    public ResponseEntity<SafraResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody SafraRequestUpdateDto dto) {
        if (! safraService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(
        			safraMapper.toDto(
        				safraService.save(safraMapper.toModel(id, dto)))
        		);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! safraService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        safraService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<SafraResponseDto> findById(@PathVariable Long id) {    	
    	return ResponseEntity.ok()
    			.body(
    				safraService
    					.findById(id)
    					.map(e -> safraMapper.toDto(e))
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);    	  		     
    }
    
    @GetMapping("/find")
    public  ResponseEntity<?> findByNome(
                @RequestParam String nome) { 

                    return ResponseEntity.ok().body(safraRepository.findByNome(nome));
    }

}
