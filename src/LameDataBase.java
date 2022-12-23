import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LameDataBase {
    public static String lameDb(String db, String op, String id, String data) {
        //db=1etsy#2wooden#3spoon
        String result = "";
        String[] array = db.split("#");
        //  System.out.println(Arrays.asList(array));//[1etsy, 2wooden, 3spoon]
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        //id is string that time i can turn char to string through""
        //("" + list.get(i).charAt(0)).equals(id) or//list.get(i).substring(0, 1)).equals(id)
        // or you can turn id to primitive via wrapper integerparse
        if (op.equals("add")) {
            if (list.size() <= (Integer.parseInt(id))) {//id=3 or more just add
                list.add(id + data);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if ((list.get(i).substring(0, 1)).equals(id)) {
                        list.add(Integer.parseInt(id) - 1, id + data);
                        break;
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).substring(1));//for removing firs chars numbers
            }
            for (int i = 0, j = 1; i < list.size(); i++, j++) {//j will add numbers
                if (i == 0) {//i=0 iken ilk kismi ekle
                    result += j + "" + list.get(i);//number varsa j ile addition olmasin
                } else {
                    result += "#" + j + list.get(i);
                }
            }
            return result;
        }

        if (op.equals("edit")) {
            list.set(Integer.parseInt(id)-1, id + data);
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    result += list.get(i);
                } else {
                    result += "#" + list.get(i);
                }

            }
            return result;
        }

        if (op.equals("delete")) {
            for (String each : list) {
                if (("" + each.charAt(0)).equals(id)) {
                    list.remove((Integer.parseInt(id)) - 1);
                    break;
                }
            }
        }
        if ((Integer.parseInt(id)) == 1) { //id=1 i=0 will be removed
            for (int i = 0; i < list.size(); i++) {

                result += "#" + list.get(i);
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {// i=0 dayken sadece 1etsy ekle
                    result += list.get(i);
                } else {//digerlerine#2aaa...
                    result += "#" + list.get(i);
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println(lameDb(in.next(), in.next(), in.next(), in.next()));

        in.close();
    }
}
