package com.contactbook.contactbook.contactbooktest;

import com.contactbook.contactbook.data.ContactBookData;
import com.contactbook.contactbook.data.ResponseData;
import com.contactbook.contactbook.entity.ContactDetailEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UtilTest {
	
	
	public static final String GET_ALL_CONTACT_DETAILS_API = "/getcontactbynameandemail/nazia/nazia@gmail.com";
	public static final String GET_ALL_CONTACT_BYNAME_AND_EMAILID_API = "/getcontactbynameandemail/nazia/nazia@gmail.com";
	public static final String GET_CONTACT_DETAILS_BY_NAME_API = "/getcontactbyname/nazia/0";
	public static final String GET_CONTACT_DETAILS_BY_EMAIL_ID_API = "/getContactByEmailId/nazia@gmail.com";
	public static final String ADD_CONTACT_API = "/addcontact";
	public static final String EDIT_CONTACT_API = "/editcontact";
	public static final String DELETE_CONTACT_API ="/deletecontact/9458788888";
	
	
    public ContactBookData contactBookDataMock = new ContactBookData(1, "nazia", "nazia@gmail.com",
            99999999, 91);

    public ContactDetailEntity contactDetailEntityMock =
            new ContactDetailEntity(contactBookDataMock);
    
    public ResponseData<ContactBookData> successResponse() {
        List<ContactBookData> listOfContact = new ArrayList<>();
        listOfContact.add(contactDetailEntityMock.convertEntityToData());
        return new ResponseData<>(200, listOfContact);
    }

    }
	
