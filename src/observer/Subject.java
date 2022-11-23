package observer;
//主题接口 气象站提供的WeatherData需要实现它
public interface Subject
{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
