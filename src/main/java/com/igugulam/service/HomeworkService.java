package com.igugulam.service;

import com.igugulam.model.Homework;
import com.igugulam.repository.HomeworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class HomeworkService {

    private final HomeworkRepository homeworkRepository;

    public HomeworkService(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    public List<Homework> getAllHomework() {
        return homeworkRepository.findAll();
    }

    public Optional<Homework> getHomeworkById(Long id) {
        return homeworkRepository.findById(id);
    }

    public Homework createHomework(Homework homework) {
        return homeworkRepository.save(homework);
    }

    public Homework updateHomework(Long id, Homework updatedHomework) {

        return homeworkRepository.findById(id)
                .map(existing -> {

                    existing.setTitle(updatedHomework.getTitle());
                    existing.setDescription(updatedHomework.getDescription());
                    existing.setSubject(updatedHomework.getSubject());
                    existing.setDueDate(updatedHomework.getDueDate());
                    existing.setStatus(updatedHomework.getStatus());

                    return homeworkRepository.save(existing);
                })
                .orElseThrow(() ->
                        new RuntimeException("Homework not found with ID: " + id));
    }

    public void deleteHomework(Long id) {
        homeworkRepository.deleteById(id);
    }
}
