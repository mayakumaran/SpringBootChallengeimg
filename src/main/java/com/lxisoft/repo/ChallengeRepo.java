package com.lxisoft.repo;

import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxisoft.applicants.Applicants;
@Repository
public interface ChallengeRepo extends JpaRepository<Applicants,String>{
/*	public Page<Applicants> findAll(int pageNumber) ;*/
	

}
