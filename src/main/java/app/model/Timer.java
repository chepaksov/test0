package app.model;

import java.time.LocalDateTime;

public class Timer extends Animal{

    private static  Timer timer = null;

    private Timer(){

    }
    public static Timer getInstance(){ // #3
        if(timer == null){		//если объект еще не создан
            timer = new Timer();	//создать новый объект
        }
        return timer;		// вернуть ранее созданный объект
    }




    private Long nanoTime = System.nanoTime();

    public Long getTime() {
        return nanoTime;
    }
}
