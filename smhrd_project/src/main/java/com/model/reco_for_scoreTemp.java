package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class reco_for_scoreTemp {
	  private double level_score = 1;
	  private double favor_part_score = 1;
	  private double hate_part_score = 1;
	  private double yesterday_part_score = 1;
	  private double eq_score = 1;

}
