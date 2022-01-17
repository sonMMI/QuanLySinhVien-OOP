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
public class Person {
    String name, gender, birthday, address;

    // Constructor
    public Person() {
    }

    public Person(String name, String gender, String birthday, String address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    // Getter / Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" + "name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", address=" + address + '}';
    }
    
    // Hiển thị thông tin
    public void showInfo() {
        System.out.println(this);
    }
    
    // Nhập thông tin
    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Tên: ");
        name = sc.nextLine();
        
        System.out.println("Nhập Giới Tính: ");
        gender = sc.nextLine();
        
        System.out.println("Nhập Ngày Sinh: ");
        birthday = sc.nextLine();
        
        System.out.println("Nhập Địa Chỉ: ");
        address = sc.nextLine();
    }
    
    
}
