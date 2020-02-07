import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class KMeans {
    int N = 300; // 数据点个数
    int K = 3;// 分类数

    double[][] points = new double[N][2];// 数据点(2列分别表示x、y坐标)
    double[][] centers = new double[K][2];// 分类质心
    double[][] distances = new double[N][K];// 数据点到分类质心的距离
    int[] kinds = new int[N];// 数据点所属的分类

    JFrame win; // 用于呈现分类结果的窗口
    final int WIN_HEIGHT = 420;// 窗口高度
    final int WIN_WIDTH = 600;// 窗口宽度

    // 分类标记和颜色
    final String[] MARKER_TEXTS = { "X", "O", "＋" };
    final Color[] MARKER_COLORS = { Color.RED, Color.MAGENTA, Color.BLUE };

    // 围绕给定的K个点随机产生N个数据点
    void generatePoints() {
        // 给定K个点的坐标
        double[][] ps = { { 300, 50 }, { 480, 300 }, { 120, 200 } }; 
        Random r = new Random();// 随机数对象
        int p; 
        for (int i = 0; i < N; i++) {
            p = r.nextInt(K);// 随机选择一个给定的点
            // 围绕点p随机产生一个数据点
            points[i][0] = ps[p][0] + (r.nextBoolean() ? r.nextInt(100) : -r.nextInt(100));
            points[i][1] = ps[p][1] + (r.nextBoolean() ? r.nextInt(50) : -r.nextInt(50));
        }
    }

    // 选择K个数据点作为K个分类的初始质心
    void initCenters() {
        for (int i = 0; i < K; i++) {
            centers[i][0] = points[i * N / K][0];
            centers[i][1] = points[i * N / K][1];
        }
    }

    // 对每个数据点，按离其最近的质心进行分类
    void assignPoints() {
        double dx, dy;
        double min;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {// 计算点i到K个质心的距离
                dx = points[i][0] - centers[j][0];
                dy = points[i][1] - centers[j][1];
                distances[i][j] = dx * dx + dy * dy;
            }
            // 选择离其最近的质心作为点i所属的分类
            min = distances[i][0];
            kinds[i] = 0;
            for (int j = 1; j < K; j++) {
                if (distances[i][j] < min) {
                    min = distances[i][j];
                    kinds[i] = j;
                }
            }
        }
    }

    // 根据所有点的分类，计算新的质心
    void calcCenters() {
        for (int j = 0; j < K; j++) {
            centers[j][0] = 0;
            centers[j][1] = 0;
            int count = 0;
            // 统计属于分类j的点的个数
            for (int i = 0; i < N; i++) {
                if (kinds[i] == j) {
                    centers[j][0] += points[i][0];
                    centers[j][1] += points[i][1];
                    count++;
                }
            }
            // 计算分类j的质心坐标(x、y的算术均值——K-Means算法名称的由来)
            centers[j][0] /= count;
            centers[j][1] /= count;
        }
    }

    // 初始化UI(仅用于呈现结果)
    void initUI() {
        win = new JFrame("K-Means");
        win.setSize(WIN_WIDTH, WIN_HEIGHT);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setVisible(true);
    }

    // 绘制N个数据点及K个质心(仅用于呈现结果)
    void plot() {
        Graphics g = win.getGraphics();
        g.clearRect(0, 0, WIN_WIDTH, WIN_HEIGHT);// 清除之前绘制的点
        // 以不同标记和颜色绘制各分类中的点
        for (int i = 0; i < N; i++) {
            g.setColor(MARKER_COLORS[kinds[i]]);
            g.drawString(MARKER_TEXTS[kinds[i]], (int) points[i][0], (int) (WIN_HEIGHT - 20 - points[i][1]));
        }
        // 绘制各分类的质心
        for (int i = 0; i < K; i++) {
            g.setColor(Color.BLACK);
            g.drawString("★", (int) centers[i][0], (int) (WIN_HEIGHT - 20 - centers[i][1]));
        }
    }

    // 程序入口
    public static void main(String[] args) throws InterruptedException {
        KMeans kMeans = new KMeans();
        kMeans.generatePoints();
        kMeans.initCenters();
        kMeans.initUI();

        for (int i = 0; i < 10; i++) { // 迭代10次
            kMeans.plot();
            kMeans.assignPoints();
            kMeans.calcCenters();
            Thread.sleep(500); // 暂停0.5秒(便于观察迭代过程)
        }
    }
}
