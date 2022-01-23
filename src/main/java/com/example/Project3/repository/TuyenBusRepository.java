package com.example.Project3.repository;

import com.example.Project3.dto.TuyenBusDTO;
import com.example.Project3.helper.JDBCMapper.TuyenBusDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TuyenBusRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TuyenBusDTO> getAllTuyenBusASC() {
        String sql = "select * from tuyen_bus order by Tuyen ASC;";
        return jdbcTemplate.query(sql, new TuyenBusDTOMapper());
    }

    public List<TuyenBusDTO> getAllTuyenBusDESC() {
        String sql = "select * from tuyen_bus order by Tuyen DESC;";
        return jdbcTemplate.query(sql, new TuyenBusDTOMapper());
    }

    public Boolean checkTuyenBusExistedByTuyen(String Tuyen) {
        String sql = "select exists (select * from tuyen_bus where lower(Tuyen) = lower(?));";
        Object[] params = {Tuyen};
        return jdbcTemplate.queryForObject(sql, Boolean.class , params);
    }

    public List<TuyenBusDTO> getTuyenBusByTuyen(String Tuyen) {
        String sql = "select * from tuyen_bus where lower(Tuyen) = lower(?);";
        Object[] params = {Tuyen};
        return jdbcTemplate.query(sql, new TuyenBusDTOMapper(), params);
    }

    public Integer addTuyenBus(TuyenBusDTO tuyenBusDTO) {
        String sql = "insert into tuyen_bus (Tuyen, cty, Don_vi, Chung_loai, ID_ledDiemDungTT, ID_ledTruoc, ID_ledSuon, ID_ledSau, ID_ledTrong) values (?,?,?,?,?,?,?,?,?);";
        Object[] params = {tuyenBusDTO.getTuyen(), tuyenBusDTO.getCty(), tuyenBusDTO.getDon_vi(), tuyenBusDTO.getChung_loai(), tuyenBusDTO.getID_ledDiemDung(), tuyenBusDTO.getID_ledTruoc(), tuyenBusDTO.getID_ledSuon(), tuyenBusDTO.getID_ledSau(), tuyenBusDTO.getID_ledTrong()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer updateTuyenBus(TuyenBusDTO tuyenBusDTO) {
        String sql = "update tuyen_bus set cty = ?, Don_vi = ?, Chung_loai = ?, ID_ledDiemDungTT = ?, ID_ledTruoc = ?, ID_ledSuon = ?, ID_ledSau = ?, ID_ledTrong = ? where Tuyen = ?;";
        Object[] params = {tuyenBusDTO.getCty(), tuyenBusDTO.getDon_vi(), tuyenBusDTO.getChung_loai(), tuyenBusDTO.getID_ledDiemDung(), tuyenBusDTO.getID_ledTruoc(), tuyenBusDTO.getID_ledSuon(), tuyenBusDTO.getID_ledSau(), tuyenBusDTO.getID_ledTrong(), tuyenBusDTO.getTuyen()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer deleteTuyenBus(String Tuyen) {
        String sql = "delete from tuyen_bus where lower(Tuyen) = lower(?);";
        Object[] params = {Tuyen};
        return jdbcTemplate.update(sql, params);
    }
}
