package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//detail_training_rutin_info����ں���ƾ �� �
@Data
@AllArgsConstructor
@NoArgsConstructor

public class user_training_infoVO {
	private int index_no;
	private int training_index;
	private int set_val;
	private String secncnt_val;
	private String training_date;
}