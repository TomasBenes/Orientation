package com.api.backend.Service;

import com.api.backend.Model.Greeter;
import com.api.backend.Model.ResultNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService{

    public long getFactor(long number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public long getSum(long number) {
        long result = 0;
        for (int i = 0; i <= number; i++) {
            result += i;
        }
        return result;
    }

    @Override
    public ResultNumber countUntil(long until, String action) {
        long result = 0;
        if (action.equals("sum")) {
            result = getSum(until);
        } else if (action.equals("factor")) {
            result = getFactor(until);
        }
        return new ResultNumber(result);
    }
}
