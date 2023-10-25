public class TheClock {

    int tempo = 0;

    int timer = 0;
    int uSegundo = 0, dSegundo = 0;
    int uMinuto = 0, dMinuto = 0;
    int uHora = 0, dHora = 0;

    TheClock(){
    }

    public void createClock(){
        timer++;
        if(timer == 60){
            uSegundo++;
            if(uSegundo == 10){
                uSegundo = 0;
                dSegundo++;
            }
            if(dSegundo == 6){
                dSegundo = 0;
                uMinuto++;
            }
            if(uMinuto == 10){
                uMinuto = 0;
                dMinuto++;
            }
            if(dMinuto == 6){
                dMinuto = 0;
                uHora++;
            }
            if(uHora == 10){
                uHora = 0;
                dHora++;
            }
            timer = 0;
        }
    }

    public void showClock(){
        tempo++;
        if(tempo == 60){
            System.out.printf("%d%d:%d%d:%d%d\n", dHora, uHora, dMinuto, uMinuto, 
                dSegundo, uSegundo);
            tempo = 0;
        }
    }

    public void resetClock(){
        tempo = 0;
        timer = 0;
        uSegundo = 0;
        dSegundo = 0;
        uMinuto = 0;
        dMinuto = 0;
        uHora = 0;
        dHora = 0;
    }

}
