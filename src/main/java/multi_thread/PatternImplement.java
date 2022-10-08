package multi_thread;

public class PatternImplement<T extends Number> implements PatternInterface<T>{
    private T var;
    public void setVar(T var) {
        this.var = var;
    }
    @Override
    public T getVar() {
        return this.var;
    }
    public <T> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException {
        T t = c.newInstance();
        return t;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        PatternImplement patternImplement = new PatternImplement();
        Object obj = patternImplement.getObject(Class.forName("Tree.TreeNode"));
    }

    public static void fun(Pattern<? super String> temp) {
        System.out.println(temp);
    }
}
