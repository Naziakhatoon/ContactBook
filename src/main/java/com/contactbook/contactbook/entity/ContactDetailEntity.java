package com.contactbook.contactbook.entity;

import com.contactbook.contactbook.data.ContactBookData;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Contact_Book")
public class ContactDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(name = "email_id")

    private String emailId;
    @Column(name = "mobile_no")
    private long mobileNo;
    @Column(name = "country_code")
    private int countryCode;


    public ContactDetailEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ContactDetailEntity(ContactBookData contactBookData) {
        super();
        this.id = contactBookData.getId();
        this.name = contactBookData.getName();
        this.emailId = contactBookData.getEmailId();
        this.mobileNo = contactBookData.getMobileNo();
        this.countryCode = contactBookData.getCountryCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public ContactBookData convertEntityToData() {
        return new ContactBookData(id, name, emailId, mobileNo, countryCode);
    }

}
