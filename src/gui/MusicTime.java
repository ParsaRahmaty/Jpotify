package gui;

public class MusicTime {
    private int second;
    private int minute;
    private int value;

    public MusicTime() {
        this.value = minute = second = 0;
    }

    public MusicTime(int value) {
        if (value >= 0) {
            this.value = value;
            minute = value / 60;
            second = value % 60;
        } else {
            this.value = minute = second = 0;
        }
    }

    public void setValue(int value) {
        if (value >= 0) {
            this.value = value;
            minute = value / 60;
            second = value % 60;
        } else {
            this.value = minute = second = 0;
        }
    }

    @Override
    public String toString() {
        if (second <= 9)
            return minute + ":0" + second;
        else
            return minute + ":" + second;
    }
}
