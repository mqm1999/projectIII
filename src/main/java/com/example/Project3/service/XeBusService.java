package com.example.Project3.service;

import com.example.Project3.dto.XeBusDTO;
import com.example.Project3.exception.ResourceAlreadyExistException;
import com.example.Project3.exception.ResourceNotFoundException;
import com.example.Project3.repository.XeBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XeBusService {
    @Autowired
    XeBusRepository xeBusRepository;

    public List<XeBusDTO> getAllBus(Integer sortType) {
        if (sortType == null) {
            return xeBusRepository.getAllBusASC();
        } else if (sortType == 1) {
            return xeBusRepository.getAllBusDESC();
        } else {
            return xeBusRepository.getAllBusASC();
        }
    }

    public XeBusDTO getBusByBKS(String BKS) {
        if (xeBusRepository.getBusByBKS(BKS).size() != 0) {
            return xeBusRepository.getBusByBKS(BKS).get(0);
        } else {
            throw new ResourceNotFoundException("Not found!");
        }
    }

    public Boolean addBus(XeBusDTO xeBusDTO) throws Exception {
        if (!xeBusRepository.checkBusExistedByBKS(xeBusDTO.getBKS()) && xeBusRepository.checkBusExistedByTuyen(xeBusDTO.getTuyen())) {
            if (xeBusRepository.addBus(xeBusDTO) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else if (!xeBusRepository.checkBusExistedByTuyen(xeBusDTO.getTuyen())) {
            throw new ResourceNotFoundException("Tuyen not found");
        } else {
            throw new ResourceAlreadyExistException("Existed");
        }
    }

    public Boolean updateBus(XeBusDTO xeBusDTO) throws Exception {
        if (xeBusRepository.checkBusExistedByBKS(xeBusDTO.getBKS()) && xeBusRepository.checkBusExistedByTuyen(xeBusDTO.getTuyen())) {
            XeBusDTO xeBusDTOResponse = xeBusRepository.getBusByBKS(xeBusDTO.getBKS()).get(0);
            if (xeBusDTO.getTT() != null) {
                xeBusDTOResponse.setTT(xeBusDTO.getTT());
            }
            if (xeBusDTO.getTuyen() != null) {
                xeBusDTOResponse.setTuyen(xeBusDTO.getTuyen());
            }
            if (xeBusDTO.getNam_SX() != null) {
                xeBusDTOResponse.setNam_SX(xeBusDTO.getNam_SX());
            }
            if (xeBusDTO.getNam_Lap_led() != null) {
                xeBusDTOResponse.setNam_Lap_led(xeBusDTO.getNam_Lap_led());
            }
            if (xeBusRepository.updateBus(xeBusDTOResponse) != 0) {
                return true;
            } else {
                throw new Exception("Problem occured!");
            }
        } else if (!xeBusRepository.checkBusExistedByTuyen(xeBusDTO.getTuyen())) {
            throw new ResourceNotFoundException("Tuyen not found");
        } else {
            throw new ResourceNotFoundException("Existed!");
        }
    }

    public Boolean deleteBus(String BKS) throws Exception {
            if (xeBusRepository.checkBusExistedByBKS(BKS)) {
                if (xeBusRepository.deleteBus(BKS) != 0) {
                    return true;
                } else {
                    throw new Exception("Problem occured!");
                }
            } else {
                throw new ResourceNotFoundException("Not found");
            }
        }
}
