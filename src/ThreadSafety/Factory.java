package ThreadSafety;

public class Factory {

    //Provides differents objects to different threads

    private final ThreadLocal<Object> threadLocal;

    public Factory(){
        threadLocal=ThreadLocal.withInitial(Object::new);
    }

    public Object getObject(){
        return threadLocal.get();
    }
}
