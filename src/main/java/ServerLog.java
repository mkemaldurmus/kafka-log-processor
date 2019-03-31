public class ServerLog {
    private String timestamp, logLevel, cityName, detail;

    public ServerLog(String timestamp, String logLevel, String cityName, String detail) {
        this.timestamp = timestamp;
        this.logLevel = logLevel;
        this.cityName = cityName;
        this.detail = detail;
    }

    public ServerLog() {
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
