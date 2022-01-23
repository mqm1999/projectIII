package com.example.Project3.controller;

import com.example.Project3.dto.LedSauDTO;
import com.example.Project3.helper.ResponseBuilder.ResponseForm;
import com.example.Project3.service.LedSauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ledsau")
public class LedSauController {
    @Autowired
    LedSauService ledSauService;

    @GetMapping("/all")
    public ResponseEntity<ResponseForm<List<LedSauDTO>>> getAllLedSau(@RequestParam Integer sortType) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledSauService.getAllLedSau(sortType), 1, "okokok"));
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseForm<LedSauDTO>> getLedSauByID(@RequestParam Integer ID_ledSau) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledSauService.getLedSauByID(ID_ledSau), 1, "okokok"));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseForm<Boolean>> addLedSau(@RequestBody LedSauDTO ledSauDTO) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledSauService.addLedSau(ledSauDTO), 1, "okokok"));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseForm<Boolean>> updateLedSau(@RequestBody LedSauDTO ledSauDTO) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledSauService.updateLedSau(ledSauDTO), 1, "okokok"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseForm<Boolean>> deleteLedSau(@RequestParam Integer ID_ledSau) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledSauService.deleteLedSau(ID_ledSau), 1, "okokok"));
    }

}
