package com.model;
//user_info ���� ���� VO
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class userVO {
	private String user_id;
	private String user_pw;
	private String nick_name;
	private int height_val;
	private int weight_val;
	private int bmi;
	private String address;
}
