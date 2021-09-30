
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hieub
 */



public class Main {
    
//    private static boolean CheckNumberOfLine(List<String> list, FileModel fileModel) {
//        int length = list.size();
//        for(int i=0; i<length; i++) {
//           if(list.get(i).length() > fileModel.getLengOfCharacterOfLine() && fileModel.isLengOfCharacter()) {
//               try {
//                   throw new CheckFile();
//               } catch (CheckFile e) {
//                    e.ErrorLimitCharacter();
//               } finally {
//                   return false;
//               }
//            }
//        }
//        return true;
//    }
    
    public static FileModel nhapThongTin(String url) {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhập số hàng cuối cùng muốn xem: ");
        int n = Integer.parseInt(in.nextLine());
        System.out.println("Giới hạn số lượng kí tự trên một dòng mà bạn muốn đọc(Nhập 0 để đọc vô hạn kí tự): ");
        System.out.println("Nhập 0: Đọc vô hạn ký tự trên một dòng");
        System.out.println("Nhập 1: Đọc 256 ký tự trên một dòng");
        System.out.print("Your choise: ");
        int lengOfCharacterOfLine = Integer.parseInt(in.nextLine());
        FileModel fileModel = null;
        while(lengOfCharacterOfLine!=0 && lengOfCharacterOfLine!=1) {
            System.out.println("Nhập sai!! Vui lòng nhập lại:");
            System.out.print("Your choise: ");
            lengOfCharacterOfLine = Integer.parseInt(in.nextLine());
        }
        if(lengOfCharacterOfLine==0) 
            fileModel = new FileModel(url, false, n);
        else
            fileModel = new FileModel(url, true, n);
        return fileModel;
    }
    
    public static void readFile() throws IOException {
        String url = "src/text.txt";
        FileModel fileModel = nhapThongTin(url);
        File file = new File(url);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        
        int point = (int) raf.length()-1;
        raf.seek(point);
        List<Character> ansList = new ArrayList<>();
        int line = fileModel.getLine();
        int numberOfLine = 0;
        boolean checkNumberCharactorOfLine = fileModel.getLengOfCharacterOfLine()==256 ? true : false;
        int numberOfSpace = 0;
        while(numberOfLine<line) {
            int data = raf.read();
            ansList.add((char)data);
            raf.seek(--point);
            if(data==32) numberOfSpace++;       // Dau space
            if(data==10) numberOfLine++;        // Dau \n
            if(numberOfSpace==255 && checkNumberCharactorOfLine) {
                System.out.println("Dòng thứ " + (numberOfLine+1) + " từ dưới lên vượt quá ký tự");
                return;
            }
        }
        
        System.out.println("--------------------------------------------------------------------------");
        for(int i=ansList.size()-1; i>=0; i--) {
            System.out.print(ansList.get(i));
        }
    }
    
    public static void writeFile() throws IOException {
        File file = new File("src/text.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        for(int i=1; i<=10000000; i+=10) {
            for(int j=i; j<=i+10; j++) {
                write.write(j + " ");
            }
            write.write("\n");
        }
        write.close();
    }

    public static void main(String[] args) throws IOException {
        //writeFile();
        readFile();
        System.out.println("");
    }
}
