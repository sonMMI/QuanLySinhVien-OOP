/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagement;

import java.util.Scanner;

/**
 *
 * @author doanvanson
 */
public class Student extends Person{
    String rollNo;
    float mark;
    String email;

    // Constructor
    public Student() {
    }
    
    // Getter / Setter
    public String getRollNo() {
        return rollNo;
    }

    public boolean setRollNo(String rollNo) {
        if(rollNo != null && rollNo.length() == 8) {
            this.rollNo = rollNo;
            return true;
        } else {
            System.out.printf("Nhập lại mã sinh viên (độ dài: 8 kí tự): ");
            return false;
        }
    }

    public float getMark() {
        return mark;
    }

    public boolean setMark(float mark) {
        if(mark >= 0 && mark <= 10) {
            this.mark = mark;
            return true;
        } else {
            System.out.printf("Nhập lại điểm (0 -> 10): ");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email != null && !email.contains(" ") && email.contains("@")) {
            this.email = email;
            return true;
        } else {
            System.out.printf("Nhập lại email (Không có khoảng trắng, có kí tự @): ");
            return false;
        }
        
    }
    
    // override Nhập thông tin
    @Override
    public void inputInfo() {
        super.inputInfo();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        while(true) {
            String rollNoInput = sc.nextLine();
            boolean check = setRollNo(rollNoInput);
            if(check) {
                break;
            }
        }
        
        System.out.println("Nhập điểm: ");
        while(true) {
            float markInput = Float.parseFloat(sc.nextLine());
            boolean check = setMark(markInput);
            if(check) {
                break;
            }
        }
        
        System.out.println("Nhập email: ");
        while(true) {
            String emailInput = sc.nextLine();
            boolean check = setEmail(emailInput);
            if(check) {
                break;
            }
        }
    }

    // override Hiển thị thông tin
    @Override
    public void showInfo() {
        super.showInfo();
        
        System.out.println("\t==> Mã sinh viên: " + rollNo + ", Điểm: " + mark + ", Email: " + email);
    }
    
    // Kiểm tra học bổng
    public boolean checkScholarship() {
        return (mark >= 8) ? true : false;
    }
    
    // format save file
    public String getFileLine() { 
        return rollNo + "," + name + "," + birthday + "," + gender + "," + mark +"," + email + "," + address + "\n"; 
    }
    
    // Parse file to Object
    public void parseFile(String line) {
        String[] params = line.split(",");
        
        try {
        rollNo = params[0];
        name = params[1];
        birthday = params[2];
        gender = params[3];
        mark = Float.parseFloat(params[4]);
        email = params[5];
        address = params[6];
        } catch(ArrayIndexOutOfBoundsException ex){
        } finally {   
        }
    }
}
