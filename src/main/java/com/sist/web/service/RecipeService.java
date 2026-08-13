package com.sist.web.service;

import java.util.*;
import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;

public interface RecipeService {

	public List<RecipeVO> recipeListData(int page);
    public int recipeCount();
    public int recipeTotalPage();
	public RecipeDetailVO recipeDetailData(int no);
	public int[] recipePages(int page);
}
