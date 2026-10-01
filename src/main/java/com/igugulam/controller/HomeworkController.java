package com.igugulam.controller;


import com.igugulam.model.Homework;
import com.igugulam.service.HomeworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homework")
@CrossOrigin(origins = "*")

public class HomeworkController {

    private final HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping
    public List<Homework> getAllHomework() {
        return homeworkService.getAllHomework();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Homework> getHomeworkById(
            @PathVariable Long id) {

        return homeworkService.getHomeworkById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Homework createHomework(
            @RequestBody Homework homework) {

        return homeworkService.createHomework(homework);
    }

    @PutMapping("/{id}")
    public Homework updateHomework(
            @PathVariable Long id,
            @RequestBody Homework homework) {

        return homeworkService.updateHomework(id, homework);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHomework(
            @PathVariable Long id) {

        homeworkService.deleteHomework(id);

        return ResponseEntity.noContent().build();
    }
}
