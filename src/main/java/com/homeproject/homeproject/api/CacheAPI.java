package com.homeproject.homeproject.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.homeproject.homeproject.cache.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cache")
public class CacheAPI {
    private static final Logger LOG = LoggerFactory.getLogger(CacheAPI.class);
    private final RedisService redisService;

    public CacheAPI(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> addInCache(@RequestBody ObjectNode objectNode){
        String key = objectNode.get("key").asText();
        Object value= objectNode.get("value");
        redisService.saveData(key,value);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get-value")
    @ResponseBody
    public ResponseEntity<?> getFromCache(@RequestBody ObjectNode objectNode){
        String key = objectNode.get("key").asText();
        return ResponseEntity.ok().body(redisService.getData(key));
    }
    @PostMapping("/evict-value")
    @ResponseBody
    public ResponseEntity<?> evictFromCache(@RequestBody ObjectNode objectNode){
        String key = objectNode.get("key").asText();
        redisService.evict(key);
        return ResponseEntity.ok().build();
    }
}
