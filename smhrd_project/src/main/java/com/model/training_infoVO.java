package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//training_infoVO
@Data
@AllArgsConstructor
@NoArgsConstructor

public class training_infoVO {
	private int training_index;
	private String training_name;
	private String act_info;
	private String training_part;
	private String training_equip;
	private String training_dif;
}