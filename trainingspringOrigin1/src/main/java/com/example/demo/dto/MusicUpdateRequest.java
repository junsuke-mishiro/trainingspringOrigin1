package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 曲情報更新リクエストデータ
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MusicUpdateRequest extends MusicRequest implements Serializable {

	@NotNull
	private Long id;
}
