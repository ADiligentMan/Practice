
import java.util.*;


/**
 * @Author: wangpeng
 * @Date: 2020-02-22 13:58
 */

public class SiblingWord{
    public static void main(String [] args){
        new SiblingWord().start();
    }

    public void start(){
        Map<Integer, List<String>> lengthMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            lengthMap.clear();
            String [] strings = scanner.nextLine().split(" ");
            int wordNum = Integer.valueOf(strings[0]);
            for(int i = 1; i <= wordNum; i++){
                String word = strings[i];
                List<String> list = lengthMap.get(word.length());
                if(null == list){
                    list = new ArrayList<>();
                    list.add(word);
                    lengthMap.put(word.length(),list);
                }else{
                    list.add(word);
                }
            }
            String srcWord = strings[strings.length-2];
            int ordering = Integer.valueOf(strings[strings.length-1]);
            List<String> wordLengthEqual = lengthMap.get(srcWord.length());
            Collections.sort(wordLengthEqual);
            countSiblingAndGetFirst(srcWord,ordering,wordLengthEqual);
        }
    }

    private void countSiblingAndGetFirst(String srcWord,int ordering ,List<String> wordLengthEqual){
        String  orderingWord = "";
        int count = 0;
        int length = wordLengthEqual.size();
        int i = 0;
        for(i = 0; i< length ; i++ ){
            if(isSibling(srcWord,wordLengthEqual.get(i))){
                count++;
                if(count == ordering){
                    orderingWord = wordLengthEqual.get(i);
                }
            }
        }
        System.out.println(count);
        if(!orderingWord.equals("")){
            System.out.println(orderingWord);
        }

    }

    private boolean isSibling(String self , String sibling){
        // isn't itself sibling
        if(self.equals(sibling)){
            return false;
        }
        // lengths is not equal
        if(self.length() != sibling.length()){
            return false;
        }

        Map<Character,Integer> map = new HashMap<>();
        int lengthSelf = self.length();
        int lengthSibling = sibling.length();
        char [] chars = new char[Math.max(lengthSelf,lengthSibling)];
        self.getChars(0,lengthSelf, chars, 0);
        //count for each  chars in string self
        for(int i = 0 ; i < lengthSelf ; i++){
            if(map.containsKey(chars[i])){
                Integer count = 1 + map.get(chars[i]);
                map.put(chars[i],count);
            }else{
                map.put(chars[i],1);
            }
        }

        //subtract number of each char in sibling
        sibling.getChars(0,lengthSibling, chars, 0);
        for(int i = 0 ; i < lengthSibling ; i++ ){
            boolean isContains = map.containsKey(chars[i]);
            if(!isContains){
                return false;
            }else if(map.get(chars[i]) != 1){
                map.put(chars[i],map.get(chars[i])-1);
            }else {
                map.remove(chars[i]);
            }
        }

        return map.isEmpty();
    }

}
