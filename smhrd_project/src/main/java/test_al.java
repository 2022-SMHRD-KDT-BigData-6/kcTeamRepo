import java.util.ArrayList;
import java.util.List;

class info_vo {
   int index;
   String part;
   String equip;
   String diff;
   double score;

   public int getIndex() {
      return index;
   }

   public void setIndex(int index) {
      this.index = index;
   }

   public String getPart() {
      return part;
   }

   public void setPart(String part) {
      this.part = part;
   }

   public String getEquip() {
      return equip;
   }

   public void setEquip(String equip) {
      this.equip = equip;
   }

   public String getDiff() {
      return diff;
   }

   public void setDiff(String diff) {
      this.diff = diff;
   }

   public double getScore() {
      return score;
   }

   public void setScore(double score) {
      this.score = score;
   }

   public info_vo(int index, String part, String equip, String diff) {
      this.index = index;
      this.part = part;
      this.equip = equip;
      this.diff = diff;
   }

}

class user_info {
   String level[] = new String[2]; // 난이도
   String favor_part[] = new String[2]; // 선호 부위
   String hate_favor_part; // 비선호 부위
   String yesterday_part[][] = new String[2][2]; // 어제자, 이틀전 부위
   String eq[] = new String[2]; // 선호 장비

   public user_info(String[] level, String[] favor_part, String hate_favor_part, String[][] yesterday_part,
         String[] eq) {
      super();
      this.level = level;
      this.favor_part = favor_part;
      this.hate_favor_part = hate_favor_part;
      this.yesterday_part = yesterday_part;
      this.eq = eq;
   }

   public String[] getLevel() {
      return level;
   }

   public void setLevel(String[] level) {
      this.level = level;
   }

   public String[] getFavor_part() {
      return favor_part;
   }

   public void setFavor_part(String[] favor_part) {
      this.favor_part = favor_part;
   }

   public String getHate_favor_part() {
      return hate_favor_part;
   }

   public void setHate_favor_part(String hate_favor_part) {
      this.hate_favor_part = hate_favor_part;
   }

   public String[][] getYesterday_part() {
      return yesterday_part;
   }

   public void setYesterday_part(String[][] yesterday_part) {
      this.yesterday_part = yesterday_part;
   }

   public String[] getEq() {
      return eq;
   }

   public void setEq(String[] eq) {
      this.eq = eq;
   }

}

class score_list {
   double level_score = 1;
   double favor_part_score = 1;
   double hate_part_score = 1;
   double yesterday_part_score = 1;
   double eq_score = 1;

   public double getLevel_score() {
      return level_score;
   }

   public void setLevel_score(double level_score) {
      this.level_score = level_score;
   }

   public double getFavor_part_score() {
      return favor_part_score;
   }

   public void setFavor_part_score(double favor_part_score) {
      this.favor_part_score = favor_part_score;
   }

   public double getHate_part_score() {
      return hate_part_score;
   }

   public void setHate_part_score(double hate_part_score) {
      this.hate_part_score = hate_part_score;
   }

   public double getYesterday_part_score() {
      return yesterday_part_score;
   }

   public void setYesterday_part_score(double yesterday_part_score) {
      this.yesterday_part_score = yesterday_part_score;
   }

   public double getEq_score() {
      return eq_score;
   }

   public void setEq_score(double eq_score) {
      this.eq_score = eq_score;
   }

}

public class test_al {

