package com.example.Project3.service;

import com.example.Project3.dto.LoaiXeDTO;
import com.example.Project3.exception.ResourceAlreadyExistException;
import com.example.Project3.exception.ResourceNotFoundException;
import com.example.Project3.repository.LoaiXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiXeService {
    @Autowired
    LoaiXeRepository loaiXeRepository;

    public List<LoaiXeDTO> getAllLoaiXe(Integer sortType) {
        if (sortType == null) {
            return loaiXeRepository.getAllLoaiXeASC();
        } else if (sortType == 1) {
            return loaiXeRepository.getAllLoaiXeDESC();
        } else {
            return loaiXeRepository.getAllLoaiXeASC();
        }
    }

    public LoaiXeDTO getLoaiXeByChungLoai(String Chung_loai) {
        if (loaiXeRepository.getLoaiXeByChungLoai(Chung_loai).size() != 0) {
            return loaiXeRepository.getLoaiXeByChungLoai(Chung_loai).get(0);
        } else {
            throw new ResourceNotFoundException("Not found!");
        }
    }

    public Boolean addLoaiXe(LoaiXeDTO loaiXeDTO) throws Exception {
        if (!loaiXeRepository.checkLoaiXeExistedByChungLoai(loaiXeDTO.getChung_loai())) {
            if (loaiXeRepository.addLoaiXe(loaiXeDTO) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceAlreadyExistException("Existed!");
        }
    }

    public Boolean updateLoaiXe(LoaiXeDTO loaiXeDTO) throws Exception {
        if (loaiXeRepository.checkLoaiXeExistedByChungLoai(loaiXeDTO.getChung_loai())) {
            LoaiXeDTO loaiXeDTOResponse = loaiXeRepository.getLoaiXeByChungLoai(loaiXeDTO.getChung_loai()).get(0);
            if (loaiXeDTO.getSuc_chua() != null) {
                loaiXeDTOResponse.setSuc_chua(loaiXeDTO.getSuc_chua());
            }
            if (loaiXeRepository.updateLoaiXe(loaiXeDTOResponse) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceNotFoundException("Not found");
        }
    }

    public Boolean deleteLoaiXe(String Chung_loai) throws Exception {
        if (loaiXeRepository.checkLoaiXeExistedByChungLoai(Chung_loai)) {
            if (loaiXeRepository.deleteLoaiXe(Chung_loai) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceNotFoundException("Not found!");
        }
    }
}
