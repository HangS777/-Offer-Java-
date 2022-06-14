

class Q02_Singleton {
    // 题目描述
    // 设计一个类，我们只能生成该类的一个实例。

    // 私有静态变量
    private static volatile Q02_Singleton singleton;

    private Q02_Singleton() {
    }

    // 双重校验锁，线程安全
    // 加同步锁前后两次判断实例是否已存在
    // 缩小的同步代码块
    public static Q02_Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Q02_Singleton.class) {
                if (singleton == null) {
                    singleton = new Q02_Singleton();
                }
            }
        }
        return singleton;
    }
}

