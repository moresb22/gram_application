package com.veda.grampanchayat.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veda.grampanchayat.entities.Resident;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long>{
	

}
