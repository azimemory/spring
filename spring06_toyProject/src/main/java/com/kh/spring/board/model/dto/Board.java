package com.kh.spring.board.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
   private String bdIdx;
   private String userId;
   private Date regDate;
   private String title;
   private String content;
   private int isDel;
}