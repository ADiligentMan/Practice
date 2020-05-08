import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wangpeng
 * @Date: 2020-03-11 22:18
 *
 * 最长会问序列
 */
public class LongestPalindrome {
    List<Palindrome> list = new LinkedList<Palindrome>();
    public String longestPalindrome(String s) {

        if(s.length() < 3){
            if(s.length() == 2 && s.charAt(0)== s.charAt(1)){
                return  s;
            }else if (s.length() > 0){
                return  s.substring(0,1);
            }else{
                return s;
            }
        }
        char [] chars = s.toCharArray();

        int tmpBoundary = chars.length - 2;
        int i = 0 ;
        for( ; i< tmpBoundary; i++){
            Palindrome p ;
            if(chars[i] == chars[i+2]){
                p = new Palindrome(i,i+2);
                list.add(p);
            }
            if( chars[i] == chars[i+1]){
                p = new Palindrome(i, i+1);
                list.add(p);
            }
        }
        //最后两个的情况没有算
        if(chars[i] == chars[i+1]){
            Palindrome p  = new Palindrome(i, i+1);
            list.add(p);
        }

        Palindrome maxp = new Palindrome(0,0);
        int maxIndex = chars.length - 1;

        while(!list.isEmpty()){
            Iterator<Palindrome> it = list.iterator();
            while(it.hasNext()){
                Palindrome p = it.next();
                // 边界处理 或者 无法向前向后扩展
                if((p.l == 0 || p.h  == maxIndex) || chars[p.l - 1] != chars[p.h + 1]){
                    if(p.length() > maxp.length()){
                        maxp = p;
                    }
                    it.remove();

                    // 向前向后各增加一个字符
                }else if(chars[p.l - 1] == chars[p.h + 1]){
                    p.update(p.l - 1,p.h +1);
                }
            }
        }

        return  new String(chars,maxp.l, maxp.length());
    }


    private class Palindrome{
        int l;
        int h;
        public int length(){
            return (h -l + 1);
        }

        public Palindrome(int l , int h){
            this.l = l;
            this.h = h;
        }

        public void update(int l , int h ){
            this.l = l;
            this.h = h;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("aaaa"));
    }
}
