package com.company.swurameal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.swurameal.dto.PickDto;
import com.company.swurameal.service.PickService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/pick")
@Slf4j
public class PickController {
	
	@Autowired
	private PickService pickService;
	
	@Secured("ROLE_USER")
	@PostMapping("/addPick")
	public String addPick(@RequestBody PickDto pick, Authentication authentication) {
		// 현재 로그인된 사용자 ID를 DTO에 설정
	    String userId = authentication.getName();
	    pick.setUserId(userId);

	    // 서비스 호출하여 찜 추가 처리
	    pickService.addPick(pick);
	    return "Pick added successfully";  // 성공 메시지 반환
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/deletePick")
	public String deletePick(int goodsId, HttpSession session) {
		pickService.deletePick(goodsId);
	
		return "redirect:/mypage/pick";
	}
	
	// 찜 여부 확인
    @Secured("ROLE_USER")
    @GetMapping("/check")
    @ResponseBody
    public boolean checkPickStatus(@RequestParam int goodsId, Authentication authentication) {
        String userId = authentication.getName();
        return pickService.isPicked(userId, goodsId);  // 찜한 경우 true, 아니면 false 반환
    }

	
	

		
}
