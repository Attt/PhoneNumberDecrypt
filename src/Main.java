import java.util.*;

public class Main {

    /** CONTAINS 0,2,4,6,8,3,1,5,7,9 **/
    private static char[][][] magicAlphabets= {
            {
                    {'Z','E','R','O'},
                    {'W','T','O'},
                    {'U','F','O','R'},
                    {'X','I','S'},
                    {'G','E','I','H','T'}
            },
            {
                    {'T','H','R','E','E'},
                    {'O','N','E'},
                    {'F','I','V','E'},
                    {'S','E','V','E','N'}
            },
            {
                    {'N','I','N','E'}
            }
    };

    private static Map<String,Integer> magicMap = new HashMap<>();
    static{
        magicMap.put("Z",0);
        magicMap.put("W",2);
        magicMap.put("U",4);
        magicMap.put("X",6);
        magicMap.put("G",8);
        magicMap.put("T",3);
        magicMap.put("O",1);
        magicMap.put("F",5);
        magicMap.put("S",7);
        magicMap.put("N",9);
    }

    private static List<Integer> numberList = new ArrayList<>();

    public static void main(String[] args) {
        //givashit();
        long starTime=System.currentTimeMillis();
        String[] argss = {"4","EIGHT","ZEROTWOONE","OHWETENRTEO","OHEWTIEGTHENRTEO"};

        giveashit(argss);
        long endTime=System.currentTimeMillis();
        long time=endTime-starTime;
        System.out.println("耗时："+time+"毫秒");
    }



    private static void giveashit(String[] args){

        int count = Integer.parseInt(args[0]);
        for(int i =1;i<=count;i++){
            holyshit(args[i]);
        }

    }

    private static void holyshit(String str){
        numberList = new ArrayList<>();
        String result = String.copyValueOf(str.toCharArray());
        for(char[][] magicAlphabet:magicAlphabets) {
            for (char[] magicAlpha : magicAlphabet) {
                result = replaceAll(result, magicAlpha);
            }
            if("".equals(result)){
                break;
            }
        }

        Integer[] resultNumbers = new Integer[numberList.size()];

        for(int i = 0;i < numberList.size();i++){
            Integer num = numberList.get(i)-8;
            if(num<0){
                num = num + 10;
            }
            resultNumbers[i] = num;
        }

        Arrays.sort(resultNumbers);
        StringBuffer sb = new StringBuffer();
        for(Integer num:resultNumbers){
            sb.append(num);
        }
        System.out.println(sb.toString());
    }

    private static boolean checkExist(char piece,String str){
        return str.contains(String.valueOf(piece));
    }

    private static String replaceAll(String str,char[] piece){
        if(checkExist(piece[0],str)){
            for(char p:piece) {
                str = str.replaceFirst(String.valueOf(p), "");
            }
            numberList.add(magicMap.get(String.valueOf(piece[0])));
            return replaceAll(str,piece);
        }else{
            return str;
        }
    }
}
