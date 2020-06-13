package com.pnu.phonebook.Repositories;

import com.pnu.phonebook.Model.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<Record, Long> {

    void deleteById(Long id);

    Record findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select r from Record r where r.firstName = ?1")
    Iterable<Record> findAllByFirstName(String firstName);
}
