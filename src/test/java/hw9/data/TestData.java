package hw9.data;

class TestData {

    static final String[] CORRECT_EN_SENTENCE = {"I am fine"};
    static final String[] CORRECT_RU_SENTENCE = {"Мне очень хорошо"};
    static final String[] CORRECT_UK_SENTENCE = {"я в порядку"};

    static final String[] CORRECT_TEXTS1 = {"I am fine", "Мне очень хорошо", "я в порядку"};
    static final String[] CORRECT_TEXTS2 = {"It is okay", "Я хочу спать"};
    static final String[] CORRECT_TEXTS3 = {"It is so sunny day"};

    static final String[] INCORRECT_ENGLISH_SENTENCE = {"I luve you so much"};
    static final String[] INCORRECT_RUSSIAN_SENTENCE = {"Я съела вкусьную булку с маком"};
    static final String[] INCORRECT_UK_SENTENCE = {"я люgлю тебе дуже сильно"};


    static final String CORRECT_VERSION_OF_RUSSIAN_SENTENCE = "вкусную";
    static final String CORRECT_VERSION_OF_ENGLISH_SENTENCE = "love";
    static final String CORRECT_VERSION_OF_INCORRECT_UK_SENTENCE = "люблю";

    static final String[] RU_WORD_WITH_DIGITS = {"да4а"};
    static final String[] EN_WORDS_WITH_DIGITS = {"0bvious"};
    static final String[] UK_WORDS_WITH_DIGITS = {"дів4ина"};
    static final String RU_WORD_WITHOUT_DIGITS = "дача";
    static final String EN_WORDS_WITHOUT_DIGITS = "obvious";
    static final String UK_WORDS_WITHOUT_DIGITS = "дівчина";

    static final String[] FEW_LANGUAGES_CASE1 = {"catкошка"};
    static final String[] FEW_LANGUAGES_CASE2 = {"приветhello"};
    static final String[] FEW_LANGUAGES_CASE3 = {"мирworld"};
    static final String[] FEW_LANGUAGES_CASE4 = {"девушкаgirl"};
    static final String FEW_LANGUAGES_SEPARATED_CASE1 = "cat кошка";
    static final String FEW_LANGUAGES_SEPARATED_CASE2 = "привет hello";
    static final String FEW_LANGUAGES_SEPARATED_CASE3 = "мир world";
    static final String FEW_LANGUAGES_SEPARATED_CASE4 = "девушка girl";

    static final String[] REPEAT_WORD_ENG = {"I love love you so much"};
    static final String[] REPEAT_WORD_RU = {"Я люблю люблю тебя так сильно"};
    static final String[] REPEAT_WORD_UK = {"я люблю тебе тебе дуже сильно"};
    static final String LIGHT_ENG_WORDS = "love";
    static final String LIGHT_RU_WORD = "люблю";
    static final String LIGHT_UK_WORD = "тебе";

    static final String[] WRONG_CAPITALIZATION_EN = {"lONDON is the capital of bRITAIN"};
    static final String[] WRONG_CAPITALIZATION_RU = {"мОСКВА столица рОССИИ"};
    static final String[] WRONG_CAPITALIZATION_UK = {"кИїв - столиця уКраїни"};
    static final String[] RIGHT_EN_CAPITALIZATION_WORDS = {"London", "Britain"};
    static final String[] RIGHT_RU_CAPITALIZATION_WORDS = {"Москва", "России"};
    static final String[] RIGHT_UK_CAPITALIZATION_WORDS = {"Київ", "України"};

    static final String[] SENTENCE_WITH_URL_EN = {"I want to work in google.com"};
    static final String[] SENTENCE_WITH_URL_RU = {"Я готовлюсь к экзаменам на сайте reshuege.ru"};
    static final String[] SENTENCE_WITH_URL_UK = {"Я беру українські слова на translate.google.com"};

    static final String INVALID_LANG_EXPECTED_MESSAGE = "SpellService: Invalid parameter 'lang'";
}
