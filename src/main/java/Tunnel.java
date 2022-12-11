public class Tunnel extends Stage{
    MainClass t = new MainClass();
    public Tunnel () {
        this .length = 80;
        this .description = "Тоннель " + length + " метров" ;
    }
     public void go (Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                MainClass.smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description + " Время: " + (System.currentTimeMillis() - t.getTime()));
                Thread.sleep(length / c.getSpeed() * 1000);
                MainClass.smp.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description + " Время: " + (System.currentTimeMillis() - t.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}