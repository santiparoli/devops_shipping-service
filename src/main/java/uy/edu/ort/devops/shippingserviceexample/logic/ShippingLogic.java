package uy.edu.ort.devops.shippingserviceexample.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uy.edu.ort.devops.shippingserviceexample.domain.Shipping;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShippingLogic {
    private static Logger logger = LoggerFactory.getLogger(ShippingLogic.class);

    private Map<String, Shipping> testShipping;

    public ShippingLogic() {
        testShipping = new HashMap<>();
        testShipping.put("a", new Shipping("Delivered", "a"));
        testShipping.put("b", new Shipping("In transit", "b"));
        testShipping.put("c", new Shipping("Preparing", "c"));
    }

    public void addShipping(String id) {
        logger.info("Adding shipping: " + id);
    }

    public boolean hasShipping(String id) {
        return testShipping.containsKey(id);
    }

    public Shipping getShipping(String id) {
        logger.info("Getting shipping: " + id);
        return testShipping.get(id);
    }
}
