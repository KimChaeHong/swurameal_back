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
import com.company.swurameal.dto.GoodsSuggestDto;
import com.company.swurameal.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService; // GoodsService를 사용하여 상품 목록을 가져옴
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int goodsId, Model model) {
		log.info("제품 상세");
		GoodsDto goodsDto = goodsService.getGoodsById(goodsId);
		List<GoodsSuggestDto> goodsSuggestDto = goodsService.getGoodsBySuggest(goodsDto);
		List<GoodsSuggestDto> goodsSuggestAlcohol = goodsService.getGoodsBySuggest(goodsDto); 
//		List<GoodsDto> goodsDtoSameCategory = goodsService.getGoodsCategory(goodsDto.getCategory());
//		String suggestType = "";
//		switch (goodsDto.getCategory()) {
//			case "양식": 
//				suggestType = "과실주";
//				break;
//			case "한식":
//				suggestType = "증류주";
//				break;
//			case "분식":
//				suggestType = "탁주";
//				break;
//			case "전통주":
//				suggestType = "떡볶이";
//				break;
//			default:
//				suggestType = "증류주";
//				break;
//		}
//		List<GoodsDto> goodsDtoAlcohol = goodsService.getGoodsSubCategory(suggestType);
		model.addAttribute("goods", goodsDto);
		model.addAttribute("goodsSameCategory", goodsSuggestDto);
		model.addAttribute("goodsAlcohol", goodsSuggestAlcohol);
		return "goods/detail";
	}
	
	@GetMapping("/downloadImage")
	public void attachDownload(int goodsId, HttpServletResponse response) throws Exception {
		GoodsImgDto goods = goodsService.getGoodsAttach(goodsId);
		
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
	
	@GetMapping("/downloadImageByRole")
	public void attachDownloadDetail(
			@RequestParam int goodsId, 
			@RequestParam String imgRole, 
			HttpServletResponse response
			) throws Exception {
		GoodsImgDto goodsImgDto = new GoodsImgDto();
		goodsImgDto.setGoodsId(goodsId);
		goodsImgDto.setImgRole(imgRole);
		GoodsImgDto goods = goodsService.getGoodsAttachByRole(goodsImgDto);
		
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
