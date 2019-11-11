package lab.spring.io.core.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public String findNameById(Integer id) {
        String name = "Anonymous";
        if (id != null && id == 1) {
            name = "INAM";
        }
        return name;
    }
}
