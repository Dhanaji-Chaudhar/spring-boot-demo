package com.demos.service;

import com.demos.pojo.Sequence;
import com.demos.repo.SequenceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SequenceServiceTest {

    @Mock
    private SequenceRepository sequenceRepository;

    @InjectMocks
    private SequenceService sequenceService;

    @BeforeEach
    void setUp() {
        System.out.println("Before Generating setUp..!");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Generating setUp");
    }

    @Test
    void testGenerateSequence() {
        String SEQ_NAME="ACC_SEQ";
        Sequence sequence=new Sequence(SEQ_NAME,1L);
        when(sequenceRepository.findById(anyString())).thenReturn(Optional.of(sequence));
        when(sequenceRepository.save(any(Sequence.class))).thenReturn(sequence);
        long sequenceID=sequenceService.generateSequence(SEQ_NAME);
        verify(sequenceRepository, times(1)).save(Mockito.any(Sequence.class));
        Assertions.assertEquals(2L,sequenceID);//2 increased auto_increment
    }
}