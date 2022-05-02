package com.contactbook.contactbook.data;

import lombok.Data;


import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class ContactBookData {
    private int id;

    @Size(min = 3, max = 50, message = "Name should be 3 to 50 characters")
    private String name;

    @Email
    private String emailId;

    private int countryCode;

    private long mobileNo;

    public ContactBookData(int id, String name, String emailId, long mobileNo, int countryCode) {
        super();
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.countryCode = countryCode;
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

}
