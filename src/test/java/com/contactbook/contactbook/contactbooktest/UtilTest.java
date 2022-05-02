package com.contactbook.contactbook.contactbooktest;

import com.contactbook.contactbook.data.ContactBookData;
import com.contactbook.contactbook.entity.ContactDetailEntity;
import org.springframework.stereotype.Component;

@Component
public class UtilTest {

    public ContactBookData contactBookDataMock = new ContactBookData(1, "nazia", "nazia@gmail.com",
            99999999, 91);

    public ContactDetailEntity contactDetailEntityMock =
            new ContactDetailEntity(contactBookDataMock);


}
	
