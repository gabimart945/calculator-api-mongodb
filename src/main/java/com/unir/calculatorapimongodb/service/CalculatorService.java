package com.unir.calculatorapimongodb.service;



import com.unir.calculatorapimongodb.data.ResultRepository;
import com.unir.calculatorapimongodb.model.AdditionSubtractionResult;
import com.unir.calculatorapimongodb.model.Result;
import com.unir.calculatorapimongodb.model.request.AdditionSubtractionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class CalculatorService {

    private final ResultRepository repository;

    public AdditionSubtractionResult add(AdditionSubtractionRequest request){

        Double total = 0.0;

        for(int i=0; i < request.getNumbers().size(); i++){
            total += request.getNumbers().get(i);
        }

        AdditionSubtractionResult result = AdditionSubtractionResult.builder()
                .type("addition")
                .result(total)
                .parameters(request).build();

        return repository.save(result);
    }

    public AdditionSubtractionResult subtract(AdditionSubtractionRequest request){

        Double total = request.getNumbers().getFirst();

        for(int i=1; i < request.getNumbers().size(); i++){
            total -= request.getNumbers().get(i);
        }

        AdditionSubtractionResult result = AdditionSubtractionResult.builder()
                .type("subtraction")
                .result(total)
                .parameters(request).build();

        return repository.save(result);
    }

    public List<Result> getOperations(){
        return repository.findAll();
    }

    public Result getOperation(String id){
        return repository.findById(id).orElse(null);
    }
}
