import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: wangpeng
 * @Date: 2020-02-22 14:46
 */

public class JunitTest {
    @Test
    public void ScannerTest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.hasNextLine());
        String line= scanner.nextLine();
        line.trim();
        if(line == null ){
            System.out.println("obj is null");
        }

        if(line .equals("")){
            System.out.println("line is empty");
        }
    }

    @Test
    public void PatternTest(){
        Pattern pattern = Pattern.compile("[AWSD]{1}[0-9]{1,2}");


        Matcher matcher = pattern.matcher("eeeA12wew");
        matcher.matches();//entire string

        if(matcher.find()){//
            System.out.println("匹配！");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println(matcher.group());;
        }
    }

    @Test
    public void nextLineTesting(){
        Scanner scanner = new Scanner(System.in);
    }

    @Test
    public void arraysSort(){

    }

    public static void main(String[] args) {
        while (true) {
            byte[] bytes = new byte[10];
            int readNum = 0;
            try {
                readNum = System.in.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.arraycopy(bytes,0,bytes ,0,0);

            for (int i = 0; i < readNum; i++) {
                String binary = Integer.toBinaryString(bytes[i]);
                System.out.println(binary.length() == 32 ? binary.substring(24, 32) : binary);
            }

            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            byte[] bytes1 = next.getBytes();
            System.out.println("length:" + bytes1.length);
            char[] chars = new char[next.length()];
            next.getChars(0, next.length(), chars, 0);

            for (int i = 0; i < chars.length; i++) {
                String binary = Integer.toBinaryString(chars[i]);
                System.out.println(binary.length() == 32 ? binary.substring(24, 32) : binary);
                System.out.println((short) chars[i]);
                System.out.println((byte) chars[i]);
            }


        }

    }

}
