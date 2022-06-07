package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//training_rutin_info ����ں� � ��ƾ VO
@Data
@AllArgsConstructor
@NoArgsConstructor

public class training_rutin_infoVO {
	private int rutin_index;
	private String user_id;
	private String training_name;
	private String myobject;
	private String start_date;
	private String end_date;
}
