package com.dec.schooldiary.service;


import com.dec.schooldiary.model.DayOfWeek;
import com.dec.schooldiary.model.Diary;
import com.dec.schooldiary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    public Iterable<Diary> getNoteOfDay(DayOfWeek dayOfWeek) {
        return diaryRepository.getAllByDayOfWeek(dayOfWeek);
    }

    public void deleteNote(String id) {
        diaryRepository.deleteById(Long.parseLong(id));
    }

    public Iterable<Diary> getAllNotes() {
        return diaryRepository.findAll();
    }

    public Diary saveOrUpdate(Diary diary) {
        Diary updatedDiaryExample = diaryRepository.findByDayOfWeekAndSubject(diary.getDayOfWeek(), diary.getSubject());
        if(updatedDiaryExample != null) {
            updatedDiaryExample.setSequenceNumber(diary.getSequenceNumber());
            return diaryRepository.save(updatedDiaryExample);
        }
        return diaryRepository.save(diary);
    }
}
