package domain;

/**
 * @author Mr MC
 */
public enum WeekDay {
    /* JavaΪö�������ṩ��һЩ���õķ�����ͬʱö�ٳ���Ҳ�������Լ��ķ�����
    ��ʱҪע�������ö��ʵ�������һ����Ա����ӷֺţ����ұ����ȶ���ö��ʵ����*/
    Mon("Monday", "����һ", "��һ", 1),
    Tue("Tuesday", "���ڶ�", "�ܶ�", 2),
    Wed("Wednesday", "������", "����", 3),
    Thu("Thursday", "������", "����", 4),
    Fri("Friday", "������", "����", 5),
    Sat("Saturday", "������", "����", 6),
    Sun("Sunday", "������", "����", 7);

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
