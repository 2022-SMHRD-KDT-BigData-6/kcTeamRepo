package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class today_user_trainingVO {
   private int training_index;
   private String training_name;
   private int cnt;
   private int set_val;
   private String secncnt_val;
}