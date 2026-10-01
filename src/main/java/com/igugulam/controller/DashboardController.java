package com.igugulam.controller;


import com.igugulam.repository.AnnouncementRepository;
import com.igugulam.repository.HomeworkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")

public class DashboardController {

    private final HomeworkRepository homeworkRepository;
    private final AnnouncementRepository announcementRepository;

    public DashboardController(
            HomeworkRepository homeworkRepository,
            AnnouncementRepository announcementRepository) {

        this.homeworkRepository = homeworkRepository;
        this.announcementRepository = announcementRepository;
    }

    @GetMapping("/summary")
    public Map<String, Object> getDashboardSummary() {

        Map<String, Object> summary = new HashMap<>();

        summary.put("totalHomework", homeworkRepository.count());
        summary.put("totalAnnouncements", announcementRepository.count());

        return summary;
    }
}
