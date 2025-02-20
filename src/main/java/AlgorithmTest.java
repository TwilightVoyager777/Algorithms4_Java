import edu.princeton.cs.algs4.In;

public class AlgorithmTest {
    public static void main(String[] args) {
        // 获取 resources 目录中的文件路径
        String filePath = AlgorithmTest.class.getClassLoader().getResource("algs4-data/largeT.txt").getPath();
        if (filePath == null) {
            System.out.println("文件未找到！");
            return;
        }

        // 创建 In 对象来读取数据文件
        In in = new In(filePath);

        // 读取文件内容并打印前几个行
        if (in.exists()) {
            System.out.println("文件内容预览：");
            for (int i = 0; i < 5; i++) {
                if (!in.isEmpty()) {
                    System.out.println(in.readLine());
                }
            }
        } else {
            System.out.println("文件没有找到！");
        }

        // 关闭输入流
        in.close();
    }
}
