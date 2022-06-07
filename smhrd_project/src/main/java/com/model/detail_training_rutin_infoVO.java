package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//detail_training_rutin_info사용자별루틴 상세 운동
@Data
@AllArgsConstructor
@NoArgsConstructor

public class detail_training_rutin_infoVO {
	private int index_no;
	private int rutin_index;
	private int trainint_index;
	private int set_val;
	private String secncnt_val;
	private int favor_check;
}
