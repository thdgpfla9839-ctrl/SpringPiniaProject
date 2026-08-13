package com.sist.web.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class RecipeRestController {

	private final RecipeService rService;
	@GetMapping("/recipe/list")
	public ResponseEntity<Map> recipe_list(@RequestParam(value = "page",required = false) String page)
	{
		Map map = new HashMap();
		try
		{
		  if(page==null)
			  page="1";
		  List<RecipeVO> list = rService.recipeListData(Integer.parseInt(page));
		  int []  pages= rService.recipePages(Integer.parseInt(page));
	      int count = rService.recipeCount();

		  // 값을 받아서 vuejs로 보낸다
		  map.put("list", list);
		  map.put("pages", pages);
		  map.put("count", count);
		  
		}catch(Exception ex)
		{
			// ResponseEntity 에러를 보내줌
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
		return ResponseEntity.ok(map);
	}
}
