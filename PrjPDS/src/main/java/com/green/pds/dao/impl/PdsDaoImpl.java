package com.green.pds.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.pds.dao.PdsDao;
import com.green.pds.vo.FilesVo;
import com.green.pds.vo.PdsVo;

@Repository("pdsDao")
public class PdsDaoImpl implements PdsDao {

	@Autowired	
	private  SqlSession   sqlSession;
	
	@Override
	public List<PdsVo> getPdsList(String menu_id) {
		
		List<PdsVo>  pdsList  =  sqlSession.selectList("Pds.PdsList", menu_id );  
		return   pdsList;
	}

	@Override
	public void setWrite(HashMap<String, Object> map) {
		
		// db 에 정보 저장
		/*
		2:{lvl=, nref=, bnum=0, step=, writer=aaa, title=aaa, cont=aaa, menu_id=MENU01,
		  fileList=[
			 FilesVo [file_num=0, idx=0, filename=history-flower.jpg, fileext=.jpg, sfilename=history-flower.jpg], 
			 FilesVo [file_num=0, idx=0, filename=색상영역.jpg, fileext=.jpg, sfilename=색상영역.jpg], 
			 FilesVo [file_num=0, idx=0, filename=Apple.jpg, fileext=.jpg, sfilename=Apple.jpg]
		  ]
	    }
	    */
		
		System.out.println("dao:" + map);
		
		// Board
		int  bnum  =  Integer.parseInt( String.valueOf( map.get("bnum") ) );
		if( bnum == 0  ) { // 새글
			sqlSession.insert("Pds.PdsInsert",  map );
		} else {           // 답글			
			sqlSession.update("Pds.StepUpdate", map );
			sqlSession.insert("Pds.PdsReply",   map );
		}
		
		// Files
		List<FilesVo>  fileList =  (List<FilesVo>) map.get("fileList");
		if( fileList.size() != 0 )
			sqlSession.insert("Pds.FileInsert", map);
		
	}

}



