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
	   private int index;
	   private String part;
	   private String equip;
	   private String diff;
	   private double score;
	   
	   public reco_for_training_infovo(int index, String part, String equip, String diff) {
		      this.index = index;
		      this.part = part;
		      this.equip = equip;
		      this.diff = diff;
		   }

}
