package com.contactbook.contactbook.contactbooktest;

import com.contactbook.contactbook.data.ContactBookData;
import com.contactbook.contactbook.data.ResponseData;
import com.contactbook.contactbook.repository.ContactBookRepository;
import com.contactbook.contactbook.service.ContactBookServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private ContactBookServiceImpl contactBookServiceImpl;

    @Autowired
    private UtilTest utilTest;

    @Mock
    private ContactBookRepository contactDetailRepositoryMock;

    @Test
    public void when_getContactBook_then_return_success_response() {
        when(contactDetailRepositoryMock.findAll())
                .thenReturn(List.of(utilTest.contactDetailEntityMock));
        ResponseData<ContactBookData> contactBookDataResponseData = contactBookServiceImpl.getAllContacts();
        assertEquals(200, contactBookDataResponseData.status);
    }

    @Test
    public void when_getContactByNameAndEmailId_then_return_success_response() {
        when(contactDetailRepositoryMock.findByNameEqualsIgnoreCaseAndEmailIdEqualsIgnoreCase(anyString(), "nazia@gmail.com"))
                .thenReturn(Optional.of(utilTest.contactDetailEntityMock));
        ResponseData<ContactBookData> contactBookDataResponseData = contactBookServiceImpl.getContactByNameAndEmailId("nazia", "nazia@gmail.com");
    }


    @Test
    public void when_getContactByName_then_return_success_response() {
        Pageable pageable = PageRequest.of(0, 10);
        when(contactDetailRepositoryMock.findByNameContains(anyString(), any()))
                .thenReturn(Page.empty());
        ResponseData<ContactBookData> contactBookDataResponseData = contactBookServiceImpl.getAllContacts();
        assertEquals(200, contactBookDataResponseData.status);
    }


    @Test
    public void when_getContactByEmailId_then_return_success_response() {
        when(contactDetailRepositoryMock.findByEmailIdEqualsIgnoreCase(anyString()))
                .thenReturn(Optional.of(utilTest.contactDetailEntityMock));
        ResponseData<ContactBookData> contactBookDataResponseData = contactBookServiceImpl
                .getContactByEmailId("nazia@gmail.com");
        assertEquals(200, contactBookDataResponseData.status);
    }

    @Test
    public void when_addContactBook_then_return_success_response() {
        when(contactDetailRepositoryMock.save(any()))
                .thenReturn(utilTest.contactDetailEntityMock);
        ResponseData<ContactBookData> contactBookDataResponseData = contactBookServiceImpl.addContact(utilTest.contactBookDataMock);
       // assertEquals(200, contactBookDataResponseData.status);
    }

    @Test
    public void when_editContactBook_then_return_success_response() {
        when(contactDetailRepositoryMock.save(any()))
                .thenReturn(utilTest.contactDetailEntityMock);
        ResponseData<ContactBookData> contactBookDataResponseData = contactBookServiceImpl.editContact(utilTest.contactBookDataMock);
        assertEquals(200, contactBookDataResponseData.status);
    }


//    @Test
//    public void when_deleteContactBook_then_return_success() {
//        Mockito.when(contactDetailRepositoryMock.findByMobileNo(Mockito.anyLong()))
//                .thenReturn(Optional.of(utilTest.contactDetailEntityMock));
//        Mockito.when(contactBookServiceImpl.deleteContact(7744L));
//        contactBookServiceImpl.deleteContact(9898547888L);
//        verifyNoMoreInteractions(contactDetailRepositoryMock);
//
//    }

    @Test
    public void findAllContacts() {
        when(contactDetailRepositoryMock.findAll())
                .thenReturn(new ArrayList<>());
        ResponseData<ContactBookData> getAllContacts = contactBookServiceImpl.getAllContacts();
        assertEquals(0, getAllContacts.data.size());
    }
}
