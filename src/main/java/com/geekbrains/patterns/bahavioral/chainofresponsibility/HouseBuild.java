package com.geekbrains.patterns.bahavioral.chainofresponsibility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HouseBuild {
    private final Set steps = new HashSet();

    public HouseBuild(Steps... steps) {
        this.steps.addAll(Arrays.asList(steps));
    }

    public enum Steps {
        CREATE_BASEMENT,
        CREATE_FLOOR,
        CREATE_ROOF,
        CREATE_FENCE
    }
    public Set getSteps() {
        return steps;
    }
}

