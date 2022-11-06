package binary_tree;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        HashSet<String> set = new HashSet<>();
        BinaryNode root = null;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            String str;
            while((str = bf.readLine()) != null) {
                List<String> words = cleanLine(str);
                for (String word : words) {
                    if (set.contains(word)) {
                        continue;
                    }
                    else {
                        set.add(word);
                        /**
                         * 核心函数
                         */
                        if(root == null) {
                            root = new BinaryNode(word);
                        }
                        else {
                            root.insert(root,word);
                        }

                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        root.print(root);

    }


    /**
     * 对每个句子去掉标点符号
     * @param str
     * @return
     */
    private static List<String> cleanLine(String str) {
        String[] splitString = str.split(" ");
        List<String> list = new ArrayList<>();
        for (String word: splitString) {
            String[] noPuncationWords = word.split("[,?.'!:;~(){}]");
            for (String cleanWord : noPuncationWords) {
                list.add(cleanWord.toLowerCase());
            }
        }
        return list;
    }
}
