package com.github.gadini.gs.gs.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.github.gadini.gs.gs.dtos.SafraRequestCreateDto;
import com.github.gadini.gs.gs.dtos.SafraRequestUpdateDto;
import com.github.gadini.gs.gs.dtos.SafraResponseDto;
import com.github.gadini.gs.gs.model.Safra;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SafraMapper {

	private final ModelMapper modelMapper;
	
	public SafraResponseDto toDto(Safra safras) {
		return modelMapper.map(safras, SafraResponseDto.class);
	}
	
	public Safra toModel(SafraRequestCreateDto dto) {
		return modelMapper.map(dto, Safra.class);
	}
	
	public Safra toModel(Long id, SafraRequestUpdateDto dto) {
		Safra result =  modelMapper.map(dto, Safra.class);
		result.setId(id);
		return result;
	}
	
}
