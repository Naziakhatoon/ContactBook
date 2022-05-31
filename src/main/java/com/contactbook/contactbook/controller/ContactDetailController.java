package com.contactbook.contactbook.controller;

import com.contactbook.contactbook.data.ContactBookData;
import com.contactbook.contactbook.service.ContactBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contactbook")

//http://localhost:8081/v3/api-docs/
//http://localhost:8081/swagger-ui.html
//http://localhost:8081/v3/api-docs.yaml

public class ContactDetailController {

    @Autowired
    private ContactBookServiceImpl contactBookServiceImpl;

    @GetMapping("/getallcontacts")
    public ResponseEntity<Object> getAllContacts() {
        return ResponseEntity.ok(contactBookServiceImpl.getAllContacts());
    }

    @GetMapping("/getcontactbynameandemail/{name}/{emailId}")
    public ResponseEntity<Object> getContactByNameAndEmail(@PathVariable String name,
                                                           @PathVariable String emailId) {
        return ResponseEntity.ok(contactBookServiceImpl.getContactByNameAndEmailId(name, emailId));
    }

    @GetMapping("/getcontactbyname/{name}/{pageNo}")
    public ResponseEntity<Object> getContactByName(@PathVariable String name, @PathVariable int pageNo) {
        return ResponseEntity.ok(contactBookServiceImpl.getContactByName(name, pageNo));
    }

    @GetMapping("/getcontactbyemail/{emailId}")
    public ResponseEntity<Object> getContactByEmailId(@PathVariable String emailId) {
        return ResponseEntity.ok(contactBookServiceImpl.getContactByEmailId(emailId));
    }

    @PostMapping("/addcontact")
    public ResponseEntity<Object> addContact(@Validated @RequestBody ContactBookData contactBookData) {
        return ResponseEntity.ok(contactBookServiceImpl.addContact(contactBookData));
    }

    @PutMapping("/editcontact")
    public ResponseEntity<Object> editContact(@Validated @RequestBody ContactBookData contactBookData) {
        return ResponseEntity.ok(contactBookServiceImpl.editContact(contactBookData));
    }
    
    /*
     * 
    @PutMapping("/editcontact/{name}")
    public ResponseEntity<Object> editContact(@PathVariable String name, 
    		@Validated @RequestBody ContactBookData contactBookData) {
        return ResponseEntity.ok(contactBookServiceImpl.editContact(contactBookData));
    }
     */

    @DeleteMapping("/deletecontact/{mobileNumber}")
    public ResponseEntity<Object> deleteContact(@Validated @PathVariable long mobileNumber) {
        return ResponseEntity.ok(contactBookServiceImpl.deleteContact(mobileNumber));
    }
}
