package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.MusicRequest;
import com.example.demo.entity.Music;
import com.example.demo.repository.MusicRepository;

/**
 * 曲情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MusicService {

	/**
	 * 曲情報 Repository
	 */
	@Autowired
	private MusicRepository musicRepository;

	/**
	 * 曲情報　全検索
	 * @return　検索結果
	 */
	public List<Music> searchAll() {
		//曲TBLの内容を全検索
		return musicRepository.findAll();
	}

	/**
	 * 曲情報　主キー検索
	 * @param id
	 * @return　検索結果
	 */
	public Music findById(Long id) {
		return musicRepository.findById(id).get();
	}

	public void save(MusicRequest musicRequest) {
		Date now = new Date();
		Music music = new Music();
		music.setName(musicRequest.getName());
		music.setPerson(musicRequest.getPerson());
		music.setCreateDate(now);
		music.setUpdateDate(now);
		musicRepository.save(music);
	}
}
