import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng học viên: ");
        int n = scanner.nextInt();

        List<String> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin học viên thứ " + (i + 1) + ":");
            System.out.print("Mã sinh viên: ");
            String maSV = scanner.next();
            System.out.print("Họ tên: ");
            String hoTen = scanner.next();
            System.out.print("Giới tính: ");
            String gioiTinh = scanner.next().toLowerCase();
            System.out.print("Điểm Python: ");
            double diemPython = scanner.nextDouble();
            System.out.print("Điểm Java: ");
            double diemJava = scanner.nextDouble();

            students.add((maSV + ","+ hoTen + ","+ gioiTinh + ","+ diemPython + ","+ diemJava));
        }

        try (PrintWriter writer = new PrintWriter("input.txt")) {
            for (String student : students) {
                writer.println(student.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Student> studentsFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                studentsFromFile.add(new Student(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        studentsFromFile.sort(Comparator.comparingDouble(Student::getAvg).reversed());

        System.out.println("Danh sách học viên sau khi sắp xếp:");
        try (PrintWriter writer = new PrintWriter("output.txt")) {
            for (Student student : studentsFromFile) {
                System.out.println(student);
                writer.println(student.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.print("Nhập họ tên học viên cần tìm: ");
        String searchName = scanner.next();

        boolean found = false;
        System.out.println("Danh sách học viên có họ tên \"" + searchName + "\":");
        for (Student student : studentsFromFile) {
            if (student.getName().equals(searchName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy học viên có họ tên \"" + searchName + "\".");
        }

        System.out.println("Danh sách học viên đã đậu:");
        for (Student student : studentsFromFile) {
            if (student.getResult().equals("Dau")) {
                System.out.println
                (student);
            }
        }

        System.out.println("Danh sách học viên đã trượt:");
        for (Student student : studentsFromFile) {
            if (student.getResult().equals("Truot")) {
                System.out.println(student);
            }
        }
        System.out.println("Danh sách học viên điểm tb > 8 ");
        for (Student student : studentsFromFile) {
            if (student.getAvg() > 8) {
                System.out.println(student);
            }
        }
    }}