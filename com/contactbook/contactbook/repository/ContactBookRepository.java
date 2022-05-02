package com.contactbook.contactbook.repository;

import com.contactbook.contactbook.entity.ContactDetailEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactBookRepository extends JpaRepository<ContactDetailEntity, Integer> {

    public Boolean existsByNameEqualsIgnoreCase(String name);

    public Boolean existsByEmailIdEqualsIgnoreCase(String emailId);

    public Optional<ContactDetailEntity> findByMobileNo(long mobileNo);

    public Page<ContactDetailEntity> findByNameContains(String name, Pageable pageable);

    public Optional<ContactDetailEntity> findByEmailIdEqualsIgnoreCase(String emailId);

    public Optional<ContactDetailEntity>
    findByNameEqualsIgnoreCaseAndEmailIdEqualsIgnoreCase(String name, String emailId);

}
