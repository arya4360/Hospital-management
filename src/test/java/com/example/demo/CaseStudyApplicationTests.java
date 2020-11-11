package com.example.demo;


import com.example.demo.Repository.patientRepository;
import com.example.demo.modal.patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(locations = {"classpath:test.properties"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CaseStudyApplicationTests {

	@Autowired
	private TestEntityManager entityManager ;
	@Autowired
	private patientRepository patientRepository;

	@Test
	@Rollback(value = false)
	void saveMethodTest(){
		patient patient = getPatient();
		patient saveInDb = entityManager.persist(patient);
		patient getFromDb = patientRepository.getOne(saveInDb.getId());
		Assertions.assertEquals(patient, getFromDb);
		entityManager.remove(patient);
	}
	@Test
	@Rollback(value = false)
	void TestUpdatePatient(){
		patient patient = getPatient();
		patient saveInDb = entityManager.persist(patient);
		patient getFromDb = patientRepository.getOne(saveInDb.getId());
		getFromDb.setFirstName("test2");
		getFromDb.setLastName("test2");
		getFromDb.setCountry("xyz");
		patient updatedPatient = entityManager.persist(getFromDb);
		Assertions.assertEquals(updatedPatient , patientRepository.getOne(patient.getId()));
		entityManager.remove(patient);
		entityManager.remove(updatedPatient);
	}
	@Test
	@Rollback(value = false)
	void getPatientByEmailTest(){
		patient patient = getPatient();
		patient saveInDb = entityManager.persist(patient) ;
		Assertions.assertEquals(patient , patientRepository.findByemail("test1@gmail.com"));
		entityManager.remove(patient);
	}

	@Test
	@Rollback(value = false)
	void TestFindAllByVerify(){
		patient patient = getPatient();
		List<patient> list = new ArrayList() ;
		list.add(patient) ;
		patient saveInDb = entityManager.persistAndFlush(patient) ;
		Assertions.assertEquals(list , patientRepository.findAllByVerify(false));
		entityManager.remove(patient);
	}
	private patient getPatient(){
		patient patient = new patient() ;
		patient.setFirstName("test1_abhishek");
		patient.setLastName("test1_ arya");
		patient.setUsername("test1");
		patient.setContactNumber("1234567412");
		patient.setEmail("test1@gmail.com");
		patient.setPassword("test1");
		patient.setCity("mau_test1");
		patient.setCountry("test1");
		patient.setVerify(false);
		return patient;
	}


}
