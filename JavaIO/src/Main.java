
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    private static boolean CheckNumberOfLine(List<String> list, FileModel fileModel) {
        int length = list.size();
        for(int i=0; i<length; i++) {
           if(list.get(i).length() > fileModel.getLengOfCharacterOfLine() && fileModel.isLengOfCharacter()) {
               try {
                   throw new CheckFile();
               } catch (CheckFile e) {
                    e.ErrorLimitCharacter();
               } finally {
                   return false;
               }
            }
        }
        return true;
    }
    
    public static void readFile() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file muốn đọc:(src/text.txt) ");     // src/text.txt
        String url = in.nextLine();
        System.out.print("Nhập số hàng cuối cùng muốn xem: ");
        int n = Integer.parseInt(in.nextLine());
        System.out.println("Giới hạn số lượng kí tự trên một dòng mà bạn muốn đọc(Nhập 0 để đọc vô hạn kí tự): ");
        System.out.println("Nhập 0: Đọc vô hạn ký tự trên một dòng");
        System.out.println("Nhập 1: Đọc 256 ký tự trên một dòng");
        System.out.print("Your choise: ");
        int lengOfCharacterOfLine = Integer.parseInt(in.nextLine());
        FileModel file = null;
        if(lengOfCharacterOfLine==0) 
            file = new FileModel(url, false);
        else if(lengOfCharacterOfLine==1)
            file = new FileModel(url);
        List<String> list = new ArrayList<String>();
        FileInputStream fileInput = null;
        BufferedReader bufferedReader = null;
        try {
            fileInput = new FileInputStream(file.getUrl());
            bufferedReader = new BufferedReader(new InputStreamReader(fileInput));
            String line = bufferedReader.readLine();
            int i=1;
            //doc so hang
            while(line!=null) {
                if(i>n) list.remove(0);
//                if(line.length() > file.getLengOfCharacterOfLine() && file.isLengOfCharacter()) {
//                    throw new CheckFile();
//                }
                list.add(line);
                line = bufferedReader.readLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
//        }  catch (CheckFile e) {
//            e.ErrorLimitCharacter();
        }  finally {
            fileInput.close();
            bufferedReader.close();
        }

        System.out.println("--------------------------------------------------------------------------");
        if(n<=list.size() && CheckNumberOfLine(list, file)) {
            int length = list.size();
            for(int i=0; i<length; i++) {
                System.out.println(list.get(i));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        readFile();
    }
}
