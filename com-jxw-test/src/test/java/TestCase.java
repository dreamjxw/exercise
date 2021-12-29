import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author jiaxingwu
 * @Time 2018/12/27 16:44
 * @Description
 */
public class TestCase {
    /**
     * 比对两个文件  并输出相同的项
     * 参与比对的两个文件，必须是一项数据一行！！！   且文件必须是文本文件 以.txt结尾
     * 输出的文件也是.txt文件   每项均以换行分隔
     *
     * 不同结果文件-----即文件A中包含 文件B中不包含
     * 相同结果文件-----A,B文件中均包含
     *
     * @param args todo---每次使用时需要修改目标文件名称   结果文件会输出在桌面
     */
    public static void main(String[] args) {
        /*要比对的文件1的名称，不用写文件名后缀*/
        String file1Name = "8月";
        /*要比对的文件2的名称，不用写文件名后缀*/
        String file2Name = "9月";
        /*最终输出包含相同结果的文件名称，不用写文件名后缀*/
        String resultSameFileName = "resultSame";
        /*最终输出包含不同结果的文件名称，不用写文件名后缀*/
        String resultDiffFileName = "resultDiff";
        String desktopPath = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
        Set<String> strings8 = toArrayByRandomAccessFile(desktopPath + "\\" + file1Name + ".txt");
        Set<String> strings9 = toArrayByRandomAccessFile(desktopPath + "\\" + file2Name + ".txt");
        Set<String> resultSameSet = new HashSet<>();
        Set<String> resultDiffSet = new HashSet<>();
        strings8.forEach(t -> {
            if (strings9.contains(t)) {
                resultSameSet.add(t);
            } else {
                resultDiffSet.add(t);
            }
        });
        toFileByRandomAccessFile(desktopPath + "\\" + resultSameFileName + ".txt", resultSameSet);
        toFileByRandomAccessFile(desktopPath + "\\" + resultDiffFileName + ".txt", resultDiffSet);
        System.out.println("执行成功，共有" + resultSameSet.size() + "项");
    }

    private static void toFileByRandomAccessFile(String name, Set<String> set) {

        try {
            OutputStreamWriter fileW = new OutputStreamWriter(new FileOutputStream(new File(name)));
            fileW.write("当前文本共有" + set.size() + "项");
            fileW.write("\n");
            for (String s : set) {
                fileW.write(s);
                fileW.write("\n");
            }
            fileW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> toArrayByRandomAccessFile(String name) {
        Set<String> set = new HashSet<>();
        try {
            File file = new File(name);
            RandomAccessFile fileR = new RandomAccessFile(file, "r");
            String str;
            while ((str = fileR.readLine()) != null) {
                set.add(str);
            }
            fileR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }

}
