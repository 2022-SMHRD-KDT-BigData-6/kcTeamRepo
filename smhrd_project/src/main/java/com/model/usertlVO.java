package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//사용자의 운동 정보를 저장하는 VO
public class usertlVO {
	
	String user_id;
	String training_name;
	int set_val;
	String secncnt_val;
	String training_date;
	int cnt;
}

