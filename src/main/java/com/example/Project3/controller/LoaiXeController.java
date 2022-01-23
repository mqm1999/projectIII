package com.example.Project3.controller;

import com.example.Project3.dto.LoaiXeDTO;
import com.example.Project3.helper.ResponseBuilder.ResponseForm;
import com.example.Project3.service.LoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loaixe")
public class LoaiXeController {
    @Autowired
    LoaiXeService loaiXeService;

    @GetMapping("/all")
    public ResponseEntity<ResponseForm<List<LoaiXeDTO>>> getAllLoaiXe(@RequestParam Integer sortType) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(loaiXeService.getAllLoaiXe(sortType), 1, "okokok"));
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseForm<LoaiXeDTO>> getLoaiXeByChungLoai(@RequestParam String Chung_loai) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(loaiXeService.getLoaiXeByChungLoai(Chung_loai), 1, "okokok"));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseForm<Boolean>> addLoaiXe(@RequestBody LoaiXeDTO loaiXeDTO) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(loaiXeService.addLoaiXe(loaiXeDTO), 1, "okokok"));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseForm<Boolean>> updateLoaiXe(@RequestBody LoaiXeDTO loaiXeDTO) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(loaiXeService.updateLoaiXe(loaiXeDTO), 1, "okokok"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseForm<Boolean>> deleteLoaiXe(@RequestParam String Chung_loai) throws Exception {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(loaiXeService.deleteLoaiXe(Chung_loai), 1, "okokok"));
    }
}
