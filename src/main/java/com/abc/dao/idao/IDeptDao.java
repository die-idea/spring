package com.abc.dao.idao;

import com.abc.dao.entity.Dept;

import java.util.List;

public interface IDeptDao {
    List<Dept> findAll()throws Exception;
}