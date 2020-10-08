package com.api.backend.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MainService {
    Object countUntil(long until, String action);
}
