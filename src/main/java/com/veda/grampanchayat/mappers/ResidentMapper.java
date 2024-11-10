package com.veda.grampanchayat.mappers;

import org.springframework.stereotype.Component;

import com.veda.grampanchayat.dtos.ResidentDTO;
import com.veda.grampanchayat.entities.Resident;

@Component
public class ResidentMapper{

	public Resident toEntity(ResidentDTO dto) {
		Resident resident = new Resident();
		resident.setName(dto.getName());
		resident.setMobileNumber(dto.getMobileNumber());
		resident.setDob(dto.getDob());
		resident.setAadhaarNo(dto.getAadhaarNo());
		resident.setGender(dto.getGender());
		resident.setAddress(dto.getAddress());
		resident.setRationCardNumber(dto.getRationCardNumber());
		resident.setType(dto.getType());
		return resident;
	}

	public ResidentDTO toDTO(Resident resident) {
		ResidentDTO dto = new ResidentDTO();
		dto.setName(resident.getName());
		dto.setMobileNumber(resident.getMobileNumber());
		dto.setDob(resident.getDob());
		dto.setAadhaarNo(resident.getAadhaarNo());
		dto.setGender(resident.getGender());
		dto.setAddress(resident.getAddress());
		dto.setRationCardNumber(resident.getRationCardNumber());
		dto.setType(resident.getType());
		return dto;
	}

}
