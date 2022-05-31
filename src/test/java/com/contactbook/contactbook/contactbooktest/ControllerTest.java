package com.contactbook.contactbook.contactbooktest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.contactbook.contactbook.service.ContactBookServiceImpl;

/*@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
class ControllerTest {

	@MockBean
	private ContactBookServiceImpl contactBookServiceImpl;

	@MockBean
	private UtilTest utilTest;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc = null;

	@BeforeAll
	void getRun() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		Mockito.when(contactBookServiceImpl.getAllContacts()).thenReturn(utilTest.successResponse());
		Mockito.when(contactBookServiceImpl.getContactByEmailId(Mockito.anyString()))
				.thenReturn(utilTest.successResponse());
		Mockito.when(contactBookServiceImpl.getContactByName(Mockito.anyString(), Mockito.anyInt()))
				.thenReturn(utilTest.successResponse());
		Mockito.when(contactBookServiceImpl.getContactByNameAndEmailId(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(utilTest.successResponse());
		Mockito.when(contactBookServiceImpl.addContact(Mockito.any())).thenReturn(utilTest.successResponse());
		Mockito.when(contactBookServiceImpl.editContact(Mockito.any())).thenReturn(utilTest.successResponse());
		Mockito.when(contactBookServiceImpl.deleteContact(Mockito.anyInt())).thenReturn(utilTest.successResponse());
	}

	@Test
	void when_getAllContacts_then_return_success() throws Exception {
       MvcResult mvcResult = mockMvc
				.perform(get(UtilTest.GET_ALL_CONTACT_DETAILS_API).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		
	}

//	@Test
//	void when_getAllContacts

}
*/
