package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//추천 알고리즘에 사용할 가중치 저장 클래스
public class reco_for_scoreTemp {
	  private double level_score = 1;	//난이도
 	  private double favor_part_score = 1;	//선호 운동 부위
	  private double hate_part_score = 1;	//비선호 운동 부위
	  private double yesterday_part_score = 1; //이전 운동 부위
	  private double eq_score = 1;	//선호 장비

}
