package com.contactbook.contactbook.service;

import com.contactbook.contactbook.data.ContactBookData;
import com.contactbook.contactbook.data.ResponseData;
import com.contactbook.contactbook.entity.ContactDetailEntity;
import com.contactbook.contactbook.entity.EmailIdAlreadyPresent;
import com.contactbook.contactbook.entity.UserNotFound;
import com.contactbook.contactbook.repository.ContactBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactBookServiceImpl {

    @Autowired
    private ContactBookRepository contactBookRepository;

    public ResponseData<ContactBookData> getAllContacts() {
        List<ContactBookData> getAllContailDetail = contactBookRepository.findAll().stream()
                .map(ContactDetailEntity::convertEntityToData).collect(Collectors.toList());
        return new ResponseData<>(200, getAllContailDetail);
    }

    public ResponseData<ContactBookData> getContactByNameAndEmailId(String name, String emailId) {
        Optional<ContactDetailEntity> contactDetailByName = contactBookRepository
                .findByNameEqualsIgnoreCaseAndEmailIdEqualsIgnoreCase(name, emailId);
        if (!contactDetailByName.isPresent()) {
            throw new UserNotFound();
        } else {
            return successResponse(contactDetailByName.get());
        }
    }

    public ResponseData<ContactBookData> getContactByName(String name, int pageNumber) {
        Pageable page = PageRequest.of(pageNumber, 10);
        Page<ContactDetailEntity> contactDetailByName = contactBookRepository.findByNameContains(name, page);
        return new ResponseData<>(200,
                contactDetailByName.stream().map(ContactDetailEntity::convertEntityToData).collect(Collectors.toList()));

    }

    public ResponseData<ContactBookData> getContactByEmailId(String emailId) {
        Optional<ContactDetailEntity> contactDetailByEmail = contactBookRepository
                .findByEmailIdEqualsIgnoreCase(emailId);
        if (contactDetailByEmail.isPresent()) {
            return successResponse(contactDetailByEmail.get());
        }
        throw new UserNotFound();
    }

    public ResponseData<ContactBookData> addContact(ContactBookData contactBookData) {
        boolean isEmailIdExist = contactBookRepository.existsByEmailIdEqualsIgnoreCase(contactBookData.getEmailId());
        if (isEmailIdExist) {
            throw new EmailIdAlreadyPresent();
        }
        ContactDetailEntity contactBookEntity = contactBookRepository.save(convertDataToEntity(contactBookData));
        return successResponse(contactBookEntity);
    }

    public ResponseData<ContactBookData> editContact(ContactBookData contactBookData) {
        ContactDetailEntity contactBookEntity = contactBookRepository.save(convertDataToEntity(contactBookData));
        return successResponse(contactBookEntity);
    }
    
    /*
     *  public ResponseData<ContactBookData> editContact(String name,ContactBookData contactBookData) {
    	Optional<ContactDetailEntity> getUserDetail = contactBookRepository
    	.findByNameEqualsIgnoreCaseAndEmailIdEqualsIgnoreCase(contactBookData.getName(),contactBookData.getEmailId());
        ContactDetailEntity contactBookEntity = contactBookRepository.save(convertDataToEntity(contactBookData));
        if(getUserDetail.isPresent()) {
        	getUserDetail.get().setMobileNo(contactBookData.getMobileNo());
        	getUserDetail.get().setCountryCode(contactBookEntity.getCountryCode());
        	}
        return successResponse(contactBookEntity);
    }*/

    public ResponseData<ContactBookData> deleteContact(long mobileNo) {
        Optional<ContactDetailEntity> contactBookEntity = contactBookRepository.findByMobileNo(mobileNo);
        if (contactBookEntity.isPresent()) {
            contactBookRepository.deleteById(contactBookEntity.get().getId());
        } else {
            throw new NoSuchElementException();
        }

        return new ResponseData<>(200, new ArrayList<>());
    }

    public ResponseData<ContactBookData> successResponse(ContactDetailEntity contactDetailEntity) {
        List<ContactBookData> listOfContact = new ArrayList<>();
        listOfContact.add(contactDetailEntity.convertEntityToData());
        return new ResponseData<>(200, listOfContact);
    }

    public ContactDetailEntity convertDataToEntity(ContactBookData contactBookData) {
        return new ContactDetailEntity(contactBookData);
    }

}
