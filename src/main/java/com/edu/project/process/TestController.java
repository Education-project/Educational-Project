package com.edu.project.process;

import com.edu.project.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static org.hibernate.internal.util.collections.CollectionHelper.isNotEmpty;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @POST
    @RequestMapping(value = "/getAllTests")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllTests() {
        Map<Integer, List<SimpleEntry<String, Long>>> menu = new HashMap<>();
        List<Test> tests = testService.findAll();
        tests.forEach(test ->
        {
            int year = test.getYear();
            if (isNotEmpty(menu.get(year)))
            {

                menu.get(year).add(new SimpleEntry<>(valueOf(test.getShift()), test.getId()));
            }
            else
            {
                menu.put(year, asList(new SimpleEntry<>(valueOf(test.getShift()), test.getId())));
            }
        });
        return Response.ok().entity(menu).build();
    }

    @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    @Produces("text/plain")
    public Test getTest(@QueryParam("testId") String testId) {
        return testService.findTest(Long.valueOf(testId));
    }
}
