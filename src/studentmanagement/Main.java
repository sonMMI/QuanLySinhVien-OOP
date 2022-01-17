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
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement stdManage = new StudentManagement();
        int choose;
        
        do {            
            showMenu();
            choose = Integer.parseInt(sc.nextLine());
            
            switch(choose){
                case 1: 
                    System.out.println("Bạn đã chọn thêm sinh viên.");
                    stdManage.inputStudent();
                    break;
                case 2: 
                    System.out.println("Bạn đã chọn sửa thông tin sinh viên.");
                    stdManage.editStudentByRollNo();
                    break;
                case 3: 
                    System.out.println("Bạn đã chọn xóa sinh viên.");
                    stdManage.deleteStudentByRollNo();
                    break;
                case 4:
                    System.out.println("Bạn đã chọn tìm sinh viên.");
                    stdManage.findStudentByName();
                    break;
                case 5:  
                    System.out.println("Bạn đã chọn sắp xếp tăng dần theo mã sinh viên.");
                    stdManage.sortStudentByRollNo();
                    System.out.println("Sắp xếp thành công.");
                    break;
                case 6: 
                    System.out.println("Bạn đã chọn sắp xếp tăng dần theo điểm.");
                    stdManage.sortStudentByMark();
                    System.out.println("Sắp xếp thành công.");
                    break;
                case 7: 
                    System.out.println("Bạn đã chọn sắp xếp A- Z theo tên.");
                    stdManage.sortStudentByName();
                    System.out.println("Sắp xếp thành công.");
                    break;
                case 8: 
                    System.out.println("Bạn đã chọn sinh viên có điểm cao nhất & thấp nhất.");
                    stdManage.studentMinMaxByMark();
                    System.out.println("Bạn đã hiển thị thành công.");
                    break;
                case 9: 
                    System.out.println("Bạn đã chọn sinh viên được học bổng từ cao -> thấp.");
                    stdManage.scholarshipStudent();
                    System.out.println("Bạn đã hiển thị thành công.");
                    break;
                case 10: 
                    System.out.println("Bạn đã chọn hiển thị danh sách sinh viên.");
                    System.out.println("Danh sách sinh viên");
                    stdManage.displayStudent();
                    System.out.println("Bạn đã hiển thị thành công.");
                    break;
                case 11: 
                    System.out.println("Bạn đã chọn lưu vào file.");
                    stdManage.saveFile();
                    System.out.println("Bạn đã lưu thành công.");
                    break;
                case 12: 
                    System.out.println("Bạn đã chọn đọc nội dung từ file.");
                    stdManage.readFile();
                    System.out.println("Nội dung đã được đọc.");
                    break;
                case 0:
                    System.out.println("Bạn đã dừng chương trình.");
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 0 -> 10 !!!");
            }
            
        } while (choose != 0);
    }
    
    static void showMenu(){
        System.out.println("+++++++++++++++++++++++MENU++++++++++++++++++++++++++");
        System.out.println("+   1. Thêm Sinh Viên.                              +");
        System.out.println("+   2. Sửa Sinh Viên Theo Mã Sinh Viên.             +");
        System.out.println("+   3. Xóa Sinh Viên Theo Mã Sinh Viên.             +");
        System.out.println("+   4. Tìm Sinh Viên Theo Tên.                      +");
        System.out.println("+   5. Sắp Xếp Tăng Dần Theo Mã Sinh Viên.          +");
        System.out.println("+   6. Sắp Xếp Tăng Dần Theo Điểm.                  +");
        System.out.println("+   7. Sắp Xếp Theo Tên A - Z.                      +");
        System.out.println("+   8. Sinh Viên Có Điểm Cao Nhất & Thấp Nhất.      +");
        System.out.println("+   9. Sinh Viên Được Học Bổng Điểm Từ Cao -> Thấp. +");   
        System.out.println("+   10. Hiển Thị Thông Tin Sinh Viên.               +");
        System.out.println("+   11. Lưu Vào File student.txt                    +");
        System.out.println("+   12. Đọc Nội Dung Sinh Viên Từ student.txt       +");
        System.out.println("+   0. Thoát.                                       +");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+   Nhập lựa chọn:                                  +");
        
    }
}
