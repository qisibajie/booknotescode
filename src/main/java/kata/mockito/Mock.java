package kata.mockito;

import kata.mockito.service.Service;
import kata.mockito.service.impl.DefaultService;

public class Mock {

    public int getTotalAge() {
        Service service = new DefaultService();
        return service.getAge();
    }
}
