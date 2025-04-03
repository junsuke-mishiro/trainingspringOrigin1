package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * 曲情報　リクエストデータ
 */
@Data
public class MusicRequest implements Serializable {
	/**
	 * 名前
	 */
	@NotEmpty(message = "曲名を入力してください")
	@Size(max = 100, message = "曲名は100文字以内で入力してください")
	private String name;

	/**
	 * 作曲者名
	 */
	@Size(max = 255, message = "作曲者名は255文字以内で入力してください")
	private String person;

}
