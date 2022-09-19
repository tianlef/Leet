package multi_thread;

/**
 * 银行账户
 */

public class BankAccount {
    private int id;

    private volatile double money;

    public BankAccount() {
    }

    public synchronized void withdrawMoney(double drawMoney) {
        String name = Thread.currentThread().getName();
        //synchronized (this) {
            if (this.getMoney() >= drawMoney) {
                System.out.println(name+"来取钱"+"取出"+drawMoney+"元");
                this.money -= drawMoney;
                System.out.println(name+"取完还剩下"+this.money+"元");
            }
            else {
                System.out.println(name+"来取钱，但是余额不足");
            }
        //}
    }

    public BankAccount(int id, double money) {
        this.id = id;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }



}
