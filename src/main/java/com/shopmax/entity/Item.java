package com.shopmax.entity;

import java.time.LocalDateTime;

import com.shopmax.constant.ItemSellStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity //엔티티 클래스로 정의
@Table(name="item") //테이블 이름 지정
@Getter
@Setter
@ToString
public class Item {
	
	@Id
	@Column(name="item_id") //테이블로 생성될때 컬럼이름을 지정해준다
	@GeneratedValue(strategy = GenerationType.AUTO) //기본키를 자동으로 생성해주는 전략 사용 
	private Long id; //상품코드
	
	@Column(nullable = false, length = 50) //not null여부, 컬럼 크기지정
	private String itemNm; //상품명 -> item_nm
	
	@Column(nullable = false)
	private int price; //가격 -> price
	
	@Column(nullable = false)
	private int stockNumber; //재고수량 -> stock_number
	
	@Lob //clob과 같은 큰타입의 문자타입으로 컬럼을 만든다
	@Column(nullable = false)
	private String itemDetail; //상품상세설명 -> item_detail
	
	@Enumerated(EnumType.STRING) //enum의 이름을 DB의 저장
	private ItemSellStatus itemSellStatus; //판매상태(SELL, SOLD_OUT) -> item_sell_status
	
	private LocalDateTime regTime; //등록시간
	
	private LocalDateTime updateTime; //수정시간
}






