package com.contactbook.contactbook.data;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

public class ResponseData<T> {
    public int status;
    public List<T> data;

    public ResponseData(int status, List<T> data) {
        super();
        this.status = status;
        this.data = data;
    }

}
