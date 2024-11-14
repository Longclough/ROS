package com.baesystems.midas.listeners;

public class OptionsListeners extends Listeners<IOptionsListener> implements IOptionsListener {
    private static OptionsListeners instance;

    public static OptionsListeners getInstance() {
        if (instance == null) {
            instance = new OptionsListeners();
        }
        return instance;
    }

    @Override
    public void optionCreated(String group, String option) {
        for (IOptionsListener listener : listeners) {
            listener.optionCreated(group, option);
        }
    }
}
