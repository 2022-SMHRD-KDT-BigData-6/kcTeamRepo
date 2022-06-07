package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//detail_training_rutin_info사용자별루틴 상세 운동
@Data
@AllArgsConstructor
@NoArgsConstructor

public class detail_training_rutin_infoVO {
	int index_no;
	int rutin_index;
	int trainint_index;
	int set_val;
	String secncnt_val;
	int favor_check;
}
