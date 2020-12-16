package com.abc.dao.idao;

import com.abc.controller.vo.DeptEmpVO;
import com.abc.service.dto.DeptEmpDTO;

import java.util.List;

public interface IReportDao {
    List<DeptEmpDTO> makeReportForDeptEmp(DeptEmpVO deptEmpVO)throws Exception;
}
