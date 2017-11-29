package test;

/**
 * Created by 黎 on 2017/11/19.
 */
public class Test3  {
    private static Test3  test3 = null;
    private Test3(){}
    public static synchronized Test3 getTest3(){
        if(null == test3){
            test3 = new Test3();
        }
        return test3;
    }
}
