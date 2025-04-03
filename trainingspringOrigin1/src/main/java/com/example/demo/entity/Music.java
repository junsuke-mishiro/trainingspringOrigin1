package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * 曲情報 Entity
 */
@Entity
@Data
@Table(name = "music")
public class Music implements Serializable{

	/**
	 * ID
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 曲名
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 作曲者名
	 */
	@Column(name = "person")
	private String person;

	/**
	 * 更新日時
	 */
	@Column(name = "update_date")
	private Date updateDate;

	/**
	 * 登録日時
	 */
	@Column(name = "create_date")
	private Date createDate;

	/**
	 * 削除日時
	 */
	@Column(name = "delete_date")
	private Date deleteDate;

}
