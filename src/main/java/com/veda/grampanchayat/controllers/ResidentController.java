package com.veda.grampanchayat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veda.grampanchayat.dtos.ResidentDTO;
import com.veda.grampanchayat.services.ResidentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {

	@Autowired
	private ResidentService residentService;

	@GetMapping
	public List<ResidentDTO> getAllResidents() {
		return residentService.getAllResidents();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResidentDTO> getResidentById(@PathVariable Long id) {
		return residentService.getResidentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<ResidentDTO> createResident(@Valid @RequestBody ResidentDTO residentDTO) {
		return new ResponseEntity<>(residentService.createResident(residentDTO),HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResidentDTO> updateResident(@PathVariable Long id,
			@Valid @RequestBody ResidentDTO residentDetails) {
		return  ResponseEntity.ok(residentService.updateResident(id, residentDetails));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteResident(@PathVariable Long id) {
		residentService.deleteResident(id);
		return ResponseEntity.noContent().build();
	}

}
