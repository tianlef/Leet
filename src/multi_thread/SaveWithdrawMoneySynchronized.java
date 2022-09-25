package multi_thread;

import java.util.concurrent.Executor;

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
         *
         * 只有start方法可以启动一个线程，run方法不能启动一个线程
         * start方法可以不执行完run方法就执行下面的方法，run方法不行
         * start执行了多线程，run不可以
         */
        //withdraw1.run();

        withdraw2.start();
        //withdraw2.run();





    }
}
