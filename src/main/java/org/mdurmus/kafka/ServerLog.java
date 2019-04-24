package org.mdurmus.kafka;

public class ServerLog {
    private String date;
    private String time;
    private String logLevel;
    private String cityName;
    private String detail;
    public ServerLog(String date, String time, String logLevel, String cityName, String detail) {
        this.date = date;
        this.time = time;
        this.logLevel = logLevel;
        this.cityName = cityName;
        this.detail = detail;
    }
    public ServerLog() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimestamp() {
        return getDate() + " " + getTime();
    }

    public ServerLog getServerLogFromString(String line) {
        String[] array = line.split(" ");
        return new ServerLog(array[0], array[1], array[2], array[3], array[4]);
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "org.mdurmus.kafka.ServerLog{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", cityName='" + cityName + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
