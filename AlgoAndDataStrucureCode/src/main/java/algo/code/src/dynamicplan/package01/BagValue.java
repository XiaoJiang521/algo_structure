package algo.code.src.dynamicplan.package01;

/*
 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表 i号物品的重量和价值。
 给定一个正数bag，表示一个载重bag的袋子， 你装的物品不能超过这个重量。 返回你能装下最多的价值是多少?
*/
public class BagValue {

    public static int getVBagMaxValue(int[] wights, int[] values, int bag) {
        return processMaxValue(wights, values, 0, bag);
    }

    /*
       wights 重量数组
       values 价值数组
       index 当前到达的数组位置
       rest 背包剩余容量
       return 能装下的最大价值
    */
    public static int processMaxValue(int[] wights, int[] values, int index, int rest) {

        if (rest < 0) {
            // 防止返回 0 造成背包超过容量,背包容量为 0 时可以继续，例如 重量  0 价值 20
            return -1;
        }
        int N = wights.length;
        if (index == N) {
            // index 已经超过 数组长度， 已经没有价值了 ，返回 0
            return 0;
        }
        // 两种情况，要当前index物品，不要当前index物品
        int p1 = processMaxValue(wights, values, index + 1, rest);
        int p2 = 0;
        int next = processMaxValue(wights, values, index + 1, rest - wights[index]);
        if (next != -1) {
            // index 的价值 + 下一个index位置，rest - wights[index]容量 可以拿到的最大价值
            p2 = values[index] + next;
        }
        return Math.max(p1, p2);
    }
}
