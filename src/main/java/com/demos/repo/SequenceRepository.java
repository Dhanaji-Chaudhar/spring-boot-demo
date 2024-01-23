package com.demos.repo;

import com.demos.pojo.Sequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceRepository extends MongoRepository<Sequence,String> {
}
