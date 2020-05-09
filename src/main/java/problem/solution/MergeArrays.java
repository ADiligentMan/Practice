package problem.solution;

import java.util.*;

/**
 * @Author: wangpeng
 * @Date: 2020-02-22 16:36
 * <p>
 * description:
 * 第一行一个数字N，之后每行全是数组A1 ,A2 ,A3...。
 * 把A1的前N个，把A2的前N 组成一个新的数组。最后一个数组处理完成后，再从第一个开始继续。
 * <p>
 * input:
 * 4
 * 3,4,42,22,123
 * 33,11,3,25
 * output:
 * 3,4,42,22,33,11,3,25,123
 *
 *
 * idea :
 *
 * 字符串裁剪与拼接
 */

public class MergeArrays {
    private List<String> stringList;
    private StringBuilder stringBuilder;

    public static void main(String[] args) {
        new MergeArrays().start();

    }

    public void start() {
        stringList = new LinkedList<>();
        stringBuilder = new StringBuilder();

        Scanner scan = new Scanner(System.in);

        System.out.println("enter");

        while (scan.hasNextLine()) {
            // initialize
            stringBuilder.delete(0, stringBuilder.length());
            stringList.clear();

            int fixedLength = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String eachArr;
                eachArr = scan.nextLine();
                stringList.add(eachArr);
            }

            System.out.println(concatenateAll(fixedLength));
        }


    }

    public String concatenateAll(int fixedLength) {
        List<Integer> indexEmpty = new LinkedList<>();

        int notEnoughLen = fixedLength * 2;
        int cutLen = fixedLength * 2;

        while (stringList.size() != 0) {
            indexEmpty.clear();
            for (int i = 0; i < stringList.size(); i++) {
                String eachStr = stringList.get(i);
                if (eachStr.length() < notEnoughLen) {
                    indexEmpty.add(i);
                    stringBuilder.append(eachStr).append(",");
                } else {
                    stringBuilder.append(eachStr.substring(0, cutLen));
                    stringList.set(i, eachStr.substring(cutLen));
                }
            }

            //删除
            if (!indexEmpty.isEmpty()) {
                for (int i = indexEmpty.size() - 1; i >= 0; i--) {
                    stringList.remove((int) indexEmpty.get(i));
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
