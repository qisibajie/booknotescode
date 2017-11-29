package kata.mockito.service.impl;

import kata.mockito.service.Service;

public class DefaultService implements Service {
    @Override
    public int getAge() {
        return 100;
    }

    @Override
    public String getName() {
        return "SERVICE";
    }
}
