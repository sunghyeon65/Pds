package com.green.pds.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.menu.service.MenuService;
import com.green.menu.vo.MenuVo;
import com.green.pds.service.PdsService;
import com.green.pds.vo.PdsVo;

@Controller
@RequestMapping("/Pds")
public class PdsController {
	
	@Autowired	
	private   MenuService  menuService;
	
	@Autowired
	private   PdsService   pdsService;
	
	// /Pds/List?menu_id=MENU01
	@RequestMapping("/List")
	public   ModelAndView   list(
		@RequestParam  HashMap<String, Object>  map	
			) {
		
		// 메뉴 목록
		List<MenuVo>  menuList  =  menuService.getMenuList();
		
		String        menu_id   =  String.valueOf( map.get("menu_id") );		
		String        menuname  =  menuService.getMenu_name(menu_id);
		map.put("menuname", menuname);
		
		// 게시물 목록
		List<PdsVo>   pdsList   =  pdsService.getPdsList(menu_id); 
				
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("pds/list");  
		mv.addObject("menuList", menuList );
		mv.addObject("pdsList",  pdsList );
		mv.addObject("map",      map );
		return  mv;		
	
	}
	
	// 새글: /Pds/WriteForm?menu_id=MENU01&bnum=0
	// 답글: /Pds/WriteForm?menu_id=MENU01&idx=13&bnum=13&lvl=1&step=1&nref=13
	@RequestMapping("/WriteForm")
	public  ModelAndView   writeForm(
		@RequestParam  HashMap<String, Object>  map) {
				
		// 메뉴 목록
		List<MenuVo>  menuList  =  menuService.getMenuList(); 
		PdsVo         pdsVo     =  null;
		if( map.get("idx") != null  ) {   // 답글 처리
			// pdsVo  =  pdsService.getView(   )
		}
		
		ModelAndView  mv  =  new ModelAndView();
		mv.setViewName("pds/write");
		mv.addObject("menuList", menuList );
		mv.addObject("vo",  pdsVo  );  // 답글처리를 위해
		mv.addObject("map", map );
		return mv;
	}
	
	// /Pds/Write 
	@RequestMapping("/Write")
	public  ModelAndView   write(
		@RequestParam  HashMap<String, Object> map,    // String 정보
		HttpServletRequest   request                   // String + File(Binary)
			) {
		// 넘어온 정보
		System.out.println( map );
		// {lvl=, nref=, bnum=0, step=, writer=aaa, title=aaa, cont=aaaa, menu_id=MENU01}
		
		// 저장
		// map 정보
		// 1. 새글(답글) 글저장 -> Board table  저장 
		
		// request 정보활용
		// 2. 파일 정보 저장    -> Files table  저장 
		// 3. 실제 파일 저장    -> d:\dev\data\ 저장 : fileupload library
		
		pdsService.setWrite(map, request);		
		
		String  menu_id =  String.valueOf( map.get("menu_id") );
		
		ModelAndView  mv  =  new ModelAndView();
		mv.setViewName("redirect:/Pds/List?menu_id=" + menu_id);
		mv.addObject("map", map);
		return  mv;
	}
	
}









