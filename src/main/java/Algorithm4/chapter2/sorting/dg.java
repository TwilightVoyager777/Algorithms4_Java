package Algorithm4.chapter2.sorting;

public class dg {

        public static void main(String[] args) {
            calculateBalls(42, 23, 43); //这里输入具体球数
        }

        private static void calculateBalls(int red, int yellow, int blue) {
            int totalBalls = red + yellow + blue;  //这里计算总数

            if (totalBalls < 3 || !canContinue(red, yellow, blue)) { //题目条件 如果取到不能再取就输出结果 即总球数<3
                System.out.println("结束时袋中各颜色球的数量为：");
                System.out.println("红球：" + red);
                System.out.println("黄球：" + yellow);
                System.out.println("蓝球：" + blue);
                return;
            }
            //下面if开始一个个遍历迭代 递归重头戏
            if (red >= 2 && yellow >= 1) {  //分别列举可能性 1.取2红1黄
                calculateBalls(red - 2, yellow, blue); //红球留着 黄球放回 那么就剩下red - 2 + yellow + blue个球继续取球了
            } else if (red >= 2 && blue >= 1) {
                calculateBalls(red - 2, yellow, blue); //这些同理
            } else if (yellow >= 2 && red >= 1) {
                calculateBalls(red, yellow - 2, blue);
            } else if (yellow >= 2 && blue >= 1) {
                calculateBalls(red, yellow - 2, blue);
            } else if (blue >= 2 && red >= 1) {
                calculateBalls(red, yellow, blue - 2);
            } else if (blue >= 2 && yellow >= 1) {
                calculateBalls(red, yellow, blue - 2);
            }
            else if (red >= 1 && yellow >= 1 && blue >= 1) { //最后一组条件 三个球颜色各不相同 放回黄色 即red少了1，blue少了1
                calculateBalls(red - 1, yellow, blue - 1);
            }
        }

        private static boolean canContinue(int red, int yellow, int blue) { //判断是否能继续取球 这几个条件缺一不可 缺一即不能完成取球操作
            if (red >= 2 && (yellow >= 1 || blue >= 1)) return true;
            if (yellow >= 2 && (red >= 1 || blue >= 1)) return true;
            if (blue >= 2 && (red >= 1 || yellow >= 1)) return true;
            if (red >= 1 && yellow >= 1 && blue >= 1) return true;
            return false;
        }

}
