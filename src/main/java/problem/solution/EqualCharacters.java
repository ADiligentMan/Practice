import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangpeng
 * @Date: 2020-02-28 11:56
 *
 * 判断连个连个字符串是否相同(不考虑顺序, 即一个可以另一个经过某种排列而形成)
 * 字符只含有ASCII字符
 */
public class EqualCharacters {

    //判断由大小写字母组成的两个字符串a ,b 是否相同(不考虑顺序)
    public static boolean compareStringBytes(String a,String b){

        //ascii 0XXXXXXX so byte为正数
        byte[] b1 = a.getBytes();
        byte[] b2 = b.getBytes();

        int[] bCount = new int[127];
        for(int i=0;i<127;i++){
            bCount[i] = 0;
        }
        for(int i=0;i<b1.length;i++)
            bCount[b1[i]]++;
        for(int i=0;i<b2.length;i++)
            bCount[b2[i]]--;
        for(int i=0;i<127;i++){
            if(bCount[i]!=0)
                return false;
        }
        return true;
    }

    //判断由大小写字母组成的两个字符串a ,b 是否相同(不考虑顺序)
    public static boolean compareStringMap(String self,String sibling){
        Map<Short,Integer> map = new HashMap<>();
        char [] chars = new char[self.length() > sibling.length() ? self.length() : sibling.length()];
        self.getChars(0,self.length(),chars,0);
        for(int i = 0 ; i< self.length() ; i++){

            Integer count = map.get((short)chars[i]);
            if(count == null){
                count = 1;
            }else{
                count++;
            }
            map.put((short)chars[i],count);
        }

        sibling.getChars(0,sibling.length(),chars,0);
        for(int i = 0 ; i< sibling.length() ; i++){

            Integer count = map.get((short)chars[i]);
            if(count == null){
                return false;
            }else{
                count--;
            }

            if(count == 0 ){
                map.remove((short)chars[i]);
            }else{
                map.put((short)chars[i],count);
            }

        }
        return map.isEmpty();
    }

    public static void main(String[] args) {

        long a =  System.currentTimeMillis();
        System.out.println(compareStringBytes("aabc","abac"));
        long b  = System.currentTimeMillis();
        System.out.println(compareStringMap("caab","acba"));
        long c  = System.currentTimeMillis();
        System.out.println("b-a : "+(b-a));
        System.out.println("c-b : "+(c-b));

    }
}
