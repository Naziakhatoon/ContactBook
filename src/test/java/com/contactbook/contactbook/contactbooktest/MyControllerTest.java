package com.contactbook.contactbook.contactbooktest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.contactbook.contactbook.entity.ContactDetailEntity;
import com.contactbook.contactbook.service.ContactBookServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;

@WebMvcTest
public class MyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UtilTest utilTest;

	@MockBean
	private ContactBookServiceImpl contactBookServiceImpl;

	@Autowired
	WebApplicationContext webApplicationContext;

	private static ObjectMapper mapper = new ObjectMapper();

	@Before
	  public void setup() {
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	  }

	public static String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	

	
	
//	    @Test
//	    public void testGetExample() throws Exception {
//	        List<ContactDetailEntity> students = new ArrayList<>();
//	        ContactDetailEntity contactBook = new ContactDetailEntity();
//	        contactBook.setName("test");
//	        contactBook.setMobileNo(9875444);
//	        contactBook.setEmailId("test@gmail.com");
//	        contactBook.setCountryCode(91);
//	        students.add(contactBook);
//	          Mockito
//	        		.when(contactBookServiceImpl.getAllContacts())
//	        		.thenReturn((ResponseData<ContactBookData>) students);
//	       // System.out.println(mvcResult.toString());
//	        mockMvc.perform(get(UtilTest.GET_ALL_CONTACT_DETAILS_API))
//	        .andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
//	                .andExpect(jsonPath("$[0].name", Matchers.equalTo("Arun")));
//	    }

	@Test
	void when_addContact_then_return_success() throws Exception {
		//mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		ContactDetailEntity contactBook = new ContactDetailEntity();
		contactBook.setId(11);
		contactBook.setName("test");
		contactBook.setMobileNo(9179784874L);
		contactBook.setEmailId("test@gmail.com");
		contactBook.setCountryCode(91);

		//String inputJson = mapToJson(utilTest.contactDetailEntityMock);
		String inputJson = mapToJson(contactBook);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(UtilTest.ADD_CONTACT_API)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		System.out.println(mvcResult);

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Record added successfully");
	}
	
	

	 @Test
	 void when_deleteContact_then_return_success() throws Exception {
			
	      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
	    		  .delete(UtilTest.DELETE_CONTACT_API)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Record deleted successsfully");
	      
	   }
}
