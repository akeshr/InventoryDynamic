package com.InventoryAnalysis.DAO;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.InventoryAnalysis.Model.Student;


public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

      InventoryAnalysisDAO inventoryAnalysisDAO = 
         (InventoryAnalysisDAO)context.getBean("InventoryAnalysisDAO");
      
      System.out.println("------Records Creation--------" );
      inventoryAnalysisDAO.create("Zara", 11);
      inventoryAnalysisDAO.create("Nuha", 20);
      inventoryAnalysisDAO.create("Ayan", 15);

      System.out.println("------Listing Multiple Records--------" );
      List<Student> students = inventoryAnalysisDAO.listStudents();
      
      for (Student record : students) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Age : " + record.getAge());
      }

      System.out.println("----Updating Record with ID = 2 -----" );
      inventoryAnalysisDAO.update(2, 20);

      System.out.println("----Listing Record with ID = 2 -----" );
      Student student = inventoryAnalysisDAO.getStudent(2);
      System.out.print("ID : " + student.getId() );
      System.out.print(", Name : " + student.getName() );
      System.out.println(", Age : " + student.getAge());
   }
}
