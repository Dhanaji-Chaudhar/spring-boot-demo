package com.demos.service;

import com.demos.pojo.Sequence;
import com.demos.repo.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {
    @Autowired
    private SequenceRepository sequenceRepository;

    public long generateSequence(String seqName){
        Sequence counter= sequenceRepository.findById(seqName).orElse(new Sequence(seqName,0));
        counter.setValue(counter.getValue()+1);
        sequenceRepository.save(counter);
        return counter.getValue();
    }
}
