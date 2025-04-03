package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.MusicRequest;
import com.example.demo.entity.Music;
import com.example.demo.service.MusicService;

/**
 * 曲情報 Controller
 */
@Controller
public class MusicController {

	/**
	 * 曲情報 Service
	 */
	@Autowired
	MusicService musicService;

	/**
	 * 曲情報一覧を表示
	 * @param model Model
	 * @return 曲情報一覧画面
	 */
	@GetMapping(value = "/music/list")
	public String displayList(Model model) {
		List<Music> musiclist = musicService.searchAll();
		model.addAttribute("musiclist", musiclist);
		return "music/list";
	}

	/**
	 * 新規曲保存画面を表示
	 * @param model Model
	 * @return　曲情報一覧画面
	 */
	@GetMapping(value = "/music/add")
	public String displayAdd(Model model) {
		model.addAttribute("musicRequest", new MusicRequest());
		return "music/add";
	}

	/**
	 * 新規曲保存
	 * @param musicRequest　リクエストデータ
	 * @param result
	 * @param model Model
	 * @return 曲情報一覧画面
	 */
	@RequestMapping(value = "/music/save", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute MusicRequest musicRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			//入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "music/add";
		}
		//新規曲保存
		musicService.save(musicRequest);
		return "redirect:/music/list";
	}

	/**
	 * 曲詳細画面を表示
	 * @param id 表示する曲ID
	 * @param model Model
	 * @return 曲情報詳細画面
	 */
	@GetMapping("/music/{id}")
	public String displayView(@PathVariable Long id, Model model) {
		Music music = musicService.findById(id);
		model.addAttribute("musicData", music);
		return "music/view";
	}
}
