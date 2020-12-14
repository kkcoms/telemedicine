package com.medical.telemedicine.interfaces;



public interface ContextualModeInteractor {
    void enableContextualMode();

    boolean isContextualMode();

    void updateSelectedCount(int count);
}
