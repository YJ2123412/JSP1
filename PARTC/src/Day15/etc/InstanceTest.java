package Day15.etc;

/**
 * InnerMyCalendar
 */
public class InstanceTest {

    public static void main(String[] args) {
        MyCalendar my = MyCalendar.getInstance();
       // MyCalendar my2 = new MyCalendar();
    }
    
}

class MyCalendar {
    private static MyCalendar object = new MyCalendar();

    private MyCalendar() {
    }

    public static MyCalendar getInstance(){
        return object;
    }

}
