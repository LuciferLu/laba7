import org.jetbrains.annotations.NotNull;

public class Road extends Stage{
    MainClass t = new MainClass();
    public Road (int length) {
        this .length = length;
        this .description = "Дорога " + length + " метров" ;
}
public void go (Car c) {
    try {
        System.out.println(c.getName() + " начал этап: " + description + " Время: " + (System.currentTimeMillis() - t.getTime()));
        Thread.sleep(length / c.getSpeed() * 1000L);
        System.out.println(c.getName() + " закончил этап: " + description + " Время: " + (System.currentTimeMillis() - t.getTime()));
    }
    catch (InterruptedException e) {
        e.printStackTrace();
        }
    }
}

