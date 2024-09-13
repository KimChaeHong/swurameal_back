package com.company.swurameal.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;
import com.company.swurameal.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	/*@Autowired
	private KoreanService koreanService;*/
	
	@RequestMapping("/detail")
	public String detail() {
		log.info("제품 상세");
		return "goods/detail";
	}
	
	/*@GetMapping("/goods")
	public String goods(int goodsId, Model model) {
		List<GoodsDto> goods = goodsService.getGoods();
		model.addAttribute("goods", goods);
		return "common/main";
	}*/
	
	@GetMapping("/downloadImage")
	   public void downloadImage(int goodsId, HttpServletResponse response) throws Exception {
	      GoodsImgDto goods = goodsService.selectAttachByGoodsId(goodsId);
	      
	      //응답 헤더에 들어가는 Content-Type 파일 확장명을 보고 저장을 자동으로 해주기
	      String contentType = goods.getGAttachType();
	      response.setContentType(contentType);
	      
	      //파일로 저장하기 위한 설정            
	      String fileName = goods.getGAttachOname();
	      String encodingfileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
	      response.setHeader("Content-Disposition", "attachment; filename=\""+encodingfileName+"\"");
	      
	      
	      //응답 본문에 파일 데이터를 출력
	      OutputStream out = response.getOutputStream();
	      out.write(goods.getGAttachData());
	      out.flush();
	      out.close();
	   }
	
}
