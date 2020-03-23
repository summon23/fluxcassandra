package com.summon23.fluxcassandra.repository;

import com.summon23.fluxcassandra.entity.Student;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCassandraRepository<Student, Integer> {
    Flux<Student> findByAgeGreaterThan(int age);
}
