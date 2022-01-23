package com.example.Project3.controller;

import com.example.Project3.dto.LedSuonDTO;
import com.example.Project3.helper.ResponseBuilder.ResponseForm;
import com.example.Project3.service.LedSuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ledsuon")
public class LedSuonController {
    @Autowired
    LedSuonService ledSuonService;

    @GetMapping("/all")
    public ResponseEntity<ResponseForm<List<LedSuonDTO>>> getAllLedSuon(@RequestParam Integer sortType) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledSuonService.getAllLedSuon(sortType), 1, "okokok"));
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseForm<LedSuonDTO>> getLedSuonByID(@RequestParam Integer ID_ledSuon) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledSuonService.getLedSuonByID(ID_ledSuon), 1, "okokok"));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseForm<Boolean>> addLedSuon(@RequestBody LedSuonDTO ledSuonDTO) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledSuonService.addLedSuon(ledSuonDTO), 1, "okokok"));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseForm<Boolean>> updateLedSuon(@RequestBody LedSuonDTO ledSuonDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledSuonService.updateLedSuon(ledSuonDTO), 1, "okokok"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseForm<Boolean>> deleteLedSuon(@RequestParam Integer ID_ledSuon) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledSuonService.deleteLedSuon(ID_ledSuon), 1, "okokok"));
    }
}
