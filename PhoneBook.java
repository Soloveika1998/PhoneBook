import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PhoneBook{
    public static void addNumber(String name, int phone, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(name)) {
            map.get(name).add(phone);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(phone);
            map.put(name, list);
        }
    }
    public static void printPhoneBook(Map<String, ArrayList<Integer>> map){
        String key = "";
        ArrayList<Integer> listPrint = new ArrayList<>();
        Integer maxSize = 0;
        ArrayList<String> listName = new ArrayList<>();

        for (Integer i = 0; i < map.size(); i++) {
            for (var item : map.entrySet()) {
                if (listName.contains(item.getKey())) {
                    continue;
                }
                else if (item.getValue().size() > maxSize) {
                    maxSize = item.getValue().size();
                    key = item.getKey();
                    listPrint = item.getValue();
                }
            }
            listName.add(key);
            System.out.println(key + " = " + listPrint);
            maxSize = 0;
        }
    }
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Иванов", 1, bookPhone);
        addNumber("Петров", 1, bookPhone);
        addNumber("Сидоров", 1, bookPhone);
        addNumber("Сидоров", 2, bookPhone);
        addNumber("Сидоров", 3, bookPhone);
        addNumber("Петров", 2, bookPhone);

        printPhoneBook(bookPhone);
       }
}