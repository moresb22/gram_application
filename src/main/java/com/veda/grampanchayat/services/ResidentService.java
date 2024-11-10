package com.veda.grampanchayat.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veda.grampanchayat.dtos.ResidentDTO;
import com.veda.grampanchayat.entities.Resident;
import com.veda.grampanchayat.exceptions.ResidentNotFoundException;
import com.veda.grampanchayat.mappers.ResidentMapper;
import com.veda.grampanchayat.repos.ResidentRepository;

@Service
public class ResidentService {

	@Autowired
	private ResidentRepository residentRepository;

	@Autowired
	private ResidentMapper residentMapper;

	public List<ResidentDTO> getAllResidents() {
		return residentRepository.findAll().stream().map(residentMapper::toDTO).collect(Collectors.toList());
	}

	public Optional<ResidentDTO> getResidentById(Long id) {
		return residentRepository.findById(id).map(residentMapper::toDTO);
	}

	public ResidentDTO createResident(ResidentDTO residentDTO) {
		Resident resident = residentMapper.toEntity(residentDTO);
		return residentMapper.toDTO(residentRepository.save(resident));
	}

	public ResidentDTO updateResident(Long id, ResidentDTO residentDetails) {
		Resident resident = residentRepository.findById(id)
				.orElseThrow(() -> new ResidentNotFoundException("Resident not found with id :"+ id));

		resident.setName(residentDetails.getName());
		resident.setMobileNumber(residentDetails.getMobileNumber());
		resident.setDob(residentDetails.getDob());
		resident.setAadhaarNo(residentDetails.getAadhaarNo());
		resident.setGender(residentDetails.getGender());
		resident.setAddress(residentDetails.getAddress());
		resident.setRationCardNumber(residentDetails.getRationCardNumber());
		resident.setType(residentDetails.getType());

		return residentMapper.toDTO(residentRepository.save(resident));
	}

	public void deleteResident(Long id) {
		residentRepository.deleteById(id);
	}

}
