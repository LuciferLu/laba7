public class Car implements Runnable{
    private static int CARS_COUNT;
    static { CARS_COUNT = 0; }
    private static int CAR_WIN;
    static { CAR_WIN = 0; }
    private Race race;
    private int speed;
    private String name;
    MainClass t = new MainClass();
    public String getName () { return name; }
    public int getSpeed () { return speed; }
    public Car (Race race, int speed) {
        this .race = race;
        this .speed = speed;
        CARS_COUNT++;
        this .name = "Участник #" + CARS_COUNT;

    }
    public void run ()
    {

        try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int) (Math.random() * 800));
                System.out.println(this.name + " готов" + " Время: " + (System.currentTimeMillis() - t.getTime() ) );
                MainClass.cd.countDown();
                MainClass.cb.await();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        for ( int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go( this );
        }
        CAR_WIN++;
        if (CAR_WIN == 1) System.out.println( this .name + " WIN" + " Время: " + (System.currentTimeMillis() - t.getTime() ));
        MainClass.cd1.countDown();
    }
}