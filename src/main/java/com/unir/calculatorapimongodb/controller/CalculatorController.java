package com.unir.calculatorapimongodb.controller;

import com.unir.calculatorapimongodb.model.AdditionSubtractionResult;
import com.unir.calculatorapimongodb.model.Result;
import com.unir.calculatorapimongodb.model.request.AdditionSubtractionRequest;
import com.unir.calculatorapimongodb.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService service;

    @PostMapping("/additions")
    public ResponseEntity<AdditionSubtractionResult> add(@RequestBody AdditionSubtractionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(request));
    }

    @PostMapping("/subtractions")
    public ResponseEntity<AdditionSubtractionResult> subtract(@RequestBody AdditionSubtractionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.subtract(request));
    }



    @GetMapping("/operations")
    public ResponseEntity<List<Result>> getOperations(){
        return ResponseEntity.ok(service.getOperations());
    }

    @GetMapping("/operations/{id}")
    public ResponseEntity<Result> getOperation(@PathVariable String id){
        Result result = service.getOperation(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }


}
