package com.ali.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ali.db.dto.DtoAdress;
import com.ali.db.services.IAdressService;

@SpringBootTest(classes = {Starter.class})
class DbApplicationTests {


	@Autowired
	private IAdressService adressService;

	@BeforeEach
	public void beforeEach(){

		System.out.println("Beforeeach");
	}

	@AfterEach
	private void afterEach(){
		System.out.println("Aftereach");
	}

	@Test
	public void testFindEmployeById(){
		DtoAdress adress =  adressService.findAdressById(44L);
		assertNotNull(adress);
		assertEquals("amsterdam", adress.getDescription());
	}

}
 