package com.example.Project3.controller;

import com.example.Project3.dto.LedTruocDTO;
import com.example.Project3.helper.ResponseBuilder.ResponseForm;
import com.example.Project3.service.LedTruocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ledtruoc")
public class LedTruocController {
    @Autowired
    LedTruocService ledTruocService;

    @GetMapping("/all")
    public ResponseEntity<ResponseForm<List<LedTruocDTO>>> getAllLedTruoc(@RequestParam Integer sortType) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledTruocService.getAllLedTruoc(sortType), 1, "okokok"));
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseForm<LedTruocDTO>> getLedTruocByID(@RequestParam Integer ID_ledTruoc) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledTruocService.getLedTruocByID(ID_ledTruoc), 1, "okokok"));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseForm<Boolean>> addLedTruoc(@RequestBody LedTruocDTO ledTruocDTO) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledTruocService.addLedTruoc(ledTruocDTO), 1, "okokok"));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseForm<Boolean>> updateLedTruoc(@RequestBody LedTruocDTO ledTruocDTO) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledTruocService.updateLedTruoc(ledTruocDTO), 1, "okokok"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseForm<Boolean>> deleteLedTruoc(@RequestParam Integer ID_ledTruoc) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledTruocService.deleteLedTruoc(ID_ledTruoc), 1, "okokok"));
    }
}
