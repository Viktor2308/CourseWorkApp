package me.coursework.examapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import me.coursework.examapp.model.Question;
import me.coursework.examapp.services.ExaminerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/exam/get")
@Tag(name = "Java exam questions", description = "exam for java")
@AllArgsConstructor
public class ExaminerController {

    private final ExaminerService examinerService;

    @GetMapping(value = "/{amount}")
    @Operation(
            summary = "get random java questions",
            description = "get amount java question"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "random questions found",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(
                                                    implementation = Question.class
                                            )
                                    )
                            )
                    }
            )
    }
    )
    public ResponseEntity<Set<Question>> read(@PathVariable int amount) {
        return new ResponseEntity<>(examinerService.getQuestion(amount), HttpStatus.OK);
    }
}
