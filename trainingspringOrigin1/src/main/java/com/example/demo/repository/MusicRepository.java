package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Music;

/**
 * 曲情報 Repository
 */
@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

}
