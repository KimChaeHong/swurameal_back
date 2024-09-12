package com.company.swurameal.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;
import com.company.swurameal.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/common")
@Slf4j
public class CommonController {
	@Autowired
	private GoodsService goodsService; // GoodsService를 사용하여 상품 목록을 가져옴
	
	
	@GetMapping("/main")
	public String allGoods(@RequestParam(value = "goodsId", required = false) Integer goodsId, Model model) {
	    // GoodsService를 통해 전체 상품 목록 가져오기
	    List<GoodsDto> goodsList = goodsService.getAllGoods();
	    model.addAttribute("goodsList", goodsList);
	    
	    // GoodsService를 통해 상품 이미지 가져오기
	    if (goodsId != null) {
	        GoodsImgDto goodsImg = goodsService.getGoodsAttach(goodsId);
	        model.addAttribute("goodsImg", goodsImg);
	    }
	    return "common/main";
	}
	
	@GetMapping("/attachShow")
	public void attachDownload(int goodsId, HttpServletResponse response) throws Exception {
		GoodsImgDto goods = goodsService.getGoodsAttach(goodsId);

		//응답 본문에 파일 데이터를 출력(그냥 보기만 할 뿐.)
		OutputStream out = response.getOutputStream();
		out.write(goods.getGAttachData());
		out.flush();
		out.close();
	}

}
