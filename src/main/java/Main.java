
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(new Main().parseLong("324732543"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long parseLong(String strLong) throws Exception {
        if (strLong == null || strLong.equals("")) {
            throw new Exception("input error.");
        }

        long result =   isLongStr(strLong);

        return result;
    }

    private long isLongStr(String strLong) throws Exception {
        long result = 0;
        char ch = strLong.charAt(0);
        int i = 0;
        if ( (ch == '+' || ch == '-')) {
            if (strLong.length() == 1) {
                throw new Exception("input error.");
            }
            i = 1;
        }

        for (; i < strLong.length(); i++) {
            ch = strLong.charAt(i);

            byte value = (byte) (ch - '0');
            if ((value <= ('9' - '0') && (value >= 0))) {
                result += value*Math.pow(10 , strLong.length() -i-1);
            } else {
               throw new Exception("input error.");
            }
        }

        if(strLong.charAt(0) == '-'){
            result = -result;
        }
        return result;
    }
}