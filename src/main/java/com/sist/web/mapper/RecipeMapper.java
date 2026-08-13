package com.sist.web.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;
@Mapper
@Repository
public interface RecipeMapper {

	/*
	 *  <select id="recipeListData" resultType="com.sist.web.vo.RecipeVO" parameterType="int">
		  SELECT no,poster,title,chef
		  FROM recipe
		  <include refid="where-no"/>
		  ORDRER BY no ASC
		  OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY
		 </select>
		 
		 */
	// 레시피 목록 출력	 
	public List<RecipeVO> recipeListData(int start);
	
	/*
		 <!--  카운트 구하기 -->
		  <select id="recipeCount" resultType="int">
		   SELECT COUNT(*)
		   FROM recipe
		   <include refid="where-no"/>
		  </select>
			 */
	public int recipeCount();
	
	// 인기순위 떄문에 조회수 증가
	@Update("UPDATE recipe SET "
			+"hit=hit+1 "
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	// 상세보기
	@Select("SELECT * FROM recipeDetail "
			+"WHERE no=#{no}")
	public RecipeDetailVO recipeDetailData(int no);
	
}
