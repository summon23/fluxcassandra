package com.summon23.fluxcassandra.router;

import com.summon23.fluxcassandra.StudentController;
import com.summon23.fluxcassandra.entity.Student;
import com.summon23.fluxcassandra.handler.StudentHandler;
import com.summon23.fluxcassandra.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class StudentRouter {
    @Autowired
    private StudentRepository studentRepository;

    @Bean
    RouterFunction<?> routes(StudentHandler handler) {
        return RouterFunctions.route(GET("/routeall"),
                request -> {
            return ServerResponse.ok().body(studentRepository.findAll(), Student.class);
                })
                .andRoute(GET("/routehandler").and(accept(MediaType.APPLICATION_JSON)), handler::getAllStudent);
    }
}
