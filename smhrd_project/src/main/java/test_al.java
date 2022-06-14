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
   String level[] = new String[2]; // ���̵�
   String favor_part[] = new String[2]; // ��ȣ ����
   String hate_favor_part; // ��ȣ ����
   String yesterday_part[][] = new String[2][2]; // ������, ��Ʋ�� ����
   String eq[] = new String[2]; // ��ȣ ���

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

      inVos.add(new info_vo(1, "��", "�ٺ�", "��"));// ����,���,���̵�
      inVos.add(new info_vo(2, "��", "����", "��"));
      inVos.add(new info_vo(3, "��ü", "�ӽ�", "��"));
      inVos.add(new info_vo(4, "���", "�ٺ�", "��"));
      inVos.add(new info_vo(5, "����", "����", "��"));
      inVos.add(new info_vo(6, "����", "�ٺ�", "��"));
      inVos.add(new info_vo(7, "������", "�ٺ�", "��"));
      inVos.add(new info_vo(8, "��", "����", "��"));
      inVos.add(new info_vo(9, "��", "�ӽ�", "��"));
      inVos.add(new info_vo(10, "��ü", "�ٺ�", "��"));
      inVos.add(new info_vo(11, "���", "����", "��"));
      inVos.add(new info_vo(12, "����", "����", "��"));
      inVos.add(new info_vo(13, "����", "�ӽ�", "��"));
      inVos.add(new info_vo(14, "������", "�ٺ�", "��"));

      for (int i = 0; i < inVos.size(); i++)
         score_lists.add(new score_list());

      String b[] = { "��ü", "����" };// ��ȣ����
      String c[] = { "�ٺ�", "����" };// �ⱸ
      String a[] = { "��", "��" };// ���̵�
      String d[][] = { { "", "" }, { "", "" } };// �ߴ�����
      // ���̵�, ��ȣ����, ��ȣ, �ߴ� � ����, ��ȣ ���
      user_info ui = new user_info(a, b, "���", d, c);
      
      // ��ȣ����
      for (int i = 0; i < inVos.size(); i++) {

         if (ui.getHate_favor_part().equals(inVos.get(i).getPart())) {
            score_lists.get(i).setFavor_part_score(0);
         }else {
             score_lists.get(i).setFavor_part_score(1);
      }
      }
      
      // ��ȣ�������
      for (int i = 0; i < inVos.size(); i++) {

         if (ui.getFavor_part()[0].equals(inVos.get(i).getPart())) {
            score_lists.get(i).setFavor_part_score(1);
         }else if(ui.getFavor_part()[1].equals(inVos.get(i).getPart())){
            score_lists.get(i).setFavor_part_score(0.8);
         }else {
             score_lists.get(i).setFavor_part_score(0.1);
          }
      }
     

      // �ⱸ���
      for (int i = 0; i < inVos.size(); i++) {
         
         if (ui.getEq()[0].equals(inVos.get(i).getEquip())) {
            score_lists.get(i).setEq_score(0.6);
         } else if (ui.getEq()[1].equals(inVos.get(i).getEquip())) {
            score_lists.get(i).setEq_score(0.4);
         } else {
            score_lists.get(i).setEq_score(0.2);
         }
      }
      // ���̵� ���
      for (int i = 0; i < inVos.size(); i++) {

         if (ui.getLevel()[0].equals(inVos.get(i).getDiff())) {
            score_lists.get(i).setLevel_score(0.8);
         } else if (ui.getLevel()[1].equals(inVos.get(i).getDiff())) {
            score_lists.get(i).setLevel_score(0.6);
         } else {
            score_lists.get(i).setLevel_score(0.2);
         }
      }
     
    

      // �ߴ� ����
      
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
      

      
      // for ��
      System.out.println("��������ġ:");
      for (int i = 0; i < score_lists.size(); i++) {
         System.out.println(score_lists.get(i).getFavor_part_score());
      }
      System.out.println("�ⱸ����ġ:");
      for (int i = 0; i < score_lists.size(); i++) {
         System.out.println(score_lists.get(i).getEq_score());
      }
      System.out.println("���̵�����ġ:");
      for (int i = 0; i < score_lists.size(); i++) {
         System.out.println(score_lists.get(i).getLevel_score());
      }
      
      System.out.println("���� ��¥ � ���� ����ġ:");   
      for(int i =0; i<score_lists.size(); i++) {
         System.out.println(score_lists.get(i).getYesterday_part_score());
      }
      System.out.println("����ġ���ھ� ����");
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

      System.out.println("���� ��");
      for (int i = inVos.size(); i > 0; i--) {
         System.out.print(inVos.get(i-1).index+":"+inVos.get(i-1).score+"\t");
      }
      

   }
}