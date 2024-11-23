package com.github.gadini.gs.gs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.gadini.gs.gs.model.Safra;
import com.github.gadini.gs.gs.repository.SafraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SafraService {
	
	private final SafraRepository safraRepository;
	
	public List<Safra> list()
	{
		return safraRepository.findAll();
	}
	
	public Safra save(Safra safras) {
		return safraRepository.save(safras);
	}
	
	public boolean existsById(Long id) {
		return safraRepository.existsById(id);
	}
	
	public void delete(Long id) {
		safraRepository.deleteById(id);
	}
	
	public Optional<Safra> findById(Long id) {
        return safraRepository.findById(id);
    }

}
