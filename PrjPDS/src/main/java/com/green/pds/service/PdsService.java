package com.green.pds.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.green.pds.vo.PdsVo;

public interface PdsService {

	List<PdsVo> getPdsList(String menu_id);

	void setWrite(HashMap<String, Object> map, HttpServletRequest request);

}
