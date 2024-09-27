package com.company.swurameal.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.company.swurameal.dto.GoodsDto;
import com.company.swurameal.dto.GoodsImgDto;
import com.company.swurameal.dto.GoodsRegForm;
import com.company.swurameal.dto.GoodsUpdateForm;
import com.company.swurameal.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/mgmt")
@Slf4j
public class MgmtController {
	@Autowired
	private GoodsService goodsService;
	
	// 등록 된 상품 목록 보기
	@RequestMapping("/registedList")
	public String adminGm(Model model) {
		log.info("상품관리");
		List<GoodsDto> goodsList = goodsService.getAllGoods();
		model.addAttribute("goodsList", goodsList);
		return "management/gMgmt";
	}

	// 상품 새로 등록하기
	@GetMapping("/gReg")
	public String gReg() {

		return "management/gReg";
	}

	// 상품 등록
	@PostMapping("/registGoods")
	public String registGoods(GoodsRegForm form) throws Exception {
		// log.info(form.toString());

		GoodsDto goods = new GoodsDto();

		goods.setGoodsName(form.getGoodsName());
		goods.setCategory(form.getCategory());
		goods.setSubcategory(form.getSubcategory());
		goods.setPrice(form.getPrice());
		goods.setGoodsComment(form.getGoodsComment());
		goods.setGoodsOrigin(form.getGoodsOrigin());
		goods.setDeliveryInfo(form.getDeliveryInfo());
		goods.setSeller(form.getSeller());
		goods.setSaleUnit(form.getSaleUnit());
		goods.setWeight(form.getWeight());
		goods.setStock(form.getStock());
		goods.setStatus(form.getStatus());

		// 사진 3개를 받기 위해 맵으로 저장한다.
		List<GoodsImgDto> imgList = new ArrayList<GoodsImgDto>();

		MultipartFile mainAttach = form.getMainAttach();
		if (!mainAttach.isEmpty()) {
			GoodsImgDto goodsImg = new GoodsImgDto();
			// goodsImg.setGoodsId(goods.getGoodsId());
			goodsImg.setGoodsName(form.getGoodsName());
			goodsImg.setImgRole("G_MAIN");
			goodsImg.setGAttachData(mainAttach.getBytes());
			goodsImg.setGAttachOname(mainAttach.getOriginalFilename());
			goodsImg.setGAttachType(mainAttach.getContentType());
			imgList.add(goodsImg);
		}

		MultipartFile descAttach = form.getDescAttach();
		if (!descAttach.isEmpty()) {
			GoodsImgDto goodsImg = new GoodsImgDto();
			// goodsImg.setGoodsId(goods.getGoodsId());
			goodsImg.setGoodsName(form.getGoodsName());
			goodsImg.setImgRole("G_DESCRIPTION");
			goodsImg.setGAttachData(descAttach.getBytes());
			goodsImg.setGAttachOname(descAttach.getOriginalFilename());
			goodsImg.setGAttachType(descAttach.getContentType());
			imgList.add(goodsImg);
		}

		MultipartFile detailAttach = form.getDetailAttach();
		if (!detailAttach.isEmpty()) {
			GoodsImgDto goodsImg = new GoodsImgDto();
			// goodsImg.setGoodsId(goods.getGoodsId());
			goodsImg.setGoodsName(form.getGoodsName());
			goodsImg.setImgRole("G_DETAIL");
			goodsImg.setGAttachData(detailAttach.getBytes());
			goodsImg.setGAttachOname(detailAttach.getOriginalFilename());
			goodsImg.setGAttachType(detailAttach.getContentType());
			imgList.add(goodsImg);
		}

		goodsService.registGoods(goods, imgList);
		return "redirect:/mgmt/registedList";
	}

	// 상품 수정하러 가기
	@GetMapping("/gUpdate")
	public String gUpdate(int goodsId, Model model) {
		GoodsDto goods = goodsService.getGoodsById(goodsId);
		model.addAttribute("goods", goods);
		return "management/gUpdate";
	}

	// 상품 수정하기
	@PostMapping("/updateGoods")
	public String updateGoods(GoodsUpdateForm form) throws Exception {
		log.info(form.toString());

		GoodsDto goods = new GoodsDto();
		goods.setGoodsId(form.getGoodsId());
		goods.setGoodsName(form.getGoodsName());
		goods.setCategory(form.getCategory());
		goods.setSubcategory(form.getSubcategory());
		goods.setPrice(form.getPrice());
		goods.setGoodsComment(form.getGoodsComment());
		goods.setGoodsOrigin(form.getGoodsOrigin());
		goods.setDeliveryInfo(form.getDeliveryInfo());
		goods.setSeller(form.getSeller());
		goods.setSaleUnit(form.getSaleUnit());
		goods.setWeight(form.getWeight());
		goods.setStock(form.getStock());
		goods.setStatus(form.getStatus());
		
		// 사진 3개를 받기 위해 맵으로 저장한다.
		List<GoodsImgDto> imgList = new ArrayList<GoodsImgDto>();

		MultipartFile mainAttach = form.getMainAttach();
		if (!mainAttach.isEmpty()) {
			GoodsImgDto goodsImg = new GoodsImgDto();
			// goodsImg.setGoodsId(goods.getGoodsId());
			goodsImg.setGoodsName(form.getGoodsName());
			goodsImg.setImgRole("G_MAIN");
			goodsImg.setGAttachData(mainAttach.getBytes());
			goodsImg.setGAttachOname(mainAttach.getOriginalFilename());
			goodsImg.setGAttachType(mainAttach.getContentType());
			imgList.add(goodsImg);
		}

		MultipartFile descAttach = form.getDescAttach();
		if (!descAttach.isEmpty()) {
			GoodsImgDto goodsImg = new GoodsImgDto();
			// goodsImg.setGoodsId(goods.getGoodsId());
			goodsImg.setGoodsName(form.getGoodsName());
			goodsImg.setImgRole("G_DESCRIPTION");
			goodsImg.setGAttachData(descAttach.getBytes());
			goodsImg.setGAttachOname(descAttach.getOriginalFilename());
			goodsImg.setGAttachType(descAttach.getContentType());
			imgList.add(goodsImg);
		}

		MultipartFile detailAttach = form.getDetailAttach();
		if (!detailAttach.isEmpty()) {
			GoodsImgDto goodsImg = new GoodsImgDto();
			// goodsImg.setGoodsId(goods.getGoodsId());
			goodsImg.setGoodsName(form.getGoodsName());
			goodsImg.setImgRole("G_DETAIL");
			goodsImg.setGAttachData(detailAttach.getBytes());
			goodsImg.setGAttachOname(detailAttach.getOriginalFilename());
			goodsImg.setGAttachType(detailAttach.getContentType());
			imgList.add(goodsImg);
		}

		goodsService.updateGoods(goods, imgList);
		
		return "redirect:/mgmt/registedList";
	}

	// 이미지 저장
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

}
