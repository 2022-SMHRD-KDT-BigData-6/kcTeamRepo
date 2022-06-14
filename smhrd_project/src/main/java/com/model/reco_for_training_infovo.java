package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class reco_for_training_infovo {
	   private int training_index;
	   private String training_part;
	   private String training_equip;
	   private String training_dif;
	   private double score;
	   
	   public reco_for_training_infovo(int training_index, String training_part, String training_equip, String training_dif) {
		      this.training_index = training_index;
		      this.training_part = training_part;
		      this.training_equip = training_equip;
		      this.training_dif = training_dif;
		   }

}
