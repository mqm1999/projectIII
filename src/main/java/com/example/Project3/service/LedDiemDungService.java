package com.example.Project3.service;

import com.example.Project3.dto.LedDiemDungDTO;
import com.example.Project3.exception.ResourceAlreadyExistException;
import com.example.Project3.exception.ResourceIdNotFoundException;
import com.example.Project3.repository.LedDiemDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedDiemDungService {
    @Autowired
    LedDiemDungRepository ledDiemDungRepository;

    public List<LedDiemDungDTO> getAllLedDiemDung(Integer sortType) {
        if (sortType == null) {
            return ledDiemDungRepository.getAllLedDiemDungASC();
        } else if (sortType == 1) {
            return ledDiemDungRepository.getAllLedDiemDungDESC();
        } else {
            return ledDiemDungRepository.getAllLedDiemDungASC();
        }
    }


    public LedDiemDungDTO getLedDiemDungByID(Integer ID_ledDiemDungTT) throws ResourceIdNotFoundException {
        if (ledDiemDungRepository.getLedDiemDungByID(ID_ledDiemDungTT).size() == 0) {
            throw new ResourceIdNotFoundException("LedDiemDung with ID not found");
        } else {
            return ledDiemDungRepository.getLedDiemDungByID(ID_ledDiemDungTT).get(0);
        }
    }

    public Boolean addLedDiemDung(LedDiemDungDTO ledDiemDungDTO) throws Exception {
        if (!ledDiemDungRepository.checkLedDiemDungExistedByID(ledDiemDungDTO.getID_ledDiemDungTT())) {
            if (ledDiemDungRepository.addLedDiemDung(ledDiemDungDTO) != 0) {
                return true;
            } else {
                throw new Exception("Failed to add");
            }
        } else {
            throw new ResourceAlreadyExistException("LedDiemDung already existed");
        }
    }

    public Boolean updateLedDiemDung(LedDiemDungDTO ledDiemDungDTO) throws Exception {
        if (ledDiemDungRepository.checkLedDiemDungExistedByID(ledDiemDungDTO.getID_ledDiemDungTT())) {
            LedDiemDungDTO ledDiemDungDTOResponse = ledDiemDungRepository.getLedDiemDungByID(ledDiemDungDTO.getID_ledDiemDungTT()).get(0);
            if (ledDiemDungDTO.getMa_sp() != null) {
                ledDiemDungDTOResponse.setMa_sp(ledDiemDungDTO.getMa_sp());
            }
            if (ledDiemDungDTO.getNCC() != null) {
                ledDiemDungDTOResponse.setNCC((ledDiemDungDTO.getNCC()));
            }
            if (ledDiemDungDTO.getKT() != null) {
                ledDiemDungDTOResponse.setKT(ledDiemDungDTO.getKT());
            }
            if (ledDiemDungDTO.getD() != null) {
                ledDiemDungDTOResponse.setD(ledDiemDungDTO.getD());
            }
            if (ledDiemDungDTO.getR() != null) {
                ledDiemDungDTOResponse.setR(ledDiemDungDTO.getR());
            }
            if (ledDiemDungDTO.getNgay_BD() != null) {
                ledDiemDungDTOResponse.setNgay_BD(ledDiemDungDTO.getNgay_BD());
            }
            if (ledDiemDungDTO.getTG_BH() != null) {
                ledDiemDungDTOResponse.setTG_BH(ledDiemDungDTO.getTG_BH());
            }
            if (ledDiemDungDTO.getTG_con_lai() != null) {
                ledDiemDungDTOResponse.setTG_con_lai(ledDiemDungDTO.getTG_con_lai());
            }
            if (ledDiemDungRepository.updateLedDiemDung(ledDiemDungDTOResponse) != 0) {
                return true;
            } else {
                throw new Exception("Failed to update");
            }
        } else {
            throw new ResourceIdNotFoundException("Cannot update because LedDiemDung Id not found");
        }
    }

    public Boolean deleteLedDiemDung(Integer ID_ledDiemDungTT) throws Exception {
        if (ledDiemDungRepository.checkLedDiemDungExistedByID(ID_ledDiemDungTT)) {
            if (ledDiemDungRepository.deleteLedDiemDung(ID_ledDiemDungTT) != 0) {
                return true;
            } else {
                throw new Exception("Failed to delete");
            }
        } else {
            throw new ResourceIdNotFoundException("Cannot delete because LedDiemDung Id not found");
        }
    }
}