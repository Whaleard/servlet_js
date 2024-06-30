package domain;

/**
 * @author Mr MC
 */
public enum WeekDay {
    /* Java为枚举类型提供了一些内置的方法，同时枚举常量也可以有自己的方法。
    此时要注意必须在枚举实例的最后一个成员后添加分号，而且必须先定义枚举实例。*/
    Mon("Monday", "星期一", "周一", 1),
    Tue("Tuesday", "星期二", "周二", 2),
    Wed("Wednesday", "星期三", "周三", 3),
    Thu("Thursday", "星期四", "周四", 4),
    Fri("Friday", "星期五", "周五", 5),
    Sat("Saturday", "星期六", "周六", 6),
    Sun("Sunday", "星期日", "周天", 7);

    private String englishName;
    private String chineseName;
    private String shortName;
    private Integer index;

    WeekDay(String englishName, String chineseName, String shortName, Integer index) {
        this.englishName = englishName;
        this.chineseName = chineseName;
        this.shortName = shortName;
        this.index = index;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
