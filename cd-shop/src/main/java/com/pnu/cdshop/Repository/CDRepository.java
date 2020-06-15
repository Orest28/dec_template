package com.pnu.cdshop.Repository;

import com.pnu.cdshop.Model.CD;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CDRepository extends CrudRepository<CD, Long> {

    void deleteById(Long id);

    CD findByName(String name);

    @Query("select c from CD c where c.topicCD = ?2 and c.releaseDate = ?1")
    Iterable<CD> findAllByTopicCD(String releaseDate, String topic);
}
