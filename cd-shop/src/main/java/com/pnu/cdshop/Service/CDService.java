package com.pnu.cdshop.Service;

import com.pnu.cdshop.Model.CD;
import com.pnu.cdshop.Repository.CDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDService {

    @Autowired
    private CDRepository cdRepository;

    public CD getCD(String id) {
        return cdRepository.findById(Long.parseLong(id)).get();
    }

    public void deleteCD(String id) {
        cdRepository.deleteById(Long.parseLong(id));
    }

    public Iterable<CD> findAllCD() {
        return cdRepository.findAll();
    }

    public Iterable<CD> findByReleaseDateAndTopic(String releaseDate, String topic) {
        return cdRepository.findAllByTopicCD(releaseDate, topic);
    }

    public CD saveOrUpdateCD(CD disk) {
        CD updatedCDExample = cdRepository.findByName(disk.getName());
        if(updatedCDExample != null) {
            updatedCDExample.setReleaseDate(disk.getReleaseDate());
            updatedCDExample.setTopicCD(disk.getTopicCD());
            return cdRepository.save(updatedCDExample);
        }
        return cdRepository.save(disk);
    }
}
