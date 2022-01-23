package com.example.Project3.service;

import com.example.Project3.dto.TuyenBusDTO;
import com.example.Project3.exception.ResourceAlreadyExistException;
import com.example.Project3.exception.ResourceNotFoundException;
import com.example.Project3.repository.TuyenBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuyenBusService {
    @Autowired
    TuyenBusRepository tuyenBusRepository;

    public List<TuyenBusDTO> getAllTuyenBus(Integer sortType) {
        if (sortType == null) {
            return tuyenBusRepository.getAllTuyenBusASC();
        } else if (sortType == 1) {
            return tuyenBusRepository.getAllTuyenBusDESC();
        } else {
            return tuyenBusRepository.getAllTuyenBusASC();
        }
    }

    public TuyenBusDTO getTuyenBusByTuyen(String Tuyen) {
        if (tuyenBusRepository.getTuyenBusByTuyen(Tuyen).size() != 0) {
            return tuyenBusRepository.getTuyenBusByTuyen(Tuyen).get(0);
        } else {
            throw new ResourceNotFoundException("Not found");
        }
    }

    public Boolean addTuyenBus(TuyenBusDTO tuyenBusDTO) throws Exception {
        if (!tuyenBusRepository.checkTuyenBusExistedByTuyen(tuyenBusDTO.getTuyen())) {
            if (tuyenBusRepository.addTuyenBus(tuyenBusDTO) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceAlreadyExistException("Existed");
        }
    }

    public Boolean updateTuyenBus(TuyenBusDTO tuyenBusDTO) throws Exception {
        if (tuyenBusRepository.checkTuyenBusExistedByTuyen(tuyenBusDTO.getTuyen())) {
            TuyenBusDTO tuyenBusDTOResponse = tuyenBusRepository.getTuyenBusByTuyen(tuyenBusDTO.getTuyen()).get(0);
            if (tuyenBusDTO.getCty() != null) {
                tuyenBusDTOResponse.setCty(tuyenBusDTO.getCty());
            }
            if (tuyenBusDTO.getDon_vi() != null) {
                tuyenBusDTOResponse.setDon_vi(tuyenBusDTO.getDon_vi());
            }
            if (tuyenBusDTO.getChung_loai() != null) {
                tuyenBusDTOResponse.setChung_loai(tuyenBusDTO.getChung_loai());
            }
            if (tuyenBusDTO.getID_ledDiemDung() != null) {
                tuyenBusDTOResponse.setID_ledDiemDung(tuyenBusDTO.getID_ledDiemDung());
            }
            if (tuyenBusDTO.getID_ledTruoc() != null) {
                tuyenBusDTOResponse.setID_ledTruoc(tuyenBusDTO.getID_ledTruoc());
            }
            if (tuyenBusDTO.getID_ledSuon() != null) {
                tuyenBusDTOResponse.setID_ledSuon(tuyenBusDTO.getID_ledSuon());
            }
            if (tuyenBusDTO.getID_ledSau() != null) {
                tuyenBusDTOResponse.setID_ledSau(tuyenBusDTO.getID_ledSau());
            }
            if (tuyenBusDTO.getID_ledTrong() != null) {
                tuyenBusDTOResponse.setID_ledTrong(tuyenBusDTO.getID_ledTrong());
            }
            if (tuyenBusRepository.updateTuyenBus(tuyenBusDTOResponse) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceNotFoundException("Not found!");
        }
    }

    public Boolean deleteTuyenBus(String Tuyen) throws Exception {
        if (tuyenBusRepository.checkTuyenBusExistedByTuyen(Tuyen)) {
            if (tuyenBusRepository.deleteTuyenBus(Tuyen) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else {
            throw new ResourceNotFoundException("Not found!");
        }
    }
}
