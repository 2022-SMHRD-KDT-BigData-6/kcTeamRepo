//헬스장 관련 vo

package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class gtm_listVO {
	//gym_list Çï½ºÀå Á¤º¸
	
	private int index_no;
	private String gym_name;
	private String gym_address;
	private String gym_tel;
	private String gym_etc;
	
}
