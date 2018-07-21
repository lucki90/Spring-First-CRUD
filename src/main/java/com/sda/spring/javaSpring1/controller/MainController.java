package com.sda.spring.javaSpring1.controller;

import com.sda.spring.javaSpring1.service.CounterComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {

    private Integer count=0;
    private List<String> list = new ArrayList<>();

    @Autowired
    private CounterComponent counterComponent;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/hello2") // mozna wywalic "value =" jesli jest jeden argument //GetMapping to RequestMapping ale odrazu z metodą get
    public ResponseEntity<String> hello2(){
        return ResponseEntity.ok("Hello2");
    }

    @PostMapping("/count")
    public ResponseEntity<Integer>count(){
        count++;
        if (count <5) {
            return ResponseEntity.ok(count);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/hello3")
    @ResponseStatus(HttpStatus.CREATED)
    public String hello3(){
        return "hello3";
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@RequestBody String newString){

        list.add(newString);

        return newString;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getAll(){

        return list;
    }

    @GetMapping("/get/{jakisNumer}")
    @ResponseStatus(HttpStatus.OK)
    public String get(@PathVariable("jakisNumer") Integer jakisNumer){

        return list.get(jakisNumer);
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public List<String> filterList(@RequestParam(value = "filter", required = false, defaultValue = "") String filter){

        return list.stream()
                .filter(elem -> elem.contains(filter))
                .collect(Collectors.toList());
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public int counter(){
        return counterComponent.increment();
    }

}
