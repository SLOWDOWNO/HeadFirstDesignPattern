package observer;
//主题对象 实现Subject接口
import java.util.ArrayList;

public class WeatherData implements Subject
{
    private ArrayList<Observer> observers;//记录观察者
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData()
    {
        observers = new ArrayList<Observer>();
    }
    @Override
    public void registerObserver(Observer o)
    {
        observers.add(o);//当注册观察者时,加到ArrayList的后面
    }
    @Override
    public void removeObserver(Observer o)//取消注册,从Arraylist中删除
    {
        int i = observers.indexOf(o);
        if (i >= 0)
        {
            observers.remove(i);
        }
    }
    @Override
    public void notifyObservers()//把状态告诉每一个观察者
    {
        for (Observer observer : observers)
        {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged()//当气象站更新观测值,通知观察者
    {
        notifyObservers();
    }
    public void setMeasurements(float temperature, float humidity, float pressure)//可以利用这个方法测试布告板
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
