package com.example.Project3.service;

import com.example.Project3.dto.LedSauDTO;
import com.example.Project3.exception.ResourceAlreadyExistException;
import com.example.Project3.exception.ResourceNotFoundException;
import com.example.Project3.repository.LedSauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedSauService {
    @Autowired
    LedSauRepository ledSauRepository;

    public List<LedSauDTO> getAllLedSau(Integer sortType) {
        if (sortType == null) {
            return ledSauRepository.getAllLedSauASC();
        } else if (sortType == 1) {
            return ledSauRepository.getAllLedSauDESC();
        } else {
            return ledSauRepository.getAllLedSauASC();
        }
    }

    public LedSauDTO getLedSauByID(Integer ID_ledSau) {
        if (ledSauRepository.getLedSauByID(ID_ledSau).size() != 0) {
            return ledSauRepository.getLedSauByID(ID_ledSau).get(0);
        } else {
            throw new ResourceNotFoundException("LedSau Id not found");
        }
    }

    public Boolean addLedSau(LedSauDTO ledSauDTO) throws Exception {
        if (!ledSauRepository.checkLedSauExistedByID(ledSauDTO.getID_ledSau())) {
            if (ledSauRepository.addLedSau(ledSauDTO) != 0) {
                return true;
            } else {
                throw new Exception("Failed to add");
            }
        } else {
            throw new ResourceAlreadyExistException("LedSau already existed");
        }
    }

    public Boolean updateLedSau(LedSauDTO ledSauDTO) throws Exception {
        if (ledSauRepository.checkLedSauExistedByID(ledSauDTO.getID_ledSau())) {
            LedSauDTO ledSauDTOResponse = ledSauRepository.getLedSauByID(ledSauDTO.getID_ledSau()).get(0);
            if (ledSauDTO.getMa_SP() != null) {
                ledSauDTOResponse.setMa_SP(ledSauDTO.getMa_SP());
            }
            if (ledSauDTO.getNCC() != null) {
                ledSauDTOResponse.setNCC((ledSauDTO.getNCC()));
            }
            if (ledSauDTO.getKT() != null) {
                ledSauDTOResponse.setKT(ledSauDTO.getKT());
            }
            if (ledSauDTO.getD() != null) {
                ledSauDTOResponse.setD(ledSauDTO.getD());
            }
            if (ledSauDTO.getR() != null) {
                ledSauDTOResponse.setR(ledSauDTO.getR());
            }
            if (ledSauDTO.getNgay_BD() != null) {
                ledSauDTOResponse.setNgay_BD(ledSauDTO.getNgay_BD());
            }
            if (ledSauDTO.getTG_BH() != null) {
                ledSauDTOResponse.setTG_BH(ledSauDTO.getTG_BH());
            }
            if (ledSauDTO.getTG_con_lai() != null) {
                ledSauDTOResponse.setTG_con_lai(ledSauDTO.getTG_con_lai());
            }
            if (ledSauRepository.updateLedSau(ledSauDTOResponse) != 0) {
                return true;
            } else {
                throw new Exception("Failed to update");
            }
        } else {
            throw new ResourceNotFoundException("LedSau not found");
        }
    }

    public Boolean deleteLedSau(Integer ID_ledSau) throws Exception {
        if (ledSauRepository.checkLedSauExistedByID(ID_ledSau)) {
            if (ledSauRepository.deleteLedSau(ID_ledSau) != 0) {
                return true;
            } else {
                throw new Exception("Failed to delete");
            }
        } else {
            throw new ResourceNotFoundException("LedSau not found");
        }
    }
}
