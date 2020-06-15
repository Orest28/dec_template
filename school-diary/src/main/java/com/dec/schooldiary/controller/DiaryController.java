package com.dec.schooldiary.controller;


import com.dec.schooldiary.model.DayOfWeek;
import com.dec.schooldiary.model.Diary;
import com.dec.schooldiary.repository.DiaryRepository;
import com.dec.schooldiary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @GetMapping("diary")
    public Iterable<Diary> getDiary() {
        return diaryService.getAllNotes();
    }

    @GetMapping("diary/{dayOfWeek}")
    public Iterable<Diary> getSubjectsFromDay(@PathVariable String dayOfWeek) {
        return diaryService.getNoteOfDay(DayOfWeek.valueOf(dayOfWeek));
    }

    @PostMapping("create")
    public Diary createNote(@RequestBody Diary diary) {
        return diaryService.saveOrUpdate(diary);
    }

    @DeleteMapping("delete/{id}")
    public void deleteNote(@PathVariable String id) {
        diaryService.deleteNote(id);
    }
}
