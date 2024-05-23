package ru.npcric.asparagus.trainerslog.adapter.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.request.attendance.AttendanceDTO;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.request.attendance.GroupAndDateRequest;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.response.attendance.AttendanceForGroupResponse;
import ru.npcric.asparagus.trainerslog.adapter.web.dto.response.attendance.AttendanceResponse;
import ru.npcric.asparagus.trainerslog.service.AttendanceService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/trainerslog/api/v1/attendance")
@Tag(name = "Контроллер Посещаемости", description =
        "Контроллер для управления посещаемости учеников секции айкидо")
public class AttendanceController {
    AttendanceService attendanceService;

    @PostMapping("/markAttendance")
    public ResponseEntity<AttendanceResponse> markAttendance(@RequestBody @Valid AttendanceDTO attendanceDTO) {
        return ResponseEntity.ok().body(attendanceService.markAttendance(attendanceDTO));
    }

    @GetMapping("/attendance")
    public AttendanceForGroupResponse getAttendanceForGroup(@RequestBody GroupAndDateRequest groupAndDateRequest) {
        return attendanceService.findStudentsByGroupAndDate(groupAndDateRequest);
    }
}
