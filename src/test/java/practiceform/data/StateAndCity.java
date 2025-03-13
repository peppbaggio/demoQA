package practiceform.data;

import java.util.HashMap;

import static practiceform.data.TestData.faker;

public class StateAndCity {

    //Создаем ассоциативный массив штатов и соответствующих городов
    private static HashMap<String, String[]> setStateAndCity() {

        HashMap<String, String[]> stateAndCity = new HashMap<>();

        stateAndCity.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        stateAndCity.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        stateAndCity.put("Haryana", new String[]{"Karnal", "Panipat"});
        stateAndCity.put("Radjasthan", new String[]{"Jaipur", "Jaiselmer"});
        return stateAndCity;
    }

    // штаты выносим в отдельный массив;
    private static String[] setStatesArray() {
        String[] states = new String[4];
        HashMap<String, String[]> stateAndCity = setStateAndCity();

        for (int i = 0; i < states.length; i++) {
            for (String key : stateAndCity.keySet()) {
                states[i] = key;
            }
        }
        return states;
    }

    /*faker'ом выбираем рэндомный штат, потом рэндомный из относящихся
    к штату городов, кладем штат и город в новый массив для
    дальнейшего использования*/

    public String[] getStateAndCity() {

        HashMap<String, String[]> stateAndCity = setStateAndCity();
        String[] states = setStatesArray();

        String[] cityInState = new String[2];

        String keyState = faker.options().nextElement(states);
        String valueCity = faker.options().nextElement((stateAndCity.get(keyState)));

        cityInState[0] = keyState;
        cityInState[1] = valueCity;

        return cityInState;
    }
}

