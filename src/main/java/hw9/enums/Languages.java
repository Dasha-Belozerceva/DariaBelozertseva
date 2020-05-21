package hw9.enums;

public enum Languages {
    EN("en"),
    RU("ru"),
    UK("uk"),
    EN_RU("en, ru"),
    EN_RU_UK("en, ru, uk"),
    INVALID_LANG("JJKHKJH");

    public String lang;

    Languages(String lang){
        this.lang = lang;
    }

    public String getLang(){
        return this.lang;
    }
}
