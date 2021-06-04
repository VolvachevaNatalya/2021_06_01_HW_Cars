package cars;

public class ResultInfo {
    private String name;
    private long resultTime;

    public ResultInfo(String name, long resultTime) {
        this.name = name;
        this.resultTime = resultTime;
    }

    public String getName() {
        return name;
    }

    public long getResultTime() {
        return resultTime;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "name='" + name + '\'' +
                ", resultTime=" + resultTime +
                '}';
    }
}
