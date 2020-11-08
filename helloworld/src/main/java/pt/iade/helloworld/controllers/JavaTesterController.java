package pt.iade.helloworld.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.helloworld.models.CurricularUnit;

@RestController
@RequestMapping(path="/api/java/tester")
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(GreeterController.class);
    private ArrayList<CurricularUnit> units = new ArrayList<CurricularUnit>();
    private double grades[] = {9.5,10.5, 12, 14.5};
    private String ucs[] = {"ING","FP","POO","BD"};

    @PostMapping(path = "/units",produces=MediaType.APPLICATION_JSON_VALUE)
    public CurricularUnit saveUnit(@RequestBody CurricularUnit unit) {
        logger.info("Added unit" +unit.getName());
        units.add(unit);
        return unit;
    }
    @GetMapping(path = "/units",produces= MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CurricularUnit> getUnits() {
        logger.info("Get "+units.size()+" Units");
        return units;
 } 
 @GetMapping(path = "/author/{fan}",
 produces= MediaType.APPLICATION_JSON_VALUE)
 public String getAuthor(@PathVariable("fan") boolean fan) {
     String f= "";

     if(fan == true ){
        f= "i am"; 
     }
      else{
          f=" im not";
      }

     String name = "Rafael Pilré";
     int number = 20190877;
     double height = 1.70;
     logger.info("Saying hello to " + name);

     return "Done by " +name+ " with number " +number+". \n" + "I am " +height+ " tall and "+ f + " a fan of football.";
 }
    @GetMapping(path = "/access/{student}/{covid}",produces= MediaType.APPLICATION_JSON_VALUE)
    public boolean getGreeting(@PathVariable("student") boolean isStudent,@PathVariable("covid") boolean hasCovid) {
       return isStudent && !(hasCovid);
    }
    @GetMapping(path = "/required/{student}/{temperature}/{classType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequired(@PathVariable("student") boolean isStudent, @PathVariable("temperature") double hasCovid,
            @PathVariable("classType") String type) {
                return isStudent && type.equals("presential") && (hasCovid > 34.5 && hasCovid < 37.5);
                
            }
    @GetMapping(path = "/evacuation/{fire}/{numberOfCovids}/{powerShutdown}/{comeBackTime}", produces= MediaType.APPLICATION_JSON_VALUE)
        public boolean getEvacuated(@PathVariable("fire") boolean fire,@PathVariable("numberOfCovids") int numberOfCovids, 
        @PathVariable("powerShutdown") boolean powerShutdown,
        @PathVariable("comeBackTime") int comeBackTime) {
            return (fire || numberOfCovids > 5 || (powerShutdown && comeBackTime > 15));
        }
    @GetMapping(path = "/average", produces= MediaType.APPLICATION_JSON_VALUE)
        public double average() { 
            double sum=0;
            for(int i=0;i<grades.length;i++) {
                sum+=grades[i];
            }
           double average=sum/grades.length;
            return average;
        }
    @GetMapping(path = "/maxgrade", produces= MediaType.APPLICATION_JSON_VALUE)
        public double maxgrade() {
           double max=0;
            for(int i=0; i<grades.length; i++) {
                if (grades[i] > max) {
                   max = grades[i];
                }
            }
            return max;
        }
    @GetMapping(path = "/ucgrade", produces = MediaType.APPLICATION_JSON_VALUE)
        public double ucGrade() {
            String uc = "POO";
            double ucgrade = 0;
            for (int i = 0; i < ucs.length; i++) {
                if (ucs[i].equals(uc)) {
                    ucgrade = grades[i];
                }
            }
            return ucgrade;
        }
    @GetMapping(path = "/minmaxgrade", produces = MediaType.APPLICATION_JSON_VALUE)
        public double minmaxGrade() {
            double min=9.5;
            double max=14.5;
            double ucgradelimits = 0;
                for (int i = 0; i < ucs.length; i++) {
                if (grades[i] >= min && (grades[i] <= max)) {
                ucgradelimits++;
                }
            }
                return ucgradelimits;
        }
    @GetMapping(path = "/text", produces= MediaType.APPLICATION_JSON_VALUE)
        public String text() {
            String text="";                  
                for(int i=0; i<grades.length; i++) {
                text+=ucs[i]+":"+grades[i]+" ";
                }
        
         return text;
            }
}
