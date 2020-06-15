package com.pnu.cdshop.Controller;


import com.pnu.cdshop.Model.CD;
import com.pnu.cdshop.Service.CDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
//@CrossOrigin("*") якщо б ми працювали з фронт ендом потрібно добавити для вирішення запитів між серверами.
public class CDController {

    @Autowired
    private CDService cdService;

    @GetMapping("disks")
    public Iterable<CD> getAllDisks() {
        return cdService.findAllCD();
    }

    @PostMapping("create")
    public CD saveCD(@RequestBody CD cd) {
        return cdService.saveOrUpdateCD(cd);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        cdService.deleteCD(id);
    }

    @GetMapping("read/{topic}&{date}")
    public Iterable<CD> customRead(@PathVariable String topic, @PathVariable String date) {
        return cdService.findByReleaseDateAndTopic(date, topic);
    }
}
