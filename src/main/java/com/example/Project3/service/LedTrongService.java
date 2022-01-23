package com.example.Project3.service;

import com.example.Project3.dto.LedTrongDTO;
import com.example.Project3.exception.ResourceAlreadyExistException;
import com.example.Project3.exception.ResourceNotFoundException;
import com.example.Project3.repository.LedTrongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedTrongService {
    @Autowired
    LedTrongRepository ledTrongRepository;

    public List<LedTrongDTO> getAllLedTrong(Integer sortType) {
        if (sortType == null) {
            return ledTrongRepository.getAllLedTrongASC();
        } else if (sortType == 1) {
            return ledTrongRepository.getAllLedTrongDESC();
        } else {
            return ledTrongRepository.getAllLedTrongASC();
        }

    }

    public LedTrongDTO getLedTrongByID(Integer ID_ledTrong) {
        if (ledTrongRepository.getLedTrongByID(ID_ledTrong).size() != 0) {
            return ledTrongRepository.getLedTrongByID(ID_ledTrong).get(0);
        } else {
            throw new ResourceNotFoundException("Not found!");
        }

    }

    public Boolean addLedTrong(LedTrongDTO ledTrongDTO) throws Exception {
        if (!ledTrongRepository.checkLedTrongExistedByID(ledTrongDTO.getID_ledTrong())) {
            if (ledTrongRepository.addLedTrong(ledTrongDTO) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceAlreadyExistException("Existed!");
        }
    }

    public Boolean updateLedTrong(LedTrongDTO ledTrongDTO) throws Exception {
        if (ledTrongRepository.checkLedTrongExistedByID(ledTrongDTO.getID_ledTrong())) {
            LedTrongDTO ledTrongDTOResponse = ledTrongRepository.getLedTrongByID(ledTrongDTO.getID_ledTrong()).get(0);
            if (ledTrongDTO.getMa_sp() != null) {
                ledTrongDTOResponse.setMa_sp(ledTrongDTO.getMa_sp());
            }
            if (ledTrongDTO.getNCC() != null) {
                ledTrongDTOResponse.setNCC((ledTrongDTO.getNCC()));
            }
            if (ledTrongDTO.getKT() != null) {
                ledTrongDTOResponse.setKT(ledTrongDTO.getKT());
            }
            if (ledTrongDTO.getD() != null) {
                ledTrongDTOResponse.setD(ledTrongDTO.getD());
            }
            if (ledTrongDTO.getR() != null) {
                ledTrongDTOResponse.setR(ledTrongDTO.getR());
            }
            if (ledTrongDTO.getNgay_BD() != null) {
                ledTrongDTOResponse.setNgay_BD(ledTrongDTO.getNgay_BD());
            }
            if (ledTrongDTO.getTG_BH() != null) {
                ledTrongDTOResponse.setTG_BH(ledTrongDTO.getTG_BH());
            }
            if (ledTrongDTO.getTG_con_lai() != null) {
                ledTrongDTOResponse.setTG_con_lai(ledTrongDTO.getTG_con_lai());
            }
            if (ledTrongRepository.updateLedTrong(ledTrongDTOResponse) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceNotFoundException("Not found!");
        }
    }

    public Boolean deleteLedTrong(Integer ID_ledTrong) throws Exception {
        if (ledTrongRepository.checkLedTrongExistedByID(ID_ledTrong)) {
            if (ledTrongRepository.deleteLedTrong(ID_ledTrong) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceNotFoundException("Not found!");
        }
    }
}

