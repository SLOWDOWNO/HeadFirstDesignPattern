package observer;
//目前状态布告板 显示当前观测值
//实现了观察者接口和展示元素接口
public class CurrentConditionsDisplay implements Observer, DisplayElement
{
    private float temperature;
    private float humidity;
    private Subject weatherData;//用weatherData对象显示当前观测值

    //构造器要weatherData对象
    public CurrentConditionsDisplay(Subject weatherData)
    {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);//告诉主题 注册成为了观察者
    }
    @Override
    public void update(float temperature, float humidity, float pressure)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
    @Override
    public void display()
    {
        //显示最近的温度和湿度
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
