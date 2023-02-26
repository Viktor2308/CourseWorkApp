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
import me.coursework.examapp.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/exam/java")
@Tag(name = "Java questions", description = "CRUD - operations for for working with java question")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService javaQuestionService;

    @PostMapping("/add/{question},{answer}")
    @Operation(
            summary = "create question",
            description = "create new question/answer"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "question is create"
            )
    }
    )
    public ResponseEntity<?> create(@PathVariable String question, @PathVariable String answer) {
        javaQuestionService.addQuestion(question, answer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{question},{answer}")
    @Operation(
            summary = "remove question",
            description = "search question and remove"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "question remove"),
            @ApiResponse(
                    responseCode = "404",
                    description = "question not found")
    }
    )
    public ResponseEntity<?> deleteRecipe(@PathVariable String question, @PathVariable String answer) {
        return javaQuestionService.removeQuestion(question, answer)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/")
    @Operation(
            summary = "get all questions",
            description = "get all question collections"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "questions found",
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
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "question not found"
            )
    }
    )
    public ResponseEntity<Set<Question>> read() {
        final Set<Question> question = javaQuestionService.getAllQuestion();
        return question != null
                ? new ResponseEntity<>(question, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
