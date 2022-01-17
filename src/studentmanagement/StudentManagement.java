/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author doanvanson
 */
public class StudentManagement {
    Scanner sc = new Scanner(System.in);
    List<Student> studentList = new ArrayList<>();
    
    
    public void inputStudent() {
        System.out.println("Nhập số sinh viên cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            Student std = new Student();
            std.inputInfo();
            
            studentList.add(std);
        }
        System.out.println("Bạn đã thêm thành công");
    }

    public void editStudentByRollNo() {
        Boolean flag = false;
        
        System.out.println("Nhập mã sinh viên cần sửa: ");
        String rollNo = sc.nextLine();
        
        for (Student student : studentList) {
            if(student.getRollNo().equalsIgnoreCase(rollNo)){
                student.inputInfo();
                flag = true;
                break;
            }
        }
        
        if(flag) {
            System.out.println("Sửa thành công.");
        } else {
            System.out.println("Không tìm thấy mã sinh viên: " + rollNo);
        }
    }

    public void deleteStudentByRollNo() {
        Boolean flag = false;
        
        System.out.println("Nhập mã sinh viên cần xóa: ");
         String rollNo = sc.nextLine();
        
        for (Student student : studentList) {
            if(student.getRollNo().equalsIgnoreCase(rollNo)){
                studentList.remove(student);
                flag = true;
                break;
            }
        }
        if(flag) {
            System.out.println("Bạn đã xóa thành công");
        } else {
            System.out.println("Không tìm thấy mã sinh viên: " + rollNo);
        }
    }
    
    public void findStudentByName() {
        Boolean flag = false;
        
        System.out.println("Nhập tên sinh viên cần tìm: ");
        String name = sc.nextLine();
        
        for (Student student : studentList) {
            if(student.getName().equalsIgnoreCase(name)){
                student.showInfo();
                flag = true;
                break;
            }
        }
        if(flag) {
            System.out.println("Bạn đã tìm thấy thành công");
        } else {
            System.out.println("Không tìm thấy sinh viên có tên: " + name);
        }
    }
    
    public void sortStudentByRollNo() {
      Collections.sort(studentList, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getRollNo().compareTo(o2.getRollNo());
            }
        });
    }

    public void sortStudentByMark() {
        Collections.sort(studentList, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getMark() < o2.getMark()) ? -1 : 1;
            }
        });
    }

    public void sortStudentByName() {
        Collections.sort(studentList, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
            
        });
    }

    public void studentMinMaxByMark() {
        int minIndex = 0, maxIndex = 0;
        float minMark, maxMark;
        minMark = studentList.get(0).getMark();
        maxMark = studentList.get(0).getMark();
        
        for (int i = 1; i < studentList.size(); i++) {
            if(studentList.get(i).getMark() < minMark) {
                minIndex = i;
                minMark = studentList.get(i).getMark();
            }
            
            if(studentList.get(i).getMark() > maxMark) {
                maxIndex = i;
                maxMark = studentList.get(i).getMark();
            }
        }
        
        System.out.println("Sinh viên có điểm trung bình cao nhất: ");
        studentList.get(maxIndex).showInfo();
        
        System.out.println("Sinh viên có điểm trung bình thấp nhất: ");
        studentList.get(minIndex).showInfo();
    }
    
    public void scholarshipStudent() {
        Collections.sort(studentList, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getMark() < o2.getMark()) ? 1 : -1;
            }
        });
        
        for (Student student : studentList) {
            if(student.checkScholarship()) {
                student.showInfo();
            }
        }
    }
    
    public void displayStudent() {
        for (Student student : studentList) {
            student.showInfo();
        }
    }

    public void saveFile() {
        // Lưu file
        System.out.println("Bắt đầu lưu: ");
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream("student.txt");
            
            //Lưu dữ liệu
            for (Student student : studentList) {
                String line = student.getFileLine();
                // chuyển string to byte[]
                byte[] b = line.getBytes("utf8");
                //save
                fos.write(b);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public void readFile() {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        
        try {
            fis = new FileInputStream("student.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            
            String line = null;
            
            while((line = bufferedReader.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                Student std = new Student();
                std.parseFile(line);
                studentList.add(std);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            if(fis != null) {            
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                }               
            }
            
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(StudentManagement.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
    }
}
