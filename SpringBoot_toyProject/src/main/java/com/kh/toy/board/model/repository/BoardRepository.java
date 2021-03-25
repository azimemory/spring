package com.kh.toy.board.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kh.toy.board.model.vo.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
