package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotetion.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Music;
import com.example.demo.repository.MusicRepository;

/**
 * 曲情報 Service
 */
@Service
public class MusicService {
	
	/**
	 * 曲情報
	 */
	@Autowired
	UserRepository userRepository;
	
	public List<User> searchAll(){
//
}
