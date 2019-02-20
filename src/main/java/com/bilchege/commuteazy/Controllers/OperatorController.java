package com.bilchege.commuteazy.Controllers;

import com.bilchege.commuteazy.Entities.Operator;
import com.bilchege.commuteazy.Services.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @RequestMapping(method = RequestMethod.POST,value = "/addOperator")
    public void addOperator(@RequestBody Operator operator){
        operatorService.addOperator(operator);
    }

    @RequestMapping("/operators")
    public List<Operator> getOperators(){
        return operatorService.getOperators();
    }

    @RequestMapping("/operatorsonroute/{origin}/{destination}")
    public List<Operator> opertorsOnRoute(@PathVariable("origin") String origin,@PathVariable("destination") String destination){
        return operatorService.operatorsOnRoute(origin,destination);
    }

    @RequestMapping("/getoperator/{id}")
    public Optional<Operator> getOperator(@PathVariable Long id){
        return operatorService.getOperator(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateoperator/{id}")
    public void updateOperator(@PathVariable Long id,@RequestBody Operator operator){
        operatorService.updateOperator(id,operator);
    }

}
