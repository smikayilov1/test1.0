package com.files;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author smikayilov
 */
public class QDao extends DBConnect{
    public QDao(){
        super();
    }
     
    public void readQuestion(Set<Integer> questionsNumber,List list){
        try {
           for(Integer questionsNumbers:questionsNumber){
            ps=c.prepareStatement("select name from question where id="+questionsNumbers);
            rs=ps.executeQuery();
            if (rs.next()) {
                list.add(rs.getString("name"));
            }
            }
       
        } catch (SQLException ex) {
            Logger.getLogger(QDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void readAnswers(Set<Integer>answersNumber,List list){
        try {
            for(Integer answersNumbers:answersNumber ){
            ps=c.prepareStatement("select name from answers where id="+answersNumbers);
            rs=ps.executeQuery();
           while(rs.next()) {
                list.add(rs.getString("name"));
            }
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(QDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void generateRange(Set<Integer> numbers){
        while(numbers.size()<10){
        int min=1;
        int max=30;
        Random random = new Random();
        int randomNumber = random.nextInt(max + 1 - min) + min;
        numbers.add(randomNumber);
        }
    }
    public int checkQuestions(List<String> list){
        int right=0;
            try {
                ps=c.prepareStatement("select s.name from right_answers s inner join question w  on s.id=w.id");
                rs=ps.executeQuery();
                while(rs.next()){
                    if (list.contains(rs.getString("name"))){
                        list.contains(rs.getString("name"));
                        right++;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(QDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        return right;
    }
   
}
