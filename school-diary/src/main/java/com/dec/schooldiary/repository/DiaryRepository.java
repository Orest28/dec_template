package com.dec.schooldiary.repository;

import com.dec.schooldiary.model.DayOfWeek;
import com.dec.schooldiary.model.Diary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiaryRepository extends CrudRepository<Diary, Long> {


    Iterable<Diary> getAllByDayOfWeek(DayOfWeek dayOfWeek);

    Diary findByDayOfWeekAndSubject(DayOfWeek dayOfWeek, String subject);
}