   public static void main(String[] args) {

      List<score_list> score_lists = new ArrayList<score_list>();

      List<info_vo> inVos = new ArrayList<info_vo>();

      inVos.add(new info_vo(1, "등", "바벨", "상"));// 부위,장비,난이도
      inVos.add(new info_vo(2, "팔", "덤벨", "상"));
      inVos.add(new info_vo(3, "하체", "머신", "중"));
      inVos.add(new info_vo(4, "어깨", "바벨", "하"));
      inVos.add(new info_vo(5, "전신", "덤벨", "하"));
      inVos.add(new info_vo(6, "가슴", "바벨", "중"));
      inVos.add(new info_vo(7, "엉덩이", "바벨", "상"));
      inVos.add(new info_vo(8, "등", "덤벨", "상"));
      inVos.add(new info_vo(9, "팔", "머신", "상"));
      inVos.add(new info_vo(10, "하체", "바벨", "중"));
      inVos.add(new info_vo(11, "어깨", "덤벨", "하"));
      inVos.add(new info_vo(12, "전신", "덤벨", "중"));
      inVos.add(new info_vo(13, "가슴", "머신", "하"));
      inVos.add(new info_vo(14, "엉덩이", "바벨", "중"));

      for (int i = 0; i < inVos.size(); i++)
         score_lists.add(new score_list());

      String b[] = { "하체", "전신" };// 선호부위
      String c[] = { "바벨", "덤벨" };// 기구
      String a[] = { "상", "중" };// 난이도
      String d[][] = { { "", "" }, { "", "" } };// 했던부위
      // 난이도, 선호부위, 비선호, 했던 운동 부위, 선호 장비
      user_info ui = new user_info(a, b, "어깨", d, c);
      
      // 비선호부위
      for (int i = 0; i < inVos.size(); i++) {

         if (ui.getHate_favor_part().equals(inVos.get(i).getPart())) {
            score_lists.get(i).setFavor_part_score(0);
         }else {
             score_lists.get(i).setFavor_part_score(1);
      }
      }
      
      // 선호부위계산
      for (int i = 0; i < inVos.size(); i++) {

         if (ui.getFavor_part()[0].equals(inVos.get(i).getPart())) {
            score_lists.get(i).setFavor_part_score(1);
         }else if(ui.getFavor_part()[1].equals(inVos.get(i).getPart())){
            score_lists.get(i).setFavor_part_score(0.8);
         }else {
             score_lists.get(i).setFavor_part_score(0.1);
          }
      }
     

      // 기구계산
      for (int i = 0; i < inVos.size(); i++) {
         
         if (ui.getEq()[0].equals(inVos.get(i).getEquip())) {
            score_lists.get(i).setEq_score(0.6);
         } else if (ui.getEq()[1].equals(inVos.get(i).getEquip())) {
            score_lists.get(i).setEq_score(0.4);
         } else {
            score_lists.get(i).setEq_score(0.2);
         }
      }
      // 난이도 계산
      for (int i = 0; i < inVos.size(); i++) {

         if (ui.getLevel()[0].equals(inVos.get(i).getDiff())) {
            score_lists.get(i).setLevel_score(0.8);
         } else if (ui.getLevel()[1].equals(inVos.get(i).getDiff())) {
            score_lists.get(i).setLevel_score(0.6);
         } else {
            score_lists.get(i).setLevel_score(0.2);
         }
      }
     
    

      // 했던 부위
      
      for (int i = 0; i < inVos.size(); i++) {
         
         for(int j = 0; j<ui.getYesterday_part()[1].length; j++)
              if(ui.getYesterday_part()[1][j].equals(inVos.get(i).getPart())){
                 score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score()-0.2);
                 break;
              }
                 
         
         for(int j = 0; j<ui.getYesterday_part()[0].length; j++)
            if(ui.getYesterday_part()[0][j].equals(inVos.get(i).getPart())){
               score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score()-0.5);
               break;
            }
               
         
        
      }
      

      
      // for 끝
      System.out.println("부위가중치:");
      for (int i = 0; i < score_lists.size(); i++) {
         System.out.println(score_lists.get(i).getFavor_part_score());
      }
      System.out.println("기구가중치:");
      for (int i = 0; i < score_lists.size(); i++) {
         System.out.println(score_lists.get(i).getEq_score());
      }
      System.out.println("난이도가중치:");
      for (int i = 0; i < score_lists.size(); i++) {
         System.out.println(score_lists.get(i).getLevel_score());
      }
      
      System.out.println("이전 날짜 운동 관련 가중치:");   
      for(int i =0; i<score_lists.size(); i++) {
         System.out.println(score_lists.get(i).getYesterday_part_score());
      }
      System.out.println("가중치스코어 총합");
      for(int i =0; i<score_lists.size(); i++) {
         inVos.get(i).setScore((score_lists.get(i).getLevel_score()+score_lists.get(i).getEq_score()+score_lists.get(i).getFavor_part_score())*score_lists.get(i).getYesterday_part_score());
          System.out.println(inVos.get(i).getScore());
       }
      for (int i = 0; i<inVos.size();i++) {   
         for (int j = 0; j < i; j++) {      
            if (inVos.get(j).getScore() > inVos.get(i).getScore() ) { 
               
               int temp = inVos.get(j).index ;             
               inVos.get(j).index = inVos.get(i).index;             
               inVos.get(i).index = temp;    
               double temp_sc = inVos.get(j).score ;             
               inVos.get(j).score = inVos.get(i).score;             
               inVos.get(i).score = temp_sc; 
            } 
         }
      }

      System.out.println("정렬 후");
      for (int i = inVos.size(); i > 0; i--) {
         System.out.print(inVos.get(i-1).index+":"+inVos.get(i-1).score+"\t");
      }
      

   }
}