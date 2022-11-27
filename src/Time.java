public class Time {
    private int hour;
    private int minute;
    private int second;

    public int getHour(){
        return this.hour;
    }

    public int getMinute(){
        return this.minute;
    }

    public int getSecond(){
        return this.second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public Time(){}

    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(Time time) {
        this.setHour(time.getHour());
        this.setMinute(time.getMinute());
        this.setSecond(time.getSecond());
    }

    public int toSeconds(){
        return second+minute*60+hour*3600;
    }

//Dodawanie czasu
    public int addMinute (int minute) {
        this.minute += minute;
        int newMinute = this.minute % 60;
        hour = this.hour + this.minute/60;
        this.minute = newMinute;
        return newMinute;
    }

    public void addSecond (int second) {
        this.second += second;
        int newSecond = this.second % 60;
        int newMinute = this.second/60;
        minute = addMinute(newMinute);
        this.second = newSecond;
    }

    public boolean isBefore (Time time){
        if (this.toSeconds() > time.toSeconds())
           return false;
        else
            return true;
    }

    @Override
    public String toString() {
        return this.hour + ":" + this.minute + ":" + this.second;
    }

}
