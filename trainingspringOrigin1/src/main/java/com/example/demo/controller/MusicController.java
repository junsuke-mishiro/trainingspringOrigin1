package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * @param model
	 * @return 曲情報一覧画面のHTML
	 */
	@RequestMapping(value = "/music/list", method = RequestMethod.GET)
	public String displayList(Model model) {
		List<Music> musiclist = musicService.searchAll();
		model.addAttribute("musiclist", musiclist);
		return "music/list";
	}

}
