package com.summon23.fluxcassandra.handler;

import com.summon23.fluxcassandra.entity.Student;
import com.summon23.fluxcassandra.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
public class StudentHandler {
    private final StudentRepository studentRepository;

    public StudentHandler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Mono<ServerResponse> getAllStudent(ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(studentRepository.findAll(), Student.class);
    }
}
