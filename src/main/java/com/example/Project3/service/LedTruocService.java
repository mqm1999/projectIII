package com.example.Project3.service;

import com.example.Project3.dto.LedTruocDTO;
import com.example.Project3.exception.ResourceAlreadyExistException;
import com.example.Project3.exception.ResourceNotFoundException;
import com.example.Project3.repository.LedTruocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedTruocService {
    @Autowired
    LedTruocRepository ledTruocRepository;

    public List<LedTruocDTO> getAllLedTruoc(Integer sortType) {
        if (sortType == null) {
            return ledTruocRepository.getAllLedTruocASC();
        } else if (sortType == 1) {
            return ledTruocRepository.getAllLedTruocDESC();
        } else {
            return ledTruocRepository.getAllLedTruocASC();
        }
    }

    public LedTruocDTO getLedTruocByID(Integer ID_ledTruoc) {
        if (ledTruocRepository.getLedTruocByID(ID_ledTruoc).size() != 0) {
            return ledTruocRepository.getLedTruocByID(ID_ledTruoc).get(0);
        } else {
            throw new ResourceNotFoundException("Not found!");
        }
    }

    public Boolean addLedTruoc(LedTruocDTO ledTruocDTO) throws Exception {
        if (!ledTruocRepository.checkLedTruocExistedByID(ledTruocDTO.getID_ledTruoc())) {
            if (ledTruocRepository.addLedTruoc(ledTruocDTO) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceAlreadyExistException("Existed!");
        }
    }

    public Boolean updateLedTruoc(LedTruocDTO ledTruocDTO) throws Exception {
        if (ledTruocRepository.checkLedTruocExistedByID(ledTruocDTO.getID_ledTruoc())) {
            LedTruocDTO ledTruocDTOResponse = ledTruocRepository.getLedTruocByID(ledTruocDTO.getID_ledTruoc()).get(0);
            if (ledTruocDTO.getMa_sp() != null) {
                ledTruocDTOResponse.setMa_sp(ledTruocDTO.getMa_sp());
            }
            if (ledTruocDTO.getNCC() != null) {
                ledTruocDTOResponse.setNCC((ledTruocDTO.getNCC()));
            }
            if (ledTruocDTO.getKT() != null) {
                ledTruocDTOResponse.setKT(ledTruocDTO.getKT());
            }
            if (ledTruocDTO.getD() != null) {
                ledTruocDTOResponse.setD(ledTruocDTO.getD());
            }
            if (ledTruocDTO.getR() != null) {
                ledTruocDTOResponse.setR(ledTruocDTO.getR());
            }
            if (ledTruocDTO.getNgay_BD() != null) {
                ledTruocDTOResponse.setNgay_BD(ledTruocDTO.getNgay_BD());
            }
            if (ledTruocDTO.getTG_BH() != null) {
                ledTruocDTOResponse.setTG_BH(ledTruocDTO.getTG_BH());
            }
            if (ledTruocDTO.getTG_con_lai() != null) {
                ledTruocDTOResponse.setTG_con_lai(ledTruocDTO.getTG_con_lai());
            }
            if (ledTruocRepository.updateLedTruoc(ledTruocDTOResponse) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceNotFoundException("Not found!");
        }
    }

    public Boolean deleteLedTruoc(Integer ID_ledTruoc) {
        if (ledTruocRepository.checkLedTruocExistedByID(ID_ledTruoc)) {
            if (ledTruocRepository.deleteLedTruoc(ID_ledTruoc) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new ResourceNotFoundException("Not found!");
        }
    }
}
