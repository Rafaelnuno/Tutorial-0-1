package pt.iade.helloworld.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.helloworld.models.CurricularUnit;

@RestController
@RequestMapping(path="/api/tester")
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(GreeterController.class);
    private ArrayList<CurricularUnit> units = new ArrayList<CurricularUnit>();

    @PostMapping(path = "/units",produces=MediaType.APPLICATION_JSON_VALUE)
    public CurricularUnit saveUnit(@RequestBody CurricularUnit unit) {
        logger.info("Added unit" +unit.getName());
        units.add(unit);
        return unit;
    }
    @GetMapping(path = "/units",
 produces= MediaType.APPLICATION_JSON_VALUE)
 public ArrayList<CurricularUnit> getUnits() {
 logger.info("Get "+units.size()+" Units");
 return units;
 } 
}
