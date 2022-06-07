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
	private String training_video;
	private String act_info;
	private String caution_info;
}
