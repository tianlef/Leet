package multi_thread;

public class SaveWithdrawMoneySynchronized {

    public static void main(String[] args) {
        /**
         * 生成一个我的账户
         */
        BankAccount myBank = new BankAccount(1,1000.0);

        Thread withdraw1 = new Thread(() -> myBank.withdrawMoney(100),"XiaoMing");

        Thread withdraw2 = new Thread(() -> myBank.withdrawMoney(300),"XiaoLe");

        withdraw1.start();
        /**
         * 不需要直接调用run函数
         * 会引起main线程运行次
         */
        //withdraw1.run();

        withdraw2.start();
        //withdraw2.run();



    }
}
